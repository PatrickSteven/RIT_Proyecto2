
package Models.WebPageManagerP;
import static Models.FileManager.FileManager.readFile;
import java.util.ArrayList;
import java.io.IOException; 
import java.util.HashMap;
import java.util.Set; 
import java.util.regex.Pattern;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.tartarus.snowball.ext.SpanishStemmer;


public class WebPageManager {
      
    private Set<String> stopWords;
    HashMap<Character, Character> replacements;

    //Time
    long timeJsoup =0;
    long timeLoweCase = 0;
    long timeRemoveNumbers = 0;
    long timeRemoveStopWords = 0;
    long timeMakeItSpanish = 0;
    long timeStemThis = 0;
    long timeReplaceAcents = 0;
    
    Document doc;

    public WebPageManager() {
        replacements = new HashMap<Character, Character>();
        replacements.put('á', 'a');
        replacements.put('é', 'e');
        replacements.put('í', 'i');
        replacements.put('ó','o');
        replacements.put('ú', 'u');
        replacements.put('.', ' ');
        replacements.put(',', ' ');
        replacements.put(':', ' ');
        replacements.put('(', ' ');
        replacements.put(')', ' ');
        
    }
    
    
    
    public ArrayList<WebPage> getWebPages(String dataFile) throws IOException{
        ArrayList<HtmlDocument> htmlTexts = getHTMLDocuments(dataFile);
        return parse(htmlTexts, dataFile);
    }
        
    //Return a ArrayList of Strings, each String is a line of the Html Document. 
    public ArrayList<String> getHTMLDocument(String collection, int initialPosition, int endPosition) throws IOException{
        String data = readFile(collection);
        String[] dataLines = data.split("\n");
        ArrayList<String> html = new ArrayList<>();
        boolean isLine = false;
        int linePosition = 0;
        for(String line : dataLines){
            if(linePosition == initialPosition) isLine = true;
            if(isLine){
                html.add(line);
            }
            if(linePosition == endPosition) break;
            linePosition++;
        }
        return html;
    }
    
    //Return the Html Documents of a txt file
    //The HTML begins with <!DOCTYPE... and ends with </html>
    public ArrayList<HtmlDocument> getHTMLDocuments(String filename) throws IOException{
        long startTime = System.currentTimeMillis();

        ArrayList<HtmlDocument> htmlDocuments = new ArrayList<>();
        String data = readFile(filename);
        String[] dataLines = data.split("\n");
        
        HtmlDocument  actualHtmlDocument = null;
        int linePosition = 0;
        for(String line : dataLines){
            if(line.contains(HtmlDocument.intialTag)){
                actualHtmlDocument = new HtmlDocument();
                actualHtmlDocument.setInitialPosition(linePosition);
            }
            else if(actualHtmlDocument != null && (line.contains(HtmlDocument.endTag))){
                actualHtmlDocument.setEndPosition(linePosition);
                htmlDocuments.add(actualHtmlDocument);
            }
            
            actualHtmlDocument.addLine(line);
            
            linePosition++;
        }
        
        long endTime = System.currentTimeMillis();
        System.out.println("GetHTMLDocuments _ Time: " + (endTime-startTime));
        
        return htmlDocuments;
    }
    
    public String removeStopWords(String text){
        StringBuilder cleanText = new StringBuilder();
        Set<String> stopwords = Stopwords.LoadStopWords();
        String[] words = text.split(" ");
        for(String word : words){
            if(!stopwords.contains(word))
                cleanText.append(word).append(" ");
        }
        return cleanText.toString();
    }
    
    public String stemThis(String text){
        
        SpanishStemmer spanish = new SpanishStemmer();
        String[] words = text.split("\\s");
        StringBuilder stemmedText = new StringBuilder();
        for (String word : words) {
            spanish.setCurrent(word);
            spanish.stem();
            stemmedText.append(spanish.getCurrent()).append(" ");
        }
        
        return stemmedText.toString();
    }
    
    public ArrayList<WebPage> parse(ArrayList<HtmlDocument> htmlTexts, String dataPath){
        
        String title;
        String body;
        String newBody;
        String aText = "";
        String hText = "";
        
        ArrayList<WebPage> webPageList = new ArrayList();
        
        for (HtmlDocument html : htmlTexts){
            //Time
            long startTime, endTime;
            
            //Get Html 
            startTime = System.currentTimeMillis();

            doc = Jsoup.parse(html.getHtmlText());
            title = doc.title();
            body = doc.body().text();  
            
            //Get ref <a>
            StringBuilder aTagsBuilder = new StringBuilder();
            Elements aTags = doc.body().select("a");
            for (Element element : aTags){
                aTagsBuilder.append(element.ownText()).append(" ");
            }
            aText = aTagsBuilder.toString();
            
            //Get subtitles <h#>
            StringBuilder hTagsBuilder = new StringBuilder();
            Elements hTags = doc.select("h1, h2, h3, h4, h5, h6");      
            for (Element element : hTags){
              hTagsBuilder.append(element.ownText()).append(" ");
            }
            hText = hTagsBuilder.toString();
            endTime = System.currentTimeMillis();
            this.timeJsoup += (endTime-startTime);
             
           
            //ToLowerCase
            startTime = System.currentTimeMillis();
            title = title.toLowerCase();
            aText = aText.toLowerCase();
            hText = hText.toLowerCase();
            body = body.toLowerCase();
            endTime = System.currentTimeMillis();
            this.timeLoweCase += (endTime-startTime);
            
            /*
            System.out.println("title " + title);
            System.out.println("a " + aText);
            System.out.println("h " + hText);
            System.out.println("body " + body + "\n");
            */
           
            
            hText = makeItSpanish(hText);
            body = makeItSpanish(body);
            title = makeItSpanish(title);
            aText = makeItSpanish(aText);

            
            startTime = System.currentTimeMillis();
            body = removeStopWords(body);
            hText = removeStopWords(hText);
            endTime = System.currentTimeMillis();
            this.timeRemoveStopWords += (endTime-startTime);
            
            startTime = System.currentTimeMillis();
            hText = stemThis(hText);
            body = stemThis(body);
            endTime = System.currentTimeMillis();
            this.timeStemThis += (endTime-startTime);


            /*
            System.out.println("title LIMPIO " + title);
            System.out.println("a LIMPIO " + aText);
            System.out.println("h LIMPIO " + hText);
            System.out.println("body LIMPIO " + body);
            System.out.println("collections " + dataPath + "\n");
            */
            
            int startHTML = html.getInitialPosition();
            int endHTML = html.getEndPosition();
            //System.out.println(dataPath);
            webPageList.add(new WebPage(body, aText, hText, title, startHTML, endHTML, dataPath));     
        }
        
        System.out.println("Jsoup _Time: " + this.timeJsoup);
        System.out.println("ToLowerCase _Time: " + this.timeLoweCase);
        System.out.println("RemoveNumbers _Time: " + this.timeRemoveNumbers);
        System.out.println("Replaceacents _Time: " + this.timeReplaceAcents);
        System.out.println("MakeItSpanish _Time: " + this.timeMakeItSpanish);
        System.out.println("RemoveStopWords _Time: " + this.timeRemoveStopWords);
        System.out.println("StemThis _Time: " + this.timeStemThis);
                
        return webPageList;
        
    }
    
    
    public void replaceAccents(StringBuilder cadena) {
        for(int i=0; i<cadena.length();i++ ){
            if(replacements.containsKey(cadena.charAt(i)))
                cadena.setCharAt(i, replacements.get(cadena.charAt(i)));
        }
    }
    
    public String makeItSpanish(String text){
        StringBuilder newText = new StringBuilder(text);
        long startTime = System.currentTimeMillis();
        replaceAccents(newText);
        long endTime = System.currentTimeMillis();
        this.timeReplaceAcents += endTime - startTime;
        
        startTime = System.currentTimeMillis();
        String cleanText = Pattern.compile("(\\w*[^a-zñ|\\s]+\\w*)").matcher(newText).replaceAll("") + " ";  
        endTime = System.currentTimeMillis();
        this.timeMakeItSpanish += (endTime-startTime);
        
        return cleanText;
    }
      
}
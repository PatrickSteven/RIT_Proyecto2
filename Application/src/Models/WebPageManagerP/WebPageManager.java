
package Models.WebPageManagerP;
import static Models.FileManager.FileManager.readFile;
import java.nio.file.*;; 
import java.io.File;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.IOException; 
import java.io.Reader; 
import java.util.HashSet; 
import java.util.Set; 
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import org.apache.lucene.analysis.Analyzer; 
import org.apache.lucene.analysis.LowerCaseFilter; 
import org.apache.lucene.analysis.StopFilter; 
import org.apache.lucene.analysis.TokenStream; 
import org.apache.lucene.analysis.WordlistLoader; 
import org.apache.lucene.analysis.core.StopAnalyzer;
import org.apache.lucene.analysis.standard.StandardTokenizer;
import org.apache.lucene.util.Version;
import org.apache.lucene.analysis.CharArraySet;
import org.apache.lucene.util.Constants;
import org.apache.lucene.analysis.util.ResourceLoader;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;
import org.apache.lucene.util.AttributeImpl;
import org.apache.lucene.analysis.Analyzer; 
import org.apache.lucene.analysis.LowerCaseFilter; 
import org.apache.lucene.analysis.StopFilter; 
import org.apache.lucene.analysis.TokenStream; 
import org.apache.lucene.analysis.WordlistLoader; 
import org.apache.lucene.analysis.standard.StandardTokenizer; 
import org.apache.lucene.util.AttributeFactory;
import org.tartarus.snowball.ext.SpanishStemmer;


public class WebPageManager {
      
    private Set<String> stopWords;
    Document doc;
    
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
        return htmlDocuments;
    }
    
    public String removeStopWords(String text){
        String cleanText = "";
        Set<String> stopwords = Stopwords.LoadStopWords();
        String[] words = text.split(" ");
        for(String word : words){
            if(!stopwords.contains(word))
                cleanText += word + " ";
        }
        return cleanText;
    }
    
    public String stemThis(String text){
        
        SpanishStemmer spanish = new SpanishStemmer();
        String[] words = text.split("\\s");
        String stemmedText = "";
        for (String word : words) {
            spanish.setCurrent(word);
            spanish.stem();
            stemmedText += spanish.getCurrent() + " ";
        }
        
        return stemmedText;
    }
    
    public ArrayList<WebPage> parse(ArrayList<HtmlDocument> htmlTexts, String dataPath){
        
        String title;
        String body;
        String newBody;
        String aText = "";
        String hText = "";
        ArrayList<WebPage> webPageList = new ArrayList();
        
        for (HtmlDocument html : htmlTexts){
            doc = Jsoup.parse(html.getHtmlText());
            title = doc.title();
            body = doc.body().text();  
            
            //Get ref <a>
            Elements aTags = doc.body().select("a");
            for (Element element : aTags){
                aText += (element.ownText() + " ");
            }
            
            //Get subtitles <h#>
            Elements hTags = doc.select("h1, h2, h3, h4, h5, h6");      
            for (Element element : hTags){
              hText += (element.ownText() + " ");
            }
            
            
            title = title.toLowerCase();
            aText = aText.toLowerCase();
            hText = hText.toLowerCase();
            body = body.toLowerCase();
            
            /*
            System.out.println("title " + title);
            System.out.println("a " + aText);
            System.out.println("h " + hText);
            System.out.println("body " + body + "\n");
            */
            
            body = removeNumbers(body);
            body = makeItSpanish(body);
            body = removeStopWords(body);
            body = stemThis(body);

            hText = removeNumbers(hText);
            hText = makeItSpanish(hText);
            hText = removeStopWords(hText);
            hText = stemThis(hText);

            title = removeNumbers(title);
            title = makeItSpanish(title);

            aText = removeNumbers(aText);
            aText = makeItSpanish(aText);
            
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
        
        return webPageList;
        
    }
    
    public String removeNumbers(String text){
    
        String[] newText = text.replaceAll("\\w*\\d\\w*", " ").split("  +");
        String cleanText = String.join(" ", newText);
        
        return cleanText;
    }
    
    public String replaceAccents(String cadena) {
    return cadena.replace("Á", "A")
            .replace("É", "E")
            .replace("Í", "I")
            .replace("Ó", "O") 
            .replace("Ú", "U")
            .replace("á", "a")
            .replace("é", "e")
            .replace("í", "i")
            .replace("ó", "o")
            .replace("ú", "u")
            .replace(".", " ")
            .replace(",", " ")
            .replace(":", " ")
            .replace("(", " ")
            .replace(")", " ");
}
    
    public String makeItSpanish(String text){
    
        text = replaceAccents(text);
        String[] newText = text.replaceAll("\\b[A-Za-zÑñ]*[^A-Za-zÑñ\\s]+[A-Za-zÑñ]*\\b|[^A-Za-zÑñ\\s]+[A-Za-zÑñ]*\\b|\\b[A-Za-zÑñ]*[^A-Za-zÑñ\\s]+|[^A-Za-zÑñ\\s]+", " ").split("  +  ");
        String cleanText = String.join(" ", newText);
        
        return cleanText;
    }
      
}
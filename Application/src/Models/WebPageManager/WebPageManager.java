
package Models.WebPageManager;
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
//import org.apache.lucene.analysis.standard.StandardFilter; 
import org.apache.lucene.analysis.standard.StandardTokenizer; 


public class WebPageManager {
      
    
    public ArrayList<WebPage> getWebPages(File dataFile){
        return new ArrayList<>(); //Es solo poder llamar al metodo //Usted implementelo bien
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
    
    public String parse(String htmlText){

          Document doc = Jsoup.parse(htmlText);
          String title = doc.title();
          String body = doc.body().text();
          String newBody;
          
          Elements aTags = doc.body().select("a");
          String aText = "";

          for (Element element : aTags){
            
            aText += (element.ownText());
          }
          
          Elements hTags = doc.select("h1, h2, h3, h4, h5, h6");
          String hText = "";
          
          for (Element element : hTags){
            
            hText += (element.ownText());
          }
          
          //System.out.println("title " + title);
          //System.out.println("a " + aText);
          //System.out.println("h " + hText);
          //System.out.println("body " + body);
          newBody = removeNumbers(body);
          newBody = makeItSpanish(newBody);
          return newBody;
          
    }
    
    public String removeNumbers(String text){
    
        String[] newText = text.replaceAll("\\w*\\d\\w* *", "").split("  +");
        String cleanText = String.join("", newText);
        
        //System.out.println(cleanText);               
        return cleanText;
    }
    
    public String makeItSpanish(String text){
    
        String[] newText = text.replaceAll("[^A-Za-zÑñ\\s]", "").split("  +");
        String cleanText = String.join("", newText);
        
        //System.out.println(cleanText);
        return cleanText;
    }
    
    public static CharArraySet makeStopSet(String[] stopWords, boolean ignoreCase) {
        CharArraySet stopSet = new CharArraySet(stopWords.length, ignoreCase);
        stopSet.addAll(Arrays.asList(stopWords));
        return stopSet;
}
 /* 
public class LuceneConstants {
   public static final String CONTENTS = "contents";
   public static final String FILE_NAME = "filename";
   public static final String FILE_PATH = "filepath";
   public static final int MAX_SEARCH = 10;
}
    
    public void displayTokenUsingStopAnalyzer(String text) throws IOException{
      
      String[] stopList = {"en, a, ante"};
      CharArraySet stopWordsSet = makeStopSet(stopList, true);
      Analyzer analyzer = new StopAnalyzer(stopWordsSet);
      TokenStream tokenStream = analyzer.tokenStream(
      LuceneConstants.CONTENTS, new StringReader(text));
      AttributeImpl term = tokenStream.addAttribute(AttributeImpl.class);
      while(tokenStream.incrementToken()) {
         System.out.print("[" + term.reflectAsString(true) + "] ");
      }
   }
*/

}


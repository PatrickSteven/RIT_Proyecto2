
package Models;
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


public class WebPageManager {
    
    public ArrayList<WebPage> getWebPages(File dataFile){
        return new ArrayList<>(); //Es solo poder llamar al metodo //Usted implementelo bien
    }
    
public String readFile(String fileName)throws Exception{
  
    String data; 
    data = new String(Files.readAllBytes(Paths.get(fileName))); 
    return data; 
  } 
    
    public String parseHTML(File html, String key){
    
        
        return "";
    }
    
    public void parse(String htmlText){

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
          System.out.println("body " + body);
          newBody = removeNumbers(body);
          newBody = makeItSpanish(newBody);
          
    }
    
    public String removeNumbers(String text){
    
        String[] newText = text.replaceAll("\\w*\\d\\w* *", "").split("  +");
        String cleanText = String.join("", newText);
        
        System.out.println(cleanText);               
        return cleanText;
    }
    
    public String makeItSpanish(String text){
    
        String[] newText = text.replaceAll("[^A-Za-zÑñ\\s]", "").split("  +");
        String cleanText = String.join("", newText);
        
        System.out.println(cleanText);
        return cleanText;
    }
    
    public static CharArraySet makeStopSet(String[] stopWords, boolean ignoreCase) {
        CharArraySet stopSet = new CharArraySet(stopWords.length, ignoreCase);
        stopSet.addAll(Arrays.asList(stopWords));
        return stopSet;
}
    
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
      CharTermAttribute term = tokenStream.addAttribute(CharTermAttribute.class);
      while(tokenStream.incrementToken()) {
         System.out.print("[" + term.toString() + "] ");
      }
   }
}


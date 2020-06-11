
package Models;
import java.nio.file.*;; 
import java.io.File;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

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
    
    public String parse(String htmlText){

          Document doc = Jsoup.parse(htmlText);
          Element a = doc.select("a").first();
          Element h = doc.select("h1").first();
          String title = doc.title();
          String hh = h.text();
          String body = doc.body().text();
          
          System.out.println("Body " + body);
          System.out.println("Title: " + title);
          System.out.println("H? " + hh);
          return body;
    }
}


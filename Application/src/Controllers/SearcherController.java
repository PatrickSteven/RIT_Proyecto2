package Controllers;

import Models.IndexManager.Searcher;
import Models.WebPageManager.WebPageConstants;
import Models.WebPageManager.WebPageManager;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.lucene.document.Document;
import org.apache.lucene.queryparser.classic.ParseException;

public class SearcherController {
    Searcher searcher;
    WebPageManager webPageManager;

    public SearcherController() {
        searcher = new Searcher();
        webPageManager = new WebPageManager();
    }
    
    public void Search(String nameIndex, String query) throws IOException{
        try {
            ArrayList<Document> documents = searcher.Search(nameIndex, query);
        } catch (ParseException ex) {
            //Query Parse Error
            Logger.getLogger(SearcherController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public String SearchHTMLDocument(Document document) throws IOException{
        ArrayList<String> htmlLines = webPageManager.getHTMLDocument(
            document.getField(WebPageConstants.COLLECTION).stringValue(),
            Integer.valueOf(document.getField(WebPageConstants.INITPOS).stringValue()),
            Integer.valueOf(document.getField(WebPageConstants.ENDPOS).stringValue())
        );
        
        String html = "";
        for(String line : htmlLines)
            html += line;
        
        return html;
    }
}

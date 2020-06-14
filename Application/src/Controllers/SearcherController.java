package Controllers;

import Models.IndexManager.Searcher;
import Models.WebPageManager.WebPageConstants;
import Models.WebPageManager.WebPageManager;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import org.apache.lucene.document.Document;
import org.apache.lucene.queryparser.classic.ParseException;

public class SearcherController {
    Searcher searcher;
    WebPageManager webPageManager;
    JFrame view;
    
    //Search data
    ArrayList<Document> documents;
    int documentsForPage;
    int page;
    int maxPages;
    
    
    public SearcherController(JFrame view) {
        searcher = new Searcher();
        webPageManager = new WebPageManager();
        this.view = view;
        this.documentsForPage = 20;
    }
    
    public void Search(String nameIndex, String query) throws IOException{
        try {
            this.documents = searcher.Search(nameIndex, query);
            this.page = 1;
            this.maxPages = this.documents.size() / documentsForPage;
            if(documents.size()%documentsForPage != 0) maxPages++;
        } catch (ParseException ex) {
            //Query Parse Error
            Logger.getLogger(SearcherController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public String[] getDocumentAtPage(){
        String documents_20 = "";
        Document doc;
        int initialIndex = (page-1)*documentsForPage;
        for(int docIndex = initialIndex; (docIndex >= this.documents.size() || docIndex < initialIndex+documentsForPage) ; docIndex++){
            doc = this.documents.get(docIndex);  
            File file = new File(doc.getField(WebPageConstants.COLLECTION).toString());
            documents_20 += doc.getField(WebPageConstants.TITULO).toString() + " from " + file.getName() + "\n";
        }
               
        return documents_20.split("\n");
    }
    
    public String getDocument(int docPosition) throws IOException{
        int docIndex = documentsForPage*page - documentsForPage+1 - docPosition;
        Document doc = this.documents.get((docPosition*page)-1);
        return SearchHTMLDocument(doc);
    }
    
    private String SearchHTMLDocument(Document document) throws IOException{
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
    
    public boolean getNextPage(){
        if(page == maxPages) return false;
        page++;
        return true;
    }
    
    public boolean getPreviousPage(){
        if(page == 1) return false;
        page--;
        return true;
    }
    
    public int getPage(){
        return page;
    }
}

package Controllers;

import Models.FileManager.FileManager;
import Models.IndexManager.IndexDataManager;
import Models.IndexManager.Searcher;
import Models.WebPageManager.WebPageConstants;
import Models.WebPageManager.WebPageManager;
import Models.IndexManager.IndexDataManager.IndexData;
import Views.SearchView;
import com.sun.javafx.webkit.WebConsoleListener;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import org.apache.lucene.document.Document;
import org.apache.lucene.queryparser.classic.ParseException;

public class SearcherController {
    Searcher searcher;
    WebPageManager webPageManager;
    SearchView view;
    
    //Search data
    ArrayList<Document> documents;
    int documentsForPage;
    int page;
    int maxPages;
    
    String htmlFilePath = "../Data/Html/openDoc.html";
    
    
    public SearcherController(SearchView view) {
        searcher = new Searcher();
        webPageManager = new WebPageManager();
        this.view = view;
        this.documentsForPage = 20;
    }
    
    public void Search(String nameIndex, String query) throws IOException{
        try {
            String indexPath = IndexDataManager.getIndexData().indexPath.get(nameIndex);
            this.documents = searcher.Search(indexPath, query);
            view.setSearchInfo(this.getSearchInfo());
            this.page = 1;
            this.maxPages = this.documents.size() / documentsForPage;
            if(documents.size()%documentsForPage != 0) maxPages++;
        } catch (ParseException ex) {
            //Query Parse Error
            System.out.println("Error: " + ex.getMessage());
            Logger.getLogger(SearcherController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public String[] getDocumentAtPage(){
        String documents_20 = "";
        Document doc;
        int initialIndex = (page-1)*documentsForPage;
        for(int docIndex = initialIndex; (docIndex < this.documents.size() && docIndex < initialIndex+documentsForPage) ; docIndex++){
            doc = this.documents.get(docIndex);  
           // File file = new File(doc.getField(WebPageConstants.COLLECTION).toString());
            documents_20 += doc.getField(WebPageConstants.TITULO).stringValue() + "\n"; //+ " from " + file.getName() + "\n";
        }
               
        return documents_20.split("\n");
    }
    
    public void openDocument(int docPosition){
        try {
            String html = getDocument(docPosition);
            FileManager.writeObject(html, htmlFilePath);
            
            URI uri = new URL(htmlFilePath).toURI();
            Desktop desktop = Desktop.isDesktopSupported() ? Desktop.getDesktop() : null;
            if (desktop != null && desktop.isSupported(Desktop.Action.BROWSE))
                desktop.browse(uri);
            
        } catch (IOException ex) {
            Logger.getLogger(SearcherController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (URISyntaxException ex) {
            Logger.getLogger(SearcherController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public String getDocument(int docPosition) throws IOException{
        //int docIndex = documentsForPage*page - documentsForPage+1 - docPosition;
        int docIndex = (docPosition*page);
        Document doc = this.documents.get(docIndex);
        System.out.println("Document: "+doc.getField(WebPageConstants.TITULO).stringValue());
         System.out.println("Collection: "+doc.getField(WebPageConstants.COLLECTION).stringValue());
        System.out.println("DocINdex: "+ docIndex);
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
    
    public String getSearchInfo(){
        return this.searcher.getQueryDocs() + " results" + " in " + searcher.getSearchTime() + "seconds." + "Total documents in index: " + searcher.getTotalDocs();
    }
}

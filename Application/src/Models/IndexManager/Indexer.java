package Models.IndexManager;
import Models.WebPageManagerP.WebPageManager;
import Models.WebPageManagerP.WebPageConstants;
import Models.WebPageManagerP.WebPage;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.StringField;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.CorruptIndexException;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;

public class Indexer {
    IndexWriter indexWriter;
    WebPageManager webPageManager;
    
    float time;
    int cuantityDocuments;
    int numDocs;
    
    
    public Indexer(){
        this.webPageManager = new WebPageManager();
    }
    
    public void Index(String indexDirPath, String dataDirPath) throws IOException{
        
        //START TIME
        long startTime = System.currentTimeMillis();
        
        //Create directory of the given index path
        Directory indexDirectory = FSDirectory.open(Paths.get(indexDirPath));
        
        //Index configuration, create new if does not find a index in the indexDirPath, 
        //otherwise append in the existent index
        IndexWriterConfig indexConfig = new IndexWriterConfig(new StandardAnalyzer());
        indexConfig.setOpenMode(IndexWriterConfig.OpenMode.CREATE_OR_APPEND);
        
        //Create IndexWriter
        this.indexWriter = new IndexWriter(indexDirectory, indexConfig);
        
        //Add documents
        int documents = this.addDocuments(dataDirPath);
        this.indexWriter.commit();
        //Close Index
        this.close();
        
        //END TIME
        long endTime = System.currentTimeMillis();
        
        //Add Time result
        this.time = endTime - startTime;
        System.out.println("Total Indexing _Time: " + this.time);
        //Cuantity of indexed documents
        this.cuantityDocuments = documents;
       
    }
    
    private int addDocuments(String dataDirPath) throws IOException{
        //Get WebPages in the provided .txt file 
        ArrayList<WebPage> webPages;
        webPages = this.webPageManager.getWebPages(dataDirPath);
      
        //Iterate the arrayList and add the documents to the index
        long startTime = System.currentTimeMillis();

        for(WebPage webPage : webPages){
            //Document that is going to be indexed
            Document doc = new Document();

            //Field that is stored and tokenized
            doc.add(new TextField(WebPageConstants.TEXTO, webPage.getTexto(), Field.Store.YES));
            doc.add(new TextField(WebPageConstants.REF, webPage.getRef(), Field.Store.YES));
            doc.add(new TextField(WebPageConstants.ENCAB, webPage.getEncab(), Field.Store.YES));
            doc.add(new TextField(WebPageConstants.TITULO, webPage.getTitulo(), Field.Store.YES));

            //Fields that are a single string, one token. No Store
            //doc.add(new StringField(WebPageConstants.ENLACE, webPage.getEnlace(), Field.Store.NO));
            
            //Collection of the documet, Path.
            doc.add(new StringField(WebPageConstants.COLLECTION, webPage.getCollection(), Field.Store.YES));
            
            //Initial and end position of the Document in the Collection .txt file
            //Int to String
            doc.add(new StringField(WebPageConstants.INITPOS, String.valueOf(webPage.getInitialPosition()), Field.Store.YES));
            doc.add(new StringField(WebPageConstants.ENDPOS,  String.valueOf(webPage.getEndPosition()), Field.Store.YES));
            
            //Add the document in the index
            this.indexWriter.addDocument(doc);
            
        }
        
        long endTime = System.currentTimeMillis();
        System.out.println("Indexing Documents _Time: " + (endTime - startTime));
        
        return webPages.size();
    }

    public float getTime() {
        return time / 1000;
    }

    public int getCuantityDocuments() {
        return cuantityDocuments;
    }
    
    public int getNumDocs(){
        return numDocs;
    }
    
       
    private void close() throws CorruptIndexException, IOException {
        this.indexWriter.close();
    }
    
    
    
}

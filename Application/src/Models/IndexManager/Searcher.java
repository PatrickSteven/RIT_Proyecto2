
package Models.IndexManager;
import Models.WebPageManagerP.WebPageConstants;
import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.index.CorruptIndexException;
//import org.apache.lucene.queryParser.ParseException;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.search.Query;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.util.Version;

public class Searcher {
    IndexSearcher indexSearcher;
    IndexReader indexReader;
    QueryParser queryParser;
    Query query;
    int maxDocs = 100;
    private final Set<String> fieldsToLoad;
    
    long searchTime;
    long queryDocs;
    long totalDocs;
    
    public Searcher(){
        //Fields that have the documents retrieved
        this.fieldsToLoad = new HashSet<>();
        this.fieldsToLoad.add(WebPageConstants.TITULO);
        this.fieldsToLoad.add(WebPageConstants.COLLECTION);
        this.fieldsToLoad.add(WebPageConstants.INITPOS);
        this.fieldsToLoad.add(WebPageConstants.ENDPOS);
    }
    
    public ArrayList<Document> Search(String indexDirPath, String queryString) throws IOException, ParseException{
        //START TIME
        
        long startTime = System.currentTimeMillis();
        
        //Create a directory of the given path
        Directory indexDirectory = FSDirectory.open(Paths.get(indexDirPath));
        //Check if the index exists
        if(this.Exists(indexDirectory)){
            System.out.println("Index exists");
            this.indexReader = DirectoryReader.open(indexDirectory);
            this.indexSearcher = new IndexSearcher(indexReader);
            //Do the query
            this.queryParser = new QueryParser(WebPageConstants.TEXTO, new StandardAnalyzer());
            TopDocs topDocs = this.DoQuery(queryString);
            queryDocs = topDocs.totalHits.value;
            totalDocs = this.indexReader.numDocs();
            maxDocs = (int) totalDocs;
            //ENDTIME 
            
            //Return result of the query
            ArrayList<Document> docs = this.getDocuments(topDocs);
             
            long endTime = System.currentTimeMillis();
            this.searchTime = endTime - startTime;
            
            return docs;
        }
        
        //If the index does not exists
        else return null;
    }
    
    private ArrayList<Document> getDocuments(TopDocs topDocs) throws IOException{
        ArrayList<Document> documents = new ArrayList<>();
        int index = 0;
        for(ScoreDoc scoreDoc : topDocs.scoreDocs){
            Document doc = indexSearcher.doc(scoreDoc.doc, fieldsToLoad);
            documents.add(doc);
            index++;
        }
        System.out.println("Documentes: " + documents.size());
        return documents;
    }
    
    private TopDocs DoQuery(String queryString) throws ParseException, IOException{
        //Query string -> query syntax 
        this.query = queryParser.parse(queryString);
        return indexSearcher.search(query, maxDocs);
    }
    
    private boolean Exists(Directory dir) throws IOException{
        return DirectoryReader.indexExists(dir);
    }
    
    public long getTotalDocs(){
        return totalDocs;
    }
    
    public long getQueryDocs(){
        return queryDocs;
    }
    
    public long getSearchTime(){
        return this.searchTime;
    }
    
}

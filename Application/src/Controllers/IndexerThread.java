
package Controllers;

import java.io.IOException;
import static java.lang.Thread.sleep;
import java.util.logging.Level;
import java.util.logging.Logger;


public class IndexerThread extends Thread{
    
    private boolean running;
    private boolean indexing;
    private boolean updating;
    private String indexName;
    private String collectionPath;
    IndexerController controlador;

    public IndexerThread(IndexerController _controlador){
        running = true;
        indexing = false;
        updating = false;
        this.controlador = _controlador;
    }
    
    @Override
    public void run (){
    
        while (running){
            
            while(!indexing){
                
                try{
                    sleep(200);
                } catch (InterruptedException ex){
                }
            }
            
            try {
                if (!updating)
                controlador.createIndex(this.indexName, this.collectionPath);
                
                else
                    controlador.updateIndex(indexName, collectionPath);
                
            } catch (IOException ex) {
                
                Logger.getLogger(IndexerThread.class.getName()).log(Level.SEVERE, null, ex);
                this.pause();
            }
            this.pause();
        }
    }

    public boolean isRunning() {
        return running;
    }

    public void setRunning(boolean running) {
        this.running = running;
    }

    public void pause(){
    
        this.indexing = false;
    }
    
    public void startIndexing(){
    
        this.indexing = true;
    }

    public String getIndexName() {
        return indexName;
    }

    public void setIndexName(String indexName) {
        this.indexName = indexName;
    }

    public String getCollectionPath() {
        return collectionPath;
    }

    public void setCollectionPath(String collectionPath) {
        this.collectionPath = collectionPath;
    }

    public boolean isUpdating() {
        return updating;
    }

    public void setUpdating(boolean updating) {
        this.updating = updating;
    }
    
    
}


package Controllers;

import Models.FileManager.FileManager;
import Models.IndexManager.IndexDataManager;
import Models.IndexManager.Indexer;
import Views.IndexView;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JFrame;

public class IndexerController {
    
    private IndexDataManager indexDataManager;
    private Indexer indexer;  

    private IndexView view;
    
    public IndexerController(){
        this.indexDataManager = new IndexDataManager();
        this.indexer = new Indexer();

    }

    public IndexerController(IndexView view) {
        this.indexDataManager = new IndexDataManager();
        this.view = view;
        this.indexer = new Indexer();
    }
      
    public void createIndex(String nameIndex, String collectionPath) throws IOException{
        if(IndexDataManager.getIndexData().indexPath.containsKey(nameIndex)){
            //TODO Mostrar mensaje de que es nombre de indice ya existe
            view.setTextCreateMsgLabel("'" + nameIndex + "'" + " is already taken");
            view.cleanIndexingInfoArea();
        }
        else{
            //TODO Agregar validaciones si la colleccion existe
            view.setTextCreateMsgLabel("");
            view.cleanIndexingInfoArea();
            view.addTextIndexingArea("Creating index " + nameIndex + "\n");
            view.addTextIndexingArea("Indexing collection " + collectionPath + "\n");
            String indexFilePath = IndexDataManager.IndexFilePath + nameIndex;
            
            indexer.Index(indexFilePath, collectionPath);  
            
            view.addTextIndexingArea("Succesfull!\n");
            view.addTextIndexingArea(getIndexingInfo() + "\n");
            view.cleanCreateCollectionPath();
            
            addNewIndexData(nameIndex, collectionPath, indexFilePath, true);
            //TODO Retornar informacin del tiempo y cantidad del indexado
        }  
    }
    
    public void updateIndex(String nameIndex, String collectionPath) throws IOException{
        IndexDataManager.getIndexData();
        System.out.println("No Indice DataManger");
        if(IndexDataManager.getIndexData().indexCollections.get(nameIndex).contains(collectionPath)){
            view.setTextUpdateMsgLabel("Collection is already indexed in " + nameIndex);
        }
        else{
            view.setTextUpdateMsgLabel("");
            view.cleanIndexingInfoArea();
            view.addTextIndexingArea("Accesing " + nameIndex + "\n");
            view.addTextIndexingArea("Updating index, collection " + collectionPath + "\n");            
            String indexFilePath = IndexDataManager.getIndexData().indexPath.get(nameIndex);
            
            indexer.Index(indexFilePath, collectionPath);
            
            view.addTextIndexingArea("Succesfull!\n");
            view.addTextIndexingArea(getIndexingInfo() + "\n");
            view.cleanUpdateCollectionPath();   
            
            addNewIndexData(nameIndex, collectionPath, indexFilePath, false);
            //TODO Retornar informacin del tiempo y cantidad del indexado
        }
    }
    
    private void addNewIndexData(String nameIndex, String collectionPath, String indexFilePath, boolean create){
        //Add new data to IndexData
        
            if(create){
                HashMap<String, ArrayList<String>> collections = IndexDataManager.getIndexData().indexCollections;
                collections.put(nameIndex, new ArrayList<>());
                collections.get(nameIndex).add(collectionPath);
                
                IndexDataManager.getIndexData().indexPath.put(nameIndex, indexFilePath);
            }
            else{
                IndexDataManager.getIndexData().indexCollections.get(nameIndex).add(collectionPath);
            }
            
            indexDataManager.Save();
    }
    
    public String getIndexingInfo(){
        return this.indexer.getCuantityDocuments() + " indexed documents in " + this.indexer.getTime() + " seconds" + ". Total: " + this.indexer.getNumDocs(); 
    }
    
    
    
}

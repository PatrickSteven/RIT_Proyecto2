
package Controllers;

import Models.FileManager.FileManager;
import Models.IndexManager.IndexDataManager;
import Models.IndexManager.Indexer;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JFrame;

public class IndexerController {
    
    private IndexDataManager indexDataManager;
    private Indexer indexer;  

    private JFrame view;
    
    public IndexerController(){
        this.indexDataManager = new IndexDataManager();

    }

    public IndexerController(JFrame view) {
        this.indexDataManager = new IndexDataManager();
        this.view = view;
    }
      
    public void createIndex(String nameIndex, String collectionPath) throws IOException{
        if(IndexDataManager.getIndexData().indexPath.containsKey(nameIndex)){
            //TODO Mostrar mensaje de que es nombre de indice ya existe
        }
        else{
            //TODO Agregar validaciones si la colleccion existe
            String indexFilePath = IndexDataManager.IndexFilePath + nameIndex;
            indexer.Index(indexFilePath, collectionPath);  
            
            addNewIndexData(nameIndex, collectionPath, indexFilePath, true);
            //TODO Retornar informacin del tiempo y cantidad del indexado
        }  
    }
    
    public void updateIndex(String nameIndex, String collectionPath) throws IOException{
        if(IndexDataManager.getIndexData().indexCollections.get(nameIndex).contains(collectionPath)){
            //TODO Mostrar mensaje de que esa colleccion ya existe en ese indice
        }
        else{
            String indexFilePath = IndexDataManager.getIndexData().indexPath.get(nameIndex);
            indexer.Index(indexFilePath, collectionPath);
            
            addNewIndexData(nameIndex, collectionPath, indexFilePath, false);
            //TODO Retornar informacin del tiempo y cantidad del indexado
        }
    }
    
    private void addNewIndexData(String nameIndex, String collectionPath, String indexFilePath, boolean create){
        //Add new data to IndexData
            if(create)
            IndexDataManager.getIndexData().indexCollections.put(nameIndex, new ArrayList<>()).add(collectionPath);
            IndexDataManager.getIndexData().indexPath.put(nameIndex, indexFilePath);
            indexDataManager.Save();
    }
    
    public String getIndexingInfo(){
        return this.indexer.getCuantityDocuments() + " indexed documents in " + this.indexer.getTime() + " ms"; 
    }
    
    
    
}

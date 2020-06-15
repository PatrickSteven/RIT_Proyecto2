
package Models.IndexManager;

import Models.FileManager.FileManager;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class IndexDataManager implements Serializable{
    
    private static IndexData indexData;
    public static final String IndexDataFilePath = "../Data/indexData";
    public static final String IndexFilePath = "../Data/Index/index_";

    public IndexDataManager() {
        LoadIndexData();
    }
    
    
    
    public class IndexData implements Serializable{

        // Index : [Collection1, Collection2]
        // "IndexWiki1" : ["Collections/Wiki1/wiki-p1.txt", "Collections/Wiki1/wiki-g1.txt"],  
        public HashMap<String, ArrayList<String>> indexCollections;

        //Index : [indexPath]
        //"IndexWiki1" : "Data/Index/Index_Wiki_1
        public HashMap<String, String> indexPath;
        
        //If there is not object in Data file //The readObject method return null
        public IndexData() {
            this.indexCollections = new HashMap<String, ArrayList<String>>();
            this.indexPath = new HashMap<String, String>();
        }
        
        public String[] getIndexes(){
            Set<String> indexesNames = indexCollections.keySet();
            String allKeys = "";
            for(String name : indexesNames) allKeys += name;
            return allKeys.split(" ");
        }
    }
    
    public void Save(){
        this.SaveIndexData();
    }
    
    public static IndexData getIndexData(){
        return IndexDataManager.indexData;
    } 
        
    //Load Index Data
    private void LoadIndexData(){
        IndexDataManager.indexData = (IndexData) FileManager.readObject(IndexDataFilePath);
        if(IndexDataManager.indexData == null) IndexDataManager.indexData = new IndexData();
        this.SaveIndexData();
    }
   
    //Save changes in index data
    private void SaveIndexData(){
        FileManager.writeObject(IndexDataManager.indexData, IndexDataFilePath);
    }
}

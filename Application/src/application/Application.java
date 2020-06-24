/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

import Controllers.IndexerController;
import Models.IndexManager.IndexDataManager;
import Models.WebPageManagerP.HtmlDocument;
import Models.WebPageManagerP.WebPage;
import Models.WebPageManagerP.WebPageManager;
import Views.IndexView;
import Views.SearchView;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;



/**
 *
 * @author Personal
 */
public class Application {

    public static void main(String[] args) throws IOException{    
        
        IndexView indexView = new IndexView();
        SearchView searchView = new SearchView();
        indexView.setVisible(true);
        searchView.setVisible(true);

    }        
}
    

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

import Controllers.IndexerController;
import Models.IndexManager.IndexDataManager;
import Models.WebPageManagerP.HtmlDocument;
import Models.WebPageManagerP.WebPageManager;
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
            
        
        WebPageManager wb = new WebPageManager();    
        /*
        ArrayList<String> html = wb.getHTMLDocument("D:\\Documentos\\Collections\\wiki-p1.txt", 0, 144);
        String texto = "<body>Me cago en la put4 esto está caliente. Los viernes de la jungla estan a todo ojete </body>";
        String cleanText = wb.removeStopWords(texto);
        //for(String line : html) texto += line;
        String body = wb.parse(cleanText);    
        */
        String htmlPath = "C:\\ITCR\\unHTML.txt";
        
        
        wb.getWebPages(htmlPath);
        //wb.resetWebPageList();
    }   
        
        
        
}
    

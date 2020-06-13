/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

import Models.WebPageManager.HtmlDocument;
import Models.WebPageManager.WebPageManager;
import java.io.IOException;
import java.util.ArrayList;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 *
 * @author Personal
 */
public class Application {

    public static void main(String[] args) throws IOException{
                      
        WebPageManager wb = new WebPageManager();        
        ArrayList<String> html = wb.getHTMLDocument("D:\\Documentos\\Collections\\wiki-p1.txt", 0, 144);
        String texto = "<body>Me cago en la put4 esto está caliente. Los viernes de la jungla estan a todo ojete </body>";
        String cleanText = wb.removeStopWords(texto);
        //for(String line : html) texto += line;
        String body = wb.parse(cleanText);
        System.out.println(body);
        
    }

}

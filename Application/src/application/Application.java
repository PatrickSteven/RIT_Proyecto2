/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

import Models.WebPageManager;
import java.io.IOException;

/**
 *
 * @author Personal
 */
public class Application {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        WebPageManager wb = new WebPageManager();
        
        try {
            String texto = wb.readFile("C:\\ITCR\\unHTML.txt");
            wb.parse(texto);
        } catch (Exception ex) {
            
        }
    }
}
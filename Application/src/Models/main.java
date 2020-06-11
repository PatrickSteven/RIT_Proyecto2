/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

/**
 *
 * @author sven
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        WebPageManager wb = new WebPageManager();
        try {
            String texto = wb.readFile("C:\\ITCR\\prueba.txt");
            System.out.println(texto + " sirvio");
        } catch (Exception ex) {
            
        }

    }
    
}

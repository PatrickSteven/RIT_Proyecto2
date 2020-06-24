/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models.WebPageManagerP;

public class WebPage {
    private String texto;
    private String ref;
    private String encab;
    private String titulo;
    //private String enlace;
    private String collection;
    
    private int initialPosition;
    private int endPosition;

    public WebPage(String texto, String ref, String encab, String titulo, int initialPosition, int endPosition, String path) {
        this.texto = texto;
        this.ref = ref;
        this.encab = encab;
        this.titulo = titulo;
        //this.enlace = enlace;
        this.initialPosition = initialPosition;
        this.endPosition = endPosition;
        this.collection = path;
    }

    public WebPage() {
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }

    public String getEncab() {
        return encab;
    }

    public void setEncab(String encab) {
        this.encab = encab;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getInitialPosition() {
        return initialPosition;
    }

    public void setInitialPosition(int initialPosition) {
        this.initialPosition = initialPosition;
    }

    public int getEndPosition() {
        return endPosition;
    }

    public void setEndPosition(int endPosition) {
        this.endPosition = endPosition;
    }

    public String getCollection() {
        return collection;
    }

    public void setCollection(String collection) {
        this.collection = collection;
    }
    
    
    
    
}

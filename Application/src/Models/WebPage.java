/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

public class WebPage {
    private String texto;
    private String ref;
    private String encab;
    private String titulo;
    private String enlace;
    
    private int initialPosition;
    private int endPosition;

    public WebPage(String texto, String ref, String encab, String titulo, String enlace, int initialPosition, int endPosition) {
        this.texto = texto;
        this.ref = ref;
        this.encab = encab;
        this.titulo = titulo;
        this.enlace = enlace;
        this.initialPosition = initialPosition;
        this.endPosition = endPosition;
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

    public String getEnlace() {
        return enlace;
    }

    public void setEnlace(String enlace) {
        this.enlace = enlace;
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
    
    
    
    
}

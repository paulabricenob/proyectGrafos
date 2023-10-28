/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Objetos;

/**
 *
 * @author Enzo
 */
public class Arco {

    private String start;
    private String end;
    private boolean nodopersonaVisitado = false;
    

    public Arco(String start, String end) {
        this.start = start;
        this.end = end;
    }

    public String getStart() {
        return start;
    }


    public void setStart(String start) {
        this.start = start;
    }


    public String getEnd() {
        return end;
    }

 
    public void setEnd(String end) {
        this.end = end;
    }
    
    public void visitarNodoPersona(String name) {
        nodopersonaVisitado = true;
    }

    
    
}

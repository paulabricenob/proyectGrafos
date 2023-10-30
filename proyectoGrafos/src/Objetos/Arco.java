/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Objetos;

/**

 * Esta clase define el objeto Grafo, con la cual tiene diferentes atributos y funciones que lo definen

 * @author: Vincenzo Miraglia, Paula Briceño, Nicola Colaruso

 * @version: 24/10/2023/A

 */
public class Arco {

    private String start;
    private String end;
    private boolean nodopersonaVisitado = false;
//Campos de la clase
//constructor
    public Arco(String start, String end) {
        this.start = start;
        this.end = end;
    }
//getter para el nodo inicial del arco
    public String getStart() {
        return start;
    }

//setter para el nodo inicial
    public void setStart(String start) {
        this.start = start;
    }

//getter para el nodo final el arco
    public String getEnd() {
        return end;
    }

//setter para el nodo final
    public void setEnd(String end) {
        this.end = end;
    }
//metodo para visitar los nodos 
    public void visitarNodoPersona(String name) {
        nodopersonaVisitado = true;
    }
    
}

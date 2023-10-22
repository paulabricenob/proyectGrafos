/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Objetos;
import TDatos.Lista;

        
/**
 *
 * @author diego
 */
public class NodoPersona {
    private String name;
    private int id;
    private NodoPersona pnext;
    private Lista<Arco> conocidos;
    
    public NodoPersona(String name, Lista conocidos, int id){
        this.name = name;
        this.pnext = null;
        this.conocidos = conocidos;
        this.id = id;
    }
    
    public String getName() {
        return name;
    }
    
    public int getid() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public NodoPersona getPnext() {
        return pnext;
    }

    public void setPnext(NodoPersona pnext) {
        this.pnext = pnext;
    }
    public Lista getconocidos() {
        return conocidos;
    }
    
    public void addToconocidos(Arco Arco){
        this.conocidos.append(Arco);
    }

    public void setconocidos(Lista conocidos) {
        this.conocidos = conocidos;
    }
    
}

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
public class Persona {
    private String name;
    private Lista<Arco> conocidos;

    public Persona(String name, Lista<Arco> conocidos) {
        this.name = name;
        this.conocidos = conocidos;
    }
    
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

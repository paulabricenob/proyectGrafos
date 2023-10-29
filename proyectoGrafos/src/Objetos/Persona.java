/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Objetos;
import TDatos.Lista;

        
/**

 * Esta clase define objetos 

 * @author: Vincenzo Miraglia, Paula Briceño, Nicola Colaruso

 * @version: 24/10/2023/A

 */
public class Persona {
    private String name;
    private Lista<Arco> conocidos;
//Campos de la clase
    //constructor
    public Persona(String name, Lista<Arco> conocidos) {
        this.name = name;
        this.conocidos = conocidos;
    }
    
//getter para tomar nombre
    public String getName() {
        return name;
    }
//setter para el nombre

    public void setName(String name) {
        this.name = name;
    }

//getter para tomar el concocido

    public Lista getconocidos() {
        return conocidos;
    }
//metodo de la clase Persona para añadir concocidos a un arco   

    public void addToconocidos(Arco Arco){
        this.conocidos.append(Arco);
    }
//metodo de la clase Persona para set concocidos a un arco   
    public void setconocidos(Lista conocidos) {
        this.conocidos = conocidos;
    }
    
}

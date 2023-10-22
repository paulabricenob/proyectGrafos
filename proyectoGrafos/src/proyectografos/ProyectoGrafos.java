/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package proyectografos;

import Objetos.Funciones;
import Objetos.NodoPersona;
import TDatos.Lista;

/**
 *
 * @author paula
 */
public class ProyectoGrafos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //Instanciamos las clases para usar el archivo txt
        Funciones func= new Funciones();
        Lista<NodoPersona> users = new Lista();
        //Prueba de insertar...
       
        users.insert_at_last("Nicola", "Paula");
        users.insert_at_last("Vincenzo", "Nicola");
        //escribimos en el txt lo que insertamos
        func.write_txt(users);
        
        Lista<NodoPersona> users2 = func.read_txt();
        users2.show_elements();
    }
    
}
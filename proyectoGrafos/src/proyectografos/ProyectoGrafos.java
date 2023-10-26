/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package proyectografos;

//import GUI.Ventana1;
import Objetos.Funciones;
import Objetos.Persona;
import TDatos.Grafo;
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
        Grafo users = new Grafo();
        //Prueba de insertar...
        users.addusuario("Paula");
        users.AgregarArco("Paula", "Nicola");
        //escribimos en el txt lo que insertamos
        func.write_txt(users);
        
        Grafo users2 = func.read_txt();
        users2.show_elements_Grafo(users);
        
        //instanciamos la ventana
      //  Ventana1 ventana = new Ventana1();
       // ventana.setVisible(true);
    }
    
}
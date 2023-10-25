/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package proyectografos;

import org.graphstream.graph.*;
import org.graphstream.graph.implementations.*;
import GUI.Ventana1;
import Objetos.Funciones;
import Objetos.NodoPersona;
import TDatos.Lista;

/**
 *
 * @author paula
 */
public class ProyectoGrafos {
    
    
    
    public static void main(String[] args) {
        String text = "usuarios\n@pepe\n@mazinger\nrelaciones\n@pepe, @mazinger\n@mazinger, @juanc\n..."; 

        String[] parts = text.split("relaciones");
        String users = parts[0].replace("usuarios", "").trim();
        String relationships = parts[1].trim();

        System.out.println("Users:\n" + users);
        System.out.println("Relationships:\n" + relationships);
    }
    
    
    /* a partir de aqui es lo del visualizador
    public static void main(String[] args) {
        System.setProperty("org.graphstream.ui", "swing");
		
		Graph graph = new SingleGraph("Prueba 1");

		graph.addNode("A");
		graph.addNode("B");
		graph.addNode("C");
		graph.addEdge("AB", "A", "B");
		graph.addEdge("BC", "B", "C");
		graph.addEdge("CA", "C", "A");

		graph.display();
    }*/
    
}
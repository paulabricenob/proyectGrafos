/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Objetos;


import Objetos.Persona;
import TDatos.Grafo;
import TDatos.Lista;
import TDatos.Nodo;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;
import javax.swing.JOptionPane;
import java.io.IOException;
import javax.swing.JFileChooser;
import org.graphstream.graph.*;
import org.graphstream.graph.implementations.*;

/**
 *
 * @author diego
 */
public class Funciones {
    //escribir en el txt
    
    
    public String leer_txt(){
        Lista<Persona> usuarios = new Lista<Persona>();
        String line;
        String usuarios_txt = "";
        String path = "test\\usuarios.txt";
        File file = new File(path);
        try{
            if (!file.exists()){
                file.createNewFile();
            }else{
                FileReader fr = new FileReader(file);
                BufferedReader br = new BufferedReader(fr);
                while((line = br.readLine()) != null){
                    if(!line.isEmpty()){
                        usuarios_txt += line + "\n";    
                    }    
                }
                if(!"".equals(usuarios_txt)){
                    String[]usuarios_split = usuarios_txt.split("relaciones");
                }
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        return usuarios_txt;
    }    
    
    public Lista<Persona> ListaUsuarios(String txt){
        String data = txt;
        Lista<Persona> usuarios = new Lista<>();
        
        String[] data_split = data.split("relaciones");
        String[] data_users = data_split[0].split("\n");
        String[] data_relations = data_split[1].split("\n");
        
        if (data_split.length > 1) {
            data_relations = data_split[1].split("\n");
        }
        
        for (int i=1; i<data_users.length;i++){
            Lista relaciones = new Lista();
            Persona user = new Persona((data_users[i].substring(1)), relaciones);
            for (int j=0;j<data_relations.length;j++){
                String[] relacion = data_relations[j].split(",");
                if (("@"+user.getName()).equals(relacion[0])){
                    Arco arc = new Arco(relacion[0], relacion[1]);
                    relaciones.append(arc);
                }
            }
            user.setconocidos(relaciones);
            usuarios.append(user);
        }    
        return usuarios;
   
    }

    public void write_Txt(Lista usuarios ,String fileRoute) {
        if ("".equals(fileRoute)){
            JOptionPane.showMessageDialog(null, "Error! No hay ruta de acceso.");
        } 
        else{
            String str = "Usuarios\n";
            if (usuarios.isEmpty() == false){
                for (int x = 0; x < usuarios.len(); x++){
                    Persona person = (Persona) usuarios.get(x);
                    str =  str+ "@" + person.getName() + "\n";
                }
                str = str + "Relaciones\n";
                for (int x = 0; x < usuarios.len(); x++){
                    Persona person = (Persona) usuarios.get(x);
                    Lista auxList = person.getconocidos();
                    for (int y = 0; y < auxList.len(); y++){
                        Arco edge = (Arco) auxList.get(y);
                        if(edge != null){
                            str += edge.getStart() + ", " + edge.getEnd() + "\n";                                             
                        }
                    }
                }
            }
            try{
               PrintWriter pw = new PrintWriter(fileRoute); 
               pw.print(str);
               pw.close();
            } catch (Exception e){
                JOptionPane.showMessageDialog(null, "Error! No se ha escrito sobre el archivo.");
            }
        }
    }
    
    public void Vergrafo(Lista usuarios) {
        System.setProperty("org.graphstream.ui", "swing");
        Graph graph = new SingleGraph("Tutorial 1");
            String str = "Usuarios\n";
            if (usuarios.isEmpty() == false){
                for (int x = 0; x < usuarios.len(); x++){
                    Persona person = (Persona) usuarios.get(x);
                    str =  str+ "@" + person.getName() + "\n";
                    graph.addNode(person.getName());
                }
                str = str + "Relaciones\n";
                for (int x = 0; x < usuarios.len(); x++){
                    Persona person = (Persona) usuarios.get(x);
                    Lista auxList = person.getconocidos();
                    for (int y = 0; y < auxList.len(); y++){
                        Arco edge = (Arco) auxList.get(y);
                        if(edge != null){
                            str += edge.getStart() + ", " + edge.getEnd() + "\n";
                            graph.addEdge(edge.getStart()+edge.getEnd(), edge.getStart(), edge.getEnd());
                        }
                    }
                }
            }
            
        graph.setAttribute("ui.stylesheet", "node { text-alignment: under; }");
               
        for (Node node : graph) {
        node.setAttribute("ui.label", node.getId());
        }
               
        for (Node node : graph) {
        node.setAttribute("ui.style", "text-size: 25;");
        }
        
        graph.display();

        }
    
    
 }
       
        
       
        

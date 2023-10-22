/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Objetos;


import TDatos.Grafo;
import Objetos.NodoPersona;
import TDatos.Lista;
import TDatos.Nodo;
import proyectografos.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
//import java.io.FileWriter;
import java.io.PrintWriter;
//import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import java.io.IOException;

/**
 *
 * @author diego
 */
public class Funciones {
    //escribir en el txt
    public void write_txt(Lista Usuarios){
        String current_users = "";
        if (!Usuarios.isEmpty()){
            for (int x=0; x <Usuarios.getSize(); x++){
                NodoPersona persona = (NodoPersona) Usuarios.get(x); 
                current_users += persona.getName()+"\n";
            }
            for (int x=0; x <Usuarios.getSize(); x++){
                NodoPersona persona = (NodoPersona) Usuarios.get(x); 
                current_users += persona.getName() + "," + persona.getconocidos() + "\n";
            }      
        }
        try{
           PrintWriter pw= new PrintWriter("test\\usuarios.txt");
           //pw.print -- borra la info actual
           pw.print(current_users); 
           //pw.append -- agrega info
           pw.append("Paula, Vincenzo");
           pw.append("\n");
           pw.append("Nicola, Paula");
           pw.close();
           // revisar si podemos usar JOption Pane
           JOptionPane.showMessageDialog(null, "Guardado exitoso");
                     
        }catch(IOException err){
            //muestra el error
            JOptionPane.showMessageDialog(null, err);
        }
    
    }
    
    //leer el txt
    public Lista read_txt(){
        Lista users = new Lista();
        String line;
        String usuarios_txt = "";
        String path = "test\\usuarios.txt";
        File file = new File(path);
        try{
            if(!file.exists()){
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
                    String[] users_split = usuarios_txt.split("\n");
                    for (int i=0; i < users_split.length; i++){
                        String [] user = users_split[i].split(",");
                        users.append(user[0], user[1]); 
                    }
                }
                br.close();
                JOptionPane.showMessageDialog(null, "Lectura exitosa!");
            }
         
        }catch(IOException err){
            JOptionPane.showMessageDialog(null, "Error al leer el archivo de usuarios.");
        }
        return users;
                
    }
    
    
    //JFile Chooser clase Ventana
    //Revisar si es`public o private...
    //ABRIR ARCHIVOS -->
    //private String openfile(){
    //    String aux= "";
    //    String text = "";
    //    try{
    //        JFileChooser file=new JFileChooser();
    //        file.showOpenDialog(this);
    //        File open= file.getSelectedFile();
    //        if (open!=null){
    //            FileReader files = new FileReader(open);
    //            BufferedReader read= new BufferedReader(files);
    //            while((aux = read.readLine()) != null){
    //                text += aux + "\n";
    //                read.close();
                    
    //            }
    //        }
    //    }catch(IOException err){
    //        JOptionPane.showMessageDialog(null, err + "\n No se ha encontrado el archivo", "Advertencia!!", JOptionPane.WARNING_MESSAGE);
            
    //    }
    //    return text ; //el texto se guarda en el JTextArea usando setText(text(
    //}
    //GUARDAR ARCHIVOS -->
    //private String savefile(){
    //    try{
    //       String name = "";
    //        JFileChooser file = new JFileChooser();
    //        file.showSaveDialog(this);
    //        File save = file.getSelectedFile();
    //        if (save != null){
    //            FileWriter save = new FileWriter(save +".txt");
    //            save.write(areaDeTexto.getText());
    //            save.close();
    //           JOptionPane.showMessageDialog(null,"El archivo se guardó exitosament", "Información:", JOptionPane.INFORMATION_MESSAGE);
    //        }
    //    }catch(IOException err){
    //        JOptionPane.showMessageDialog(null, err + "\n No se ha guardado el archivo", "Advertencia!!", JOptionPane.WARNING_MESSAGE);
        
    //    }
    //}
    
    
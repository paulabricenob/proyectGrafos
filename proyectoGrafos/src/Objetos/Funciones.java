/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Objetos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;
import javax.swing.JOptionPane;

/**
 *
 * @author diego
 */
public class Funciones {
    //escribir en el txt
    public void write_txt(ListaPersonas users){
        String current_users = "";
        if (!users.isEmpty()){
            NodoPersona temp = users.getpFirst();
            for (int i=0; i <users.getiN(); i++){
                current_users += temp.getName()+ "," + temp.getconocidos() + "\n";
                temp = temp.getPnext();
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
                     
        }catch(Exception err){
            //muestra el error
            JOptionPane.showMessageDialog(null, err);
        }
    
    }
    
    //leer el txt
    public ListaPersonas read_txt(){
        ListaPersonas users = new ListaPersonas();
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
                        users.insert_at_last(user[0], user[1]); 
                    }
                }
                br.close();
                JOptionPane.showMessageDialog(null, "Lectura exitosa!");
            }
         
        }catch(Exception err){
            JOptionPane.showMessageDialog(null, "Error al leer el archivo de usuarios.");
        }
        return users;
                
    }
}

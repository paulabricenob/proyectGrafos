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

/**
 *
 * @author diego
 */
public class Funciones {
    //escribir en el txt
    public void write_txt(Grafo usuarios){
        String current_users = "";
        if (!usuarios.getusuarios().isEmpty()){
            Nodo<Persona> temp = usuarios.getusuarios().getHead();
            for (int i=0; i < usuarios.getusuarios().len(); i++){
                current_users += temp.getData().getName()+ "," + temp.getData().getconocidos() + "\n";
                temp = temp.getNext();
            }
        }
        
        try{
           PrintWriter pw= new PrintWriter("test\\usuarios.txt");
           //pw.print -- borra la info actual
           pw.print(current_users); 
           //pw.append -- agrega info
           //pw.append("");
           // revisar si podemos usar JOption Pane
           JOptionPane.showMessageDialog(null, "Guardado exitoso");
                     
        }catch(IOException err){
            //muestra el error
            JOptionPane.showMessageDialog(null, err);
        }
    
    }
    
    //leer el txt
    public Grafo read_txt(){
        Grafo graph = new Grafo();
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
                    String[] users_split = usuarios_txt.split("relaciones");
                    String users = users_split[0].replace("usuarios", "").trim();
                    graph.addusuario(users);
                    // aqui tamb va el visualizador del usuario
                    
                    String relationships = users_split[1].trim(); 
                    
                    
                    // aqui tambien hay que comprobar si hay relaciones
                    for (int i=0; i < relationships.length(); i++){
                        String[] arco = relationships.split(",");
                        graph.AgregarArco(arco[0], arco[1]);
                    }
                }
                br.close();
                JOptionPane.showMessageDialog(null, "Lectura exitosa!");
            }
         
        }catch(Exception err){
            JOptionPane.showMessageDialog(null, "Error al leer el archivo de usuarios.");
        }
        return graph;
        
                
    }
            // OPCION DE CODIGO
              //  if(!"".equals(usuarios_txt)){
                 //   while(usuarios_txt.equals("usuarios")){
                    //    String[] users_split = usuarios_txt.split("\n");
                      //  for (int i=0; i < users_split.length ; i++){
                        //    users.addusuario(users_split[0]);
                       // }
                        
                        
                    //}
                    //for (int i=0; i < users_split.length; i++){
                    //    String [] user = users_split[i].split(",");
                    //    users.addusuario(user[0], user[1]); 
                    //}
               // }
                
    
    //JFile Chooser clase Ventana
    //Revisar si es`public o private...

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
   



}
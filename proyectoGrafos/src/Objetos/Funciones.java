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

/**
 *
 * @author diego
 */
public class Funciones {
    //escribir en el txt
    /*public String select_files(){
        String path;
        JFileChooser search = new JFileChooser();
        search.showOpenDialog(search);
        path = search.getSelectedFile().getAbsolutePath();
        return path;
    }
    */
    public String leer_txt(String line){
        Lista<Persona> usuarios = new Lista<Persona>();
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
                    for (int i=0; i<usuarios_split.length;i++){
                        
                    }
                }
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        return usuarios_txt;
    }    
    
    public Lista<Persona> ListaUsuarios(){
        String data = leer_txt();
        Lista<Persona> usuarios = new Lista<Persona>();
        
        String[] data_split = data.split("relaciones");
        String[] data_users = data_split[0].split("\n");
        String[] data_relations = data_split[1].split("\n");
        for (int i=1; i<data_users.length;i++){
            Lista relaciones = new Lista();
            Persona user = new Persona((data_users[i].substring(1)), relaciones);
            for (int j=0;j<data_relations.length;j++){
                String[] relacion = data_relations[j].split(",");
                if (("@"+user.getName()).equals(relacion[0])){
                    String conocidos = relacion[1].substring(2);
                    relaciones.append(conocidos);
                }
            }
            user.setconocidos(relaciones);
            usuarios.append(user);
        }    
        return usuarios;
   
    }
        
    
    Grafo graph = new Grafo();
    graph.crearGrafo()
    Lista nombre = ListaUsuarios();
    graph.setUsuarios(nombre);
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    /*
    public void write_Txt(Lista<Persona> usuarios ,String fileRoute) {
        if ("".equals(fileRoute)){
            JOptionPane.showMessageDialog(null, "Error! No hay ruta de acceso.");
        } 
        else{
            String str = "Usuarios\n";
            if (usuarios.isEmpty() == false){
                for (int x = 0; x < usuarios.len(); x++){
                    Persona person = usuarios.get(x);
                    str =  person.getName() + "\n";
                }
                str = str + "Relaciones\n";
                for (int x = 0; x < usuarios.len(); x++){
                    Persona person = usuarios.get(x);
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
    public void write_Txt(Grafo usuarios ,String fileRoute) {
        if ("".equals(fileRoute)){
            JOptionPane.showMessageDialog(null, "Error! No hay ruta de acceso.");
        } 
        else{
            String str = "Usuarios\n";
            if (usuarios.getusuarios().isEmpty() == false){
                for (int x = 0; x < usuarios.getusuarios().len(); x++){
                    Nodo<Persona> person = (Nodo<Persona>) usuarios.getusuarios().get(x);
                    str =  person.getData().getName() + "\n";
                }
                str = str + "Relaciones\n";
                for (int x = 0; x < usuarios.getusuarios().len(); x++){
                    Nodo<Persona> person = (Nodo<Persona>) usuarios.getusuarios().get(x);
                    Lista auxList = person.getData().getconocidos();
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
        
                
    }*/
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
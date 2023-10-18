/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectografos;

import java.io.PrintWriter;

/**
 *
 * @author diego
 */
public class Funciones {
    
    public void write_txt(Lista users){
        String current_users = "";
        if (!users.isEmpty()){
            NodoPersona temp = users.first();
            for (int i=0; i <users.size(); i++){
                current_users += temp.getName()+ "," + temp.getRelations() + "\n";
                temp = temp.getPnext();
            }
                  
        }
        try{
           PrintWriter pw = new PrintWritter("test\\usuarios.txt");
           pw.print(current_users);
           pw.append(current_users)
        }catch(Exception e)
    
    }
    
}

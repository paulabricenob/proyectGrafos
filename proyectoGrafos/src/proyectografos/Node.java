/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectografos;

/**
 *
 * @author diego
 */
public class Node <T> {
    protected T tInfo;
    protected Node <T> pNext;
    
    //Constructor
    public Node(T elem){
        this.tInfo=elem;
        this.pNext=null;
        
    } 
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectografos;

/**
 *
 * @author diego
 */
public class Lista <T>{
    private Node <T> pFirst;
    private String name;
    private int iN;
    
    
    public Lista (String s){
        this.name=s;
        this.pFirst=null;
        this.iN=0;
    }
    
    public int size (){
        return this.iN;
    }
    
    public boolean isEmpty(){
        return this.pFirst==last();
    }
    
    public Node last(){
        return null;
    }
    
    public Node first(){
        return this.pFirst;
    }
    
    public T read(Node <T> pValor){
        return pValor.tInfo;
    }
    
    public Node <T> next (Node <T> pValor){
        if (pValor != this.last()){
            return pValor.pNext;
        }else{
            return null;
        }
    }
    
    public void insert(T x, Node <T> pValor){
     // postinsertar.   
        Node <T> pNew= new Node <>(x);
        if (this.isEmpty()){
            this.pFirst=pNew;
        }else{
            pNew.pNext=pValor.pNext;
            pValor.pNext=pNew;
        }
        iN++;
    }
    public String travel (){
        Node <T> pAux; 
        String result="";
        if(this.isEmpty()){
            result="Está vacía";
        }else{
            pAux=this.first();
            while (pAux != this.last()){
                result=result+this.read(pAux)+ ", ";
                pAux=this.next(pAux);
            }
            
        }
        return result;
    }
    
    
    public Node <T> beforeLast(){
        if (this.isEmpty()){
            return null;
        }else{
            Node<T> pAux=this.first();
            while (pAux.pNext!= this.last()){
                pAux=this.next(pAux);
            }
            return pAux;
        }
    }
}


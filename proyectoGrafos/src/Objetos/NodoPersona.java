/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectografos;

/**
 *
 * @author diego
 */
public class NodoPersona {
    private String name;
    private NodoPersona pnext;
    private String relations;
    
    public NodoPersona(String name, String relations){
        this.name = name;
        this.pnext = null;
        this.relations = relations;
       
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public NodoPersona getPnext() {
        return pnext;
    }

    public void setPnext(NodoPersona pnext) {
        this.pnext = pnext;
    }

    public String getRelations() {
        return relations;
    }

    public void setRelations(String relations) {
        this.relations = relations;
    }
    
    
}

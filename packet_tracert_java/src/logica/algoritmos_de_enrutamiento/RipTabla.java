/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package logica.algoritmos_de_enrutamiento;

import java.util.ArrayList;

/**
 *
 * @author minrock
 */
public class RipTabla {
    
    private long id_owner;
    private ArrayList<EntradaRip> entradas;
    
    public RipTabla(long owner){
        this.id_owner = owner;
        entradas = new ArrayList<>();
    }

    /**
     * @return the id_owner
     */
    public long getId_owner() {
        return id_owner;
    }

    /**
     * @param id_owner the id_owner to set
     */
    public void setId_owner(long id_owner) {
        this.id_owner = id_owner;
    }

    /**
     * @return the entradas
     */
    public ArrayList<EntradaRip> getEntradas() {
        return entradas;
    }

    /**
     * @param entradas the entradas to set
     */
    public void setEntradas(ArrayList<EntradaRip> entradas) {
        this.entradas = entradas;
    }
    
}

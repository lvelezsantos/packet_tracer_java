/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package logica.algoritmos_de_enrutamiento;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author minrock
 */
public class RipTabla implements Serializable{
    
    private long id_owner;
    private ArrayList<EntradaRip> entradas;
    private boolean ripv2_enable;
    
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
    
     /**
     * @return the ripv2_enable
     */
    public boolean isRipv2_enable() {
        return ripv2_enable;
    }

    /**
     * @param ripv2_enable the ripv2_enable to set
     */
    public void setRipv2_enable(boolean ripv2_enable) {
        this.ripv2_enable = ripv2_enable;
    }
    
}

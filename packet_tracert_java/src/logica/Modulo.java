/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.util.ArrayList;

/**
 *
 * @author warlock
 */
public class Modulo {
    private ArrayList<Puerto> puertos;
    private String nombre;

    public Modulo() {
    }

    public Modulo(ArrayList<Puerto> puertos, String nombre) {
        this.puertos = puertos;
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Puerto> getPuertos() {
        return puertos;
    }

    public void setPuertos(ArrayList<Puerto> puertos) {
        this.puertos = puertos;
    }
    
    
}

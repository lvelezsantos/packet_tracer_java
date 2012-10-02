/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

/**
 *
 * @author warlock
 */
public class Puerto {
    private boolean activado;
    private boolean usado;
    private String ip;
    private String nombre;
    private int velocidad;
    private String nombre_velocidad;
    private String tipo_puerto; // Ethernet, FastEthernet, GigaEthernet, Serial

    public Puerto() {
    }

    
    
    public Puerto(boolean activado, String ip, String nombre, int velocidad, String nombre_velocidad,String tipo_puerto, boolean usado) {
        this.activado = activado;
        this.ip = ip;
        this.nombre = nombre;
        this.velocidad = velocidad;
        this.nombre_velocidad = nombre_velocidad;
        this.usado = usado;
    }

    public boolean isActivado() {
        return activado;
    }

    public void setActivado(boolean activado) {
        this.activado = activado;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(int velocidad) {
        this.velocidad = velocidad;
    }

    public String getNombre_velocidad() {
        return nombre_velocidad;
    }

    public void setNombre_velocidad(String nombre_velocidad) {
        this.nombre_velocidad = nombre_velocidad;
    }

    public String getTipo_puerto() {
        return tipo_puerto;
    }

    public void setTipo_puerto(String tipo_puerto) {
        this.tipo_puerto = tipo_puerto;
    }

    public boolean isUsado() {
        return usado;
    }

    public void setUsado(boolean usado) {
        this.usado = usado;
    }
    
    
    
}

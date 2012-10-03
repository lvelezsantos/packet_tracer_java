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
public class ProtocoloVectorDistancia {
    private ArrayList<String> ips_redes;
    private ArrayList<String> matriz_protocolo;
    private ArrayList<Router> routers;

    public ProtocoloVectorDistancia() {
    }

    
    public void add_ip(String ip){
        if(this.ips_redes.indexOf(ip)==-1){
            this.ips_redes.add(ip); 
        }else{
            System.err.println("Ya existe esta ip");
        }
        
    }
    
    public void remove_ip(String ip){
        if(this.ips_redes.indexOf(ip)!=-1){
            this.ips_redes.remove(ip);
        }else{
            System.err.println("Esta ip no existe");
        }
    }
    
    public ArrayList<String> getIps_redes() {
        return ips_redes;
    }

    public void setIps_redes(ArrayList<String> ips_redes) {
        this.ips_redes = ips_redes;
    }

    public ArrayList<String> getMatriz_protocolo() {
        return matriz_protocolo;
    }

    public void setMatriz_protocolo(ArrayList<String> matriz_protocolo) {
        this.matriz_protocolo = matriz_protocolo;
    }

    public ArrayList<Router> getRouters() {
        return routers;
    }

    public void setRouters(ArrayList<Router> routers) {
        this.routers = routers;
    }
    
    
    
    
    
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package logica.algoritmos_de_enrutamiento;

import java.io.Serializable;
import java.util.ArrayList;
import logica.Conexion;
import logica.Dispositivo;

/**
 *
 * @author warlock
 */
public class ProtocoloFlooding implements Serializable{
    private int numero_de_saltos;
    
    public void ejecutar_protocolo(ArrayList<Conexion> conexiones, 
                                   String ip_buscada, 
                                   int numero_de_saltos){
        boolean respuesta;
        for(int i=0; i<conexiones.size(); i++ ){
            Dispositivo dis = conexiones.get(i).getDispositivo();
            respuesta = dis.buscar_ip_en_conexiones(ip_buscada);
            if(numero_de_saltos<=0){
                break;
            }
            if(respuesta){
                System.out.println("se ha encontrado la ip "+ip_buscada+" se ha parado el algoritmo");
                break;
            }else{
                dis.getFlooding().ejecutar_protocolo(dis.getConexiones(), ip_buscada, numero_de_saltos--);
            }
        }
        
        
    }
}

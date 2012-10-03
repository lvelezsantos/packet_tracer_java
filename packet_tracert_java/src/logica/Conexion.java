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
public class Conexion {
    private Dispositivo dispositivo; // dispositivo al cual se conecta.
    private String modulo_cad; //modulo del dispositivo
    private String puerto_cad; // puerto del dispositivo

    public Conexion() {
    }

    
    
    public Conexion(Dispositivo dispositivo, String modulo_cad, String puerto_cad) {
        this.dispositivo = dispositivo;
        this.modulo_cad = modulo_cad;
        this.puerto_cad = puerto_cad;
    }
    
    
    
    public boolean conectar() throws Exception{
        /*
         Asigna el puerto del dispositivo como usado 
         */
        boolean flag =  false;
        ArrayList<Modulo> modulos = this.dispositivo.getModulos();
        for(int i=0;i<modulos.size();i++){
            Modulo modulo = modulos.get(i);
            ArrayList<Puerto> puertos = modulo.getPuertos();
            for(int j=0;j < puertos.size(); j++){
                Puerto puerto = puertos.get(j);
                if(modulo.getNombre().equals(this.modulo_cad) && puerto.getNombre().equals(this.puerto_cad)){
                    if(!puerto.isUsado()){
                        System.out.println(modulo_cad);
                        System.out.println(puerto_cad);
                        puerto.setUsado(true);
                        modulo.getPuertos().set(j, puerto);
                        this.dispositivo.getModulos().set(i, modulo);
                        flag = true;
                    }else{
                        throw new Exception("Puerto Ocupado");
                    }
                }              
                
            }
            
        }
        
        return flag;
        
    }
    
    public boolean desconectar(){
        /*
         Asigna el puerto del dispositivo como usado 
         */
        boolean flag =  false;
        ArrayList<Modulo> modulos = this.dispositivo.getModulos();
        for(int i=0;i<modulos.size();i++){
            Modulo modulo = modulos.get(i);
            ArrayList<Puerto> puertos = modulo.getPuertos();
            for(int j=0;j < puertos.size(); j++){
                Puerto puerto = puertos.get(j);
                if(modulo.getNombre().equals(this.modulo_cad) && puerto.getNombre().equals(this.puerto_cad)){
                    if(puerto.isUsado()){
                        puerto.setUsado(false);
                        modulo.getPuertos().set(j, puerto);
                        this.dispositivo.getModulos().set(i, modulo);
                        flag = true;
                    }else{
                        System.err.println("El puerto elegido no esta siendo usado");
                    }
                }              
                
            }
            
        }
        
        return flag;
        
    }
    

    public Dispositivo getDispositivo() {
        return dispositivo;
    }

    public void setDispositivo(Dispositivo dispositivo) {
        this.dispositivo = dispositivo;
    }

    public String getModulo_cad() {
        return modulo_cad;
    }

    public void setModulo_cad(String modulo_cad) {
        this.modulo_cad = modulo_cad;
    }

    public String getPuerto_cad() {
        return puerto_cad;
    }

    public void setPuerto_cad(String puerto_cad) {
        this.puerto_cad = puerto_cad;
    }
}

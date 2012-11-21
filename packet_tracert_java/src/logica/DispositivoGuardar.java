/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.awt.Point;
import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author warlock
 */

public class DispositivoGuardar implements Serializable{
    private String nombre;
    private int id_dispositivo;
    private ArrayList<Modulo>  modulos;
    private ArrayList<ConexionGuardar> conexiones;
    private Point point;
    
    public DispositivoGuardar() {
        this.conexiones = new  ArrayList<ConexionGuardar>();
    }
    
    public DispositivoGuardar(String nombre, ArrayList<Modulo> modulos,int id, Point point) {
        this.nombre = nombre;
        this.modulos = modulos;
        this.conexiones = new  ArrayList<ConexionGuardar>();
        this.id_dispositivo = id;
        this.point = point;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Modulo> getModulos() {
        return modulos;
    }

    public void setModulos(ArrayList<Modulo> puertos) {
        this.modulos = puertos;
    }

    public int getIdDispositivo() {
        return id_dispositivo;
    }

    public void setIdDispositivo(int id) {
        this.id_dispositivo = id;
    }
    
    public void colacarPuertosLibres(){
        for(int i=0;i<this.modulos.size();i++){
            Modulo modulo = this.modulos.get(i);
            for(int j=0; j < modulo.getPuertos().size(); j++){
                Puerto puerto = modulo.getPuertos().get(j);
                puerto.setUsado(false);
            }
        }
        
    }    
    
    
    public String mostrarPuertos(){
        System.out.println(this.nombre);
        String lista_puertos= "";
        for(int i=0;i<this.modulos.size();i++){
            Modulo modulo = this.modulos.get(i);
            for(int j=0; j < modulo.getPuertos().size(); j++){
                Puerto puerto = modulo.getPuertos().get(j);
                String cadena_puerto = modulo.getNombre() + "/" + puerto.getNombre() +" - Usado:"+ puerto.isUsado() +"\n";
                lista_puertos = lista_puertos.concat(cadena_puerto);
            }
        }
        System.out.println(lista_puertos);
        return lista_puertos;
    }    
    
    public ArrayList<String> mostrarPuertosLibres(){
        System.out.println(this.nombre);
        ArrayList<String> lista_puertos = new ArrayList<>();
        for(int i=0;i<this.modulos.size();i++){
            Modulo modulo = this.modulos.get(i);
            for(int j=0; j < modulo.getPuertos().size(); j++){
                Puerto puerto = modulo.getPuertos().get(j);
                if(!puerto.isUsado()){
                    String cadena_puerto = modulo.getNombre() + "/" + puerto.getNombre();
                    lista_puertos.add(cadena_puerto);
                }
            }
        }
        System.out.println(lista_puertos);
        return lista_puertos;
    }    

    /**
     * @return the point
     */
    public Point getPoint() {
        return point;
    }

    /**
     * @param point the point to set
     */
    public void setPoint(Point point) {
        this.point = point;
    }

    public ArrayList<ConexionGuardar> getConexiones() {
        return conexiones;
    }

    public void setConexiones(ArrayList<ConexionGuardar> conexiones) {
        this.conexiones = conexiones;
    }
    
    
    
    public int[] buscar_modulo_puerto(String modulo, String puerto){
        /*
         * Los datos iran de la siguiente forma en el vector
         * [modulo,puerto]
         */
        int[] datos = new int[2];
        datos[0] = -1;
        datos[1] = -1;
        for(int i=0;i<getModulos().size();i++){
            for(int j=0;j<getModulos().get(i).getPuertos().size(); j++){
                if(getModulos().get(i).getNombre().equals(modulo) && 
                        getModulos().get(i).getPuertos().get(j).getNombre().equals(puerto))
                {
                    datos[0] = i;
                    datos[1] = j;
                }
            }

        
        }
        return datos;
    }
    
    public boolean asignar_ip_puerto(String modulo, String puerto, String ip, String netmask){
        boolean flag = true;
        int[] datos = buscar_modulo_puerto(modulo, puerto);
        if(datos[0]!=-1){
            getModulos().get(datos[0]).getPuertos().get(datos[1]).setIp(ip);
            getModulos().get(datos[0]).getPuertos().get(datos[1]).setNetmask(netmask);
        }else{
            System.err.println("No se pudo asignar la ip al puerto");
            flag = false;
        }
        return flag;
    }
    
    public boolean encender_puerto(String modulo, String puerto) {
        boolean flag;
        int[] datos ;
        datos = buscar_modulo_puerto(modulo, puerto);
        if(!getModulos().get(datos[0]).getPuertos().get(datos[1]).isActivado()){
            getModulos().get(datos[0]).getPuertos().get(datos[1]).setActivado(true);        
            flag = true;
        }else{
            flag = false;
            System.err.println("No se activo el puerto porque ya estaba activado");
        }
        
        return flag;
    }
    
  
   
    
    
    
    
  
    
    
    
    
}

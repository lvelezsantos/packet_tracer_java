/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.awt.Point;
import java.util.ArrayList;

/**
 *
 * @author warlock
 */
public class Dispositivo {
    private String nombre;
    private int id;
    private ArrayList<Modulo>  modulos;
    private ArrayList<Conexion> conexiones;
    private Point point;
    
    public Dispositivo() {
        this.conexiones = new  ArrayList<Conexion>();
    }
    
    public Dispositivo(String nombre, ArrayList<Modulo> modulos,int id, Point point) {
        this.nombre = nombre;
        this.modulos = modulos;
        this.conexiones = new  ArrayList<Conexion>();
        this.id = id;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    
    
    public void agregar_conexion(Dispositivo dispositivo, String modulo_cad, String puerto_cad){
        Conexion conexion;
        conexion = new Conexion(dispositivo, modulo_cad, puerto_cad);
        conexion.conectar();
        this.conexiones.add(conexion);
    }
    
    public void eliminar_conexion(Dispositivo dispositivo, String modulo_cad, String puerto_cad){
        Conexion conexion;
        conexion = new Conexion(dispositivo, modulo_cad, puerto_cad);
        conexion.desconectar();
        this.conexiones.remove(conexion);
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
    
}

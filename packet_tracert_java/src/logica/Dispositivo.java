/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.awt.Point;
import java.util.ArrayList;
import logica.algoritmos_de_enrutamiento.ProtocoloFlooding;

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
    private ProtocoloFlooding flooding;
    
    public Dispositivo() {
        this.conexiones = new  ArrayList<Conexion>();
        this.flooding = new ProtocoloFlooding();
    }
    
    public Dispositivo(String nombre, ArrayList<Modulo> modulos,int id, Point point) {
        this.nombre = nombre;
        this.modulos = modulos;
        this.conexiones = new  ArrayList<Conexion>();
        this.id = id;
        this.point = point;
        this.flooding = new ProtocoloFlooding();
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

    public ProtocoloFlooding getFlooding() {
        return flooding;
    }

    public void setFlooding(ProtocoloFlooding flooding) {
        this.flooding = flooding;
    }
    
    public void agregar_conexion(Dispositivo dispositivo, String modulo_cad, String puerto_cad) throws Exception{
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

    public ArrayList<Conexion> getConexiones() {
        return conexiones;
    }

    public void setConexiones(ArrayList<Conexion> conexiones) {
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
    
    public boolean apagar_puerto(String modulo, String puerto) {
        boolean flag;
        int[] datos ;
        datos = buscar_modulo_puerto(modulo, puerto);
        if(getModulos().get(datos[0]).getPuertos().get(datos[1]).isActivado()){
            getModulos().get(datos[0]).getPuertos().get(datos[1]).setActivado(false);        
            flag = true;
        }else{
            flag = false;
            System.err.println("No se desactivo el puerto porque ya estaba desactivado");
        }
        
        return flag;
    }
    
    public String mostrar_informacion(){
        String informacion;
        informacion = "\nhostname\t" +getNombre();
        informacion += "\n!\n!\n!\n!\n!";
        String cad_puertos = "";
        for(int i=0;i<getModulos().size();i++){
            Modulo mod = getModulos().get(i);
            for(int j=0; j<mod.getPuertos().size();j++){
                Puerto puer = mod.getPuertos().get(j);
                cad_puertos += "\ninterface  "+ puer.getTipo_puerto() + " " + mod.getNombre() + "/" + puer.getNombre();
                if(!puer.getIp().equals("0.0.0.0")){
                    cad_puertos += "\n" + puer.getIp()+ "  " + puer.getNetmask();
                }else{
                    cad_puertos += "\nno ip address";
                }
                cad_puertos += "\nspeed   "+ puer.getVelocidad() + " " + puer.getNombre_velocidad();
                cad_puertos += "\n"+ puer.encendido();
                cad_puertos += "\n!";
                        
            }
        }
        informacion += cad_puertos;
        
        String cad_conexiones = "\nConexiones: ";
        for(int i=0;i<getConexiones().size();i++){
            Conexion conex = getConexiones().get(i);
            cad_conexiones += conex.getDispositivo().getNombre() + "\t" + conex.getModulo_cad() + "/" + 
                    conex.getPuerto_cad();
        }
        if(!getConexiones().isEmpty()){
            informacion += cad_conexiones;
        }
        return informacion;
    }
    
    public boolean buscar_ip_en_conexiones(String ip){
        boolean respuesta;
        respuesta = false;
        for(int i=0;i<getConexiones().size();i++){
            Dispositivo dispositivo = getConexiones().get(i).getDispositivo();
            for(int j=0;j< dispositivo.getModulos().size();j++){
                Modulo modulo = dispositivo.getModulos().get(j);
                for(int k=0; k < modulo.getPuertos().size(); k++){
                    Puerto puerto = modulo.getPuertos().get(k);
                    if(puerto.getIp().equals(ip)){
                        respuesta = true;
                    }
                }
            }            
        }
        for(int j=0;j< getModulos().size();j++){
            Modulo modulo = getModulos().get(j);
            for(int k=0; k < modulo.getPuertos().size(); k++){
                Puerto puerto = modulo.getPuertos().get(k);
                if(puerto.getIp().equals(ip)){
                    respuesta = true;
                }
            }
        }
        
        return respuesta;
    }
    
    public String ping(String ip){
        boolean respuesta = buscar_ip_en_conexiones(ip);
        if(respuesta) {
            return "Encontrada la ip: " + ip;
        }
        else {
            return "No Encontrada la ip: " + ip;
        }
        
        
    }
    
    
    
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.awt.Point;
import java.util.ArrayList;
import logica.Conexion;
import logica.Dispositivo;
import logica.PC;
import logica.Router;

/**
 *
 * @author warlock
 */
public class Controlador {
    private int id;
    ArrayList<Router> routers;
    ArrayList<PC> pcs;
    Router creador_router = new Router();
    PC creador_pc = new PC(); 
    
    public Controlador() {
        id = 0;
        routers = new ArrayList<Router>();
        pcs = new ArrayList<PC>();
        
    }
    
    public void add_router(Point point){
        /*
         agrega un router y aumenta el id
         */
        Router router = this.creador_router.router_1("Router"+this.routers.size(), this.id, point);
        this.id++;
        routers.add(router);
    }
    
    public void add_pc(Point point){
        /*
         Agrega un pc y aumenta el id
         */
        PC pc = this.creador_pc.pc_1("PC"+this.pcs.size(), id, point);
        this.id++;
        pcs.add(pc);
    }
    
    public Router search_router(int id){
        /*
         Si no existe un router con id devuelve un valor nulo
         */
        Router router = null;
        for(int i=0;i<this.routers.size();i++){
            if(routers.get(i).getId()==id){
                router = routers.get(i);
            }
        }
        
        return router;        
    }
    
    public PC search_pc(int id){
        /*
         * Busca un pc pormedio del id.
         * Si no existe un pc con el buscado id 
         * devuelve un valor nulo.
         */
        PC pc = null;
        for(int i=0;i<this.pcs.size();i++){
            if(this.pcs.get(i).getId()==id){
                pc = this.pcs.get(i);
            }
        }
        
        return pc;        
    }
    
    public int search_pos_pc(int id){
        for(int i=0;i<this.pcs.size();i++){
            if(this.pcs.get(i).getId()==id){
                return i;
            }
        }
        return -1;
    }
    
    public int search_pos_router(int id){
        for(int j=0; j < this.routers.size(); j++){
            if(this.routers.get(j).getId()==id) {
                return j;
            }
        }
        return -1;
    }
    
    public ArrayList<Router> search_all_routers(){
        return this.routers;
    }
    
    public ArrayList<PC> search_all_pcs(){
        return this.pcs;
    }
    
    public String tipo_dispositivo(int id){
        String tipo = "pc";
        int dispositivo = search_pos_pc(id);
        if(dispositivo == -1){
            dispositivo = search_pos_router(id);
            if(dispositivo != -1){
                tipo = "router";
            }
        }
        
        return tipo;
    }
    
    public void connect(int dispositivo_1_id, int dispositivo_2_id, String puerto_dis_1,String puerto_dis_2,
            String modulo_dis_1,String modulo_dis_2){
        if(dispositivo_1_id != dispositivo_2_id){
            //Agrega la conexion en el dispositivo 1 y pone los puertos del dispositivo 2 como ocupado
            if(tipo_dispositivo(dispositivo_1_id).equals("pc")){
               if(tipo_dispositivo(dispositivo_2_id).equals("pc")){
                   this.pcs.get(search_pos_pc(dispositivo_1_id)).agregar_conexion(this.pcs.get(search_pos_pc(dispositivo_2_id)), modulo_dis_2, puerto_dis_2);  
               }else if(tipo_dispositivo(dispositivo_2_id).equals("router")){
                   this.pcs.get(search_pos_pc(dispositivo_1_id)).agregar_conexion(this.routers.get(search_pos_router(dispositivo_2_id)), modulo_dis_2, puerto_dis_2);  
               }
            }else if(tipo_dispositivo(dispositivo_1_id).equals("router")){
               if(tipo_dispositivo(dispositivo_2_id).equals("pc")){
                   this.routers.get(search_pos_router(dispositivo_1_id)).agregar_conexion(this.pcs.get(search_pos_pc(dispositivo_2_id)), modulo_dis_2, puerto_dis_2);  
               }else if(tipo_dispositivo(dispositivo_2_id).equals("router")){
                   this.routers.get(search_pos_router(dispositivo_1_id)).agregar_conexion(this.routers.get(search_pos_router(dispositivo_2_id)), modulo_dis_2, puerto_dis_2);  
               }
            }
            //Agrega las conexiones en el dispositivo 2 y pone los puertos del dispositivo 1 como ocupado
            if(tipo_dispositivo(dispositivo_2_id).equals("pc")){
               if(tipo_dispositivo(dispositivo_1_id).equals("pc")){
                   this.pcs.get(search_pos_pc(dispositivo_2_id)).agregar_conexion(this.pcs.get(search_pos_pc(dispositivo_1_id)), modulo_dis_1, puerto_dis_1);  
               }else if(tipo_dispositivo(dispositivo_2_id).equals("router")){
                   this.pcs.get(search_pos_pc(dispositivo_2_id)).agregar_conexion(this.routers.get(search_pos_router(dispositivo_1_id)), modulo_dis_1, puerto_dis_1);  
               }
            }else if(tipo_dispositivo(dispositivo_2_id).equals("router")){
               if(tipo_dispositivo(dispositivo_1_id).equals("pc")){
                   this.routers.get(search_pos_router(dispositivo_2_id)).agregar_conexion(this.pcs.get(search_pos_pc(dispositivo_1_id)), modulo_dis_1, puerto_dis_1);  
               }else if(tipo_dispositivo(dispositivo_1_id).equals("router")){
                   this.routers.get(search_pos_router(dispositivo_2_id)).agregar_conexion(this.routers.get(search_pos_router(dispositivo_1_id)), modulo_dis_1, puerto_dis_1);  
               }
            }
        }else{
            System.err.println("Los routers a conectar deben ser diferentes");
        }
    }
    
    public ArrayList<Conexion> conexiones_router(int id){
        return this.routers.get(search_pos_router(id)).getConexiones();
    }
    
    public ArrayList<Conexion> conexiones_pc(int id){
        return this.pcs.get(search_pos_pc(id)).getConexiones();
    }
    
   
    
    public boolean asignar_ip_puerto(int dispositivo_id, String modulo, String puerto, String ip){
        boolean flag = true;
        String tipo = tipo_dispositivo(dispositivo_id);
        if(tipo.equals("pc")){
            int pos = search_pos_pc(dispositivo_id); 
            this.pcs.get(pos).asignar_ip_puerto(modulo, puerto, ip);
        }else if(tipo.equals("router")){
            int pos = search_pos_router(dispositivo_id);
            this.routers.get(pos).asignar_ip_puerto(modulo, puerto, ip); 
        }
        return flag;
    }
    
}

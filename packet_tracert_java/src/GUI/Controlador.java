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
    
    private String tipo_dispositivo(int id){
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
    
    public void connect(Dispositivo dispositivo_1, Dispositivo dispositivo_2, String puerto_dis_1,String puerto_dis_2,
            String modulo_dis_1,String modulo_dis_2){
        
        //Agrega la conexion en el dispositivo 1 y pone los puertos del dispositivo 2 como ocupado
        if(tipo_dispositivo(dispositivo_1.getId()).equals("pc")){
           if(tipo_dispositivo(dispositivo_2.getId()).equals("pc")){
               this.pcs.get(dispositivo_1.getId()).agregar_conexion(this.pcs.get(dispositivo_2.getId()), modulo_dis_2, puerto_dis_2);  
           }else if(tipo_dispositivo(dispositivo_1.getId()).equals("router")){
               this.pcs.get(dispositivo_1.getId()).agregar_conexion(this.routers.get(dispositivo_2.getId()), modulo_dis_2, puerto_dis_2);  
           }
        }else if(tipo_dispositivo(dispositivo_1.getId()).equals("router")){
           if(tipo_dispositivo(dispositivo_1.getId()).equals("pc")){
               this.routers.get(dispositivo_1.getId()).agregar_conexion(this.pcs.get(dispositivo_2.getId()), modulo_dis_2, puerto_dis_2);  
           }else if(tipo_dispositivo(dispositivo_1.getId()).equals("router")){
               this.routers.get(dispositivo_1.getId()).agregar_conexion(this.routers.get(dispositivo_2.getId()), modulo_dis_2, puerto_dis_2);  
           }
        }
        //Agrega las conexiones en el dispositivo 2 y pone los puertos del dispositivo 1 como ocupado
        if(tipo_dispositivo(dispositivo_2.getId()).equals("pc")){
           if(tipo_dispositivo(dispositivo_1.getId()).equals("pc")){
               this.pcs.get(dispositivo_2.getId()).agregar_conexion(this.pcs.get(dispositivo_1.getId()), modulo_dis_1, puerto_dis_1);  
           }else if(tipo_dispositivo(dispositivo_2.getId()).equals("router")){
               this.pcs.get(dispositivo_2.getId()).agregar_conexion(this.routers.get(dispositivo_1.getId()), modulo_dis_1, puerto_dis_1);  
           }
        }else if(tipo_dispositivo(dispositivo_2.getId()).equals("router")){
           if(tipo_dispositivo(dispositivo_1.getId()).equals("pc")){
               this.routers.get(dispositivo_2.getId()).agregar_conexion(this.pcs.get(dispositivo_1.getId()), modulo_dis_1, puerto_dis_1);  
           }else if(tipo_dispositivo(dispositivo_1.getId()).equals("router")){
               this.routers.get(dispositivo_2.getId()).agregar_conexion(this.routers.get(dispositivo_1.getId()), modulo_dis_1, puerto_dis_1);  
           }
        }
        
    }
    
    public ArrayList<Conexion> conexiones_router(int id){
        return this.routers.get(search_pos_router(id)).getConexiones();
    }
    
    public ArrayList<Conexion> conexiones_pc(int id){
        return this.pcs.get(search_pos_pc(id)).getConexiones();
    }
    
}

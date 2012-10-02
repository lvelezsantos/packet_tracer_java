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
    
    public void connect(Dispositivo dispositivo_1, Dispositivo dispositivo_2, String puerto_dis_1,String puerto_dis_2,
            String modulo_dis_1,String modulo_dis_2){
        int dis_1 = search_pos_pc(dispositivo_1.getId());
        if(dis_1 == -1){
            
        }
        
    }
    
}

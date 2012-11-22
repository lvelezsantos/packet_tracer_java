/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.awt.Point;
import java.io.Serializable;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import logica.Conexion;
import logica.Dispositivo;
import logica.PC;
import logica.Paquete;
import logica.Router;

/**
 *
 * @author warlock
 */
public class Controlador implements Serializable{
    private int id;
    ArrayList<Router> routers;
    ArrayList<PC> pcs;
    ArrayList<Paquete> paquetes;
    Router creador_router = new Router();
    PC creador_pc = new PC(); 
    
    public Controlador() {
        id = 0;
        routers = new ArrayList<Router>();
        pcs = new ArrayList<PC>();
        paquetes = new ArrayList<>();
    }
    
    public void add_router(Point point){
        /*
         agrega un router y aumenta el id
         */
        Router router = this.creador_router.router_1("Router"+this.routers.size(), this.id, point);
        router.start();
        this.id++;
        routers.add(router);
    }
    
    public void add_pc(Point point){
        /*
         Agrega un pc y aumenta el id
         */
        PC pc = this.creador_pc.pc_1("PC"+this.pcs.size(), id, point);
        this.id++;
        pc.start();
        pcs.add(pc);
    }
    
    public Router search_router(int id){
        /*
         Si no existe un router con id devuelve un valor nulo
         */
        Router router = null;
        for(int i=0;i<this.routers.size();i++){
            if(routers.get(i).getIdDispositivo()==id){
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
            if(this.pcs.get(i).getIdDispositivo()==id){
                pc = this.pcs.get(i);
            }
        }
        
        return pc;        
    }
    
    public int search_pos_pc(int id){
        for(int i=0;i<this.pcs.size();i++){
            if(this.pcs.get(i).getIdDispositivo()==id){
                return i;
            }
        }
        return -1;
    }
    
    public int search_pos_router(int id){
        for(int j=0; j < this.routers.size(); j++){
            if(this.routers.get(j).getIdDispositivo()==id) {
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
            String modulo_dis_1,String modulo_dis_2) throws Exception{
        
        if(dispositivo_1_id != dispositivo_2_id){
            //Agrega la conexion en el dispositivo 1 y pone los puertos del dispositivo 2 como ocupado
            if(tipo_dispositivo(dispositivo_1_id).equals("pc")){
               if(tipo_dispositivo(dispositivo_2_id).equals("pc")){
                   this.pcs.get(search_pos_pc(dispositivo_1_id)).agregar_conexion(this.pcs.get(search_pos_pc(dispositivo_2_id)), modulo_dis_2, puerto_dis_2, modulo_dis_1, puerto_dis_1);  
               }else if(tipo_dispositivo(dispositivo_2_id).equals("router")){
                   this.pcs.get(search_pos_pc(dispositivo_1_id)).agregar_conexion(this.routers.get(search_pos_router(dispositivo_2_id)), modulo_dis_2, puerto_dis_2, modulo_dis_1, puerto_dis_1);  
               }
            }else if(tipo_dispositivo(dispositivo_1_id).equals("router")){
               if(tipo_dispositivo(dispositivo_2_id).equals("pc")){
                   this.routers.get(search_pos_router(dispositivo_1_id)).agregar_conexion(this.pcs.get(search_pos_pc(dispositivo_2_id)), modulo_dis_2, puerto_dis_2, modulo_dis_1, puerto_dis_1);  
               }else if(tipo_dispositivo(dispositivo_2_id).equals("router")){
                   this.routers.get(search_pos_router(dispositivo_1_id)).agregar_conexion(this.routers.get(search_pos_router(dispositivo_2_id)), modulo_dis_2, puerto_dis_2, modulo_dis_1, puerto_dis_1);  
               }
            }
            //Agrega las conexiones en el dispositivo 2 y pone los puertos del dispositivo 1 como ocupado
            if(tipo_dispositivo(dispositivo_2_id).equals("pc")){
               if(tipo_dispositivo(dispositivo_1_id).equals("pc")){
                   this.pcs.get(search_pos_pc(dispositivo_2_id)).agregar_conexion(this.pcs.get(search_pos_pc(dispositivo_1_id)), modulo_dis_1, puerto_dis_1, modulo_dis_2, puerto_dis_2);  
               }else if(tipo_dispositivo(dispositivo_2_id).equals("router")){
                   this.pcs.get(search_pos_pc(dispositivo_2_id)).agregar_conexion(this.routers.get(search_pos_router(dispositivo_1_id)), modulo_dis_1, puerto_dis_1, modulo_dis_2, puerto_dis_2);  
               }
            }else if(tipo_dispositivo(dispositivo_2_id).equals("router")){
               if(tipo_dispositivo(dispositivo_1_id).equals("pc")){
                   this.routers.get(search_pos_router(dispositivo_2_id)).agregar_conexion(this.pcs.get(search_pos_pc(dispositivo_1_id)), modulo_dis_1, puerto_dis_1, modulo_dis_2, puerto_dis_2);  
               }else if(tipo_dispositivo(dispositivo_1_id).equals("router")){
                   this.routers.get(search_pos_router(dispositivo_2_id)).agregar_conexion(this.routers.get(search_pos_router(dispositivo_1_id)), modulo_dis_1, puerto_dis_1, modulo_dis_2, puerto_dis_2);  
               }
            }
        }else{
            System.err.println("Los routers a conectar deben ser diferentes");
        }
    }
    
    public void connect_import(int dispositivo_1_id, int dispositivo_2_id, String puerto_dis_1,String puerto_dis_2,
            String modulo_dis_1,String modulo_dis_2) throws Exception{
        
        if(dispositivo_1_id != dispositivo_2_id){
            //Agrega la conexion en el dispositivo 1 y pone los puertos del dispositivo 2 como ocupado
            if(tipo_dispositivo(dispositivo_1_id).equals("pc")){
               if(tipo_dispositivo(dispositivo_2_id).equals("pc")){
                   this.pcs.get(search_pos_pc(dispositivo_1_id)).agregar_conexion(this.pcs.get(search_pos_pc(dispositivo_2_id)), modulo_dis_2, puerto_dis_2, modulo_dis_1, puerto_dis_1);  
               }else if(tipo_dispositivo(dispositivo_2_id).equals("router")){
                   this.pcs.get(search_pos_pc(dispositivo_1_id)).agregar_conexion(this.routers.get(search_pos_router(dispositivo_2_id)), modulo_dis_2, puerto_dis_2, modulo_dis_1, puerto_dis_1);  
               }
            }else if(tipo_dispositivo(dispositivo_1_id).equals("router")){
               if(tipo_dispositivo(dispositivo_2_id).equals("pc")){
                   this.routers.get(search_pos_router(dispositivo_1_id)).agregar_conexion(this.pcs.get(search_pos_pc(dispositivo_2_id)), modulo_dis_2, puerto_dis_2, modulo_dis_1, puerto_dis_1);  
               }else if(tipo_dispositivo(dispositivo_2_id).equals("router")){
                   this.routers.get(search_pos_router(dispositivo_1_id)).agregar_conexion_import(this.routers.get(search_pos_router(dispositivo_2_id)), modulo_dis_2, puerto_dis_2, modulo_dis_1, puerto_dis_1);  
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
    
   
    
    public boolean asignar_ip_puerto(int dispositivo_id, String modulo, String puerto, String ip, String netmask){
        boolean flag = true;
        String tipo = tipo_dispositivo(dispositivo_id);
        if(tipo.equals("pc")){
            int pos = search_pos_pc(dispositivo_id); 
            flag = this.pcs.get(pos).asignar_ip_puerto(modulo, puerto, ip, netmask);
        }else if(tipo.equals("router")){
            int pos = search_pos_router(dispositivo_id);
            flag = this.routers.get(pos).asignar_ip_puerto(modulo, puerto, ip, netmask); 
        }
        return flag;
    }
    
    public boolean asignarBorde(int dispositivo_id){
        boolean flag = true;
        String tipo = tipo_dispositivo(dispositivo_id);
        if(tipo.equals("router")){
            int pos = search_pos_router(dispositivo_id);
            this.routers.get(pos).setBorde(true); 
        }
        return flag;
    }
    
    public boolean asignarSistemaAutonomo(int dispositivo_id, String As){
        boolean flag = true;
        String tipo = tipo_dispositivo(dispositivo_id);
        if(tipo.equals("router")){
            int pos = search_pos_router(dispositivo_id);
            this.routers.get(pos).setSistemaAutonomo(As); 
        }
        return flag;
    }
    
    public void cambiar_nombre_router(int id_router, String nombre){
        int pos_router = search_pos_router(id_router);
        this.routers.get(pos_router).setNombre(nombre);
    
    }
    
    public boolean encender_puerto(int id_router, String modulo, String puerto){
        int pos_router = search_pos_router(id_router);
        return this.routers.get(pos_router).encender_puerto(modulo, puerto); 
    }
    
    public boolean apagar_puerto(int id_router, String modulo, String puerto){
        int pos_router = search_pos_router(id_router);
        return this.routers.get(pos_router).apagar_puerto(modulo, puerto); 
    }
    
    public String mostrar_informacion(int id_router){
        int pos_router = search_pos_router(id_router);
        return this.routers.get(pos_router).mostrar_informacion();
    }

    public String ping(int id_router, String ip) {
        int pos = this.search_pos_router(id_router);
        return this.routers.get(pos).ping(ip);
    }
    
    public void recorrido(){
        ArrayList<Paquete> toremove = new ArrayList<>();
        ArrayList<Paquete> np = new ArrayList<>();
        
        for(Paquete p : paquetes){
            boolean s = p.arrive();
            System.err.println(s);
            if(s){
                System.out.println("Llego el paquete a su destino");
                if(tipo_dispositivo((int)p.getNxthp().getIdDispositivo()).equalsIgnoreCase("router")){
                    Router r = this.search_router((int)p.getNxthp().getIdDispositivo());
                    np = r.enrutar(p);
                    
                    toremove.add(p);
                }else{
                    toremove.add(p);
                }
            }
        }
        if(np!=null){
            for(Paquete p : np){
                paquetes.add(p);
                System.out.println("Agregando paquete"+p.getNxthp().getNombre());
            }
            
        }
         for(Paquete p : toremove){
             paquetes.remove(p);
             System.out.println("Eliminado paquete"+p.getNxthp().getNombre());
         }
        
    }
    
     public void enviarFlooding(String ip, String mask,int num_saltos, int id_dispositivo){
        /*
         * Primero verificamos que la ip buscada este en
         * algun puerto local
         */
        Router rout = search_router(id_dispositivo);
        boolean resultado = rout.buscarIpEnPuerto(ip); 
        System.out.println("numero de salto"+num_saltos);
        if(!resultado && num_saltos > 0){
            //buscamos en las conexiones 
            for(Conexion c : rout.getConexiones()){
                //comentamos las validaciones para hacer pruebas facilmente
                //if(rout.isPuertoEncendido(c.getModulo_local(), c.getPuerto_local())){ //puerto del router que envia
                    //if(c.getDispositivo().isPuertoEncendido(c.getModulo_cad(), c.getPuerto_cad())){ //puerto del router que recibe
                        resultado = c.getDispositivo().buscarIpEnPuerto(ip); 
                        Paquete paquete = new Paquete(ip, mask, c.getDispositivo(), 5, rout); 
                        this.paquetes.add(paquete);
                        if(resultado) {
                            JOptionPane.showMessageDialog(null, "Se encontro la ip en el router"+c.getDispositivo().getNombre());
                            break;
                        }
                    //}else{
                    //    System.out.println("El puerto esta apagado");
                    //}
                //}else{
                //    System.out.println("El puerto esta apagado");
                //}
            }
        }
        if(num_saltos==0 && !resultado){
            System.out.println("No se ha encontrado la ip");
        }
        if(resultado){
            System.err.print("Se ha encontrado la ip buscada");
        }
    }
    
}

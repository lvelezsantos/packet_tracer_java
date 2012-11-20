/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import packet_tracert_java.EntradaRip;
import packet_tracert_java.RipTabla;

/**
 *
 * @author warlock
 */
public class Router extends Dispositivo{
    private ProtocoloVectorDistancia p_vector;
    private RipTabla ript;
    
    public Router() {
    }

    public Router(String nombre, ArrayList<Modulo> modulos, int id, Point point) {
        super(nombre, modulos, id, point);
        this.p_vector = new ProtocoloVectorDistancia();
        this.ript = new RipTabla(id);
    }
    
    public Router router_1(String nombre, int id, Point point){
        Puerto puerto1 = new Puerto(false, "0.0.0.0", "0", 100, "MB/s", "fastEthernet", false,"0.0.0.0");
        Puerto puerto2 = new Puerto(false, "0.0.0.0", "1", 100, "MB/s", "fastEthernet", false,"0.0.0.0");
        
        ArrayList<Puerto> puertos_modulo_1 = new ArrayList<Puerto>();
        
        puertos_modulo_1.add(puerto1);
        puertos_modulo_1.add(puerto2); 
        
        Puerto puerto3 = new Puerto(false, "0.0.0.0", "0", 100, "MB/s", "fastEthernet", false,"0.0.0.0");
        Puerto puerto4 = new Puerto(false, "0.0.0.0", "1", 100, "MB/s", "fastEthernet", false,"0.0.0.0");
        
        ArrayList<Puerto> puertos_modulo_2 = new ArrayList<Puerto>();
        
        puertos_modulo_2.add(puerto3);
        puertos_modulo_2.add(puerto4); 
        
        Modulo modulos1 = new Modulo(puertos_modulo_1, "0");
        Modulo modulos2 = new Modulo(puertos_modulo_2, "1");
        
        ArrayList<Modulo> modulos = new ArrayList<Modulo>();
        modulos.add(modulos1);
        modulos.add(modulos2);
        
        
        Router router = new Router(nombre, modulos, id, point);
        
        return router;
        
    }

    public ProtocoloVectorDistancia getP_vector() {
        return p_vector;
    }

    public void setP_vector(ProtocoloVectorDistancia p_vector) {
        this.p_vector = p_vector;
    }
    

    public boolean thisisrouter(){
        return true;
        
    }

     public Paquete enrutar(Paquete p) {
        if(hasIP(p.getIpdst())){
            return null;
        }else{
            //logica del enrutamiento...
        }
        return null;
    }
    
    
    
    public void compararEntrada(EntradaRip en, long id_owner){
        for(int i=0;i<ript.getEntradas().size();i++){
            EntradaRip aux = ript.getEntradas().get(i);
            if(aux.getIpdst().equalsIgnoreCase(en.getIpdst())){
                if(aux.getNhops()>en.getNhops()){
                    replace(en,i,id_owner);
                }
            }
        }
    }

    private void replace(EntradaRip en, int i,long id_owner) {
        ArrayList con = this.getConexiones();
        Conexion aux=null;
        Iterator it = con.iterator();
        while(it.hasNext()){
            Conexion c = (Conexion) it.next();
            if(c.getDispositivo().getIdDispositivo() == id_owner){
                aux = c;
            }
        }
        String ipnexthop = "";
        if(aux!=null){
            try{
            ipnexthop = ""+aux.getDispositivo().ip_modulo_puerto(aux.getModulo_cad(), aux.getPuerto_cad());
            }catch(Exception e){
                System.out.println("Error No existe IP");
            }
        }
        
        ript.getEntradas().set(i, new EntradaRip(en.getIpdst(), en.getMaskdst(), ipnexthop, en.getNhops()+1));
        
    }
    
    public void run(){
        while(true){
            enviartRip();
            try {
                Thread.sleep(1000*5);
            } catch (InterruptedException ex) {
                System.err.println("Error al hacer dormir el hilo");
            }
        }
    }

    private void enviartRip() {
        for(Conexion c : this.getConexiones()){
            Router aux = (Router)c.getDispositivo();
            aux.recibirRip(ript);
            try{
            
            }catch(Exception e){
            }
            
        }
    }
    
    public void recibirRip(RipTabla rip){
        for(EntradaRip r : rip.getEntradas()){
            this.compararEntrada(r,rip.getId_owner());
        }
    }
    
    public void agregarRip(EntradaRip r){
        this.ript.getEntradas().add(r);
    }
    
}
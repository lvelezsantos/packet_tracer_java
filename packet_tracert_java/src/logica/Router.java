/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.awt.Point;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import logica.algoritmos_de_enrutamiento.RipTable;
import logica.algoritmos_de_enrutamiento.RipEntrance;

/**
 *
 * @author warlock
 */
public class Router extends Dispositivo{
    private ProtocoloVectorDistancia p_vector;
    private RipTable rip;
    
    public Router() {
    }

    public Router(String nombre, ArrayList<Modulo> modulos, int id, Point point) {
        super(nombre, modulos, id, point);
        this.p_vector = new ProtocoloVectorDistancia();
        this.rip = new RipTable();
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
    
    @Override
    public boolean thisisrouter(){
        return true;
        
    }
    
    public void recibir_riptalbe(RipTable ript){
        System.out.println("Version actual router "+rip.getVersion());
        System.out.println("Version recibida por compañero "+ript.getVersion());
        if(ript.getVersion()> this.rip.getVersion()){
        System.err.println("Recibiendo");
        for(RipEntrance ripe : ript.getRips()){
            getRip().compare_entrances(ripe);
        }
        this.getRip().upgradeVersion();
        }
    }
    
    public void enviar_riptable() throws Exception{
    
    for(Conexion c : this.getConexiones()){
            try{
            Router router = (Router) c.getDispositivo();
            try {
                RipTable ripsend = (RipTable) getRip().clone(router.ip_modulo_puerto(c.getModulo_local(),c.getPuerto_local()));
                System.out.println("Supuesta IP del router en blanco "+router.ip_modulo_puerto(c.getModulo_local(),c.getPuerto_local()));
                if(!router.ip_modulo_puerto(c.getModulo_local(),c.getPuerto_local()).equalsIgnoreCase("0.0.0.0")){
                router.recibir_riptalbe(ripsend);
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null,"Por favor primero configure la interfaz "+c.getModulo_local()+"/"+c.getPuerto_local());
            }
            }catch(Exception e){
                System.err.println("Intente castear un pc como un router y no pude");
            }
        
    }
        
    }

    /**
     * @return the rip
     */
    public RipTable getRip() {
        return rip;
    }

    /**
     * @param rip the rip to set
     */
    public void setRip(RipTable rip) {
        this.rip = rip;
    }


    public String getRipConf(){
        String ripconf = "";
        if(!rip.getRips().isEmpty()){
            if(rip.isV2_active()){
                ripconf +="\n!\n!\nRip Version 2 enable";
            }
            
            for(RipEntrance r : rip.getRips()){
                ripconf +="!\n!\nnetwork "+r.getDestip();
                if(rip.isV2_active()){
                ripconf +=" netmask "+r.getDestmask();
                }
                ripconf+=" -> "+r.getNextHop();
            }
            
        }
        return ripconf;
    }
    
    
}

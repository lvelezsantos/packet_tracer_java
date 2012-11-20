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
import logica.algoritmos_de_enrutamiento.EntradaRip;
import logica.algoritmos_de_enrutamiento.RipTabla;

/**
 *
 * @author warlock
 */
public class Router extends Dispositivo{
    private ProtocoloVectorDistancia p_vector;
    private RipTabla ript;
    private boolean ripv2=false;
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
    

     public Paquete enrutar(Paquete p) {
        if(hasIP(p.getIpdst())){
            return null;
        }else{
            if(!ript.getEntradas().isEmpty()){
            try{
            String ipdst = toNetworkip(p.getIpdst(), p.getMskdst());
            String nmks = p.getMskdst();
            Dispositivo nxthp = null;
            String ipnxt = "";
            for(EntradaRip r : this.getRipt().getEntradas()){
                if(r.getIpdst().equals(ipdst)){
                    ipnxt = r.getNextHop();
                }
            }
            if(!ipnxt.equals("")){
                for(Conexion c : this.getConexiones()){
                   if(c.getDispositivo().hasIP(ipnxt)){
                       nxthp = c.getDispositivo();
                   }
                }
                if(nxthp!=null){
                    Paquete r = new Paquete(ipdst, nmks, nxthp, p.getTtl() -1 , this.getPoint());
                    return r;
                }
            }
            }catch(Exception er){
                return null;
            }
            }else{
            // enrutamiento para otros protocolos
            }
        }
        return null;
    }
    
    
    
    public void compararEntrada(EntradaRip en, long id_owner){
        boolean localizado = false;
        for(int i=0;i<getRipt().getEntradas().size();i++){
            EntradaRip aux = getRipt().getEntradas().get(i);
            if(aux.getIpdst().equalsIgnoreCase(en.getIpdst())){
                if(aux.getNhops()>en.getNhops()+1){
                    replace(en,i,id_owner);
                    localizado = true;
                }else{
                    localizado = true;
                }
            }
        }
        if(!localizado){
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
            this.agregarRip(new EntradaRip(en.getIpdst(), en.getMaskdst(), ipnexthop, en.getNhops()+1)); //falta calcular el nextHop
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
        
        getRipt().getEntradas().set(i, new EntradaRip(en.getIpdst(), en.getMaskdst(), ipnexthop, en.getNhops()+1));
        
    }
    
    public void run(){
        while(true){
            System.out.println("Enviando tablas rip");
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
            
            try{
                Router aux = (Router)c.getDispositivo();
                aux.recibirRip(getRipt());
            }catch(Exception e){
                System.err.println("Error al enviar datos no soy un router");
            }
            
        }
    }
    
    public void recibirRip(RipTabla rip){
        for(EntradaRip r : rip.getEntradas()){
            this.compararEntrada(r,rip.getId_owner());
        }
        System.err.println("Acabando de comparar tablas rip soy"+this.getNombre());
    }
    
    public void agregarRip(EntradaRip r){
        boolean localizado = false;
        int pos=0;
        for(int i = 0; i<this.getRipt().getEntradas().size();i++){
            if(this.ript.getEntradas().get(i).getIpdst() == r.getIpdst()){
                localizado = true;
                pos = i;
                break;
            }
        }
        if(!localizado){
            this.getRipt().getEntradas().add(r);
        }else{
            this.ript.getEntradas().set(pos,r);
       }
        
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
                    conex.getPuerto_cad()+'\n';
        }
        if(!getConexiones().isEmpty()){
            informacion += cad_conexiones;
        }
        
        if(!ript.getEntradas().isEmpty()){
        informacion+="!\n!\n!";
            for(EntradaRip r : getRipt().getEntradas()){
                informacion+="network "+r.getIpdst();
                if(ripv2){
                    informacion+=" netmask "+r.getMaskdst();
                }
                informacion+=" NextHop "+r.getNextHop()+" #hops : "+r.getNhops()+"\n!\n";
            }
        informacion+="\n!\n!";
        }
        
        return informacion;
    }
    
    private String toNetworkip(String ipdst,String msk) throws Exception {
        String[] dividemask = msk.split(".");
        String netip ="";
        String[] splitip = ipdst.split(".");
        if(dividemask[0].equals("255")){
            netip += splitip[0]+".";
            if(dividemask[1].equals("255")){
                netip += splitip[1]+".";
                if(dividemask[2].equals("255")){
                    netip = splitip[2];
                    if(dividemask[3].equals("255")){
                        throw new Exception("La mascara del dispositivo no acepta conexiones (Full Mask)");
                    }
                    return netip+"0";
                }
                return netip+"0.0";
            }
            return netip+"0.0.0";
        }else{
            throw new Exception("Un dispositivo no tiene mascara aceptada");
        }
    }

    /**
     * @return the ript
     */
    public RipTabla getRipt() {
        return ript;
    }

    /**
     * @param ript the ript to set
     */
    public void setRipt(RipTabla ript) {
        this.ript = ript;
    }
    
}
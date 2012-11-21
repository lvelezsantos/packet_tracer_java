/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import logica.algoritmos_de_enrutamiento.EntradaRip;
import logica.algoritmos_de_enrutamiento.RipTabla;

/**
 *
 * @author warlock
 */
public class RouterGuardar extends DispositivoGuardar{
    private ProtocoloVectorDistancia p_vector;
    private RipTabla ript;
    private boolean ripv2=false;
    public RouterGuardar() {
    }

    public RouterGuardar(String nombre, ArrayList<Modulo> modulos, int id, Point point) {
        super(nombre, modulos, id, point);        
        this.ript = new RipTabla(id);
    }
    
    public RouterGuardar router_1(String nombre, int id, Point point){
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
        
        
        RouterGuardar router = new RouterGuardar(nombre, modulos, id, point);
        
        return router;
        
    }

    public ProtocoloVectorDistancia getP_vector() {
        return p_vector;
    }

    public void setP_vector(ProtocoloVectorDistancia p_vector) {
        this.p_vector = p_vector;
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

    public boolean isRipv2() {
        return ripv2;
    }

    public void setRipv2(boolean ripv2) {
        this.ripv2 = ripv2;
    }
    
    
}
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.util.ArrayList;

/**
 *
 * @author warlock
 */
public class Router extends Dispositivo{

    public Router() {
    }

    public Router(String nombre, ArrayList<Modulo> modulos) {
        super(nombre, modulos);
    }
    
    public Router router_1(String nombre){
        Puerto puerto1 = new Puerto(false, "", "0", 100, "MB/s", "fastEthernet", false);
        Puerto puerto2 = new Puerto(false, "", "1", 100, "MB/s", "fastEthernet", false);
        
        ArrayList<Puerto> puertos = new ArrayList<Puerto>();
        
        puertos.add(puerto1);
        puertos.add(puerto2);
        
        Modulo modulos1 = new Modulo(puertos, "0");
        Modulo modulos2 = new Modulo(puertos, "1");
        
        ArrayList<Modulo> modulos = new ArrayList<Modulo>();
        modulos.add(modulos1);
        modulos.add(modulos2);
        
        
        Router router = new Router(nombre, modulos);
        
        return router;
        
    }
        
}

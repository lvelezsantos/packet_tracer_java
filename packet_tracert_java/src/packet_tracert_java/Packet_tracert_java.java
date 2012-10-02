/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package packet_tracert_java;

import java.security.Principal;
import GUI.principal;
import java.util.ArrayList;
import logica.*;
/**
 *
 * @author minrock
 */
public class Packet_tracert_java {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        principal p = new principal();
        p.show();
        Puerto puerto1 = new Puerto(false, "", "1", 100, "MB/S","Ethernet");
        Puerto puerto2 = new Puerto(false, "", "2", 100, "MB/S","Ethernet");
        Puerto puerto3 = new Puerto(false, "", "3", 100, "MB/S","Ethernet");
        Puerto puerto4 = new Puerto(false, "", "4", 100, "MB/S","Ethernet");
        ArrayList<Puerto> puertos = new ArrayList<Puerto>();
        puertos.add(puerto1);
        puertos.add(puerto2);
        puertos.add(puerto3);
        puertos.add(puerto4);
        Modulo modulo = new Modulo(puertos, "0");
        ArrayList<Modulo> modulos = new ArrayList<Modulo>();
        modulos.add(modulo);
        Router router = new Router("Router1", modulos);
        router.mostrarPuertos();
    }
    
    
}

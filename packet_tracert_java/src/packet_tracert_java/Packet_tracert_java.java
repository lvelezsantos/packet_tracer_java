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
        Router creador_router = new Router();
        PC creador_pc = new PC();
        principal p = new principal();
        p.show();
        
        //puertos del pc
        
        PC pc1 = creador_pc.pc_1("pc1");
        pc1.mostrarPuertos();
        
        Router router1 = creador_router.router_1("Router1");
        Router router2 = creador_router.router_1("Router2");
        Router router3 = creador_router.router_1("Router3");
                
        router3.mostrarPuertos();
        router1.mostrarPuertos();
        router2.mostrarPuertos();
    }
    
    
}

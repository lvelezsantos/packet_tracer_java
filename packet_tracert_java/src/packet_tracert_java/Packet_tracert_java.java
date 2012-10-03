/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package packet_tracert_java;

import GUI.Controlador;
import java.security.Principal;
import GUI.principal;
import java.awt.Point;
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
        Controlador controlador = new Controlador();
        Point point = new Point(2, 4);
        controlador.add_router(point);
        controlador.add_router(point);
        controlador.add_router(point);
        controlador.add_pc(point);
        controlador.add_pc(point);
        controlador.add_pc(point);
        
        controlador.connect(1, 1, "0", "0", "0", "0");
        
        System.out.println(controlador.search_all_pcs().get(1).getConexiones());
        /*PC pc1 = creador_pc.pc_1("pc1",0);
        pc1.mostrarPuertos();
        
        Router router1 = creador_router.router_1("Router1",1);
        Router router2 = creador_router.router_1("Router2",2);
        Router router3 = creador_router.router_1("Router3",3);
                
        router1.mostrarPuertos();
        pc1.mostrarPuertos();
        
        router1.agregar_conexion(pc1, "0", "eth0");
        pc1.agregar_conexion(router1, "0", "1");
        
        router1.mostrarPuertos();
        pc1.mostrarPuertos();
        
        //router3.eliminar_conexion(router1, "0", "1");
        router1.mostrarPuertos();
        */
    }
    
    
}

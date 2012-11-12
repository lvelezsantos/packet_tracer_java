/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package logica.algoritmos_de_enrutamiento;

/**
 *
 * @author minrock
 */
public class mainprot {
    
    public static void main(String s[]){
        RipTable rip = new RipTable("192.168.1.1");
        //rip.enableRipV2();
        rip.add_rip_Entrance(3, "192.168.0.0","24", "192.168.1.1");
        rip.imprimir();
        rip.compare_entrances(new RipEntrance(1, "192.168.0.0", "24", "192.168.3.1", "192.168.2.1"));
        rip.imprimir();
    }
    
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.awt.Point;
import java.util.ArrayList;

/**
 *
 * @author warlock
 */
public class PC extends Dispositivo{

    public PC() {
    }

    public PC(String nombre, ArrayList<Modulo> modulos, int id, Point point) {
        super(nombre, modulos, id, point);
    }
   
    public PC pc_1(String nombre,int id, Point point){
        Puerto puerto1 = new Puerto(false, "", "eth0", 100, "MB/s", "fastEthernet", false);

        ArrayList<Puerto> puertos = new ArrayList<Puerto>();
        puertos.add(puerto1);
        
        Modulo modulos1 = new Modulo(puertos, "0");

        ArrayList<Modulo> modulos = new ArrayList<Modulo>();
        modulos.add(modulos1);

        PC pc = new PC(nombre, modulos,id, point);
        
        return pc;
        
    }
    
}

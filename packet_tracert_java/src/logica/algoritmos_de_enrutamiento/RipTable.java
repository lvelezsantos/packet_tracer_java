/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package logica.algoritmos_de_enrutamiento;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author minrock
 */
public class RipTable {
    
    private boolean v2_active = false;
    private ArrayList<RipEntrance> rips;
    private String ownerTable;

    public RipTable(String owner){
        rips = new ArrayList<>();
        this.ownerTable = owner;
        
    }
    
    public void add_rip_Entrance(int hops, String ipdest, String maskdst, String nextHop){
        rips.add(new RipEntrance(hops, ipdest, maskdst,nextHop, ownerTable));
    }
    
    public void compare_entrances(RipEntrance rip){
        int localizado=-1;
        for (RipEntrance aux : rips) {
            localizado++;
            if(aux.getDestip().equalsIgnoreCase(rip.getDestip())){
                if(!v2_active){
                    if(rip.getHops()+1<aux.getHops()){
                        replace(localizado,rip);
                        break;
                    }
                }else{
                    if(rip.getHops()+1<aux.getHops() && rip.getDestmask().equalsIgnoreCase(aux.getDestmask())){
                        replace(localizado,rip);
                        break;
                    }
                }
            }
            
        }
        if(localizado == -1){
            rips.add(new RipEntrance(rip.getHops()+1, rip.getDestip(), rip.getDestmask(), rip.getOwnerip(), ownerTable));
        }
    }

    private void replace(int aux, RipEntrance rip) {
        System.out.println(aux);
        rips.set(aux, new RipEntrance(rip.getHops()+1,rip.getDestip(), rip.getDestmask(), rip.getOwnerip(),ownerTable));
    }

    void imprimir() {
        for(RipEntrance aux : rips){
        System.out.println(aux.getDestip()+"  ->"+aux.getDestmask()+"   ->"+aux.getNextHop()+"   ->"+aux.getHops());
        }
    }
    
    public void enableRipV2(){
        this.v2_active = true;
    }
    
    public void disableRipV2(){
        this.v2_active = false;
    }
    
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package logica.algoritmos_de_enrutamiento;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author minrock
 */
public class RipTable implements Serializable {
    
    private int version = 0;
    private boolean v2_active = false;
    private ArrayList<RipEntrance> rips;
    private String ownerTable;

    public RipTable(){
        rips = new ArrayList<>();
        
    }
    
    public void add_rip_Entrance(int hops, String ipdest, String maskdst, String nextHop){
        getRips().add(new RipEntrance(hops, ipdest, maskdst,nextHop, getOwnerTable()));
        this.upgradeVersion();
    }
    
     public RipTable clone(String owner){
         
         RipTable rip = new RipTable();
         rip.setOwnerTable(owner);
         rip.setRips(rips);
         rip.setVersion(version);
         return rip;
        
    }
    
    public void compare_entrances(RipEntrance rip){
        int localizado=-1;
        for (RipEntrance aux : getRips()) {
            localizado++;
            if(aux.getDestip().equalsIgnoreCase(rip.getDestip())){
                if(!isV2_active()){
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
            getRips().add(new RipEntrance(rip.getHops()+1, rip.getDestip(), rip.getDestmask(), rip.getOwnerip(), getOwnerTable()));
            System.out.println("Agregado");
        }
    }

    private void replace(int aux, RipEntrance rip) {
        System.out.println(aux);
        getRips().set(aux, new RipEntrance(rip.getHops()+1,rip.getDestip(), rip.getDestmask(), rip.getOwnerip(), getOwnerTable()));
    }

    void imprimir() {
        for(RipEntrance aux : getRips()){
        System.out.println(aux.getDestip()+"  ->"+aux.getDestmask()+"   ->"+aux.getNextHop()+"   ->"+aux.getHops());
        }
    }
    
    public void enableRipV2(){
        this.setV2_active(true);
    }
    
    public void disableRipV2(){
        this.setV2_active(false);
    }
    
    public void upgradeVersion(){
        setVersion(getVersion() + 1);
        System.out.println("Wait Upgrading........ -> Finished New version :"+getVersion());
    }
    
    public void setOwner(String owner){
        this.setOwnerTable(owner);
    }

    /**
     * @return the version
     */
    public int getVersion() {
        return version;
    }

    /**
     * @param version the version to set
     */
    public void setVersion(int version) {
        this.version = version;
    }

    /**
     * @return the v2_active
     */
    public boolean isV2_active() {
        return v2_active;
    }

    /**
     * @param v2_active the v2_active to set
     */
    public void setV2_active(boolean v2_active) {
        this.v2_active = v2_active;
    }

    /**
     * @return the rips
     */
    public ArrayList<RipEntrance> getRips() {
        return rips;
    }

    /**
     * @param rips the rips to set
     */
    public void setRips(ArrayList<RipEntrance> rips) {
        this.rips = rips;
    }

    /**
     * @return the ownerTable
     */
    public String getOwnerTable() {
        return ownerTable;
    }

    /**
     * @param ownerTable the ownerTable to set
     */
    public void setOwnerTable(String ownerTable) {
        this.ownerTable = ownerTable;
    }
    
    
    
}

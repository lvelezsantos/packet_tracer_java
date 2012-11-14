/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package logica.algoritmos_de_enrutamiento;

import java.io.Serializable;

/**
 *
 * @author minrock
 */
public class RipEntrance implements Serializable{
    
    private int hops;
    private String destip;
    private String destmask;
    private String nextHop;
    private String ownerip;

    public RipEntrance(int hops, String destip, String destmask,String nextHop, String owner){
        this.hops = hops;
        this.destip = destip;
        this.destmask = destmask;
        this.nextHop = nextHop;
        this.ownerip = owner;
    }
    
    /**
     * @return the hops
     */
    public int getHops() {
        return hops;
    }

    /**
     * @param hops the hops to set
     */
    public void setHops(int hops) {
        this.hops = hops;
    }

    /**
     * @return the destip
     */
    public String getDestip() {
        return destip;
    }

    /**
     * @param destip the destip to set
     */
    public void setDestip(String destip) {
        this.destip = destip;
    }

    /**
     * @return the destmask
     */
    public String getDestmask() {
        return destmask;
    }

    /**
     * @param destmask the destmask to set
     */
    public void setDestmask(String destmask) {
        this.destmask = destmask;
    }

    /**
     * @return the nextHop
     */
    public String getNextHop() {
        return nextHop;
    }

    /**
     * @param nextHop the nextHop to set
     */
    public void setNextHop(String nextHop) {
        this.nextHop = nextHop;
    }

    /**
     * @return the ownerip
     */
    public String getOwnerip() {
        return ownerip;
    }

    /**
     * @param ownerip the ownerip to set
     */
    public void setOwnerip(String ownerip) {
        this.ownerip = ownerip;
    }
    
    
    
}

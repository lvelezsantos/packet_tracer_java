/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package logica.algoritmos_de_enrutamiento;

/**
 *
 * @author minrock
 */
public class EntradaRip {
    
    private String ipdst;
    private String maskdst;
    private String nextHop;
    private int nhops;
    
    public EntradaRip(String ipdst, String maskdst, String nextHop, int nhops){
        this.ipdst = ipdst;
        this.maskdst = maskdst;
        this.nextHop = nextHop;
        this.nhops = nhops;
    }

    /**
     * @return the ipdst
     */
    public String getIpdst() {
        return ipdst;
    }

    /**
     * @param ipdst the ipdst to set
     */
    public void setIpdst(String ipdst) {
        this.ipdst = ipdst;
    }

    /**
     * @return the maskdst
     */
    public String getMaskdst() {
        return maskdst;
    }

    /**
     * @param maskdst the maskdst to set
     */
    public void setMaskdst(String maskdst) {
        this.maskdst = maskdst;
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
     * @return the nhops
     */
    public int getNhops() {
        return nhops;
    }

    /**
     * @param nhops the nhops to set
     */
    public void setNhops(int nhops) {
        this.nhops = nhops;
    }
    
    
    
}

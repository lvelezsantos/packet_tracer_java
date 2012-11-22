/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package logica.algoritmos_de_enrutamiento;

/**
 *
 * @author minrock
 */
public class EntradaBgp {
    
    private String ipdst;
    private String maskdst;
    private String nextAtnSys;
    private int nhops;
    private String autonSys;
    
    public EntradaBgp(String ipdst, String maskdst, String nextSys, int nhops, String atnsys){
        this.ipdst = ipdst;
        this.maskdst = maskdst;
        this.nextAtnSys = nextSys;
        this.nhops = nhops;
        this.autonSys = atnsys;
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
        return nextAtnSys;
    }

    /**
     * @param nextHop the nextHop to set
     */
    public void setNextHop(String nextSys) {
        this.nextAtnSys = nextSys;
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
    
    public String getAutonSystem() {
        return autonSys;
    }

    public void setAutonSystem(String autnsys) {
        this.autonSys = autnsys;
    }
    
}

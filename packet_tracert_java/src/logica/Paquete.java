/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.awt.Point;

/**
 *
 * @author minrock
 */
public class Paquete {
    
    private String ipdst;
    private String mskdst;
    private Dispositivo nxthp;
    private int ttl;
    // Para el manejo en la parte grafica
    private Point p;
    private Dispositivo origen;
    private int m;
    private int b;
    private Point pf;
    
    public Paquete(String ipdst, String mskdst, Dispositivo nxthp, int ttl, Dispositivo origen){
        this.ipdst = ipdst;
        this.mskdst = mskdst;
        this.nxthp = nxthp;
        this.ttl = ttl;
        this.pf = (Point) nxthp.getPoint().clone();
        this.p = (Point)origen.getPoint().clone();
        this.origen = origen;
        m = (this.pf.y - p.y)/(this.pf.x - p.x);
        b = this.pf.y - m*this.pf.x;
    }
    
    public boolean arrive(){
         if(p.y>=nxthp.getPoint().y-40 && p.y <= nxthp.getPoint().y + 40){
                if(p.x>=nxthp.getPoint().x-40 && p.x <= nxthp.getPoint().x + 40){
                System.out.println("Llego llego llego");
                return true;
                }
         }else{
            if(getP().x < getNxthp().getPoint().x){
            this.p.x++;
            }else{
                this.p.x--;
            }
        
            this.p.y = m*getP().x + b;
        }
        return false;
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
     * @return the mskdst
     */
    public String getMskdst() {
        return mskdst;
    }

    /**
     * @param mskdst the mskdst to set
     */
    public void setMskdst(String mskdst) {
        this.mskdst = mskdst;
    }

    /**
     * @return the nxthp
     */
    public Dispositivo getNxthp() {
        return nxthp;
    }

    /**
     * @param nxthp the nxthp to set
     */
    public void setNxthp(Dispositivo nxthp) {
        this.nxthp = nxthp;
    }

    /**
     * @return the ttl
     */
    public int getTtl() {
        return ttl;
    }

    /**
     * @param ttl the ttl to set
     */
    public void setTtl(int ttl) {
        this.ttl = ttl;
    }

    /**
     * @return the p
     */
    public Point getP() {
        return p;
    }

    /**
     * @param p the p to set
     */
    public void setP(Point p) {
        this.p = p;
    }

    public Dispositivo getOrigen() {
        return origen;
    }

    public void setOrigen(Dispositivo origen) {
        this.origen = origen;
    }
    
    
    
}

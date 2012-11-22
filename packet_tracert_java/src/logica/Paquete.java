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
    private float m;
    private boolean destino_encontrado;
    private Point pf;
    
    public Paquete(String ipdst, String mskdst, Dispositivo nxthp, int ttl, Dispositivo origen, boolean destino_encontrado){
        this.ipdst = ipdst;
        this.mskdst = mskdst;
        this.nxthp = nxthp;
        this.ttl = ttl;
        this.p = (Point)origen.getPoint().clone();
        this.origen = origen;
        this.pf = (Point)nxthp.getPoint().clone();
        this.destino_encontrado = destino_encontrado;
        //System.out.println(p.toString());
        //System.out.println(pf.toString());
        try{
            
            m =(float) (this.pf.y - p.y)/(this.pf.x - p.x);
            //System.err.println((this.pf.y - p.y)/(this.pf.x - p.x));
        }catch(Exception e){
            m=0;
        }
        
        
    }
    
    public boolean arrive(){
        
         if(p.y>nxthp.getPoint().y-33 && p.y < nxthp.getPoint().y + 33){
                if(p.x>nxthp.getPoint().x-33 && p.x < nxthp.getPoint().x + 33){
                //System.out.println("Llego llego llego");
                return true;
                }
         }else{
            this.p.y = Math.round(-m*(pf.x-p.x)+pf.y);
             //System.out.println(p);
            //System.err.println("b ->"+b+" m->"+m);
//             Point ps = Bresenham(p.x, p.y, nxthp.getPoint().x, nxthp.getPoint().y);
//             p.x = ps.x;
//             p.y = ps.y;
        }
         if(getP().x < getNxthp().getPoint().x){
            this.p.x++;
            }else{
            this.p.x--;
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

    public boolean isDestino_encontrado() {
        return destino_encontrado;
    }

    public void setDestino_encontrado(boolean destino_encontrado) {
        this.destino_encontrado = destino_encontrado;
    }
    
    
    
    
    public Point Bresenham(int x0, int y0, int x1, int y1){
        int x, y, dx, dy, p, incE, incNE, stepx, stepy;
        dx = (x1 - x0);
        dy = (y1 - y0);
        /* determinar que punto usar para empezar, cual para terminar */
            if (dy < 0) { 
                dy = -dy; stepy = -1; 
            } 
        else
            stepy = 1;
        if (dx < 0) {  
            dx = -dx; stepx = -1; 
        } 
        else 
            stepx = 1;
        x = x0;
        y = y0;
        //g.drawLine( x0, y0, x0, y0);
        /* se cicla hasta llegar al extremo de la línea */
        if(dx>dy){
            p = 2*dy - dx;
            incE = 2*dy;
            incNE = 2*(dy-dx);
        while (x != x1){
          x = x + stepx;
          if (p < 0){
            p = p + incE;
          }
          else {
            y = y + stepy;
            p = p + incNE;
          }
          return new Point(x0,y0);
        }
      }
      else{
        p = 2*dx - dy;
        incE = 2*dx;
        incNE = 2*(dx-dy);
        while (y != y1){
          y = y + stepy;
          if (p < 0){
            p = p + incE;
          }
          else {
            x = x + stepx;
            p = p + incNE;
          }
          return new Point(x0,y0);
        }
      }
      return null;
}
    
    
}

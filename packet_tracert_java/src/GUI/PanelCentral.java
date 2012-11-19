/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import logica.Conexion;
import logica.Dispositivo;

/**
 *
 * @author minrock
 */
public class PanelCentral extends JPanel implements Runnable{

    private Controlador con;
    
    public PanelCentral(){
        this.con = new Controlador();
        Thread t = new Thread(this);
        t.start();
    }
    
    
    @Override
    public void run() {
        while(true){
         repaint();
            try {
                Thread.sleep(1000/24); //cambios de 24fps
            } catch (InterruptedException ex) {
                
            }
        }
    }

    public void paint(Graphics g){
        
        System.out.println("DIBUJANDO");
        paintElements(g);
    }
    
    
    private void paintElements(Graphics g) {
         g.setColor(Color.white);
        g.fillRect(0,0,this.getWidth(), this.getHeight());
        ImageIcon ii = new javax.swing.ImageIcon(getClass().getResource("/GUI/Image/router1.png"));
        ImageIcon ii2 = new javax.swing.ImageIcon(getClass().getResource("/GUI/Image/pc1.png"));
        

        for(int i=0;i<getCon().routers.size();i++){
            //33,30
            g.setColor(Color.blue);
            Iterator it = getCon().routers.get(i).getConexiones().iterator();
            
            while(it.hasNext()){
                Dispositivo aux = ((Conexion) it.next()).getDispositivo();
                g.drawLine(getCon().routers.get(i).getPoint().x, getCon().routers.get(i).getPoint().y,aux.getPoint().x, aux.getPoint().y);
            }
            
            //g.drawRect(routers.get(i).x-40,routers.get(i).y-40,80, 80);
            
        }
        for(int i=0;i<getCon().routers.size();i++){
        g.drawImage(ii.getImage(),getCon().routers.get(i).getPoint().x - 34 , getCon().routers.get(i).getPoint().y - 27,this);
        }
        
        
        for(int i=0;i<getCon().pcs.size();i++){
            //33,30
            g.drawImage(ii2.getImage(),getCon().pcs.get(i).getPoint().x - 33 , getCon().pcs.get(i).getPoint().y - 30,this);
            //g.drawRect(pcs.get(i).x-40,pcs.get(i).y-40,80, 80);
        }
        
        this.repaint();
    }

    /**
     * @return the con
     */
    public Controlador getCon() {
        return con;
    }

    /**
     * @param con the con to set
     */
    public void setCon(Controlador con) {
        this.con = con;
    }
    
}

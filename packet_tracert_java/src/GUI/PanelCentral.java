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
import logica.Paquete;

/**
 *
 * @author minrock
 */
public class PanelCentral extends JPanel implements Runnable{

    private Controlador con;
    
    public PanelCentral(Controlador c){
        this.con = c;
        Thread t = new Thread(this);
        t.start();
    }
    
    
    @Override
    public void run() {
        while(true){
         repaint();
         con.recorrido();
            try {
                Thread.sleep(1000/24);
            } catch (InterruptedException ex) {
                
            }
        }
    }

    public void Paint(Graphics g){
        paintElements(g);
    }
    
    
    private void paintElements(Graphics g) {
         g.setColor(Color.white);
        g.fillRect(0,0,this.getWidth(), this.getHeight());
        ImageIcon ii = new javax.swing.ImageIcon(getClass().getResource("/GUI/Image/router1.png"));
        ImageIcon ii2 = new javax.swing.ImageIcon(getClass().getResource("/GUI/Image/pc1.png"));
        ImageIcon ii3 = new javax.swing.ImageIcon(getClass().getResource("/GUI/Image/mss.jpg"));
        

        for(int i=0;i<con.routers.size();i++){
            //33,30
            g.setColor(Color.blue);
            Iterator it = con.routers.get(i).getConexiones().iterator();
            
            while(it.hasNext()){
                Dispositivo aux = ((Conexion) it.next()).getDispositivo();
                g.drawLine(con.routers.get(i).getPoint().x, con.routers.get(i).getPoint().y,aux.getPoint().x, aux.getPoint().y);
            }
            
            //g.drawRect(routers.get(i).x-40,routers.get(i).y-40,80, 80);
            
        }
        for(int i=0;i<con.routers.size();i++){
        g.drawImage(ii.getImage(),con.routers.get(i).getPoint().x - 34 , con.routers.get(i).getPoint().y - 27,this);
        }
        
        
        for(int i=0;i<con.pcs.size();i++){
            //33,30
            g.drawImage(ii2.getImage(),con.pcs.get(i).getPoint().x - 33 , con.pcs.get(i).getPoint().y - 30,this);
            //g.drawRect(pcs.get(i).x-40,pcs.get(i).y-40,80, 80);
        }
        
        for(Paquete p : this.con.paquetes){
            g.drawImage(ii3.getImage(),p.getP().x,p.getP().y, this);
        }
        
    }
    
}

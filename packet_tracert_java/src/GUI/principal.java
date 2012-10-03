/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import logica.Conexion;
import logica.Dispositivo;
import logica.Router;

/**
 *
 * @author minrock
 */
public class principal extends javax.swing.JFrame {

    private String selected = "";
    private int selectedr = -1;
    private int selectedp = -1;
    private int sel = 0;
    private boolean panel = false;
    private Controlador con = new Controlador();
    private String kind = "none";
    private Dispositivo d1 = null;
    private Dispositivo d2 = null;
    String d1c1= "";
    String d2c1= "";
    
    /**
     * Creates new form principal
     */
    public principal() {
        initComponents();
    }
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel(){
            public void paint(Graphics g){
                paintElements(g);

            }
        };

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Image/router2.png"))); // NOI18N
        jLabel2.setText("Router");
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Image/pc.png"))); // NOI18N
        jLabel1.setText("PC");
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Image/eth.png"))); // NOI18N
        jLabel3.setText("Conexiones");
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel2)
                .addComponent(jLabel1)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel3.setVisible(false);

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel5MouseClicked(evt);
            }
        });

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Image/rj45.png"))); // NOI18N
        jLabel4.setText(" ");

        jLabel5.setText("Cruzado");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel4))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel5))
        );

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));
        jPanel9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel9MouseClicked(evt);
            }
        });

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Image/serial.png"))); // NOI18N
        jLabel12.setText(" ");

        jLabel13.setText("Serial");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel13))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(246, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setMaximumSize(new java.awt.Dimension(800, 600));
        jPanel4.setMinimumSize(new java.awt.Dimension(800, 600));
        jPanel4.setPreferredSize(new java.awt.Dimension(800, 600));
        jPanel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel4MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel4MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jPanel4MouseReleased(evt);
            }
        });
        jPanel4.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jPanel4MouseDragged(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 800, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 600, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jPanel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel4MouseClicked
        if(choque(new Point(evt.getX(),evt.getY())).equalsIgnoreCase("false")){
        if(selected.equalsIgnoreCase("router")){
        con.add_router(evt.getPoint());
        }else if(selected.equalsIgnoreCase("pc")){
        con.add_pc(new Point(evt.getX(),evt.getY()));
        }
        }
        if(selected.equalsIgnoreCase("conn")){
            
            Dispositivo d11 = disxpoint(evt.getPoint());
            if(d11 != null){
                System.out.println("A conectar");
                if(d1 == null){
                    d1 = d11;
                    System.out.println("Dispositivo 1 seleccionado");
                }else{
                    d2 = d11;
                    System.out.println("Dispositivo 2 seleccionado");
                    connect();
                }
            
                
            }
        }
        imprimir();
        jPanel4.repaint();
        
           
        
    }//GEN-LAST:event_jPanel4MouseClicked

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        selected = "router";
        panel = false;
        this.jPanel3.setVisible(panel);
    }//GEN-LAST:event_jLabel2MouseClicked

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        selected = "pc";
        panel = false;
        this.jPanel3.setVisible(panel);
    }//GEN-LAST:event_jLabel1MouseClicked

    private void jPanel4MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel4MouseDragged
//        if(choque(evt.getPoint()).contains("false")){
//        if(sel == 1){
//            if(selectedr != -1){
//                this.routers.set(selectedr, evt.getPoint());
//            }else if(selectedp != -1){
//                this.pcs.set(selectedp, evt.getPoint());
//            }
//        }
//        this.jPanel4.repaint();
//        }
//        
    }//GEN-LAST:event_jPanel4MouseDragged

    private void jPanel4MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel4MousePressed
//        String resp = choque(new Point(evt.getX(),evt.getY()));
//            if(resp.contains("router")){
//                String num = resp.substring(6);
//                System.out.println("Router numero : " +num);
//                selectedr = Integer.parseInt(num);
//                sel = 1;
//            }else if(resp.contains("pc")){
//                String num = resp.substring(2);
//                System.out.println("Pc numero : " +num);
//                selectedp = Integer.parseInt(num);
//                sel = 1;
//            }
    }//GEN-LAST:event_jPanel4MousePressed

    private void jPanel4MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel4MouseReleased
        sel =0;
        selectedr = selectedp = -1;
    }//GEN-LAST:event_jPanel4MouseReleased

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        selected = "conn";
        this.panel = true;
        this.jPanel3.setVisible(panel);
    }//GEN-LAST:event_jLabel3MouseClicked

    private void jPanel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel5MouseClicked
        kind = "cross";
    }//GEN-LAST:event_jPanel5MouseClicked

    private void jPanel9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel9MouseClicked
       kind = "serial";
    }//GEN-LAST:event_jPanel9MouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new principal().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel9;
    // End of variables declaration//GEN-END:variables

    private void imprimir() {
        for(int i=0; i<con.routers.size();i++){
        System.out.println("Router -> "+con.routers.get(i).toString());
        }
        for(int i=0; i<con.pcs.size();i++){
        System.out.println("PC -> "+con.pcs.get(i).toString());
        }        
    }
    
    private String choque(Point p){
        
        for(int i=0;i<con.routers.size();i++){
            if(p.y>=con.routers.get(i).getPoint().y-40 && p.y <= con.routers.get(i).getPoint().y + 40){
                if(p.x>=con.routers.get(i).getPoint().x-40 && p.x <= con.routers.get(i).getPoint().x + 40){
                    
                    return "router"+i;
                    
                }
            }
        }
        
        for(int i=0;i<con.pcs.size();i++){
            if(p.y>=con.pcs.get(i).getPoint().y-40 && p.y <= con.pcs.get(i).getPoint().y + 40){
                if(p.x>=con.pcs.get(i).getPoint().x-40 && p.x <= con.pcs.get(i).getPoint().x + 40){
                    
                    return "pc"+i;
                    
                }
            }
        }
        
        if(p.y<0 || p.y> jPanel4.getHeight() || p.x<0 || p.x>jPanel4.getWidth()){
            return "pared";
        }
        
        
        
        return "false";
    }
    
    
    private void paintElements(Graphics g){
    g.setColor(Color.white);
        g.fillRect(0,0,jPanel4.getWidth(), jPanel4.getHeight());
        ImageIcon ii = new javax.swing.ImageIcon(getClass().getResource("/GUI/Image/router2.png"));
        ImageIcon ii2 = new javax.swing.ImageIcon(getClass().getResource("/GUI/Image/pc.png"));
        

        for(int i=0;i<con.routers.size();i++){
            //33,30
            g.setColor(Color.blue);
            Iterator it = con.routers.get(i).getConexiones().iterator();
            while(it.hasNext()){
                Dispositivo aux = ((Conexion) it.next()).getDispositivo();
                g.drawLine(con.routers.get(i).getPoint().x, con.routers.get(i).getPoint().y,aux.getPoint().x, aux.getPoint().y);
            }
            g.drawImage(ii.getImage(),con.routers.get(i).getPoint().x - 34 , con.routers.get(i).getPoint().y - 27,this);
            //g.drawRect(routers.get(i).x-40,routers.get(i).y-40,80, 80);
            
        }
        
        for(int i=0;i<con.pcs.size();i++){
            //33,30
            g.drawImage(ii2.getImage(),con.pcs.get(i).getPoint().x - 33 , con.pcs.get(i).getPoint().y - 30,this);
            //g.drawRect(pcs.get(i).x-40,pcs.get(i).y-40,80, 80);
        }
        
    }
    
    public Dispositivo disxpoint(Point p){
    System.out.println("Encontrar dispositivo");
        Dispositivo dre = null;
        for(int i=0;i<con.routers.size();i++){
            if(p.y>=con.routers.get(i).getPoint().y-40 && p.y <= con.routers.get(i).getPoint().y + 40){
                if(p.x>=con.routers.get(i).getPoint().x-40 && p.x <= con.routers.get(i).getPoint().x + 40){
                    
                    dre = con.routers.get(i);
                    
                }
            }
        }
        
        for(int i=0;i<con.pcs.size();i++){
            if(p.y>=con.pcs.get(i).getPoint().y-40 && p.y <= con.pcs.get(i).getPoint().y + 40){
                if(p.x>=con.pcs.get(i).getPoint().x-40 && p.x <= con.pcs.get(i).getPoint().x + 40){
                    
                    dre =con.pcs.get(i);
                    
                }
            }
        }
        
        return dre;
    
    }

    private void connect() {
        System.out.println("Connect :"+d1.getId()+" <> "+d2.getId());
                
        if(con.tipo_dispositivo(d1.getId()).equalsIgnoreCase("pc")){
        d1c1 = "0/0";
        }else{
        d1c1 = JOptionPane.showInputDialog("Digite el conector y el modulo del router "+d1.getId()+" (modulo/conector)\n"+d1.mostrarPuertos());
        }
        if(con.tipo_dispositivo(d2.getId()).equalsIgnoreCase("pc")){
        d2c1 = "0/0";
        }else{
        d2c1 = JOptionPane.showInputDialog("Digite el conector y el modulo del router "+d1.getId()+" (modulo/conector)\n"+d2.mostrarPuertos());
        }
        try{
        con.connect(d1.getId(), d2.getId(), d1c1.charAt(0)+"",d2c1.charAt(0)+"", d1c1.charAt(2)+"", d2c1.charAt(2)+"");
        }catch(Exception e){
        JOptionPane.showMessageDialog(null, e.getMessage());
        }
        d1 = null;
        d2 = null;
    }
    
}

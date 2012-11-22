/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.border.LineBorder;
import logica.Conexion;
import logica.ConexionGuardar;
import logica.Dispositivo;
import logica.DispositivoGuardar;
import logica.Modulo;
import logica.Paquete;
import logica.Puerto;
import logica.Router;
import logica.RouterGuardar;

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
        jLabel7 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jButtonExportar = new javax.swing.JButton();
        jButtonImportar = new javax.swing.JButton();
        jPanel4 = new PanelCentral();
        jLabelInfo = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel2.setLayout(new java.awt.GridLayout());

        jLabel7.setText("Seleccionar");
        jPanel2.add(jLabel7);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Image/router1.png"))); // NOI18N
        jLabel2.setText("Router");
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });
        jPanel2.add(jLabel2);

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Image/pc1.png"))); // NOI18N
        jLabel1.setText("PC");
        jLabel1.setEnabled(false);
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });
        jPanel2.add(jLabel1);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Image/eth.png"))); // NOI18N
        jLabel3.setText("Conexiones");
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });
        jPanel2.add(jLabel3);

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Image/Terminal Icon.jpg"))); // NOI18N
        jLabel6.setText("Terminal");
        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel6MouseClicked(evt);
            }
        });
        jPanel2.add(jLabel6);

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Image/mess.jpg"))); // NOI18N
        jLabel4.setText("Mensaje");
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
        });
        jPanel2.add(jLabel4);

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Image/mess_flood.png"))); // NOI18N
        jLabel5.setText("Inundar Red");
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
        });
        jPanel2.add(jLabel5);

        jButtonExportar.setText("Exportar");
        jButtonExportar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonExportarActionPerformed(evt);
            }
        });
        jPanel2.add(jButtonExportar);

        jButtonImportar.setText("Importar");
        jButtonImportar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonImportarActionPerformed(evt);
            }
        });
        jPanel2.add(jButtonImportar);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setMaximumSize(new java.awt.Dimension(800, 600));
        jPanel4.setMinimumSize(new java.awt.Dimension(800, 600));
        jPanel4.setPreferredSize(new java.awt.Dimension(800, 600));
        jPanel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel4MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jPanel4MouseReleased(evt);
            }
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel4MouseClicked(evt);
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
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 612, Short.MAX_VALUE)
        );

        jLabelInfo.setText("Info");
        jLabelInfo.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jButton1.setText("Info");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1257, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabelInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 1122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 612, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1)))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jButton1, jLabelInfo});

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jPanel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel4MouseClicked
        if(choque(new Point(evt.getX(),evt.getY())).equalsIgnoreCase("false")){
        if(selected.equalsIgnoreCase("router")){
            jPanel4.getCon().add_router(evt.getPoint());
        }else if(selected.equalsIgnoreCase("pc")){
            jPanel4.getCon().add_pc(new Point(evt.getX(),evt.getY()));
        }
        }
        if(selected.equalsIgnoreCase("term") && !choque(evt.getPoint()).equalsIgnoreCase("false")){
        iniciar_Consola(evt.getPoint());
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
        
        if(selected.equalsIgnoreCase("mess")){
            
            Dispositivo d11 = disxpoint(evt.getPoint());
            if(d11 != null){
                System.out.println("A conectar");
                if(d1 == null){
                    d1 = d11;
                    System.out.println("Dispositivo 1 seleccionado");
                }else{
                    d2 = d11;
                    System.out.println("Dispositivo 2 seleccionado");
                    String ret = d2.giveAIp(); // obtengo una IP valida del dispositivo
                    System.out.println("RETORNADO-> "+ret);
                    String[] splited = ret.split("/");
                    String ipdst = splited[0];
                    String msk = splited[1];
                    //trabajo de la ip para convertirlo a ip de red
                    //this.jPanel4.getCon()
                        Paquete p = new Paquete(ipdst, msk, d2, 15, d1, false);
                        System.out.println("A enviar "+p.toString());
                        
                        this.jPanel4.getCon().paquetes.add(p);                   
                }
            
                
            }
        }
        if(selected.equalsIgnoreCase("flood")){
            Dispositivo a = disxpoint(evt.getPoint());
            if(a!=null){
                String ip = JOptionPane.showInputDialog("Digite la ip destino");
                System.err.println("ip flooding: "+ip);
                if(ip!=null){

                   //validar_ip(ip);
                   jPanel4.getCon().enviarFlooding(ip, "255.255.255.0", 5, a.getIdDispositivo()); 
                }else{
                    JOptionPane.showMessageDialog(rootPane, "Seleccione una ip valida");
                }
            }
            
            
        }
        imprimir();
        jPanel4.repaint();
        
           
        
    }//GEN-LAST:event_jPanel4MouseClicked

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        if(selected.equalsIgnoreCase("router")){
        selected = "none";
        jLabel2.setBorder(null);
        }else{
        selected = "router";
        jLabel2.setBorder(new LineBorder(Color.blue, 2));
        }
        panel = false;
//        this.jPanel3.setVisible(panel);
        jLabel1.setBorder(null);
        jLabel3.setBorder(null);
        jLabel4.setBorder(null);
        jLabel5.setBorder(null);
    }//GEN-LAST:event_jLabel2MouseClicked

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
//        if(selected.equalsIgnoreCase("pc")){
//        selected = "none";
//        jLabel1.setBorder(null);
//        }else{
//        selected = "pc";
//        jLabel1.setBorder(new LineBorder(Color.blue, 2));
//        }
//        panel = false;
////        this.jPanel3.setVisible(panel);
//        jLabel2.setBorder(null);
//        jLabel3.setBorder(null);
//        jLabel6.setBorder(null);
//        jLabel4.setBorder(null);
//        jLabel5.setBorder(null);
    }//GEN-LAST:event_jLabel1MouseClicked

    private void jPanel4MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel4MouseDragged
        if(!choque(evt.getPoint()).contains("false")){
        if(sel == 1){
            if(selectedr != -1){
                this.jPanel4.getCon().routers.get(selectedr).setPoint(evt.getPoint());//set(selectedr, evt.getPoint());
            }else if(selectedp != -1){
                this.jPanel4.getCon().pcs.get(selectedp).setPoint(evt.getPoint());
            }
        }
        this.jPanel4.repaint();
        }
        
    }//GEN-LAST:event_jPanel4MouseDragged

    private void jPanel4MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel4MousePressed
        String resp = choque(new Point(evt.getX(),evt.getY()));
            if(resp.contains("router")){
                String num = resp.substring(6);
                System.out.println("Router numero : " +num);
                selectedr = Integer.parseInt(num);
                sel = 1;
            }else if(resp.contains("pc")){
                String num = resp.substring(2);
                System.out.println("Pc numero : " +num);
                selectedp = Integer.parseInt(num);
                sel = 1;
            }
    }//GEN-LAST:event_jPanel4MousePressed

    private void jPanel4MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel4MouseReleased
        sel =0;
        selectedr = selectedp = -1;
    }//GEN-LAST:event_jPanel4MouseReleased

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        if(selected.equalsIgnoreCase("conn")){
        selected = "none";
        jLabel3.setBorder(null);
        }else{
        selected = "conn";
        jLabel3.setBorder(new LineBorder(Color.blue, 2));
        }
        this.panel = true;
        //this.jPanel3.setVisible(panel);
        jLabel1.setBorder(null);
        jLabel2.setBorder(null);
        jLabel6.setBorder(null);
        jLabel4.setBorder(null);
        jLabel5.setBorder(null);
    }//GEN-LAST:event_jLabel3MouseClicked

    private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseClicked
        if(selected.equalsIgnoreCase("term")){
        selected = "none";
        jLabel6.setBorder(null);
        }else{
        selected = "term";
        jLabel6.setBorder(new LineBorder(Color.blue, 2));
        }
        this.panel = true;
        //this.jPanel3.setVisible(panel);
        jLabel1.setBorder(null);
        jLabel2.setBorder(null);
        jLabel3.setBorder(null);
        jLabel4.setBorder(null);
        jLabel5.setBorder(null);
    }//GEN-LAST:event_jLabel6MouseClicked

    private void jButtonExportarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonExportarActionPerformed
        exportar();
    }//GEN-LAST:event_jButtonExportarActionPerformed

    private void jButtonImportarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonImportarActionPerformed
        importar();
    }//GEN-LAST:event_jButtonImportarActionPerformed

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
        // Activacion de envio de mensajes
        d1 = null;
        d2 = null;
        if(selected.equalsIgnoreCase("mess")){
            selected = "none";
            this.jLabel4.setBorder(null);
        }else{
            this.jLabel4.setBorder(new LineBorder(Color.blue,2));
            selected = "mess";
        }
        jLabel1.setBorder(null);
        jLabel2.setBorder(null);
        jLabel3.setBorder(null);
        jLabel6.setBorder(null);
        jLabel5.setBorder(null);
    }//GEN-LAST:event_jLabel4MouseClicked

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
        if(selected.equalsIgnoreCase("flood")){
            selected = "none";
            this.jLabel5.setBorder(null);            
        }else{
            this.jLabel5.setBorder(new LineBorder(Color.blue,2));
            selected = "flood";
        }
        jLabel1.setBorder(null);
        jLabel2.setBorder(null);
        jLabel3.setBorder(null);
        jLabel6.setBorder(null);
        jLabel4.setBorder(null);
    }//GEN-LAST:event_jLabel5MouseClicked

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
            
            @Override
            public void run() {
                principal prin = new principal();
                ModVentana.centrar(prin);
                prin.setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButtonExportar;
    private javax.swing.JButton jButtonImportar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabelInfo;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    /*
    private javax.swing.JPanel jPanel4;
    */
    private PanelCentral jPanel4;
    // End of variables declaration//GEN-END:variables

    private void imprimir() {
        for(int i=0; i<jPanel4.getCon().routers.size();i++){
        System.out.println("Router -> "+jPanel4.getCon().routers.get(i).toString());
        }
        for(int i=0; i<jPanel4.getCon().pcs.size();i++){
        System.out.println("PC -> "+jPanel4.getCon().pcs.get(i).toString());
        }        
    }
    
    private String choque(Point p){
        
        for(int i=0;i<jPanel4.getCon().routers.size();i++){
            if(p.y>=jPanel4.getCon().routers.get(i).getPoint().y-40 && p.y <= jPanel4.getCon().routers.get(i).getPoint().y + 40){
                if(p.x>=jPanel4.getCon().routers.get(i).getPoint().x-40 && p.x <= jPanel4.getCon().routers.get(i).getPoint().x + 40){
                    
                    return "router"+i;
                    
                }
            }
        }
        
        for(int i=0;i<jPanel4.getCon().pcs.size();i++){
            if(p.y>=jPanel4.getCon().pcs.get(i).getPoint().y-40 && p.y <= jPanel4.getCon().pcs.get(i).getPoint().y + 40){
                if(p.x>=jPanel4.getCon().pcs.get(i).getPoint().x-40 && p.x <= jPanel4.getCon().pcs.get(i).getPoint().x + 40){
                    
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
        ImageIcon ii = new javax.swing.ImageIcon(getClass().getResource("/GUI/Image/router1.png"));
        ImageIcon ii2 = new javax.swing.ImageIcon(getClass().getResource("/GUI/Image/pc1.png"));
        

        for(int i=0;i<jPanel4.getCon().routers.size();i++){
            //33,30
            g.setColor(Color.blue);
            Iterator it = jPanel4.getCon().routers.get(i).getConexiones().iterator();
            
            while(it.hasNext()){
                Dispositivo aux = ((Conexion) it.next()).getDispositivo();
                g.drawLine(jPanel4.getCon().routers.get(i).getPoint().x, jPanel4.getCon().routers.get(i).getPoint().y,aux.getPoint().x, aux.getPoint().y);
            }
            
            //g.drawRect(routers.get(i).x-40,routers.get(i).y-40,80, 80);
            
        }
        for(int i=0;i<jPanel4.getCon().routers.size();i++){
        g.drawImage(ii.getImage(),jPanel4.getCon().routers.get(i).getPoint().x - 34 , jPanel4.getCon().routers.get(i).getPoint().y - 27,this);
        }
        
        
        for(int i=0;i<jPanel4.getCon().pcs.size();i++){
            //33,30
            g.drawImage(ii2.getImage(),jPanel4.getCon().pcs.get(i).getPoint().x - 33 , jPanel4.getCon().pcs.get(i).getPoint().y - 30,this);
            //g.drawRect(pcs.get(i).x-40,pcs.get(i).y-40,80, 80);
        }
        
    }
    
    public Dispositivo disxpoint(Point p){
    System.out.println("Encontrar dispositivo");
        Dispositivo dre = null;
        for(int i=0;i<jPanel4.getCon().routers.size();i++){
            if(p.y>=jPanel4.getCon().routers.get(i).getPoint().y-40 && p.y <= jPanel4.getCon().routers.get(i).getPoint().y + 40){
                if(p.x>=jPanel4.getCon().routers.get(i).getPoint().x-40 && p.x <= jPanel4.getCon().routers.get(i).getPoint().x + 40){
                    
                    dre = jPanel4.getCon().routers.get(i);
                    jLabelInfo.setText(dre.getNombre());
                           
                    
                }
            }
        }
        
        for(int i=0;i<jPanel4.getCon().pcs.size();i++){
            if(p.y>=jPanel4.getCon().pcs.get(i).getPoint().y-40 && p.y <= jPanel4.getCon().pcs.get(i).getPoint().y + 40){
                if(p.x>=jPanel4.getCon().pcs.get(i).getPoint().x-40 && p.x <= jPanel4.getCon().pcs.get(i).getPoint().x + 40){
                    
                    dre =jPanel4.getCon().pcs.get(i);
                    
                }
            }
        }
        
        return dre;
    
    }

    private void connect() {
        
        boolean disponible_d1 = d1.mostrarPuertosLibres().isEmpty();    
        boolean disponible_d2 = d2.mostrarPuertosLibres().isEmpty();
        if(disponible_d1){
            JOptionPane.showMessageDialog(null, "El dispositivo 1 no tiene puertos libres");
            if(disponible_d2){
                JOptionPane.showMessageDialog(null, "El dispositivo 2 no tiene puertos libres");
            }
        }
        if(!disponible_d1 && !disponible_d2){
            System.out.println("Connect :"+d1.getIdDispositivo()+" <> "+d2.getIdDispositivo());
            if(jPanel4.getCon().tipo_dispositivo(d1.getIdDispositivo()).equalsIgnoreCase("pc")){
            d1c1 = "0/0";
            }else{

                JDialogPuertos jd = new JDialogPuertos(this, true, jPanel4.getCon(), d1.getIdDispositivo());
                ModVentana.centrar(jd);
                //d1c1 = JOptionPane.showInputDialog("Digite el conector y el modulo del router "+d1.getIdDispositivo()+" (modulo/conector)\n"+d1.mostrarPuertos());
                jd.setVisible(true);
                d1c1 = jd.getSeleccion();
            }
            if(jPanel4.getCon().tipo_dispositivo(d2.getIdDispositivo()).equalsIgnoreCase("pc")){
            d2c1 = "0/0";
            }else{
                JDialogPuertos jd = new JDialogPuertos(this, true, jPanel4.getCon(), d2.getIdDispositivo());
                ModVentana.centrar(jd);
                jd.setVisible(true);
                d2c1 = jd.getSeleccion();
                //d2c1 = JOptionPane.showInputDialog("Digite el conector y el modulo del router "+d1.getIdDispositivo()+" (modulo/conector)\n"+d2.mostrarPuertos());

            }
            try{

                jPanel4.getCon().connect(d1.getIdDispositivo(), d2.getIdDispositivo(), d1c1.charAt(2)+"",d2c1.charAt(2)+"", d1c1.charAt(0)+"", d2c1.charAt(0)+"");
            }catch(Exception e){
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
            d1 = null;
            d2 = null;
        }
    }

    private void iniciar_Consola(Point point) {
        Dispositivo a = disxpoint(point);
        System.out.println("bout show console");
        if(jPanel4.getCon().tipo_dispositivo(a.getIdDispositivo()).equalsIgnoreCase("router")){
            JDialogConsola jd = new JDialogConsola(null,true, jPanel4.getCon(), a.getIdDispositivo());
            ModVentana.centrar(jd);
            jd.setVisible(true);
        }else{
            String ip = JOptionPane.showInputDialog("Digite la IP del computador");
            a.getModulos().get(0).getPuertos().get(0).setIp(ip);
            String netmask = JOptionPane.showInputDialog("Digite la mascara de red del computador");
            a.getModulos().get(0).getPuertos().get(0).setNetmask(netmask);
            JOptionPane.showMessageDialog(null, a.mostrar_informacion());
        }
    }
    
    private void exportar() {
        JFileChooser jf = new JFileChooser();
        jf.setMultiSelectionEnabled(false);
        int r =jf.showSaveDialog(jf); 
        if(r == JFileChooser.APPROVE_OPTION){
            try {
                FileOutputStream bs = new FileOutputStream(jf.getSelectedFile());
                ObjectOutputStream os;
                System.out.println("Serializando");
                os = new ObjectOutputStream(bs);
                ArrayList<RouterGuardar> lista_router= new ArrayList<>();
                for(Router rout: jPanel4.getCon().routers){
                    RouterGuardar rout_guar = new RouterGuardar();
                    rout_guar.setPoint(rout.getPoint());
                    rout_guar.setNombre(rout.getNombre());
                    rout_guar.setModulos(rout.getModulos());
                    rout_guar.setRipt(rout.getRipt());
                    rout_guar.setRipv2(rout.isRipv2());
                    rout_guar.setIdDispositivo(rout.getIdDispositivo());
                    ArrayList<ConexionGuardar> lista_conex = new ArrayList<>();
                    for(Conexion conex : rout.getConexiones()){
                        Dispositivo dis = conex.getDispositivo();
                        DispositivoGuardar dis_guar = new DispositivoGuardar(
                                                                                dis.getNombre(), 
                                                                                dis.getModulos(), 
                                                                                dis.getIdDispositivo(), 
                                                                                dis.getPoint()
                                                                            );
                        ConexionGuardar conexio_guarda = new ConexionGuardar(
                                                                                dis_guar, 
                                                                                conex.getModulo_cad(), 
                                                                                conex.getPuerto_cad(), 
                                                                                conex.getModulo_local(), 
                                                                                conex.getPuerto_local()
                                                                            );
                        lista_conex.add(conexio_guarda); 
                    }
                    rout_guar.setConexiones(lista_conex);
                    lista_router.add(rout_guar); 
                }
                    
                os.writeObject(lista_router);  // this es de tipo DatoUdp
                os.close();
                JOptionPane.showMessageDialog(null, "El archivo se ha exportado exitosamente");
            } catch (IOException ex) {
                Logger.getLogger(principal.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    private void importar() {
        JFileChooser jf = new JFileChooser();
        jf.setMultiSelectionEnabled(false);
        int r =jf.showOpenDialog(jf);
        if(r == JFileChooser.APPROVE_OPTION){
             ObjectInputStream entrada;
            try {
                entrada = new ObjectInputStream(new FileInputStream(jf.getSelectedFile()));                
                ArrayList<RouterGuardar> lista_dis = (ArrayList<RouterGuardar>) entrada.readObject();
                
                //importando los datos
                ArrayList<Router> lista_router= new ArrayList<>();
                jPanel4.setCon(new Controlador()); //reinicializamos el controlador
                for(RouterGuardar rout_guar: lista_dis){
                    
                    jPanel4.getCon().add_router(rout_guar.getPoint());
                    jPanel4.getCon().search_router(rout_guar.getIdDispositivo()).setRipt(rout_guar.getRipt());
                    jPanel4.getCon().search_router(rout_guar.getIdDispositivo()).setRipv2(rout_guar.isRipv2());
                    jPanel4.getCon().search_router(rout_guar.getIdDispositivo()).setNombre(rout_guar.getNombre());
                    for(Modulo mod: rout_guar.getModulos()){
                        for(Puerto puer: mod.getPuertos()){
                            jPanel4.getCon().asignar_ip_puerto(rout_guar.getIdDispositivo(), mod.getNombre(), puer.getNombre(), puer.getIp(), puer.getNetmask());
                        }
                    }
                    
                }
                System.out.println("");
                for(RouterGuardar rout_guar: lista_dis){  
                    System.err.println("Agregando conexiones");
                    System.out.println("");
                    System.out.println("Router1:"+rout_guar.getNombre());
                    for(ConexionGuardar conex : rout_guar.getConexiones()){
                        
                        System.out.println("");
                        System.out.println("Router2:"+conex.getDispositivo().getNombre());
                        System.out.println(""+conex);
                        //try{
                            jPanel4.getCon().connect_import(
                                    rout_guar.getIdDispositivo(), //dis1
                                    conex.getDispositivo().getIdDispositivo(), //dis2
                                    conex.getPuerto_local(), //puertodis1
                                    conex.getPuerto_cad(), //puertodis2
                                    conex.getModulo_local(), //modulodis1
                                    conex.getModulo_cad() //modulodis2
                                    );  
                        /*}catch(Exception e){
                            
                        }*/
                    }
                    
                }
                
                JOptionPane.showMessageDialog(null, "Controlador importado con exito");
                
                
            } catch (Exception ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null , "Error al escoger el archivo");
            }


        }
    }

    
}

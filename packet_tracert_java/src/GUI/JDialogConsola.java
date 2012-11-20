/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Autom.Diccionario;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import logica.Dispositivo;
import logica.Router;
import logica.algoritmos_de_enrutamiento.EntradaRip;

/**
 *
 * @author warlock
 */
public class JDialogConsola extends javax.swing.JDialog {
    
    /**
     * Creates new form JDialogConsola
     */
    
    /*
     * Comandos
     * hostname nombre_router
     * enable
     * configure terminal
     * conf t
     * router vector
     * network ip
     * interface fastEthernet modulo/puerto
     * interface fa modulo/puerto
     * ip address ip netmask
     * exit
     * no shutdown
     * shutdown
     * show running-config
     * sh run
     * end
     * ping
     * ?
     * router rip
     * version2
     */
    
    Controlador controlador;
    int id_router;
    int pos_router;
    private String nivel;
    private static String nivel_normal = ">";
    private static String nivel_enable = "#";
    private static String nivel_configure_terminal = "(config)#";
    private static String nivel_router_vector = "(config-router)#";
    private static String nivel_router_rip = "(config-router)#";
    private static String nivel_interface = "(config-if)#";
    private String modulo;
    private String puerto;
    private ArrayList<String> comandos_ejecutados;
    private int posicion_comandos;
    private Diccionario diccionario;
    private boolean isripv2 = false;
    
    public JDialogConsola(java.awt.Frame parent, boolean modal, Controlador controlador, int id_router) {
        super(parent, modal);
        initComponents();
        nivel = nivel_normal;
        this.controlador = controlador;
        
        this.id_router = id_router;
        this.pos_router = this.controlador.search_pos_router(this.id_router);
        set_label_nivel();
        this.comandos_ejecutados = new ArrayList<String>();
        this.posicion_comandos = comandos_ejecutados.size();
        this.diccionario = new Diccionario();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextAreaConsola = new javax.swing.JTextArea();
        jTextFieldComando = new javax.swing.JTextField();
        jLabelNivel = new javax.swing.JLabel();

        setTitle("Consola");

        jTextAreaConsola.setEditable(false);
        jTextAreaConsola.setColumns(20);
        jTextAreaConsola.setRows(5);
        jScrollPane1.setViewportView(jTextAreaConsola);

        jTextFieldComando.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldComandoKeyTyped(evt);
            }
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldComandoKeyPressed(evt);
            }
        });

        jLabelNivel.setText("jLabel1");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 746, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabelNivel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldComando, javax.swing.GroupLayout.PREFERRED_SIZE, 609, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 403, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldComando, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelNivel))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldComandoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldComandoKeyTyped
       
    }//GEN-LAST:event_jTextFieldComandoKeyTyped

    String eliminar_espacios(String cadena){
        String cadena_sin_espacios=cadena.trim();
        
        while(!cadena_sin_espacios.replaceAll("  ", " ").equals(cadena_sin_espacios)){ 
            cadena_sin_espacios = cadena_sin_espacios.replaceAll("  ", " ");
        }
        
        return cadena_sin_espacios;
    }
    
    private void mensaje_consola(String mensaje){
        jTextAreaConsola.append(this.controlador.routers.get(this.pos_router).getNombre() +nivel+mensaje+"\n");
    }
    
    private void mensaje_2_consola(String mensaje){
        jTextAreaConsola.append("\n"+mensaje+"\n");
    }
    
    private void set_label_nivel(){
        jLabelNivel.setText(this.controlador.routers.get(this.pos_router).getNombre() +this.nivel);
    }
    
    private void jTextFieldComandoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldComandoKeyPressed
        if(evt.getKeyCode()==17){
            //Se hara la funcion de autocompletado
        }
        if(evt.getKeyCode()==38){
            if(comandos_ejecutados.size()>0){
                if(posicion_comandos==comandos_ejecutados.size()){
                    posicion_comandos = comandos_ejecutados.size() -1 ;
                }
                if(posicion_comandos>=0){
                    jTextFieldComando.setText(comandos_ejecutados.get(posicion_comandos));
                }else{
                jTextFieldComando.setText("");
                }
                if(posicion_comandos >= 0){
                    posicion_comandos--;
                }
            }
        }
        if(evt.getKeyCode()==40){
            if(comandos_ejecutados.size()>0){
                if(posicion_comandos<0){
                    posicion_comandos = 0;
                }
                if(posicion_comandos<comandos_ejecutados.size()) {
                    jTextFieldComando.setText(comandos_ejecutados.get(posicion_comandos));
                }else{
                    jTextFieldComando.setText("");
                }
                if(posicion_comandos < comandos_ejecutados.size()){
                    posicion_comandos++;
                }
            }
        }
        if(evt.getKeyCode()==10){
            String comando = jTextFieldComando.getText();
            comando = eliminar_espacios(comando);
            mensaje_consola(comando);
            comandos_ejecutados.add(comando);
            //if(diccionario.solver(comando)){
            if(true){
                if(comando.equals("flooding")){
                    String[] list_com = comando.split(" ");
                    Dispositivo dis = this.controlador.routers.get(pos_router);
                    dis.getFlooding().ejecutar_protocolo(dis.getConexiones(), list_com[1], Integer.getInteger(list_com[2]));
                    
                }
                if(nivel.equals(nivel_normal)){
                    if(comando.equals("enable") || comando.equals("en")){
                        nivel = nivel_enable;
                    }
                    if(comando.equals("?")){
                        mensaje_consola("\nComandos Disponibles\n\nenable");
                    }
                }
                if(nivel.equals(nivel_enable)){
                    String[] list_com;
                    list_com = comando.split(" ");
                    if(comando.equals("configure terminal") || comando.equals("conf t")) {
                        nivel = nivel_configure_terminal;
                    }

                    if(comando.equals("show running-config")||comando.equals("sh run")){
                        mensaje_consola(this.controlador.mostrar_informacion(this.id_router)+"\n");
                    }

                    if(comando.equals("?")){
                        mensaje_consola("\nComandos Disponibles\n\nconfigure terminal\nshow running-config");
                    }

                    if(list_com.length==2){
                        if(list_com[0].equals("ping")){
                            String ip = list_com[1];
                            String resultado = this.controlador.ping(this.id_router,ip);
                            mensaje_consola("\n!\n!"+resultado);
                        }
                    }
                }

                if(nivel.equals(nivel_configure_terminal)){
                    String[] list_comando;
                    list_comando = comando.split(" ");
                    if(list_comando.length==2){
                        if(list_comando[0].equals("hostname")){
                            controlador.cambiar_nombre_router(this.id_router, list_comando[1]);
                        }
                    }

                    if(comando.equals("router vector")){
                        nivel = nivel_router_vector;
                    }
                    
                    if(comando.equals("router rip")){
                        nivel = nivel_router_rip;
                    }

                    if(list_comando.length == 3){
                        if(list_comando[0].equals("interface") || list_comando[0].equals("int")){
                            if(list_comando[1].equals("fastEthernet") || list_comando[1].equals("fa")){
                                String[] lista_modulo_puerto;
                                lista_modulo_puerto = list_comando[2].split("/");
                                if(lista_modulo_puerto.length == 2 ){
                                    modulo = lista_modulo_puerto[0];
                                    puerto = lista_modulo_puerto[1];
                                    int[] variable = new int[2];

                                    if(this.controlador.routers.get(this.pos_router).buscar_modulo_puerto(modulo, puerto)[0]!=-1){
                                        nivel = nivel_interface;
                                    }else{
                                        mensaje_consola("No existe modulos o interfaz seleccionada"); 
                                    }
                                 }
                            }
                        }
                    }

                    if(comando.equals("?")){
                        mensaje_consola("\nComandos Disponibles\n\nhostname <nombre>\n"
                                + "interface fastEthernet <modulo>/<puerto>\n"
                                + "router vector");
                    }

                }

                if(nivel.equals(nivel_interface)){
                    String[] list_ip_addres;
                    list_ip_addres = comando.split(" ");


                    if(list_ip_addres.length==5){
                        if(list_ip_addres[0].equals("ip") && list_ip_addres[1].equals("address") && list_ip_addres[3].equals("netmask")){
                            String ip = list_ip_addres[2];
                            String netmask = list_ip_addres[4];
                            boolean flag;
                            flag = this.controlador.asignar_ip_puerto(this.id_router, this.modulo, this.puerto, ip, netmask);
                            try {
                                System.out.println("Envio exitoso");
                            } catch (Exception ex) {
                                System.err.println("Intente enviar una tabla sin configuracion de puertos :'(");
                            }
                            if(!flag){
                                mensaje_consola("No se asigno la ip al puerto");
                            }
                        }                        
                    }

                    if(comando.equals("no shutdown")){
                        boolean flag = this.controlador.encender_puerto(this.id_router, this.modulo, this.puerto);
                        if(flag){
                            mensaje_consola("el puerto  se ha encendido");
                            try {
                                System.out.println("Envio exitoso");
                            } catch (Exception ex) {
                                System.err.println("Intente enviar una tabla sin configuracion de puertos :'(");
                                
                            }
                        }else{
                            mensaje_consola("El puerto ya estaba encendido");
                        }
                    }

                    if(comando.equals("shutdown")){
                        boolean flag = this.controlador.apagar_puerto(this.id_router, this.modulo, this.puerto);
                        if(flag){
                            mensaje_consola("El puerto se ha apagado");
                        }else{
                            mensaje_consola("El puerto ya estaba apagado");
                        }
                    }
                    if(comando.equals("?")){
                        mensaje_consola("\nComandos Disponibles\n\nip address <ip> <netmask>\n"
                                + "shutdown\nno shutdown");
                    }
                }
         
                if(nivel.equals(nivel_router_rip)){
                    String[] list_comando;
                    list_comando = comando.split(" ");
                        if(list_comando[0].equals("network")){
                            String ip = list_comando[1];
                            System.err.println("AQUI ESTOY");
                            String mask = "0.0.0.0";
                            if(isripv2){
                                try{
                                mask = list_comando[2];
                                }catch(IndexOutOfBoundsException iex){
                                mensaje_consola("Por favor Escriba la mascara de subred");
                                }
                            }else{
                            }
                            nuevaentradaRip(ip,mask); 
                        }
                }
                
                if(comando.equals("exit")){
                    if(nivel.equals(nivel_interface)){
                        nivel = nivel_configure_terminal;
                    }else if(nivel.equals(nivel_router_vector)){
                        nivel = nivel_configure_terminal;
                    }else if(nivel.equals(nivel_configure_terminal)){
                        nivel = nivel_enable;
                    }else if(nivel.equals(nivel_enable)){
                        nivel = nivel_normal;
                    }

                }

                if(comando.equals("end")){
                    nivel = nivel_enable;
                }

                jTextFieldComando.setText("");
                set_label_nivel();
                this.posicion_comandos = comandos_ejecutados.size()-1;
            }else{
                mensaje_2_consola("Comando incorrecto");
            }
        }
    }//GEN-LAST:event_jTextFieldComandoKeyPressed

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
            java.util.logging.Logger.getLogger(JDialogConsola.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JDialogConsola.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JDialogConsola.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JDialogConsola.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                JDialogConsola dialog = new JDialogConsola(new javax.swing.JFrame(), true,new Controlador(), 1);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabelNivel;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextAreaConsola;
    private javax.swing.JTextField jTextFieldComando;
    // End of variables declaration//GEN-END:variables

    private void nuevaentradaRip(String ip, String mask) {
        Router r = this.controlador.routers.get(pos_router);
        r.agregarRip(new EntradaRip(ip, mask, ip, 1));
    }


}

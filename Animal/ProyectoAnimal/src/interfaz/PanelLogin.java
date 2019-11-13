/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaz;

import dominio.Funcionario;
import dominio.Sistema;
import encriptación.PasswordUtils;
import serialización.Persistencia;

/**
 *
 * @author lucas
 */
public class PanelLogin extends javax.swing.JPanel {

    /**
     * Creates new form pnlLogin
     */
    public PanelLogin(VentanaRegistroLogin vent,Sistema sistema) {
        initComponents();
        
        this.ventana = vent;
        this.modelo = sistema;
        this.ocultarAdvertencias();
       
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlLogin = new javax.swing.JPanel();
        lblTitulo = new javax.swing.JLabel();
        txUsuario = new javax.swing.JTextField();
        lblUsuario = new javax.swing.JLabel();
        lblContraseña = new javax.swing.JLabel();
        fieldContraseña = new javax.swing.JPasswordField();
        btnIngresar = new javax.swing.JButton();
        btnRegistrar = new javax.swing.JButton();
        lblAdvertUsuario = new javax.swing.JLabel();
        lblAdvertPassword = new javax.swing.JLabel();
        btnSalir = new javax.swing.JButton();

        pnlLogin.setBackground(new java.awt.Color(51, 204, 255));
        pnlLogin.setPreferredSize(new java.awt.Dimension(600, 670));

        lblTitulo.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lblTitulo.setForeground(new java.awt.Color(0, 0, 0));
        lblTitulo.setText("Inicio de Sesión");

        txUsuario.setBackground(java.awt.SystemColor.controlLtHighlight);
        txUsuario.setForeground(new java.awt.Color(0, 0, 0));
        txUsuario.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lblUsuario.setForeground(new java.awt.Color(51, 51, 51));
        lblUsuario.setText("Nombre De Usuario o Correo Electronico");

        lblContraseña.setForeground(new java.awt.Color(51, 51, 51));
        lblContraseña.setText("Contraseña");

        fieldContraseña.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        btnIngresar.setText("Ingresar");
        btnIngresar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnIngresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIngresarActionPerformed(evt);
            }
        });

        btnRegistrar.setText("Ir A Registrar ");
        btnRegistrar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });

        lblAdvertUsuario.setForeground(new java.awt.Color(255, 0, 0));
        lblAdvertUsuario.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblAdvertUsuario.setText("advertencia usuario");

        lblAdvertPassword.setForeground(new java.awt.Color(255, 0, 0));
        lblAdvertPassword.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblAdvertPassword.setText("advertencia password");

        btnSalir.setText("Salir");
        btnSalir.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlLoginLayout = new javax.swing.GroupLayout(pnlLogin);
        pnlLogin.setLayout(pnlLoginLayout);
        pnlLoginLayout.setHorizontalGroup(
            pnlLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlLoginLayout.createSequentialGroup()
                .addContainerGap(314, Short.MAX_VALUE)
                .addGroup(pnlLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblUsuario)
                    .addComponent(lblContraseña)
                    .addGroup(pnlLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                        .addComponent(fieldContraseña, javax.swing.GroupLayout.PREFERRED_SIZE, 322, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 322, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblTitulo, javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(lblAdvertUsuario, javax.swing.GroupLayout.Alignment.CENTER, javax.swing.GroupLayout.PREFERRED_SIZE, 322, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.CENTER, pnlLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                        .addComponent(btnRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnIngresar, javax.swing.GroupLayout.Alignment.CENTER, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblAdvertPassword, javax.swing.GroupLayout.Alignment.CENTER, javax.swing.GroupLayout.PREFERRED_SIZE, 322, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(321, Short.MAX_VALUE))
        );
        pnlLoginLayout.setVerticalGroup(
            pnlLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlLoginLayout.createSequentialGroup()
                .addGap(98, 98, 98)
                .addComponent(lblTitulo)
                .addGap(27, 27, 27)
                .addComponent(lblUsuario)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblAdvertUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblContraseña)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(fieldContraseña, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(lblAdvertPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnIngresar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(147, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlLogin, javax.swing.GroupLayout.DEFAULT_SIZE, 957, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlLogin, javax.swing.GroupLayout.DEFAULT_SIZE, 614, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        // TODO add your handling code here:
        this.ocultarAdvertencias();
        this.vaciarFields();
        this.ventana.mostrarPanelRegistro();
        
    }//GEN-LAST:event_btnRegistrarActionPerformed
    
    private void btnIngresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIngresarActionPerformed
        if(this.verificarDatosIngresados()){
            VentanaPrincipal ventana = new VentanaPrincipal(this.modelo);
            this.ventana.dispose();
            ventana.setVisible(true);
           
        }
    }//GEN-LAST:event_btnIngresarActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        new Persistencia().serializar(this.modelo);
        System.exit(0);
    }//GEN-LAST:event_btnSalirActionPerformed
    public boolean verificarDatosIngresados(){
        String username = this.txUsuario.getText();
        String password = new String(this.fieldContraseña.getPassword());
        Funcionario func = new Funcionario(username,"",username);
        if(!this.usernameVacio(username)){
            this.ocultarAdvertencias();
            func = this.modelo.buscarFuncionario(func);
            if(func != null && PasswordUtils.verificarPassswordUsuario(password, func.getPassword(), func.getGeneratedSalt())){
                return true;
            }else{
                this.mostrarAdvertencia(1, "Nombre de usuario o contraseña incorrectos");
            }
        }else{
            String advUsuario= "Debe ingresar un nombre de usuario.";
            String advPassword = "La contraseña es incorrecta.";
            this.ocultarAdvertencias();
            if(usernameVacio(username)){
                this.mostrarAdvertencia(0,advUsuario);
            }else {
                this.mostrarAdvertencia(1, advPassword);
            }
        }
        return false;
    }
    public void mostrarAdvertencia(int adv,String texto){
        switch(adv){
            case 0: 
                this.lblAdvertUsuario.setText(texto);
                this.lblAdvertUsuario.setVisible(true);
            break;
            case  1: 
                this.lblAdvertPassword.setText(texto);
                this.lblAdvertPassword.setVisible(true);
            break;
            default:
                this.lblAdvertUsuario.setVisible(false);
                this.lblAdvertPassword.setVisible(false);
            break;
        }
    }
    public void ocultarAdvertencias(){
        this.lblAdvertPassword.setVisible(false);
        this.lblAdvertUsuario.setVisible(false);
    }
    public void vaciarFields(){
        this.txUsuario.setText("");
        this.fieldContraseña.setText("");
    }
    public static boolean usernameVacio(String username){
        return username.trim().isEmpty();
    }
    
    
    private final VentanaRegistroLogin ventana;
    private final Sistema modelo;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnIngresar;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JButton btnSalir;
    private javax.swing.JPasswordField fieldContraseña;
    private javax.swing.JLabel lblAdvertPassword;
    private javax.swing.JLabel lblAdvertUsuario;
    private javax.swing.JLabel lblContraseña;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JLabel lblUsuario;
    private javax.swing.JPanel pnlLogin;
    private javax.swing.JTextField txUsuario;
    // End of variables declaration//GEN-END:variables
}

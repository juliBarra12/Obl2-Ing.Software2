/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaz;
import dominio.Funcionario;
import dominio.Sistema;
import serializacion.Persistencia;


/**
 *
 * @author lucas
 */
public class PanelRegistro extends javax.swing.JPanel {

    /**
     * Creates new form PanelRegistro
     */
    public PanelRegistro(VentanaRegistroLogin vent,Sistema sistema) {
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
        lblUsuario = new javax.swing.JLabel();
        txUsuario = new javax.swing.JTextField();
        lblContraseña = new javax.swing.JLabel();
        fieldContraseña = new javax.swing.JPasswordField();
        txCorreo = new javax.swing.JTextField();
        lblCorreo = new javax.swing.JLabel();
        btnRegistrar = new javax.swing.JButton();
        btnAtras = new javax.swing.JButton();
        lblAdvertUsuario = new javax.swing.JLabel();
        lblAdvertEmail = new javax.swing.JLabel();
        lblAdvertPassword = new javax.swing.JLabel();
        btnSalir = new javax.swing.JButton();

        pnlLogin.setBackground(new java.awt.Color(204, 204, 204));

        lblTitulo.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lblTitulo.setForeground(new java.awt.Color(0, 0, 0));
        lblTitulo.setText("Registro");

        lblUsuario.setForeground(new java.awt.Color(51, 51, 51));
        lblUsuario.setText("Nombre De Usuario");

        txUsuario.setBackground(java.awt.SystemColor.controlLtHighlight);
        txUsuario.setForeground(new java.awt.Color(0, 0, 0));
        txUsuario.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txUsuarioActionPerformed(evt);
            }
        });

        lblContraseña.setForeground(new java.awt.Color(51, 51, 51));
        lblContraseña.setText("Contraseña");

        fieldContraseña.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        fieldContraseña.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldContraseñaActionPerformed(evt);
            }
        });

        txCorreo.setBackground(java.awt.SystemColor.controlLtHighlight);
        txCorreo.setForeground(new java.awt.Color(0, 0, 0));
        txCorreo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txCorreo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txCorreoActionPerformed(evt);
            }
        });

        lblCorreo.setForeground(new java.awt.Color(51, 51, 51));
        lblCorreo.setText("Correo electronico");

        btnRegistrar.setText("Registrar");
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });

        btnAtras.setText("Atras");
        btnAtras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtrasActionPerformed(evt);
            }
        });

        lblAdvertUsuario.setForeground(new java.awt.Color(255, 0, 0));
        lblAdvertUsuario.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblAdvertUsuario.setText("jLabel1");

        lblAdvertEmail.setForeground(new java.awt.Color(255, 0, 0));
        lblAdvertEmail.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblAdvertEmail.setText("jLabel1");

        lblAdvertPassword.setForeground(new java.awt.Color(255, 0, 0));
        lblAdvertPassword.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblAdvertPassword.setText("jLabel1");

        btnSalir.setText("Salir");
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
                .addContainerGap(367, Short.MAX_VALUE)
                .addGroup(pnlLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                        .addComponent(lblAdvertUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 322, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblTitulo))
                    .addComponent(lblUsuario)
                    .addComponent(lblCorreo)
                    .addComponent(lblContraseña)
                    .addComponent(lblAdvertPassword, javax.swing.GroupLayout.Alignment.CENTER, javax.swing.GroupLayout.PREFERRED_SIZE, 322, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblAdvertEmail, javax.swing.GroupLayout.Alignment.CENTER, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txCorreo, javax.swing.GroupLayout.Alignment.CENTER, javax.swing.GroupLayout.PREFERRED_SIZE, 322, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fieldContraseña, javax.swing.GroupLayout.Alignment.CENTER, javax.swing.GroupLayout.PREFERRED_SIZE, 322, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAtras, javax.swing.GroupLayout.Alignment.CENTER, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSalir, javax.swing.GroupLayout.Alignment.CENTER, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRegistrar, javax.swing.GroupLayout.Alignment.CENTER, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(367, Short.MAX_VALUE))
        );
        pnlLoginLayout.setVerticalGroup(
            pnlLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlLoginLayout.createSequentialGroup()
                .addGap(84, 84, 84)
                .addComponent(lblTitulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblUsuario)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblAdvertUsuario)
                .addGap(23, 23, 23)
                .addComponent(lblCorreo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(lblAdvertEmail)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblContraseña)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(fieldContraseña, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(lblAdvertPassword)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnRegistrar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAtras)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSalir)
                .addContainerGap(169, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1060, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, 0)
                    .addComponent(pnlLogin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGap(0, 0, 0)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 699, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, 0)
                    .addComponent(pnlLogin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGap(0, 0, 0)))
        );
    }// </editor-fold>//GEN-END:initComponents
    
    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        if(this.verificarDatosIngresados()){
            new Persistencia().serializar(this.modelo);
            this.ventana.mostrarPanelLogin();
        }
    }//GEN-LAST:event_btnRegistrarActionPerformed
    public boolean verificarDatosIngresados(){
        
        String username = this.txUsuario.getText();
        String password = new String(this.fieldContraseña.getPassword());
        String email = this.txCorreo.getText();
        Funcionario func;
        if(this.passwordAprobada(password) && !PanelLogin.usernameVacio(username) && VentanaPrincipal.isValidEmailAddress(email)){
            this.ocultarAdvertencias();
            func = new Funcionario(username,password,email);
            if(!this.modelo.existeFuncionario(func)){
                this.modelo.agregarFuncionario(func);
                return true;
            }else{
                this.mostrarAdvertencia(2, "Ya existe un usuario con esos datos");
            }
        }else{
            String advUsuario= "Usted debe ingresar un nombre.";
            String advPassword = "La contraseña debe contener al menos 8 caracteres.";
            String advEmail = "El correo ingresado no es valido";
            this.ocultarAdvertencias();
            if(PanelLogin.usernameVacio(username)){
                this.mostrarAdvertencia(0,advUsuario);
            }
            else if (!VentanaPrincipal.isValidEmailAddress(email)){
                this.mostrarAdvertencia(1, advEmail);
            
            }else if(!this.passwordAprobada(password)){
                this.mostrarAdvertencia(2, advPassword);
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
            case 1: 
                this.lblAdvertEmail.setText(texto);
                this.lblAdvertEmail.setVisible(true);
            break;
            case 2:
                this.lblAdvertPassword.setText(texto);
                this.lblAdvertPassword.setVisible(true);
            break;
            default:
                this.lblAdvertUsuario.setVisible(false);
                this.lblAdvertEmail.setVisible(false);
                this.lblAdvertPassword.setVisible(false);
            break;
    }
}
    public void ocultarAdvertencias(){
        this.lblAdvertPassword.setVisible(false);
        this.lblAdvertEmail.setVisible(false);
        this.lblAdvertUsuario.setVisible(false);
    }
    public void vaciarFields(){
        this.txCorreo.setText("");
        this.txUsuario.setText("");
        this.fieldContraseña.setText("");
        
    }
    public static boolean passwordAprobada(String password){
        return password.length() >= 8;
    }
    private void btnAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtrasActionPerformed
        // TODO add your handling code here:
        this.ocultarAdvertencias();
        this.vaciarFields();
        this.ventana.mostrarPanelLogin();
    }//GEN-LAST:event_btnAtrasActionPerformed

    private void txCorreoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txCorreoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txCorreoActionPerformed

    private void fieldContraseñaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldContraseñaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldContraseñaActionPerformed

    private void txUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txUsuarioActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btnSalirActionPerformed

    private final VentanaRegistroLogin ventana;
    private final Sistema modelo;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAtras;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JButton btnSalir;
    private javax.swing.JPasswordField fieldContraseña;
    private javax.swing.JLabel lblAdvertEmail;
    private javax.swing.JLabel lblAdvertPassword;
    private javax.swing.JLabel lblAdvertUsuario;
    private javax.swing.JLabel lblContraseña;
    private javax.swing.JLabel lblCorreo;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JLabel lblUsuario;
    private javax.swing.JPanel pnlLogin;
    private javax.swing.JTextField txCorreo;
    private javax.swing.JTextField txUsuario;
    // End of variables declaration//GEN-END:variables
}

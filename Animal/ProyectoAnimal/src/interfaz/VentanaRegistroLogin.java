/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaz;

import dominio.Sistema;
import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JPanel;

/**
 *
 * @author lucas
 */
public class VentanaRegistroLogin extends javax.swing.JFrame {

    /**
     * Creates new form VentanaRegistroLogin
     */
    public VentanaRegistroLogin(Sistema sistema) {
        initComponents();
        
        //Inicializar componentes
        this.modelo = sistema;
        this.pnlLogin = new PanelLogin(this,this.modelo);
        this.pnlRegistro = new PanelRegistro(this,this.modelo);
        
    }
  
    public void inicializarVentana(){
        this.setLayout(new BorderLayout());
        this.add(this.pnlContenido,BorderLayout.CENTER);
        this.pack();
        this.setMinimumSize(new Dimension(600,670));
        this.setVisible(true);
        this.mostrarPanelLogin();
    }
    
    public void mostrarPanelLogin(){
        this.cambiarPanel(this.pnlLogin);
    }
    public void mostrarPanelRegistro(){
        this.cambiarPanel(this.pnlRegistro);
    }
    public void cambiarPanel(JPanel panel){
        this.pnlContenido.removeAll();
        this.pnlContenido.add(panel);
        this.pnlContenido.repaint();
        this.pnlContenido.revalidate();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlContenido = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pnlContenido.setLayout(new java.awt.CardLayout());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(pnlContenido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(pnlContenido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
   
    private final Sistema modelo;
    private final PanelRegistro pnlRegistro;
    private final PanelLogin pnlLogin;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel pnlContenido;
    // End of variables declaration//GEN-END:variables
}

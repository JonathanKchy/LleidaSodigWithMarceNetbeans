/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package INTERFAZ;

import com.mycompany.lleidaapp.LeidaApi;
import com.mycompany.lleidaapp.Usuario;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.HttpsURLConnection;
import javax.swing.JOptionPane;

/**
 *
 * @author Jess
 */
public class JFLogin extends javax.swing.JFrame {

    /**
     * Creates new form JFLogin
     */
    LeidaApi leidaApi= new LeidaApi();
    Usuario user = new Usuario();
    
    JFConsultas jfConsultas;
    
    public JFLogin() throws IOException {
        
        this.jfConsultas = new JFConsultas();
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

        jBInicio = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jTUser = new javax.swing.JTextField();
        jTPassword = new javax.swing.JTextField();
        label = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jBInicio.setText("Inicio");
        jBInicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBInicioActionPerformed(evt);
            }
        });

        jLabel2.setText("Contraseña");

        jLabel1.setText("Usuario");

        jTUser.setText("sodigsa@ec");
        jTUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTUserActionPerformed(evt);
            }
        });

        jTPassword.setText("TIiANcmymJ");
        jTPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTPasswordActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTPassword, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)
                            .addComponent(jTUser)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jBInicio)
                        .addGap(39, 39, 39)
                        .addComponent(label)
                        .addGap(32, 32, 32)))
                .addContainerGap(57, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBInicio)
                    .addComponent(label))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBInicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBInicioActionPerformed
        
        URL url = null;
         //validar usuario
        if(user.validarUsuario(jTUser.getText(),jTPassword.getText())){ 
        
        try {
            url = leidaApi.construirURL("list_pdf",user.getValiduser(), user.getValidpassword(),"20220501070000", "20220601070000");
        } catch (MalformedURLException ex) {
            Logger.getLogger(JFLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
            HttpsURLConnection conn = null;
        try {
            conn = leidaApi.getConnection(url);
        } catch (IOException ex) {
            Logger.getLogger(JFLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
            boolean band = false;
        try {
            band = leidaApi.verificarConnection(conn);
        } catch (IOException ex) {
            Logger.getLogger(JFLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
            jfConsultas.setEnabled(true);
            jfConsultas.setVisible(true);
            
        
        }else{
            JOptionPane.showMessageDialog(null, "Datos Incorrectos");
            
        }
    }//GEN-LAST:event_jBInicioActionPerformed

    private void jTUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTUserActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTUserActionPerformed

    private void jTPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTPasswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTPasswordActionPerformed

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
            java.util.logging.Logger.getLogger(JFLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new JFLogin().setVisible(true);
                } catch (IOException ex) {
                    Logger.getLogger(JFLogin.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBInicio;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField jTPassword;
    private javax.swing.JTextField jTUser;
    private javax.swing.JLabel label;
    // End of variables declaration//GEN-END:variables
}

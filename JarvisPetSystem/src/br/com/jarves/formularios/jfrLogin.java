package br.com.jarves.formularios;

import br.com.jarves.util.Global;
import br.com.jarves.util.LimiteDigitos;
import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.UIManager;

/**
 *
 * @author Humberto
 */
public class jfrLogin extends javax.swing.JFrame { 

    public jfrLogin() {
        initComponents();
        jtfUsuario.setDocument(new LimiteDigitos(5));
        
       //Muda o icone da Aplicação...
       URL url = this.getClass().getResource("/br/com/jarves/icones/iconPet.png");    
       Image iconeTitulo = Toolkit.getDefaultToolkit().getImage(url);    
       this.setIconImage(iconeTitulo);  
        
        
    }
    

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jbtLogin = new javax.swing.JButton();
        jbtCancelar = new javax.swing.JButton();
        jtfUsuario = new javax.swing.JTextField();
        jpfSenha = new javax.swing.JPasswordField();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Login");
        setResizable(false);
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(null);

        jbtLogin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/jarves/icones/ok.png"))); // NOI18N
        jbtLogin.setText("Login");
        jbtLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtLoginActionPerformed(evt);
            }
        });
        jPanel1.add(jbtLogin);
        jbtLogin.setBounds(290, 210, 120, 50);

        jbtCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/jarves/icones/cancelar.png"))); // NOI18N
        jbtCancelar.setText("Cancelar");
        jbtCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtCancelarActionPerformed(evt);
            }
        });
        jPanel1.add(jbtCancelar);
        jbtCancelar.setBounds(430, 210, 120, 50);

        jtfUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfUsuarioActionPerformed(evt);
            }
        });
        jPanel1.add(jtfUsuario);
        jtfUsuario.setBounds(350, 90, 200, 30);
        jPanel1.add(jpfSenha);
        jpfSenha.setBounds(350, 140, 200, 30);

        jLabel1.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 102, 102));
        jLabel1.setText("Senha:");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(290, 150, 70, 20);

        jLabel3.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(102, 102, 102));
        jLabel3.setText("Usuário:");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(280, 100, 70, 20);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/jarves/imagens/login.jpg"))); // NOI18N
        jPanel1.add(jLabel2);
        jLabel2.setBounds(0, 0, 600, 400);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 600, 410);

        setSize(new java.awt.Dimension(597, 430));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jbtCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtCancelarActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jbtCancelarActionPerformed

    private void jbtLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtLoginActionPerformed
        jfrPrincipal jp = new jfrPrincipal();
        jp.setVisible(true);
        Global.principal=jp;
        jp.setExtendedState(jfrPrincipal.MAXIMIZED_BOTH);//chama a tela principal maximizada
        this.dispose();//tira tela de login da memória
        //System.out.println(new String(jpfSenha.getPassword()));
    }//GEN-LAST:event_jbtLoginActionPerformed

    private void jtfUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfUsuarioActionPerformed

   
    public static void main(String args[]) {
        
        try {
           UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(jfrLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(jfrLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(jfrLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(jfrLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        

        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new jfrLogin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton jbtCancelar;
    private javax.swing.JButton jbtLogin;
    private javax.swing.JPasswordField jpfSenha;
    private javax.swing.JTextField jtfUsuario;
    // End of variables declaration//GEN-END:variables
}

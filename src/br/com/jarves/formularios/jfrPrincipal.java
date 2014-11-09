/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.jarves.formularios;

import br.com.jarves.util.Global;
import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;
import javax.swing.JOptionPane;
import javax.swing.plaf.basic.BasicInternalFrameUI;

/**
 *
 * @author Humberto
 */
public class jfrPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form jfrPrincipal
     */
     
    public jfrPrincipal() {
        initComponents();
        Global.jdpPrincipal = jdpPrincipal;
        
       //Muda o icone da Aplicação... 
       //Muda o icone da Aplicação... 
       URL url = this.getClass().getResource("/br/com/jarves/icones/iconPet.png");    
       Image iconeTitulo = Toolkit.getDefaultToolkit().getImage(url);    
       this.setIconImage(iconeTitulo);  
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jdpPrincipal = new javax.swing.JDesktopPane();
        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jmnCadastro = new javax.swing.JMenu();
        jmiCadCliente = new javax.swing.JMenuItem();
        jmiCadAnimal = new javax.swing.JMenuItem();
        jmiCategoria = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jmiSair = new javax.swing.JMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();
        jmnConsulta = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jmiConAnimal = new javax.swing.JMenuItem();
        jmiConsCli = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Jarvis Pet System");

        jdpPrincipal.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/jarves/imagens/principal.jpg"))); // NOI18N
        jLabel1.setMaximumSize(new java.awt.Dimension(930, 1024));
        jdpPrincipal.add(jLabel1);
        jLabel1.setBounds(360, 30, 940, 740);

        jmnCadastro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/jarves/icones/registro.png.png"))); // NOI18N
        jmnCadastro.setText("Registros");

        jmiCadCliente.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.ALT_MASK));
        jmiCadCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/jarves/icones/cadcli.png.png"))); // NOI18N
        jmiCadCliente.setText("Cliente / Proprietário");
        jmiCadCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiCadClienteActionPerformed(evt);
            }
        });
        jmnCadastro.add(jmiCadCliente);

        jmiCadAnimal.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.ALT_MASK));
        jmiCadAnimal.setText("Cliente / Animal");
        jmiCadAnimal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiCadAnimalActionPerformed(evt);
            }
        });
        jmnCadastro.add(jmiCadAnimal);

        jmiCategoria.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_G, java.awt.event.InputEvent.ALT_MASK));
        jmiCategoria.setText("Categoria");
        jmiCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiCategoriaActionPerformed(evt);
            }
        });
        jmnCadastro.add(jmiCategoria);

        jMenuItem4.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F, java.awt.event.InputEvent.ALT_MASK));
        jMenuItem4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/jarves/icones/forn.png.png"))); // NOI18N
        jMenuItem4.setText("Fornecedor");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jmnCadastro.add(jMenuItem4);

        jMenuItem5.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.ALT_MASK));
        jMenuItem5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/jarves/icones/prod.png.png"))); // NOI18N
        jMenuItem5.setText("Produtos");
        jmnCadastro.add(jMenuItem5);

        jmiSair.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.ALT_MASK));
        jmiSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/jarves/icones/f.png.png"))); // NOI18N
        jmiSair.setText("Sair");
        jmiSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiSairActionPerformed(evt);
            }
        });
        jmnCadastro.add(jmiSair);

        jMenuItem7.setText("Servicos");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        jmnCadastro.add(jMenuItem7);

        jMenuBar1.add(jmnCadastro);

        jmnConsulta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/jarves/icones/cons.png.gif"))); // NOI18N
        jmnConsulta.setText("Consultas");

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.SHIFT_MASK));
        jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/jarves/icones/concli.png.png"))); // NOI18N
        jMenuItem1.setText("Clientes / Proprietários");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jmnConsulta.add(jMenuItem1);

        jmiConAnimal.setText("Clientes / Animais");
        jmiConAnimal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiConAnimalActionPerformed(evt);
            }
        });
        jmnConsulta.add(jmiConAnimal);

        jmiConsCli.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.SHIFT_MASK));
        jmiConsCli.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/jarves/icones/iconMap.png.png"))); // NOI18N
        jmiConsCli.setText("Endereços");
        jmiConsCli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiConsCliActionPerformed(evt);
            }
        });
        jmnConsulta.add(jmiConsCli);

        jMenuItem6.setText("Fornecedores");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jmnConsulta.add(jMenuItem6);

        jMenuBar1.add(jmnConsulta);

        jMenu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/jarves/icones/servi.png.jpg"))); // NOI18N
        jMenu1.setText("Serviços");

        jMenuItem2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/jarves/icones/vac.png.png"))); // NOI18N
        jMenuItem2.setText("Vacinação");
        jMenu1.add(jMenuItem2);

        jMenuItem3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/jarves/icones/bt.png.jpg"))); // NOI18N
        jMenuItem3.setText("Banho e Tosa");
        jMenu1.add(jMenuItem3);

        jMenuBar1.add(jMenu1);

        jMenu2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/jarves/icones/relat.png.png"))); // NOI18N
        jMenu2.setText("Relátorios");
        jMenuBar1.add(jMenu2);

        jMenu3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/jarves/icones/caixa.png.jpg"))); // NOI18N
        jMenu3.setText("Caixa");
        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jdpPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jdpPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, 274, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(416, 339));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jmiCadClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiCadClienteActionPerformed
       jifCadClie jic = new jifCadClie();
       jdpPrincipal.add(jic);
       
       ((BasicInternalFrameUI)jic.getUI()).setNorthPane(null);
       //jic.setBorder(null); insere bordas no formulário
       jic.setPosicao();
       jic.setVisible(true);
       
    }//GEN-LAST:event_jmiCadClienteActionPerformed

    private void jmiConsCliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiConsCliActionPerformed
        jifConEnd jie = new jifConEnd();
        jdpPrincipal.add(jie);
                    
       ((BasicInternalFrameUI)jie.getUI()).setNorthPane(null);
       //jie.setBorder(null); //insere bordas no formulário
       jie.setPosicao();
       jie.setVisible(true);
    }//GEN-LAST:event_jmiConsCliActionPerformed

    private void jmiSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiSairActionPerformed
        if(JOptionPane.showConfirmDialog(null, "Encerrar o Programa?", "Pergunta",JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)
            System.exit(0);
      
    }//GEN-LAST:event_jmiSairActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
       JifConCliente jie = new JifConCliente();
       jdpPrincipal.add(jie);
                    
       ((BasicInternalFrameUI)jie.getUI()).setNorthPane(null);
       //jie.setBorder(null); //insere bordas no formulário
       jie.setPosicao();
       jie.setVisible(true);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
       jifCadForn jif = new jifCadForn();
       jdpPrincipal.add(jif);
       
       ((BasicInternalFrameUI)jif.getUI()).setNorthPane(null);
       //jic.setBorder(null); insere bordas no formulário
       jif.setPosicao();
       jif.setVisible(true);
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jmiCadAnimalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiCadAnimalActionPerformed
        jifCadAnimal ja = new jifCadAnimal();
        jdpPrincipal.add(ja);
        ((BasicInternalFrameUI)ja.getUI()).setNorthPane(null);
        ja.setPosicao();
        ja.setVisible(true);
    }//GEN-LAST:event_jmiCadAnimalActionPerformed

    private void jmiConAnimalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiConAnimalActionPerformed
        JifConAnimal ja = new JifConAnimal();
        jdpPrincipal.add(ja);
        ((BasicInternalFrameUI)ja.getUI()).setNorthPane(null);
        ja.setPosicao();
        ja.setVisible(true); 
    }//GEN-LAST:event_jmiConAnimalActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
     JifConForn jie = new JifConForn();
       jdpPrincipal.add(jie);
                    
       ((BasicInternalFrameUI)jie.getUI()).setNorthPane(null);
       //jie.setBorder(null); //insere bordas no formulário
       jie.setPosicao();
       jie.setVisible(true);
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void jmiCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiCategoriaActionPerformed
        jifCadCategoria jie = new jifCadCategoria();
        jdpPrincipal.add(jie);
          
       ((BasicInternalFrameUI)jie.getUI()).setNorthPane(null);
       //jie.setBorder(null); //insere bordas no formulário
       jie.setPosicao();
       jie.setVisible(true);
    }//GEN-LAST:event_jmiCategoriaActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
       jifCadServicos jis = new jifCadServicos();
       jdpPrincipal.add(jis);
       
       ((BasicInternalFrameUI)jis.getUI()).setNorthPane(null);
       //jic.setBorder(null); insere bordas no formulário
       jis.setPosicao();
       jis.setVisible(true);        
    }//GEN-LAST:event_jMenuItem7ActionPerformed

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
            java.util.logging.Logger.getLogger(jfrPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(jfrPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(jfrPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(jfrPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new jfrPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JDesktopPane jdpPrincipal;
    private javax.swing.JMenuItem jmiCadAnimal;
    private javax.swing.JMenuItem jmiCadCliente;
    private javax.swing.JMenuItem jmiCategoria;
    private javax.swing.JMenuItem jmiConAnimal;
    private javax.swing.JMenuItem jmiConsCli;
    private javax.swing.JMenuItem jmiSair;
    private javax.swing.JMenu jmnCadastro;
    private javax.swing.JMenu jmnConsulta;
    // End of variables declaration//GEN-END:variables


}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jarves.formularios;

import br.com.jarves.bancodedados.ClienteDAO;
import br.com.jarves.bancodedados.EnderecoDAO;
import br.com.jarves.bancodedados.ServicoDAO;
import br.com.jarves.classes.Cliente;
import br.com.jarves.classes.Contato;
import br.com.jarves.classes.Logradouro;
import br.com.jarves.classes.Servico;
import br.com.jarves.classes.TableFormat;
import br.com.jarves.classes.Util;
import br.com.jarves.util.Global;
import br.com.jarves.util.LimiteDigitos;

import java.awt.Dimension;
import java.awt.event.KeyEvent;
import static java.awt.event.KeyEvent.VK_F1;
import java.awt.event.KeyListener;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableModel;
import static oracle.net.aso.C11.i;

/**
 *
 * @author Gabriel
 */
public class jifCadServicos extends javax.swing.JInternalFrame {
    
    
    int idServico = 0;

    /**
     * Creates new form jifCadServicos
     */
    public jifCadServicos() {
        initComponents();
        carregaLista();
        btnAltera.setVisible(false);
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
        jLabel1 = new javax.swing.JLabel();
        jtfNomeServ = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtfDescServ = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();
        jbtInserir = new javax.swing.JButton();
        lblDtCad = new javax.swing.JLabel();
        jtfPreco = new javax.swing.JTextField();
        btnAltera = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtbServico = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Cadastro de Serviços"));

        jLabel1.setText("Nome do serviço:");

        jLabel2.setText("Descrição:");

        jLabel3.setText("Preco do Servico:");

        jLabel4.setText("R$:");

        jtfDescServ.setColumns(20);
        jtfDescServ.setRows(5);
        jScrollPane1.setViewportView(jtfDescServ);

        jButton1.setText("Voltar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jbtInserir.setText("Inserir");
        jbtInserir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtInserirActionPerformed(evt);
            }
        });

        lblDtCad.setOpaque(true);

        btnAltera.setText("Alterar");
        btnAltera.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlteraActionPerformed(evt);
            }
        });

        jtbServico.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jtbServico.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtbServicoMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jtbServico);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(15, 15, 15)
                                .addComponent(jLabel4))
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jtfPreco, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jtfNomeServ))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jbtInserir, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnAltera, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(99, 99, 99)
                                .addComponent(lblDtCad, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(lblDtCad, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jtfNomeServ, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAltera, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbtInserir, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jtfPreco, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
      this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jbtInserirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtInserirActionPerformed
          if (jtfNomeServ.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(null, "Por Favor Informe o Nome do Servico!");
        } if (jtfDescServ.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(null, "Por favor Informe a Descrição do Servico!");
        } if (jtfPreco.getText().trim().equals("")){
            JOptionPane.showMessageDialog(null, "Por favor informe o preço do Servico");
        } else{
            ServicoDAO sd = new ServicoDAO();
            Servico servico = new Servico();
            servico.setNomeServico(jtfNomeServ.getText().trim().toLowerCase());
            servico.setDescrServico(jtfDescServ.getText().trim().toLowerCase());
            servico.setPrecoServico(Double.parseDouble(jtfPreco.getText().trim().toLowerCase()));
            JOptionPane.showMessageDialog(null, sd.insereServico(servico));
            jtfNomeServ.setText("");
            jtfDescServ.setText("");
            jtfPreco.setText("");
            jtfNomeServ.grabFocus();

            carregaLista();
        }

    }//GEN-LAST:event_jbtInserirActionPerformed

    private void btnAlteraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlteraActionPerformed
       if(jtfNomeServ.getText().trim().equals("")){
           JOptionPane.showMessageDialog(null, "Por Favor Informe o Nome do Servico!");
       } if (jtfDescServ.getText().trim().equals("")){
           JOptionPane.showMessageDialog(null, "Por favor Informe a Descrição do Serviço");
       }  if (jtfPreco.getText().trim().equals("")){
           JOptionPane.showMessageDialog(null, "Por favor Informe o preço do Servico");
       }else{
           ServicoDAO sd = new ServicoDAO();
           Servico servico = new Servico();
           servico.setIdServico(idServico);
           servico.setNomeServico(jtfNomeServ.getText().trim().toLowerCase());
           servico.setDescrServico(jtfDescServ.getText().trim().toLowerCase());
           servico.setPrecoServico(Double.parseDouble(jtfPreco.getText()));
           JOptionPane.showMessageDialog(null, sd.alteraServico(servico));
           jtfNomeServ.setText("");
           jtfPreco.setText("");
           jtfDescServ.setText("");
           jtfNomeServ.grabFocus();
           btnAltera.setVisible(false);
           jbtInserir.setVisible(true);
           carregaLista();
       }
    }//GEN-LAST:event_btnAlteraActionPerformed

    private void jtbServicoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtbServicoMouseClicked
        if(evt.getClickCount()>1){
            int indiceLinha = jtbServico.getSelectedRow();
            idServico = (int)jtbServico.getValueAt(indiceLinha, 0);
            Object cate = jtbServico.getValueAt(indiceLinha, 1);
            jtfNomeServ.setText(cate.toString());
            Object cate1 = jtbServico.getValueAt(indiceLinha, 2);
            jtfDescServ.setText(cate1.toString());
            Object cate2 = jtbServico.getValueAt(indiceLinha, 3);
            jtfPreco.setText(cate2.toString());
            jbtInserir.setVisible(false);
            btnAltera.setVisible(true);
        }
    }//GEN-LAST:event_jtbServicoMouseClicked

   public void limparCampos() {
        jtfNomeServ.setText("");
        jtfPreco.setText("");
        jtfDescServ.setText("");
       

    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAltera;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton jbtInserir;
    private javax.swing.JTable jtbServico;
    private javax.swing.JTextArea jtfDescServ;
    private javax.swing.JTextField jtfNomeServ;
    private javax.swing.JTextField jtfPreco;
    private javax.swing.JLabel lblDtCad;
    // End of variables declaration//GEN-END:variables
public void setPosicao() {
        Dimension d = this.getDesktopPane().getSize();
        this.setLocation((d.width - this.getSize().width) / 2, 0);
    }

public void carregaLista() {

        String titulopessoais[] = {"Código", "servico","descrição","preco"};

        Object dados[][] = {};

        DefaultTableModel modelo = new DefaultTableModel(dados, titulopessoais) {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        jtbServico.setDefaultRenderer(Object.class, new TableFormat());
        jtbServico.setModel(modelo);

        ArrayList<Servico> lista = new ServicoDAO().listarServico();

        for (Servico lista1 : lista) {

            lista1.getIdServico();
            modelo.addRow(new Object[]{lista1.getIdServico(), lista1.getNomeServico(), lista1.getDescrServico(),
            lista1.getPrecoServico()});
        }

    }


}

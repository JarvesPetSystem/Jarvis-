/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.jarves.formularios;

import br.com.jarves.bancodedados.ClienteDAO;
import br.com.jarves.bancodedados.EnderecoDAO;
import br.com.jarves.classes.Cliente;
import br.com.jarves.classes.Contato;
import br.com.jarves.classes.Logradouro;
import br.com.jarves.classes.Util;
import br.com.jarves.util.Global;

import java.awt.Dimension;
import java.awt.Frame;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.plaf.basic.BasicInternalFrameUI;

/**
 *
 * @author Humberto
 */
public class jifCadClie extends javax.swing.JInternalFrame {

    /**
     * Creates new form jifCadCli
     */
    
    
    public jifCadClie() {
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
        jftCpf = new javax.swing.JFormattedTextField();
        jtfNome = new javax.swing.JTextField();
        btnPesquisar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jtbPainel = new javax.swing.JTabbedPane();
        jpnEndereco = new javax.swing.JPanel();
        jftCep = new javax.swing.JFormattedTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jtfCidade = new javax.swing.JTextField();
        jtfBairro = new javax.swing.JTextField();
        jtfRua = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jtfEstado = new javax.swing.JTextField();
        jtfNumero = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jtfComplemento = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jbtPesEnd = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jftTelefone = new javax.swing.JFormattedTextField();
        jftCelular = new javax.swing.JFormattedTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jtfEmail = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jtfObs = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jcbSexo = new javax.swing.JComboBox();
        jbtInserir = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jbtVoltar = new javax.swing.JButton();
        jdcNasc = new com.toedter.calendar.JDateChooser();
        jtfRg = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();

        setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        setForeground(java.awt.Color.red);
        setName(""); // NOI18N
        getContentPane().setLayout(null);

        jPanel1.setLayout(null);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Cadastro de Clientes"));
        jPanel2.setToolTipText("Cadastro de Cliente");
        jPanel2.setLayout(null);

        try {
            jftCpf.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jPanel2.add(jftCpf);
        jftCpf.setBounds(110, 40, 120, 30);
        jPanel2.add(jtfNome);
        jtfNome.setBounds(110, 90, 290, 30);

        btnPesquisar.setText("Pesquisar");
        btnPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisarActionPerformed(evt);
            }
        });
        jPanel2.add(btnPesquisar);
        btnPesquisar.setBounds(460, 170, 110, 40);

        jLabel1.setText("Dt Nascimento:");
        jPanel2.add(jLabel1);
        jLabel1.setBounds(20, 140, 80, 30);

        jButton1.setText("jButton1");
        jButton1.setFocusable(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1);
        jButton1.setBounds(460, 120, 110, 40);

        jpnEndereco.setLayout(null);

        try {
            jftCep.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#####-###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jftCep.setToolTipText("Digite o CEP");
        jftCep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jftCepActionPerformed(evt);
            }
        });
        jftCep.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jftCepKeyReleased(evt);
            }
        });
        jpnEndereco.add(jftCep);
        jftCep.setBounds(70, 10, 90, 30);

        jLabel5.setText("Estado:");
        jpnEndereco.add(jLabel5);
        jLabel5.setBounds(330, 130, 50, 30);

        jLabel4.setText("Cidade:");
        jpnEndereco.add(jLabel4);
        jLabel4.setBounds(20, 134, 50, 30);

        jtfCidade.setEditable(false);
        jpnEndereco.add(jtfCidade);
        jtfCidade.setBounds(70, 130, 240, 30);

        jtfBairro.setEditable(false);
        jpnEndereco.add(jtfBairro);
        jtfBairro.setBounds(70, 90, 240, 30);

        jtfRua.setEditable(false);
        jpnEndereco.add(jtfRua);
        jtfRua.setBounds(70, 50, 240, 30);

        jLabel2.setText("Endereço:");
        jpnEndereco.add(jLabel2);
        jLabel2.setBounds(10, 50, 50, 30);

        jLabel3.setText("Bairro:");
        jpnEndereco.add(jLabel3);
        jLabel3.setBounds(20, 90, 50, 30);

        jLabel6.setText("CEP:");
        jpnEndereco.add(jLabel6);
        jLabel6.setBounds(30, 10, 80, 30);

        jtfEstado.setEditable(false);
        jpnEndereco.add(jtfEstado);
        jtfEstado.setBounds(380, 130, 100, 30);
        jpnEndereco.add(jtfNumero);
        jtfNumero.setBounds(380, 50, 90, 30);

        jLabel14.setText("N °:");
        jpnEndereco.add(jLabel14);
        jLabel14.setBounds(350, 50, 40, 30);
        jpnEndereco.add(jtfComplemento);
        jtfComplemento.setBounds(380, 90, 150, 30);

        jLabel16.setText("Comp:");
        jpnEndereco.add(jLabel16);
        jLabel16.setBounds(340, 90, 40, 30);

        jbtPesEnd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/jarves/icones/search.png"))); // NOI18N
        jbtPesEnd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtPesEndActionPerformed(evt);
            }
        });
        jpnEndereco.add(jbtPesEnd);
        jbtPesEnd.setBounds(170, 10, 70, 30);

        jtbPainel.addTab("Endereço", jpnEndereco);

        jPanel4.setLayout(null);

        jLabel9.setText("Telefone:");
        jPanel4.add(jLabel9);
        jLabel9.setBounds(30, 20, 90, 30);

        try {
            jftTelefone.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jPanel4.add(jftTelefone);
        jftTelefone.setBounds(90, 20, 170, 30);

        try {
            jftCelular.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jPanel4.add(jftCelular);
        jftCelular.setBounds(90, 60, 170, 30);

        jLabel10.setText("Email:");
        jPanel4.add(jLabel10);
        jLabel10.setBounds(40, 100, 90, 30);

        jLabel11.setText("Celular:");
        jPanel4.add(jLabel11);
        jLabel11.setBounds(30, 60, 90, 30);
        jPanel4.add(jtfEmail);
        jtfEmail.setBounds(90, 100, 370, 30);

        jLabel12.setText("Observações:");
        jPanel4.add(jLabel12);
        jLabel12.setBounds(10, 140, 90, 30);
        jPanel4.add(jtfObs);
        jtfObs.setBounds(90, 140, 370, 30);

        jtbPainel.addTab("Contato", jPanel4);

        jPanel2.add(jtbPainel);
        jtbPainel.setBounds(20, 260, 550, 220);
        jtbPainel.getAccessibleContext().setAccessibleName("Contato");

        jLabel7.setText("RG:");
        jPanel2.add(jLabel7);
        jLabel7.setBounds(250, 40, 80, 30);

        jLabel8.setText("Nome:");
        jPanel2.add(jLabel8);
        jLabel8.setBounds(60, 90, 80, 30);

        jLabel13.setText("Sexo:");
        jPanel2.add(jLabel13);
        jLabel13.setBounds(50, 190, 50, 30);

        jcbSexo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione...", "Masculino", "Feminino" }));
        jcbSexo.setToolTipText("Selecione o Sexo");
        jPanel2.add(jcbSexo);
        jcbSexo.setBounds(110, 190, 160, 30);

        jbtInserir.setText("Inserir");
        jbtInserir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtInserirActionPerformed(evt);
            }
        });
        jPanel2.add(jbtInserir);
        jbtInserir.setBounds(460, 20, 110, 40);
        jPanel2.add(jSeparator1);
        jSeparator1.setBounds(20, 242, 560, 10);

        jbtVoltar.setText("Voltar");
        jbtVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtVoltarActionPerformed(evt);
            }
        });
        jPanel2.add(jbtVoltar);
        jbtVoltar.setBounds(460, 70, 110, 40);

        jdcNasc.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jdcNascPropertyChange(evt);
            }
        });
        jPanel2.add(jdcNasc);
        jdcNasc.setBounds(110, 140, 160, 30);
        jPanel2.add(jtfRg);
        jtfRg.setBounds(280, 40, 120, 30);

        jLabel15.setText("CPF:");
        jPanel2.add(jLabel15);
        jLabel15.setBounds(70, 40, 80, 30);

        jPanel1.add(jPanel2);
        jPanel2.setBounds(20, 10, 620, 490);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 650, 510);

        setBounds(0, 0, 650, 537);
    }// </editor-fold>//GEN-END:initComponents

    private void btnPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarActionPerformed
        
        
        
        Cliente c = new Cliente();
        ClienteDAO cd = new ClienteDAO();
                    
        if(cd.getCliente(c)!= null){
        JOptionPane.showMessageDialog(null, ""+cd.getCliente(c).getIdCliente()+"\n"+cd.getCliente(c).getNomeCliente()+"\n"+
                cd.getCliente(c).getEndereco().getNomeRua()+"\n"+cd.getCliente(c).getEndereco().getBairro());
        
        }else{
            JOptionPane.showMessageDialog(null, "Cliente não Cadastrado", "Erro", 3 );
        }
        
    }//GEN-LAST:event_btnPesquisarActionPerformed

    private void jbtPesEndActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtPesEndActionPerformed
    
        jifConEnd jie = new jifConEnd();
        Global.jdpPrincipal.add(jie);
        
       ((BasicInternalFrameUI)jie.getUI()).setNorthPane(null);
        jie.setPosicao();
        jie.setVisible(true);
                
        
    }//GEN-LAST:event_jbtPesEndActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
        if(jdcNasc.getDate()!=null){
            SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
            String data = formato.format(jdcNasc.getDate());
            System.out.println(data);
        }else
            JOptionPane.showMessageDialog(null, "Malucão");
    }//GEN-LAST:event_jButton1ActionPerformed
    
    
    private void jdcNascPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jdcNascPropertyChange

    }//GEN-LAST:event_jdcNascPropertyChange

    private void jftCepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jftCepActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jftCepActionPerformed
    Logradouro end = new Logradouro();
    EnderecoDAO endereco = new EnderecoDAO();
    private void jftCepKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jftCepKeyReleased
        if(jftCep.getText().trim().length()>8){
            Util u = new Util();
            
            String cep = u.formataCep(jftCep.getText().trim());
            end.setCep(cep);
            endereco.getEndereco(end);
            if(end.getIdLogradouro()==0){
                JOptionPane.showMessageDialog(null,"Endereço Não Localizado");
            }else{
                jtfBairro.setText(end.getBairro());
                jtfCidade.setText(end.getCidade());
                jtfRua.setText(end.getNomeRua());
                jtfEstado.setText(end.getEstado());
            }
        }
    }//GEN-LAST:event_jftCepKeyReleased

    private void jbtInserirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtInserirActionPerformed
       Util u = new Util();
       Cliente cliente = new Cliente();
       ClienteDAO clientedao = new ClienteDAO();
       Contato contato = new Contato();
       if(!u.isCPF(u.formataCpf(jftCpf.getText()))){
           JOptionPane.showMessageDialog(null,"CPF Inválido");
       }else if(jtfNome.getText().trim().equalsIgnoreCase("")){
           JOptionPane.showMessageDialog(null,"Por Favor Informe o Nome");
       }else if(jdcNasc.getDate()==null){
           JOptionPane.showMessageDialog(null,"Por Favor Selecione Uma Data de Nascimento");
       }else if(jcbSexo.getSelectedIndex()==0){
           JOptionPane.showMessageDialog(null,"Por Favor Selecione o Sexo");
       }else if(jftCep.getText().trim().length()<8){
           JOptionPane.showMessageDialog(null,"Por Favor Informe o CEP");
       }else if(jftCelular.getText().trim().length()<2 && jftTelefone.getText().trim().length()<2 && jtfEmail.getText().trim().equalsIgnoreCase("")){
           JOptionPane.showMessageDialog(null,"Por Favor Informe ao Menos um contato");
       }else if (jtfNumero.getText().trim().equalsIgnoreCase("")){
           JOptionPane.showMessageDialog(null,"Por Favor Informe o Número");
       }else{
           cliente.setNomeCliente(jtfNome.getText().toLowerCase().trim());
           cliente.setCpf(u.formataCpf(jftCpf.getText().trim()));
           cliente.setRg(jtfRg.getText().trim());
           try {
               cliente.setDtNasc(u.data(jdcNasc.getDate()));
           } catch (ParseException ex) {
               Logger.getLogger(jifCadClie.class.getName()).log(Level.SEVERE, null, ex);
           }
           cliente.setSexo(jcbSexo.getSelectedItem().toString().toLowerCase());
           end.setNumero(jtfNumero.getText().trim());
           end.setComplemento(jtfComplemento.getText().trim());
           cliente.setEndereco(end);
           contato.setEmail(jtfEmail.getText().toLowerCase().trim());
           contato.setTelefone(u.formataTelefone(jftTelefone.getText()));
           contato.setCelular(u.formataCelular(jftCelular.getText()));
           contato.setObs(jtfObs.getText().trim());
           cliente.setContato(contato);
           JOptionPane.showMessageDialog(null,clientedao.insereCliente(cliente));
           limparCampos();
           
       }
        
       
    }//GEN-LAST:event_jbtInserirActionPerformed

    public void limparCampos(){
        jftCpf.setText("");
        jtfNome.setText("");
        jtfRg.setText("");
        jdcNasc.setDate(null);
        jcbSexo.setSelectedIndex(0);
        jftCep.setText("");
        jtfRua.setText("");
        jtfBairro.setText("");
        jtfNumero.setText("");
        jtfComplemento.setText("");
        jtfCidade.setText("");
        jtfEstado.setText("");
        jftTelefone.setText("");
        jftCelular.setText("");
        jtfEmail.setText("");
        jtfObs.setText("");
        jtbPainel.setSelectedIndex(0);
        jftCpf.grabFocus();
    
    }
    
    
    private void jbtVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtVoltarActionPerformed
        this.dispose();
    }//GEN-LAST:event_jbtVoltarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnPesquisar;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JButton jbtInserir;
    private javax.swing.JButton jbtPesEnd;
    private javax.swing.JButton jbtVoltar;
    private javax.swing.JComboBox jcbSexo;
    private com.toedter.calendar.JDateChooser jdcNasc;
    private javax.swing.JFormattedTextField jftCelular;
    private javax.swing.JFormattedTextField jftCep;
    private javax.swing.JFormattedTextField jftCpf;
    private javax.swing.JFormattedTextField jftTelefone;
    private javax.swing.JPanel jpnEndereco;
    private javax.swing.JTabbedPane jtbPainel;
    private javax.swing.JTextField jtfBairro;
    private javax.swing.JTextField jtfCidade;
    private javax.swing.JTextField jtfComplemento;
    private javax.swing.JTextField jtfEmail;
    private javax.swing.JTextField jtfEstado;
    private javax.swing.JTextField jtfNome;
    private javax.swing.JTextField jtfNumero;
    private javax.swing.JTextField jtfObs;
    private javax.swing.JTextField jtfRg;
    private javax.swing.JTextField jtfRua;
    // End of variables declaration//GEN-END:variables
    
    /**
     *Abre a tela no meio do formulário 
     */
    public void setPosicao() {  
        Dimension d = this.getDesktopPane().getSize();  
        this.setLocation((d.width - this.getSize().width) / 2, 0);
    }   
}


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jarves.formularios;

import br.com.jarves.bancodedados.FornecedorDAO;
import br.com.jarves.bancodedados.EnderecoDAO;
import br.com.jarves.classes.Fornecedor;
import br.com.jarves.classes.Logradouro;
import br.com.jarves.classes.TableFormat;
import br.com.jarves.classes.Util;
import br.com.jarves.util.Global;
import static br.com.jarves.util.Global.cnpj;
import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
//import net.proteanit.sql.DbUtils;

/**
 *
 * @author Humberto
 */
public class JifConForn extends javax.swing.JInternalFrame {

    /**
     * Creates new form jifConEnd
     */
    public JifConForn() {
        initComponents();
        carregaLista();
        jftCnpj.setVisible(false);
        
        //jtbEndereco.setModel(DbUtils.resultSetToTableModel(EnderecoDAO.listarEnderecos()));
    }
   
public int flag=0;
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bgpPesquisar = new javax.swing.ButtonGroup();
        jPanel2 = new javax.swing.JPanel();
        jlbNome = new javax.swing.JLabel();
        jtfNome = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jbtVoltar = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jpnDados = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtbFornecedor = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtbEndForn = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jtbConForn = new javax.swing.JTable();
        jftCnpj = new javax.swing.JFormattedTextField();
        jrbNome = new javax.swing.JRadioButton();
        jrbCnpj = new javax.swing.JRadioButton();

        setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        setTitle("Consulta de Endereços");
        getContentPane().setLayout(null);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Consulta de Clientes"));
        jPanel2.setLayout(null);

        jlbNome.setText("Nome:");
        jPanel2.add(jlbNome);
        jlbNome.setBounds(30, 40, 80, 30);

        jtfNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfNomeActionPerformed(evt);
            }
        });
        jtfNome.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtfNomeKeyReleased(evt);
            }
        });
        jPanel2.add(jtfNome);
        jtfNome.setBounds(100, 40, 410, 30);
        jPanel2.add(jSeparator1);
        jSeparator1.setBounds(10, 130, 760, 20);

        jbtVoltar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/jarves/icones/voltar.png.jpg"))); // NOI18N
        jbtVoltar.setText("Voltar");
        jbtVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtVoltarActionPerformed(evt);
            }
        });
        jPanel2.add(jbtVoltar);
        jbtVoltar.setBounds(640, 30, 100, 40);

        jpnDados.setLayout(null);

        jtbFornecedor.setModel(new javax.swing.table.DefaultTableModel(
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
        jtbFornecedor.setToolTipText("Lista de Endereços");
        jtbFornecedor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtbFornecedorMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtbFornecedor);

        jpnDados.add(jScrollPane1);
        jScrollPane1.setBounds(20, 10, 700, 140);

        jTabbedPane1.addTab("Informações Pessoais", jpnDados);

        jPanel1.setLayout(null);

        jtbEndForn.setModel(new javax.swing.table.DefaultTableModel(
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
        jtbEndForn.setToolTipText("Lista de Endereços");
        jScrollPane2.setViewportView(jtbEndForn);

        jPanel1.add(jScrollPane2);
        jScrollPane2.setBounds(20, 10, 700, 140);

        jTabbedPane1.addTab("Endereço", jPanel1);

        jPanel3.setLayout(null);

        jtbConForn.setModel(new javax.swing.table.DefaultTableModel(
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
        jtbConForn.setToolTipText("Lista de Endereços");
        jScrollPane3.setViewportView(jtbConForn);

        jPanel3.add(jScrollPane3);
        jScrollPane3.setBounds(20, 10, 700, 140);

        jTabbedPane1.addTab("Contato", jPanel3);

        jPanel2.add(jTabbedPane1);
        jTabbedPane1.setBounds(10, 140, 760, 190);

        try {
            jftCnpj.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##.###.###/####-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jftCnpj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jftCnpjActionPerformed(evt);
            }
        });
        jftCnpj.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jftCnpjKeyReleased(evt);
            }
        });
        jPanel2.add(jftCnpj);
        jftCnpj.setBounds(100, 40, 120, 30);

        bgpPesquisar.add(jrbNome);
        jrbNome.setSelected(true);
        jrbNome.setText("Nome");
        jrbNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrbNomeActionPerformed(evt);
            }
        });
        jPanel2.add(jrbNome);
        jrbNome.setBounds(40, 90, 93, 23);

        bgpPesquisar.add(jrbCnpj);
        jrbCnpj.setText("CNPJ");
        jrbCnpj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrbCnpjActionPerformed(evt);
            }
        });
        jPanel2.add(jrbCnpj);
        jrbCnpj.setBounds(130, 90, 50, 23);

        getContentPane().add(jPanel2);
        jPanel2.setBounds(0, 0, 780, 340);

        setBounds(0, 0, 791, 377);
    }// </editor-fold>//GEN-END:initComponents

    private void jbtVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtVoltarActionPerformed
        this.dispose();
    }//GEN-LAST:event_jbtVoltarActionPerformed

    private void jtfNomeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfNomeKeyReleased
       
    if(jtfNome.getText().length()>4)
        filtraLista();
    else
        carregaLista();
    }//GEN-LAST:event_jtfNomeKeyReleased

    private void jtfNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfNomeActionPerformed

    private void jrbNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrbNomeActionPerformed
       jftCnpj.setVisible(false);
       jtfNome.setVisible(true);
       jtfNome.grabFocus();
       jlbNome.setText("Nome: ");
       jtfNome.setText("");
       carregaLista();
    }//GEN-LAST:event_jrbNomeActionPerformed

    private void jrbCnpjActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrbCnpjActionPerformed
        jtfNome.setVisible(false);
        jftCnpj.setVisible(true);
        jftCnpj.grabFocus();
        jftCnpj.setText("");
        jlbNome.setText("CNPJ:");
        carregaLista();
    }//GEN-LAST:event_jrbCnpjActionPerformed

    private void jftCnpjActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jftCnpjActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jftCnpjActionPerformed

    private void jftCnpjKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jftCnpjKeyReleased
        if(jftCnpj.getText().trim().length()==18){
            filtraLista();
            
        }else{
            carregaLista();
        }
    }//GEN-LAST:event_jftCnpjKeyReleased

    private void jtbFornecedorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtbFornecedorMouseClicked
        if(evt.getClickCount()>1){
            if (flag ==2){
                int indiceLinha = jtbFornecedor.getSelectedRow();
                Object fornecedor = jtbFornecedor.getValueAt(indiceLinha, 0);
                Object cpf = jtbFornecedor.getValueAt(indiceLinha, 1);
                Global.jtfFornecedor.setText(fornecedor.toString());
                Global.cnpj.setText("CNPJ: "+cnpj.toString()); 
                Global.jtfFornecedor.grabFocus();
                flag =0;
                this.dispose();
            }
        }
    }//GEN-LAST:event_jtbFornecedorMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup bgpPesquisar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JButton jbtVoltar;
    private javax.swing.JFormattedTextField jftCnpj;
    private javax.swing.JLabel jlbNome;
    private javax.swing.JPanel jpnDados;
    private javax.swing.JRadioButton jrbCnpj;
    private javax.swing.JRadioButton jrbNome;
    private javax.swing.JTable jtbConForn;
    private javax.swing.JTable jtbEndForn;
    private javax.swing.JTable jtbFornecedor;
    private javax.swing.JTextField jtfNome;
    // End of variables declaration//GEN-END:variables

    /**
     * Método para alinhar o internal frame no meio da tela
     */
    public void setPosicao() {  
        Dimension d = this.getDesktopPane().getSize();  
        this.setLocation((d.width - this.getSize().width) / 2, 0);
    }
    
    
    /**
     * Método que filtra a lista de fornecedores
     */
    public void filtraLista(){
        Util u = new Util();
        String cnpj = "";
        String nome = "";
        String titulopessoais[] = {"Nome","CNPJ","IE","Cliente Desde"};
        String tituloendereco[] = {"Nome","Endereço","N°","Complemento","CEP"};
        String titulocontato[]  = {"Nome","Telefone","Celular","Email","Observações" };
        
        Object dados [][]={};
             
        DefaultTableModel modelo = new DefaultTableModel(dados,titulopessoais);
        DefaultTableModel ender  = new DefaultTableModel(dados,tituloendereco);
        DefaultTableModel contat = new DefaultTableModel(dados,titulocontato);
        
        jtbFornecedor.setDefaultRenderer(Object.class,new TableFormat());
        jtbFornecedor.setModel(modelo);
        
        
        jtbEndForn.setDefaultRenderer(Object.class,new TableFormat());
        jtbEndForn.setModel(ender);
        
        
        jtbConForn.setDefaultRenderer(Object.class,new TableFormat());
        jtbConForn.setModel(contat);
        
        if(jftCnpj.getText().trim().length()>11){
           cnpj = u.formataCnpj(jftCnpj.getText().trim());
        }
        if(jtfNome.getText().trim().length()>0){
            nome = jtfNome.getText()+"%";
        }
        
        ArrayList<Fornecedor> lista = new FornecedorDAO().pesquisarFornecedor(cnpj,nome);
               
        for(int i = 0;i<lista.size();i++){
            modelo.addRow(new Object[]{lista.get(i).getNomeFornecedor(),u.reformataCnpj(lista.get(i).getCnpj()),lista.get(i).getIeFornecedor(),
            u.reformataData(lista.get(i).getDtCadFornecedor())});
            
            ender.addRow(new Object[]{lista.get(i).getNomeFornecedor(),lista.get(i).getIdEndereco().getNomeRua(),
                                      lista.get(i).getIdEndereco().getNumero(),lista.get(i).getIdEndereco().getComplemento(),
                                       u.reformataCep(lista.get(i).getIdEndereco().getCep())});
        
            contat.addRow(new Object[]{lista.get(i).getNomeFornecedor(),lista.get(i).getIdContato().getTelefone(),
                                      lista.get(i).getIdContato().getCelular(),lista.get(i).getIdContato().getCelular(),lista.get(i).getIdContato().getObs()});
        
        }
    }
    
    
    public void carregaLista(){
        Util u = new Util();
        String titulopessoais[] = {"Nome","CNPJ","IE","Cliente Desde"};
        String tituloendereco[] = {"Nome","Endereço","N°","Complemento","CEP"};
        String titulocontato[]  = {"Nome","Telefone","Celular","Email","Observações" };
        
        Object dados [][]={};
             
        DefaultTableModel modelo = new DefaultTableModel(dados,titulopessoais){
            public boolean isCellEditable(int row,int column){
                return false;
            }
        };
        DefaultTableModel ender  = new DefaultTableModel(dados,tituloendereco){
            public boolean isCellEditable(int row,int column){
                return false;
            }
        };
        DefaultTableModel contat = new DefaultTableModel(dados,titulocontato){
            public boolean isCellEditable(int row,int column){
                return false;
            }
        };
        
        jtbFornecedor.setDefaultRenderer(Object.class,new TableFormat());
        jtbFornecedor.setModel(modelo);
        
        
        jtbEndForn.setDefaultRenderer(Object.class,new TableFormat());
        jtbEndForn.setModel(ender);
        
        
        jtbConForn.setDefaultRenderer(Object.class,new TableFormat());
        jtbConForn.setModel(contat);
        
        ArrayList<Fornecedor> lista = new FornecedorDAO().listarFornecedor();
               
        for(int i = 0;i<lista.size();i++){
            modelo.addRow(new Object[]{lista.get(i).getNomeFornecedor(),u.reformataCnpj(lista.get(i).getCnpj()),lista.get(i).getIeFornecedor(),
            u.reformataData(lista.get(i).getDtCadFornecedor())});
            
            ender.addRow(new Object[]{lista.get(i).getNomeFornecedor(),lista.get(i).getIdEndereco().getNomeRua(),
                                      lista.get(i).getIdEndereco().getNumero(),lista.get(i).getIdEndereco().getComplemento(),
                                       u.reformataCep(lista.get(i).getIdEndereco().getCep())});
        
            contat.addRow(new Object[]{lista.get(i).getNomeFornecedor(),lista.get(i).getIdContato().getTelefone(),
                                      lista.get(i).getIdContato().getCelular(),lista.get(i).getIdContato().getCelular(),lista.get(i).getIdContato().getObs()});
        }
        
    }
    
    
}


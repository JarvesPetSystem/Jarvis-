/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jarves.formularios;

import br.com.jarves.bancodedados.EnderecoDAO;
import br.com.jarves.bancodedados.ProdutoDAO;
import br.com.jarves.classes.Logradouro;
import br.com.jarves.classes.Produtos;
import br.com.jarves.classes.TableFormat;
import br.com.jarves.classes.Util;
import br.com.jarves.util.Global;
import java.awt.Dimension;
import java.text.NumberFormat;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
//import net.proteanit.sql.DbUtils;

/**
 *
 * @author Humberto
 */
public class jifConProd extends javax.swing.JInternalFrame {

    /**
     * Creates new form jifConEnd
     */
    public jifConProd() {
        initComponents();
        carregaLista();
        
        //jtbEndereco.setModel(DbUtils.resultSetToTableModel(EnderecoDAO.listarEnderecos()));
    }
   
public int flag;
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        rbgProdutos = new javax.swing.ButtonGroup();
        jPanel2 = new javax.swing.JPanel();
        lblCodDes = new javax.swing.JLabel();
        jtfCodigo = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtbEndereco = new javax.swing.JTable();
        jbtVoltar = new javax.swing.JButton();
        jtfDescricao = new javax.swing.JTextField();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();

        setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        setTitle("Consulta de Endereços");
        getContentPane().setLayout(null);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Consulta de Produtos"));
        jPanel2.setLayout(null);

        lblCodDes.setText("Código:");
        jPanel2.add(lblCodDes);
        lblCodDes.setBounds(30, 50, 80, 20);

        jtfCodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfCodigoActionPerformed(evt);
            }
        });
        jtfCodigo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtfCodigoKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtfCodigoKeyReleased(evt);
            }
        });
        jPanel2.add(jtfCodigo);
        jtfCodigo.setBounds(100, 40, 280, 30);
        jPanel2.add(jSeparator1);
        jSeparator1.setBounds(10, 130, 760, 20);

        jtbEndereco.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtbEndereco.setToolTipText("Lista de Endereços");
        jtbEndereco.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtbEnderecoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtbEndereco);

        jPanel2.add(jScrollPane1);
        jScrollPane1.setBounds(10, 160, 760, 170);

        jbtVoltar.setText("Sair");
        jbtVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtVoltarActionPerformed(evt);
            }
        });
        jPanel2.add(jbtVoltar);
        jbtVoltar.setBounds(570, 40, 100, 40);

        jtfDescricao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfDescricaoActionPerformed(evt);
            }
        });
        jtfDescricao.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtfDescricaoKeyReleased(evt);
            }
        });
        jPanel2.add(jtfDescricao);
        jtfDescricao.setBounds(100, 40, 280, 30);

        rbgProdutos.add(jRadioButton1);
        jRadioButton1.setSelected(true);
        jRadioButton1.setText("Código");
        jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jRadioButton1);
        jRadioButton1.setBounds(430, 30, 59, 23);

        rbgProdutos.add(jRadioButton2);
        jRadioButton2.setText("Descricão");
        jRadioButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton2ActionPerformed(evt);
            }
        });
        jPanel2.add(jRadioButton2);
        jRadioButton2.setBounds(430, 60, 71, 23);

        getContentPane().add(jPanel2);
        jPanel2.setBounds(0, 0, 780, 340);

        setBounds(0, 0, 791, 377);
    }// </editor-fold>//GEN-END:initComponents

    private void jbtVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtVoltarActionPerformed
        this.dispose();
    }//GEN-LAST:event_jbtVoltarActionPerformed

    private void jtfCodigoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfCodigoKeyReleased
       
    if(jtfCodigo.getText().trim().length()<2)
        carregaLista();
    
    }//GEN-LAST:event_jtfCodigoKeyReleased

    private void jtfCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfCodigoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfCodigoActionPerformed

    private void jtbEnderecoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtbEnderecoMouseClicked
        if(evt.getClickCount()>1){
            if (flag ==1){
                int indiceLinha = jtbEndereco.getSelectedRow();
                Object cep = jtbEndereco.getValueAt(indiceLinha, 2);
                Global.jtfCep.setText(cep.toString());
                
                Global.jtfCep.grabFocus();
                flag =0;
                this.dispose();
            }else if (flag ==2){
                int indiceLinha = jtbEndereco.getSelectedRow();
                Object cep = jtbEndereco.getValueAt(indiceLinha, 2);
                Global.jtfCep.setText(cep.toString());
                
                Global.jtfCep.grabFocus();
                flag =0;
                this.dispose();
            }
           
       }
      
    }//GEN-LAST:event_jtbEnderecoMouseClicked

    private void jtfDescricaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfDescricaoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfDescricaoActionPerformed

    private void jtfDescricaoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfDescricaoKeyReleased
        if(jtfDescricao.getText().trim().length()>4)
            filtraListaDesc();
        else
            carregaLista();
                 
    }//GEN-LAST:event_jtfDescricaoKeyReleased

    private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton1ActionPerformed
        lblCodDes.setText("Código:");
        jtfCodigo.setVisible(true);
        jtfDescricao.setVisible(false);
    }//GEN-LAST:event_jRadioButton1ActionPerformed

    private void jRadioButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton2ActionPerformed
        lblCodDes.setText("Descrição:");
        jtfCodigo.setVisible(false);
        jtfDescricao.setVisible(true);
    }//GEN-LAST:event_jRadioButton2ActionPerformed

    private void jtfCodigoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfCodigoKeyPressed
       if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_ENTER){
           filtraLista();
       }
    }//GEN-LAST:event_jtfCodigoKeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel2;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JButton jbtVoltar;
    private javax.swing.JTable jtbEndereco;
    private javax.swing.JTextField jtfCodigo;
    private javax.swing.JTextField jtfDescricao;
    private javax.swing.JLabel lblCodDes;
    private javax.swing.ButtonGroup rbgProdutos;
    // End of variables declaration//GEN-END:variables

    /**
     * Método para alinhar o internal frame no meio da tela
     */
    public void setPosicao() {  
        Dimension d = this.getDesktopPane().getSize();  
        this.setLocation((d.width - this.getSize().width) / 2, 0);
    }
    
    public void carregaLista(){
        
        String titulo[] = {"Código","Descricão","Unidade","Categoria","Compra R$","Imposto %","Lucro %","Venda R$"};
        Object dados [][]={};
        DefaultTableModel modelo = new DefaultTableModel(dados,titulo){
            public boolean isCellEditable(int row,int column){
                return false;
            }
        };
        jtbEndereco.setDefaultRenderer(Object.class,new TableFormat());
        jtbEndereco.setModel(modelo);
        
        ArrayList<Produtos> lista = new ProdutoDAO().listarProdutos();
        
        for(int i = 0;i<lista.size();i++){
            modelo.addRow(new String[]{lista.get(i).getEanProduto(),lista.get(i).getDescricao(),
            lista.get(i).getUnidade(),lista.get(i).getCategoria().getNomeCategoria(),
            NumberFormat.getCurrencyInstance().format((lista.get(i).getPrecoProduto().getPrecoCompra())).replace("R$ ", ""),
            NumberFormat.getCurrencyInstance().format((lista.get(i).getPrecoProduto().getImposto())).replace("R$ ", ""),
            NumberFormat.getCurrencyInstance().format((lista.get(i).getPrecoProduto().getLucro())).replace("R$ ", ""),
            NumberFormat.getCurrencyInstance().format((lista.get(i).getPrecoProduto().getPrecoVenda())).replace("R$ ", "")
            
            });
            
        }
        
        
    }
    public void filtraLista(){
       String titulo[] = {"Código","Descricão","Unidade","Categoria","Compra R$","Imposto %","Lucro %","Venda R$"};
        Object dados [][]={};
        DefaultTableModel modelo = new DefaultTableModel(dados,titulo){
            public boolean isCellEditable(int row,int column){
                return false;
            }
        };
        jtbEndereco.setDefaultRenderer(Object.class,new TableFormat());
        jtbEndereco.setModel(modelo);
        
        
        ArrayList<Produtos> lista = new ProdutoDAO().listarProdutosCodigo(jtfCodigo.getText().trim()+"%");
        
        for(int i = 0;i<lista.size();i++){
            modelo.addRow(new String[]{lista.get(i).getEanProduto(),lista.get(i).getDescricao(),
            lista.get(i).getUnidade(),lista.get(i).getCategoria().getNomeCategoria(),
            NumberFormat.getCurrencyInstance().format((lista.get(i).getPrecoProduto().getPrecoCompra())).replace("R$ ", ""),
            NumberFormat.getCurrencyInstance().format((lista.get(i).getPrecoProduto().getImposto())).replace("R$ ", ""),
            NumberFormat.getCurrencyInstance().format((lista.get(i).getPrecoProduto().getLucro())).replace("R$ ", ""),
            NumberFormat.getCurrencyInstance().format((lista.get(i).getPrecoProduto().getPrecoVenda())).replace("R$ ", "")
            
            });
            
        }
        
    }
    public void filtraListaDesc(){
       String titulo[] = {"Código","Descricão","Unidade","Categoria","Compra R$","Imposto %","Lucro %","Venda R$"};
        Object dados [][]={};
        DefaultTableModel modelo = new DefaultTableModel(dados,titulo){
            public boolean isCellEditable(int row,int column){
                return false;
            }
        };
        jtbEndereco.setDefaultRenderer(Object.class,new TableFormat());
        jtbEndereco.setModel(modelo);
        
        
        ArrayList<Produtos> lista = new ProdutoDAO().listarProdutosDesc(jtfDescricao.getText().trim().toLowerCase()+"%");
        
        for(int i = 0;i<lista.size();i++){
            modelo.addRow(new String[]{lista.get(i).getEanProduto(),lista.get(i).getDescricao(),
            lista.get(i).getUnidade(),lista.get(i).getCategoria().getNomeCategoria(),
            NumberFormat.getCurrencyInstance().format((lista.get(i).getPrecoProduto().getPrecoCompra())).replace("R$ ", ""),
            NumberFormat.getCurrencyInstance().format((lista.get(i).getPrecoProduto().getImposto())).replace("R$ ", ""),
            NumberFormat.getCurrencyInstance().format((lista.get(i).getPrecoProduto().getLucro())).replace("R$ ", ""),
            NumberFormat.getCurrencyInstance().format((lista.get(i).getPrecoProduto().getPrecoVenda())).replace("R$ ", "")
            
            });
            
        }
        
    }
    
    
}


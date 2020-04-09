package pacote_gas;


import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Lucas
 */
public class AlteraValorPadrao extends javax.swing.JFrame {
    dados d = new dados();
    
    public AlteraValorPadrao() {
        initComponents();
        d.conecta("localhost","db_gas","root","");
        comboNomeProdSt();
        comboNomeValor();
        comboAlteraStatus();
        Tabela();
        setIcone();
    }
    
    private void setIcone(){
        URL caminhoIcone = getClass().getResource("/images/iconeProdutos.png");
        Image iconeTitulo = Toolkit.getDefaultToolkit().getImage(caminhoIcone);
        this.setIconImage(iconeTitulo);
    }

    private void comboAlteraStatus(){
    comboAlteraStatus.removeAllItems();
    comboAlteraStatus.addItem("Ativo");
    comboAlteraStatus.addItem("Inativo");
    } 
    
    private void comboNomeProdSt(){
        comboNomeProduto.removeAllItems();
        ResultSet rs = d.consulta("select descricao_prod from produtos;");
       
            try {
             while(rs.next()) {
                 comboNomeProduto.addItem(rs.getString("descricao_prod"));
                              }
                 }
            catch (Exception e) {
                    System.err.println("Erro: " + e);
                                }    
    }
    
        private void comboNomeValor(){
        comboAlteraProd.removeAllItems();
        ResultSet rs = d.consulta("select descricao_prod from produtos where status = 'Ativo';");
       
            try {
             while(rs.next()) {
                 comboAlteraProd.addItem(rs.getString("descricao_prod"));
                              }
                 }
            catch (Exception e) {
                    System.err.println("Erro: " + e);
                                }    
    }
    
    private void cadastraProduto(){
        String nomeP = nomeProduto.getText();
        String valorP = valorProduto.getText();
        String ativo = "Ativo";
        
        if(nomeP.isEmpty()){
            JOptionPane.showMessageDialog(this, "Preencha um nome para o produto!");
            nomeProduto.setText("");
            nomeProduto.requestFocus();
        } else if(valorP.isEmpty()){
            JOptionPane.showMessageDialog(this, "Preencha um valor para o produto!");
            valorProduto.setText("");
            valorProduto.requestFocus();
        } else {
        
        ResultSet rs = d.consulta("select descricao_prod from produtos where descricao_prod ='"+nomeP+"';");
        try{
        if(rs.next()){
         JOptionPane.showMessageDialog(this, "Produto já cadastrado!");
         nomeProduto.setText("");
         valorProduto.setText("");
        } else {
            if(d.insereProdutos("produtos", nomeP, valorP, ativo)){
            Tabela();
            comboNomeProdSt();
            comboNomeValor();
            nomeProduto.setText("");
            valorProduto.setText("");
            } else {
                JOptionPane.showMessageDialog(this, "Erro ao cadastrar produto!");
               nomeProduto.setText("");
               valorProduto.setText("");
               nomeProduto.requestFocus();
            }
            
        }
        
       } catch (SQLException e){
            System.out.println(e);
       }
      }
    }
    
    private void Tabela(){
        DefaultTableModel modelotabela = (DefaultTableModel) TabelaProdutos.getModel();
        TabelaProdutos.setRowSelectionAllowed(false);
    
        modelotabela.setColumnCount(4);
        modelotabela.setRowCount(0);
        TabelaProdutos.getColumnModel().getColumn(0).setHeaderValue("Codigo");
        TabelaProdutos.getColumnModel().getColumn(1).setHeaderValue("Descrição");
        TabelaProdutos.getColumnModel().getColumn(2).setHeaderValue("Valor");
        TabelaProdutos.getColumnModel().getColumn(3).setHeaderValue("Status");

        ResultSet rs = d.consulta("select id_produto,descricao_prod,valorpadrao,status from produtos");
       
        int linha = 0;
            try {
             while(rs.next()) {
                    modelotabela.addRow(new String[modelotabela.getColumnCount()]);
                    modelotabela.setValueAt(rs.getString("id_produto"), linha, 0);
                    modelotabela.setValueAt(rs.getString("descricao_prod"), linha, 1);
                    modelotabela.setValueAt(rs.getString("valorpadrao"), linha, 2);
                    modelotabela.setValueAt(rs.getString("status"), linha, 3);
                    linha++;
                              }
                 }
            catch (Exception e) {
                    System.err.println("Erro: " + e);
                                }  
    }
    
        
    private void alteraProduto(){
         if(d.atualizaClientes("produtos",  "status='"+comboAlteraStatus.getSelectedItem()+"'","descricao_prod='"+comboNomeProduto.getSelectedItem()+"'")){   
         JOptionPane.showMessageDialog(this, "Produto alterado!");
             Tabela();
          } else {
             JOptionPane.showMessageDialog(this, "Erro ao alterar produto!");
         }
    }
    
     private void alteraValor(){
         if(valorp.getText().isEmpty()){
             JOptionPane.showMessageDialog(this, "Porfavor, preencha um valor!");
         } else {
         if(d.atualizaClientes("produtos",  "valorpadrao='"+valorp.getText()+"'","descricao_prod='"+comboAlteraProd.getSelectedItem()+"'")){   
         JOptionPane.showMessageDialog(this, "Produto alterado!");
             Tabela();
             valorp.setText("");
          } else {
             JOptionPane.showMessageDialog(this, "Erro ao alterar produto!");
         }
         }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btAlteraValor = new javax.swing.JButton();
        valorp = new javax.swing.JTextField();
        rss2 = new javax.swing.JLabel();
        rss3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TabelaProdutos = new javax.swing.JTable();
        comboAlteraProd = new javax.swing.JComboBox<>();
        nomeProduto = new javax.swing.JTextField();
        btCadastraProduto = new javax.swing.JButton();
        btAlteraStatus = new javax.swing.JButton();
        comboAlteraStatus = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        rss5 = new javax.swing.JLabel();
        rss6 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        comboNomeProduto = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        valorProduto = new javax.swing.JTextField();
        rss4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Alterar valor padrão");
        setResizable(false);

        btAlteraValor.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btAlteraValor.setText("Alterar");
        btAlteraValor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btAlteraValorMousePressed(evt);
            }
        });

        valorp.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                valorpKeyPressed(evt);
            }
        });

        rss2.setBackground(new java.awt.Color(153, 153, 255));
        rss2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        rss2.setText("Cadastrar Produto");

        rss3.setBackground(new java.awt.Color(153, 153, 255));
        rss3.setFont(new java.awt.Font("Tahoma", 2, 12)); // NOI18N
        rss3.setText("(ex: 55)");

        TabelaProdutos.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(TabelaProdutos);

        comboAlteraProd.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        nomeProduto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                nomeProdutoKeyPressed(evt);
            }
        });

        btCadastraProduto.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btCadastraProduto.setText("Cadastrar");
        btCadastraProduto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btCadastraProdutoMousePressed(evt);
            }
        });

        btAlteraStatus.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btAlteraStatus.setText("Alterar");
        btAlteraStatus.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btAlteraStatusMousePressed(evt);
            }
        });

        comboAlteraStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel2.setText("Nome do Produto:");

        rss5.setBackground(new java.awt.Color(153, 153, 255));
        rss5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        rss5.setText("Alterar Status");

        rss6.setBackground(new java.awt.Color(153, 153, 255));
        rss6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        rss6.setText("Alterar valor atual");

        jLabel3.setText("Nome do Produto:");

        comboNomeProduto.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel4.setText("Status:");

        jLabel5.setText("Nome do Produto:");

        jLabel6.setText("Valor:");

        valorProduto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                valorProdutoKeyPressed(evt);
            }
        });

        rss4.setBackground(new java.awt.Color(153, 153, 255));
        rss4.setFont(new java.awt.Font("Tahoma", 2, 12)); // NOI18N
        rss4.setText("(ex: 55)");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(145, 145, 145)
                                .addComponent(rss2))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addGap(42, 42, 42)
                                        .addComponent(valorProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(nomeProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(rss4, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 65, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(valorp, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(comboAlteraProd, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(rss6, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(rss3, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(44, 44, 44))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(173, 173, 173)
                                .addComponent(btCadastraProduto))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(166, 166, 166)
                                .addComponent(btAlteraStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btAlteraValor)
                        .addGap(137, 137, 137))))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(167, 167, 167)
                        .addComponent(rss5))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(29, 29, 29)
                                .addComponent(jLabel4)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(comboAlteraStatus, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(comboNomeProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(rss2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(nomeProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(valorProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6)
                            .addComponent(rss4, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(rss6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(comboAlteraProd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(valorp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rss3, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btCadastraProduto)
                    .addComponent(btAlteraValor))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addComponent(rss5)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(comboNomeProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboAlteraStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addComponent(btAlteraStatus)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btAlteraValorMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btAlteraValorMousePressed
    alteraValor();
    }//GEN-LAST:event_btAlteraValorMousePressed

    private void valorpKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_valorpKeyPressed
    if(evt.getKeyCode() == KeyEvent.VK_ENTER){
        alteraValor();
    }
    }//GEN-LAST:event_valorpKeyPressed

    private void btCadastraProdutoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btCadastraProdutoMousePressed
         cadastraProduto();
    }//GEN-LAST:event_btCadastraProdutoMousePressed

    private void btAlteraStatusMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btAlteraStatusMousePressed
    alteraProduto();
    }//GEN-LAST:event_btAlteraStatusMousePressed

    private void valorProdutoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_valorProdutoKeyPressed
    if(evt.getKeyCode() == KeyEvent.VK_ENTER){
        cadastraProduto();
    }
    }//GEN-LAST:event_valorProdutoKeyPressed

    private void nomeProdutoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nomeProdutoKeyPressed
     if(evt.getKeyCode() == KeyEvent.VK_ENTER){
         valorProduto.requestFocus();
     }
    }//GEN-LAST:event_nomeProdutoKeyPressed

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
            java.util.logging.Logger.getLogger(AlteraValorPadrao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AlteraValorPadrao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AlteraValorPadrao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AlteraValorPadrao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AlteraValorPadrao().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TabelaProdutos;
    private javax.swing.JButton btAlteraStatus;
    private javax.swing.JButton btAlteraValor;
    private javax.swing.JButton btCadastraProduto;
    private javax.swing.JComboBox<String> comboAlteraProd;
    private javax.swing.JComboBox<String> comboAlteraStatus;
    private javax.swing.JComboBox<String> comboNomeProduto;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField nomeProduto;
    private javax.swing.JLabel rss2;
    private javax.swing.JLabel rss3;
    private javax.swing.JLabel rss4;
    private javax.swing.JLabel rss5;
    private javax.swing.JLabel rss6;
    private javax.swing.JTextField valorProduto;
    private javax.swing.JTextField valorp;
    // End of variables declaration//GEN-END:variables
}

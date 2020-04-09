/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pacote_gas;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Lucas
 */
public class relatorioClienteTelefone extends javax.swing.JFrame {
    dados d = new dados();
    
    public relatorioClienteTelefone() {
        initComponents();
        d.conecta("localhost","db_gas","root","");
       TabelaClientes.getTableHeader().setReorderingAllowed(false);
       TabelaClientes.getTableHeader().getColumnModel().getColumn(1).setMinWidth(120);
       TabelaClientes.getTableHeader().getColumnModel().getColumn(2).setMinWidth(200);
       TabelaClientes.getTableHeader().getColumnModel().getColumn(3).setMinWidth(120);
       TabelaClientes.getTableHeader().getColumnModel().getColumn(8).setMinWidth(120);
        setIcone();
    }
    
    private void setIcone(){
        URL caminhoIcone = getClass().getResource("/images/iconeRelatorios.png");
        Image iconeTitulo = Toolkit.getDefaultToolkit().getImage(caminhoIcone);
        this.setIconImage(iconeTitulo);
    }
    
    public void buscarCliente(){
         DefaultTableModel modelotabela = (DefaultTableModel) TabelaClientes.getModel();
          TabelaClientes.setRowSelectionAllowed(false);
                  try{
                    String tel = telefone.getText();
                    tel = tel.replaceAll("-", "");
                      ResultSet vendasA = d.consulta("select telefone from vendas where telefone='"+tel+"'");
                      ResultSet vendasB = d.consulta("select telefone from vendas_bkp where telefone='"+tel+"'");      
     if(vendasA.next()){
                    modelotabela.setNumRows(0);
                    avisos.setText("Retornando dados solicitados!");
                    vendasAtual();
     } else if (vendasB.next()){
                    modelotabela.setNumRows(0);
                    avisos.setText("Retornando dados solicitados!");
                    vendasBkp();
                  } else {
                      avisos.setText("Nenhum registro não encontrado!");
                      modelotabela.setNumRows(0);
                      telefone.setText("");
                      telefone.requestFocus();
                  }
                  } catch (SQLException e){
                      System.out.println(e);
                  }
               
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        TabelaClientes = new javax.swing.JTable();
        btBuscar = new javax.swing.JButton();
        telefone = new javax.swing.JTextField();
        avisos = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Relatório por Telefone");
        setResizable(false);

        TabelaClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Telefone", "Nome", "Endereço", "Bairro", "Valor", "Qtd", "Produto", "Motorista", "Pagamento", "Hora", "Data"
            }
        )
        {public boolean isCellEditable(int row, int column){return false;}}
    );
    jScrollPane1.setViewportView(TabelaClientes);

    btBuscar.setText("Buscar");
    btBuscar.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mousePressed(java.awt.event.MouseEvent evt) {
            btBuscarMousePressed(evt);
        }
    });

    telefone.addKeyListener(new java.awt.event.KeyAdapter() {
        public void keyPressed(java.awt.event.KeyEvent evt) {
            telefoneKeyPressed(evt);
        }
    });

    avisos.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
    avisos.setText("Digite o número do cliente, para consultar a última compra!");

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(layout.createSequentialGroup()
            .addGap(49, 49, 49)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(telefone, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createSequentialGroup()
                    .addGap(30, 30, 30)
                    .addComponent(btBuscar)))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 57, Short.MAX_VALUE)
            .addComponent(avisos, javax.swing.GroupLayout.PREFERRED_SIZE, 697, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(61, 61, 61))
        .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
    );
    layout.setVerticalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(layout.createSequentialGroup()
            .addGap(42, 42, 42)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(telefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(btBuscar))
                .addGroup(layout.createSequentialGroup()
                    .addGap(10, 10, 10)
                    .addComponent(avisos)))
            .addGap(18, 18, 18)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 307, Short.MAX_VALUE))
    );

    pack();
    }// </editor-fold>//GEN-END:initComponents

    private void telefoneKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_telefoneKeyPressed
    if(evt.getKeyCode() == KeyEvent.VK_ENTER){
       if(telefone.getText().isEmpty()){
           avisos.setText("Porfavor, digite um telefone!");
       } else {
        buscarCliente();
    }
    }  
    }//GEN-LAST:event_telefoneKeyPressed
   
    private void vendasBkp(){
         String tel = telefone.getText();
         tel = tel.replaceAll("-", "");
         DefaultTableModel modelotabela = (DefaultTableModel) TabelaClientes.getModel();
         modelotabela.setNumRows(0);
      try{
         ResultSet vendasBkp = d.consulta("select vendas_bkp.telefone,vendas_bkp.nome,vendas_bkp.endereco,vendas_bkp.bairro,vendas_bkp.valor,vendas_bkp.qtd,produtos.descricao_prod,motoristas.nome_motorista,forma_pgto.descricao,vendas_bkp.hora,date_format(dt, '%d/%m/%y') from vendas_bkp,produtos,motoristas,forma_pgto\n" +
     "where telefone ='"+tel+"' and vendas_bkp.id_motorista = motoristas.id_motorista and produtos.id_produto = vendas_bkp.id_produto and vendas_bkp.id_pgto = forma_pgto.id_pgto ORDER BY dt desc;");   
                    int linha = 0;
                    while(vendasBkp.next()) {
                    modelotabela.addRow(new String[modelotabela.getColumnCount()]);
                    modelotabela.setValueAt(vendasBkp.getString("telefone"), linha, 0);
                    modelotabela.setValueAt(vendasBkp.getString("nome"), linha, 1);
                    modelotabela.setValueAt(vendasBkp.getString("endereco"), linha, 2);
                    modelotabela.setValueAt(vendasBkp.getString("bairro"), linha, 3);
                    modelotabela.setValueAt(vendasBkp.getString("valor"), linha, 4);
                    modelotabela.setValueAt(vendasBkp.getString("qtd"), linha, 5);
                    modelotabela.setValueAt(vendasBkp.getString("descricao_prod"), linha, 6);
                    modelotabela.setValueAt(vendasBkp.getString("nome_motorista"), linha, 7);
                    modelotabela.setValueAt(vendasBkp.getString("descricao"), linha, 8);     
                    modelotabela.setValueAt(vendasBkp.getString("hora"), linha, 9);
                    modelotabela.setValueAt(vendasBkp.getString("date_format(dt, '%d/%m/%y')"), linha, 10);
                    linha++;
                    }
                } catch (SQLException e){
                    System.out.println(e);
                }
    }
    
    private void vendasAtual(){
        try{
              String tel = telefone.getText();
              tel = tel.replaceAll("-", "");
                   DefaultTableModel modelotabela = (DefaultTableModel) TabelaClientes.getModel();
                   modelotabela.setNumRows(0);
              ResultSet vendasAt = d.consulta("select vendas.telefone,vendas.nome,vendas.endereco,vendas.bairro,vendas.valor,vendas.qtd,produtos.descricao_prod,motoristas.nome_motorista,forma_pgto.descricao,vendas.hora,date_format(dt, '%d/%m/%y') from vendas,produtos,motoristas,forma_pgto\n" +
"where telefone ='"+tel+"' and vendas.id_motorista = motoristas.id_motorista and produtos.id_produto = vendas.id_produto and vendas.id_pgto = forma_pgto.id_pgto ORDER BY dt desc;"); 
                     int linha = 0;
                    while(vendasAt.next()) {
                    modelotabela.addRow(new String[modelotabela.getColumnCount()]);
                    modelotabela.setValueAt(vendasAt.getString("telefone"), linha, 0);
                    modelotabela.setValueAt(vendasAt.getString("nome"), linha, 1);
                    modelotabela.setValueAt(vendasAt.getString("endereco"), linha, 2);
                    modelotabela.setValueAt(vendasAt.getString("bairro"), linha, 3);
                    modelotabela.setValueAt(vendasAt.getString("valor"), linha, 4);
                    modelotabela.setValueAt(vendasAt.getString("qtd"), linha, 5);
                    modelotabela.setValueAt(vendasAt.getString("descricao_prod"), linha, 6);
                    modelotabela.setValueAt(vendasAt.getString("nome_motorista"), linha, 7);
                    modelotabela.setValueAt(vendasAt.getString("descricao"), linha, 8);     
                    modelotabela.setValueAt(vendasAt.getString("hora"), linha, 9);
                    modelotabela.setValueAt(vendasAt.getString("date_format(dt, '%d/%m/%y')"), linha, 10);
                    linha++;
                              }
        } catch (SQLException e){
            System.out.println(e);
        }
        
    }
    
    private void btBuscarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btBuscarMousePressed
    buscarCliente();
    }//GEN-LAST:event_btBuscarMousePressed

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
            java.util.logging.Logger.getLogger(relatorioClienteTelefone.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(relatorioClienteTelefone.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(relatorioClienteTelefone.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(relatorioClienteTelefone.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new relatorioClienteTelefone().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TabelaClientes;
    private javax.swing.JLabel avisos;
    private javax.swing.JButton btBuscar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField telefone;
    // End of variables declaration//GEN-END:variables
}

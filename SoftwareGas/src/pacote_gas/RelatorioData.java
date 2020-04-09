/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pacote_gas;

import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Lucas
 */
public class RelatorioData extends javax.swing.JFrame {
    dados d = new dados();
    /**
     * Creates new form RelatorioData
     */
    public RelatorioData() {
        initComponents();
        d.conecta("localhost","db_gas","root","");
        TabelaRelatorio.getTableHeader().setReorderingAllowed(false);
        setIcone();
    }
    
    private void setIcone(){
        URL caminhoIcone = getClass().getResource("/images/iconeRelatorios.png");
        Image iconeTitulo = Toolkit.getDefaultToolkit().getImage(caminhoIcone);
        this.setIconImage(iconeTitulo);
    }

   public void buscaPorData(){
        DefaultTableModel modelotabela = (DefaultTableModel) TabelaRelatorio.getModel();
        TabelaRelatorio.setRowSelectionAllowed(false);
         modelotabela.setNumRows(0);
       SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
       String dataInicio = sdf.format(dataInicial.getDate());
       String dataFim = sdf.format(dataFinal.getDate());
       ResultSet rs = d.consulta("select vendas_bkp.id_venda,vendas_bkp.telefone,vendas_bkp.nome,vendas_bkp.endereco,vendas_bkp.bairro,vendas_bkp.observacao,\n" +
"vendas_bkp.valor,vendas_bkp.qtd,produtos.descricao_prod,forma_pgto.descricao,motoristas.nome_motorista,vendas_bkp.hora,date_format(vendas_bkp.dt, '%d/%m/%y') from vendas_bkp,produtos,motoristas,forma_pgto\n" +
"where dt between '"+dataInicio+"' and '"+dataFim+"' and vendas_bkp.id_produto = produtos.id_produto and vendas_bkp.id_motorista = motoristas.id_motorista and vendas_bkp.id_pgto = forma_pgto.id_pgto ORDER BY dt asc");
       
       try {
            int linha = 0;
             while(rs.next()) {
                    modelotabela.addRow(new String[modelotabela.getColumnCount()]);
                    modelotabela.setValueAt(rs.getString("id_venda"), linha, 0);
                    modelotabela.setValueAt(rs.getString("telefone"), linha, 1);
                    modelotabela.setValueAt(rs.getString("nome"), linha, 2);
                    modelotabela.setValueAt(rs.getString("endereco"), linha, 3);
                    modelotabela.setValueAt(rs.getString("bairro"), linha, 4);
                    modelotabela.setValueAt(rs.getString("observacao"), linha, 5);
                    modelotabela.setValueAt(rs.getString("valor"), linha, 6);
                    modelotabela.setValueAt(rs.getString("qtd"), linha, 7);
                    modelotabela.setValueAt(rs.getString("descricao_prod"), linha, 8);     
                    modelotabela.setValueAt(rs.getString("descricao"), linha, 9);
                    modelotabela.setValueAt(rs.getString("nome_motorista"), linha, 10);
                    modelotabela.setValueAt(rs.getString("hora"), linha, 11);
                    modelotabela.setValueAt(rs.getString("date_format(vendas_bkp.dt, '%d/%m/%y')"), linha, 12);
                    linha++;
                              }
                 }      
            catch (Exception e) {
                    System.err.println("Erro: " + e);
                                }   
       
       
   }
   
   private void somaVendas(){
       DefaultTableModel modelotabela = (DefaultTableModel) TabelaRelatorio.getModel();  
             
        int total = modelotabela.getRowCount();
        
         n_vendas.setText(String.valueOf(total));
   }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        dataInicial = new com.toedter.calendar.JDateChooser();
        jScrollPane1 = new javax.swing.JScrollPane();
        TabelaRelatorio = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        dataFinal = new com.toedter.calendar.JDateChooser();
        jLabel2 = new javax.swing.JLabel();
        n_vendas = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Relatório por Data");

        jButton1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jButton1.setText("Buscar");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jButton1MousePressed(evt);
            }
        });
        jButton1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jButton1KeyPressed(evt);
            }
        });

        dataInicial.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N

        TabelaRelatorio.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Cód. Venda", "Telefone", "Nome", "Endereço", "Bairro", "Observação", "Valor", "Qtd", "Produto", "Pagamento", "Motorista", "Hora", "Data"
            }
        )
        {public boolean isCellEditable(int row, int column){return false;}}
    );
    jScrollPane1.setViewportView(TabelaRelatorio);

    jLabel1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
    jLabel1.setText("Data Inicial");

    dataFinal.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N

    jLabel2.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
    jLabel2.setText("Data Final");

    n_vendas.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
    n_vendas.setForeground(new java.awt.Color(124, 124, 124));
    n_vendas.setText("0");

    jLabel4.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
    jLabel4.setText("Total de Vendas:");

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(jScrollPane1)
        .addGroup(layout.createSequentialGroup()
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(jLabel4)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(n_vendas, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createSequentialGroup()
                    .addGap(500, 500, 500)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(dataInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(30, 30, 30)
                                    .addComponent(jLabel1)))
                            .addGap(89, 89, 89)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(dataFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(30, 30, 30)
                                    .addComponent(jLabel2))))
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 435, javax.swing.GroupLayout.PREFERRED_SIZE))))
            .addContainerGap(539, Short.MAX_VALUE))
    );
    layout.setVerticalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(layout.createSequentialGroup()
            .addGap(82, 82, 82)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(jLabel1)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(dataInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createSequentialGroup()
                    .addComponent(jLabel2)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(dataFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addComponent(jButton1)
            .addGap(29, 29, 29)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel4)
                .addComponent(n_vendas))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 597, Short.MAX_VALUE))
    );

    pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButton1KeyPressed

    }//GEN-LAST:event_jButton1KeyPressed

    private void jButton1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MousePressed
    buscaPorData();
    somaVendas();
    }//GEN-LAST:event_jButton1MousePressed

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
            java.util.logging.Logger.getLogger(RelatorioData.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RelatorioData.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RelatorioData.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RelatorioData.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RelatorioData().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TabelaRelatorio;
    private com.toedter.calendar.JDateChooser dataFinal;
    private com.toedter.calendar.JDateChooser dataInicial;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel n_vendas;
    // End of variables declaration//GEN-END:variables
}

package pacote_gas;


import static java.awt.Frame.MAXIMIZED_BOTH;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
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
public class Cadastra_AlteraCli extends javax.swing.JFrame {
    dados d = new dados();
    
    public Cadastra_AlteraCli() {
        initComponents();
        d.conecta("localhost","db_gas","root","");
        TabelaClientes();
        numeroTotalClientes();
        Tabela.setRowSelectionAllowed(false);
        Tabela.getTableHeader().setReorderingAllowed(false);
        setIcone();
    }
    
        private void setIcone(){
        URL caminhoIcone = getClass().getResource("/images/iconeClientes.png");
        Image iconeTitulo = Toolkit.getDefaultToolkit().getImage(caminhoIcone);
        this.setIconImage(iconeTitulo);
    }

    public void TabelaClientes(){
    DefaultTableModel modelotabela = (DefaultTableModel) Tabela.getModel();
    
        modelotabela.setColumnCount(4);
        modelotabela.setRowCount(0);
        Tabela.getColumnModel().getColumn(0).setHeaderValue("Telefone");
        Tabela.getColumnModel().getColumn(1).setHeaderValue("Nome");
        Tabela.getColumnModel().getColumn(2).setHeaderValue("Endereço");
        Tabela.getColumnModel().getColumn(3).setHeaderValue("Bairro");

        ResultSet rs = d.consulta("select * from clientes");
       
        int linha = 0;
            try {
             while(rs.next()) {
                    modelotabela.addRow(new String[modelotabela.getColumnCount()]);
                    modelotabela.setValueAt(rs.getString("telefone"), linha, 0);
                    modelotabela.setValueAt(rs.getString("nome"), linha, 1);
                    modelotabela.setValueAt(rs.getString("endereco"), linha, 2);
                    modelotabela.setValueAt(rs.getString("bairro"), linha, 3);
                    linha++;
                              }
                 }
            catch (Exception e) {
                    System.err.println("Erro: " + e);
                                } 
            rolaScroll();
    }
      
     private void rolaScroll() {
	SwingUtilities.invokeLater(new Runnable() {
		public void run() {
		 jScrollPane1.getVerticalScrollBar().setValue(Tabela.getHeight());
		}
	});
}
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        telefone = new javax.swing.JTextField();
        endereco = new javax.swing.JTextField();
        nome = new javax.swing.JTextField();
        bairro = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btCadastra = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        Tabela = new javax.swing.JTable();
        avisos = new javax.swing.JLabel();
        btAltera = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        totalClientes = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastrar/Alterar Clientes");

        telefone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                telefoneActionPerformed(evt);
            }
        });
        telefone.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                telefoneKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                telefoneKeyTyped(evt);
            }
        });

        endereco.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                enderecoKeyPressed(evt);
            }
        });

        nome.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                nomeKeyPressed(evt);
            }
        });

        bairro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                bairroKeyPressed(evt);
            }
        });

        jLabel1.setText("Telefone");

        jLabel2.setText("Nome");

        jLabel3.setText("Endereço");

        jLabel4.setText("Bairro");

        btCadastra.setText("Cadastrar");
        btCadastra.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btCadastraKeyPressed(evt);
            }
        });

        Tabela.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Telefone", "Nome", "Endereço", "Bairro"
            }
        )
        {public boolean isCellEditable(int row, int column){return false;}}
    );
    jScrollPane1.setViewportView(Tabela);

    avisos.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
    avisos.setText("Seja Bem-Vindo ao menu de Clientes!");

    btAltera.setText("Alterar");
    btAltera.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            btAlteraMouseClicked(evt);
        }
        public void mousePressed(java.awt.event.MouseEvent evt) {
            btAlteraMousePressed(evt);
        }
    });

    jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
    jLabel5.setText("Clientes cadastrados:");

    totalClientes.setBackground(new java.awt.Color(105, 105, 105));
    totalClientes.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
    totalClientes.setForeground(new java.awt.Color(110, 110, 110));

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(layout.createSequentialGroup()
            .addContainerGap()
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(jLabel3)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(endereco, javax.swing.GroupLayout.PREFERRED_SIZE, 379, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(jLabel4)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(bairro, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE))
                .addGroup(layout.createSequentialGroup()
                    .addComponent(jLabel1)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(telefone, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(jLabel2)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(nome, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel5)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(totalClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addContainerGap())
        .addGroup(layout.createSequentialGroup()
            .addGap(122, 122, 122)
            .addComponent(btCadastra)
            .addGap(18, 18, 18)
            .addComponent(btAltera)
            .addGap(33, 33, 33)
            .addComponent(avisos)
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 964, Short.MAX_VALUE)
    );
    layout.setVerticalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(layout.createSequentialGroup()
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(20, 20, 20)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(telefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel1)
                        .addComponent(nome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2)))
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5)
                        .addComponent(totalClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))))
            .addGap(18, 18, 18)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(bairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jLabel4)
                .addComponent(endereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jLabel3))
            .addGap(18, 18, 18)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(btCadastra)
                .addComponent(avisos)
                .addComponent(btAltera))
            .addGap(18, 18, 18)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 599, Short.MAX_VALUE))
    );

    pack();
    }// </editor-fold>//GEN-END:initComponents

    private void telefoneKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_telefoneKeyTyped
    }//GEN-LAST:event_telefoneKeyTyped

    private void enderecoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_enderecoKeyPressed
     if(evt.getKeyCode() == KeyEvent.VK_ENTER){
         bairro.requestFocus();
     }
    }//GEN-LAST:event_enderecoKeyPressed

    private void nomeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nomeKeyPressed
          if(evt.getKeyCode() == KeyEvent.VK_ENTER){
         endereco.requestFocus();
     }
    }//GEN-LAST:event_nomeKeyPressed

    private void bairroKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_bairroKeyPressed
       //Pega o telefone digitado e remove o traço.
        String valor = telefone.getText();
           valor = valor.replaceAll("-", ""); 
           //Quando o usuário digita enter.
                if(evt.getKeyCode() == KeyEvent.VK_ENTER){
                    //Checagem se nenhum campo está vázio.
                    if(telefone.getText().isEmpty() || endereco.getText().isEmpty() || nome.getText().isEmpty() || bairro.getText().isEmpty()){
                        JOptionPane.showMessageDialog(this, "Preencha todos os campos, porfavor!");
                        telefone.requestFocus();
                        } else { //Se nenhum campo estiver vázio, é realizado o cadastro/alteração de cliente(s).
                             try{
                                 //Consulta com telefone de cliente.
                                ResultSet rs = d.consulta("select telefone from clientes where telefone = '" + valor + "'");
                                if(rs.next()){ //Se o cliente já estiver cadastrado, é possível alterar o cadastro do cliente.
                                        AlteraClientes();
                                        limpaTodosCampos();
                                        avisos.setText("");
                                        telefone.requestFocus();
                              } else { //Se o cliente não estiver cadastrado, pode ser feito o cadastro dele.
                                if(d.insereClientes("clientes", valor, endereco.getText(), nome.getText(), bairro.getText())){
                                        JOptionPane.showMessageDialog(this, "Cliente cadastrado!");
                                        telefone.setText("");
                                        endereco.setText("");
                                        nome.setText("");
                                        bairro.setText("");
                                        telefone.requestFocus();
                                        avisos.setText("");
                                        TabelaClientes();
                                        numeroTotalClientes();
                                        limpaTodosCampos();
                                                                                                                              }
                                              }
                                } catch (SQLException ex){
                                    System.out.println(ex);
                                }
         }
                                                          }    
    }//GEN-LAST:event_bairroKeyPressed

    public void numeroTotalClientes(){
          DefaultTableModel modelotabela = (DefaultTableModel) Tabela.getModel();
          int numeroLinhas = Tabela.getRowCount();
          totalClientes.setText(String.valueOf(numeroLinhas));   
    }
    
    private void limpaTodosCampos(){
        telefone.setText("");
        nome.setText("");
        endereco.setText("");
        bairro.setText("");
    }
    
    private void telefoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_telefoneActionPerformed
    }//GEN-LAST:event_telefoneActionPerformed

    private void telefoneKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_telefoneKeyPressed
            if(evt.getKeyCode() == KeyEvent.VK_ENTER){ // Evento caso o enter seja pressionado.
            String valor = telefone.getText();
            valor = valor.replaceAll("-", "");
            int tam = valor.length();
                    if(tam <= 7 || tam > 9){  // Checagem se o tamanho do número de telefone informado é inválido.
            avisos.setText("Número de telefone inválido!");
            JOptionPane.showMessageDialog(this, "Digite um número de telefone válido!");
            nome.setText("");
            endereco.setText("");
            bairro.setText("");
            telefone.setText("");
            telefone.requestFocus();
                    } else if (tam >= 8 || tam < 9){ // Caso o número de telefone for válido.
                     String valorN = "1234567890-";
                     String t = telefone.getText();
        if(t.contains(valorN)){
            avisos.setText("Digite apenas números!");
        } else {          
            //Consulta o telefone digitado no banco.            
            ResultSet rs = d.consulta("select nome,endereco,bairro from clientes where telefone = '" + valor + "'"); 

            try{
                if(rs.next()){ // Se o cliente já estiver cadastrado, ele trás os dados do cliente nos campos de texto.
                    avisos.setText("Cliente cadastrado!");
                    nome.setText(rs.getString("nome"));
                    endereco.setText(rs.getString("endereco"));
                    bairro.setText(rs.getString("bairro")); 
                    btCadastra.setEnabled(false);
                } else { // Se o cliente não estiver cadastrado.
                    nome.setText("");
                    endereco.setText("");
                    bairro.setText("");
                    btCadastra.setText("Cadastrar");
                    btCadastra.setEnabled(true);
                    avisos.setText("Cliente não cadastrado, porfavor informe os dados do cliente!");
                    nome.requestFocus();
                    if(telefone.getText().isEmpty()){ // Realiza checagem se o campo de telefone tem algum telefone digitado.
                        telefone.requestFocus();
                        JOptionPane.showMessageDialog(this, "Porfavor, informe um número de telefone.");
                    }
                   
                }
            } catch(SQLException e){
                System.out.println(e);
            }
        }    
      }
     }
    }//GEN-LAST:event_telefoneKeyPressed

    private void btAlteraMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btAlteraMouseClicked
    AlteraClientes();
    limpaTodosCampos();
    avisos.setText("");
    telefone.requestFocus();
    }//GEN-LAST:event_btAlteraMouseClicked

    private void btAlteraMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btAlteraMousePressed
    AlteraClientes();
    limpaTodosCampos();
    avisos.setText("");
    telefone.requestFocus();
    }//GEN-LAST:event_btAlteraMousePressed

    private void btCadastraKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btCadastraKeyPressed
    //Pega o telefone digitado e remove o traço.
        String valor = telefone.getText();
           valor = valor.replaceAll("-", ""); 
                    //Checagem se nenhum campo está vázio.
                    if(telefone.getText().isEmpty() || endereco.getText().isEmpty() || nome.getText().isEmpty() || bairro.getText().isEmpty()){
                        JOptionPane.showMessageDialog(this, "Preencha todos os campos, porfavor!");
                        telefone.requestFocus();
                        } else { //Se nenhum campo estiver vázio, é realizado o cadastro/alteração de cliente(s).
                             try{
                                 //Consulta com telefone de cliente.
                                ResultSet rs = d.consulta("select telefone from clientes where telefone = '" + valor + "'");
                                if(rs.next()){ //Se o cliente já estiver cadastrado, é possível alterar o cadastro do cliente.
                                        AlteraClientes();
                                        limpaTodosCampos();
                                        avisos.setText("");
                                        telefone.requestFocus();
                              } else { //Se o cliente não estiver cadastrado, pode ser feito o cadastro dele.
                                if(d.insereClientes("clientes", valor, endereco.getText(), nome.getText(), bairro.getText())){
                                        JOptionPane.showMessageDialog(this, "Cliente cadastrado!");
                                        telefone.setText("");
                                        endereco.setText("");
                                        nome.setText("");
                                        bairro.setText("");
                                        telefone.requestFocus();
                                        avisos.setText("");
                                        TabelaClientes();
                                        numeroTotalClientes();
                                        limpaTodosCampos();
                                                                                                                              }
                                              }
                                } catch (SQLException ex){
                                    System.out.println(ex);
                                }
         }
                                                              
    }//GEN-LAST:event_btCadastraKeyPressed

    public void AlteraClientes(){
        String valor = telefone.getText();
        valor = valor.replaceAll("-", "");
        if(d.atualizaClientes("clientes",  "nome='"+nome.getText()+"',endereco='"+endereco.getText()+"',bairro='"+bairro.getText()+"'","telefone='"+valor+"'")){   
        JOptionPane.showMessageDialog(this, "Cadastro alterado!");
        TabelaClientes();
        } else {
            JOptionPane.showMessageDialog(this, "Erro ao alterar!");   
        }
    }
    
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
            java.util.logging.Logger.getLogger(Cadastra_AlteraCli.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Cadastra_AlteraCli.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Cadastra_AlteraCli.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Cadastra_AlteraCli.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Cadastra_AlteraCli cac = new Cadastra_AlteraCli();
                cac.setVisible(true);
                cac.setExtendedState(MAXIMIZED_BOTH);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Tabela;
    private javax.swing.JLabel avisos;
    private javax.swing.JTextField bairro;
    private javax.swing.JButton btAltera;
    private javax.swing.JButton btCadastra;
    private javax.swing.JTextField endereco;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField nome;
    private javax.swing.JTextField telefone;
    private javax.swing.JLabel totalClientes;
    // End of variables declaration//GEN-END:variables
}

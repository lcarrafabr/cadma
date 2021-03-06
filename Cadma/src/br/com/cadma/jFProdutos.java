/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * jFProdutos.java
 *
 * Created on 29/05/2010, 00:42:22
 */

package br.com.cadma;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Vitiazze
 */
public class jFProdutos extends javax.swing.JFrame {

    /** Creates new form jFProdutos */
    public jFProdutos() {
        initComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")

        public int codProduto;

    public ClassConecta conexao = new ClassConecta();

    public void getGradeSituacao() throws ParseException{
       //Consultar pedidos
        Produtos oProduto = new Produtos();

        ResultSet resultSet = null;

        String[] colunasTabela = new String[]{"Código", "Produto", "Quantidade", "Especificação", "Valor Unitário"};
        DefaultTableModel modeloTabela = new DefaultTableModel(null, colunasTabela) {

            @Override
            public boolean isCellEditable(int row, int col) {
                return false;
            }
        };
        gradeProdutojTable.setModel(modeloTabela);
        gradeProdutojTable.getColumnModel().getColumn(0).setPreferredWidth(10);
        gradeProdutojTable.getColumnModel().getColumn(1).setPreferredWidth(200);
        gradeProdutojTable.getColumnModel().getColumn(2).setPreferredWidth(10);
        gradeProdutojTable.getColumnModel().getColumn(3).setPreferredWidth(200);
        gradeProdutojTable.getColumnModel().getColumn(4).setPreferredWidth(40);

try {
            resultSet = oProduto.getConsultar(conexao);
            if (resultSet.getRow() == 1){
             resultSet.first();
            }


        } catch (SQLException ex) {
            Logger.getLogger(jFProdutos.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {

            while (resultSet.next()) {

                modeloTabela.addRow(new String[]{
                    Funcoes.getCodigoFormat(resultSet.getInt("codProduto")),
                    resultSet.getString("produto"),
                    resultSet.getString("quantidade"),
                    resultSet.getString("especificacao"),
                    resultSet.getString("valorUnit")
                });

            }

        } catch (SQLException ex) {
            Logger.getLogger(jFProdutos.class.getName()).log(Level.SEVERE, null, ex);
        }

           }

    public void getFieldProdutos(int codProdutos) throws ParseException{
        //Buscar produto
        Produtos oProduto = new Produtos();
        ResultSet rs = null;
        oProduto.setCodProduto(codProdutos);

        try {
            rs = oProduto.getConsultar(conexao);
            rs.next();

            //Pegar campos
            produtojTextField.setText(rs.getString("produto"));
            quantidadejTextField.setText(rs.getString("quantidade"));
            especificacaojTextField.setText(rs.getString("especificacao"));
            valorUnitjFormattedTextField.setText(rs.getString("valorUnit"));

        } catch (SQLException ex) {
            Logger.getLogger(Produtos.class.getName()).log(Level.SEVERE, null, ex);
        }



    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToolBar1 = new javax.swing.JToolBar();
        buscarjButton = new javax.swing.JButton();
        novojButton = new javax.swing.JButton();
        editarjButton = new javax.swing.JButton();
        salvarjButton = new javax.swing.JButton();
        alterarjButton = new javax.swing.JButton();
        excluirjButton = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        gradeProdutojTable = new javax.swing.JTable();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        codProdutojSpinner1 = new javax.swing.JSpinner();
        produtojTextField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        quantidadejTextField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        especificacaojTextField = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        valorUnitjFormattedTextField = new javax.swing.JFormattedTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance().getContext().getResourceMap(jFProdutos.class);
        setTitle(resourceMap.getString("Form.title")); // NOI18N
        setName("Form"); // NOI18N
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jToolBar1.setRollover(true);
        jToolBar1.setName("jToolBar1"); // NOI18N

        buscarjButton.setIcon(resourceMap.getIcon("buscarjButton.icon")); // NOI18N
        buscarjButton.setText(resourceMap.getString("buscarjButton.text")); // NOI18N
        buscarjButton.setFocusable(false);
        buscarjButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        buscarjButton.setName("buscarjButton"); // NOI18N
        buscarjButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        buscarjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarjButtonActionPerformed(evt);
            }
        });
        jToolBar1.add(buscarjButton);

        novojButton.setIcon(resourceMap.getIcon("novojButton.icon")); // NOI18N
        novojButton.setText(resourceMap.getString("novojButton.text")); // NOI18N
        novojButton.setFocusable(false);
        novojButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        novojButton.setName("novojButton"); // NOI18N
        novojButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        novojButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                novojButtonActionPerformed(evt);
            }
        });
        jToolBar1.add(novojButton);

        editarjButton.setIcon(resourceMap.getIcon("editarjButton.icon")); // NOI18N
        editarjButton.setText(resourceMap.getString("editarjButton.text")); // NOI18N
        editarjButton.setFocusable(false);
        editarjButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        editarjButton.setName("editarjButton"); // NOI18N
        editarjButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        editarjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editarjButtonActionPerformed(evt);
            }
        });
        jToolBar1.add(editarjButton);

        salvarjButton.setIcon(resourceMap.getIcon("salvarjButton.icon")); // NOI18N
        salvarjButton.setText(resourceMap.getString("salvarjButton.text")); // NOI18N
        salvarjButton.setFocusable(false);
        salvarjButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        salvarjButton.setName("salvarjButton"); // NOI18N
        salvarjButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        salvarjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salvarjButtonActionPerformed(evt);
            }
        });
        jToolBar1.add(salvarjButton);

        alterarjButton.setIcon(resourceMap.getIcon("alterarjButton.icon")); // NOI18N
        alterarjButton.setText(resourceMap.getString("alterarjButton.text")); // NOI18N
        alterarjButton.setFocusable(false);
        alterarjButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        alterarjButton.setName("alterarjButton"); // NOI18N
        alterarjButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        alterarjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                alterarjButtonActionPerformed(evt);
            }
        });
        jToolBar1.add(alterarjButton);

        excluirjButton.setIcon(resourceMap.getIcon("excluirjButton.icon")); // NOI18N
        excluirjButton.setText(resourceMap.getString("excluirjButton.text")); // NOI18N
        excluirjButton.setFocusable(false);
        excluirjButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        excluirjButton.setName("excluirjButton"); // NOI18N
        excluirjButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        excluirjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                excluirjButtonActionPerformed(evt);
            }
        });
        jToolBar1.add(excluirjButton);

        jButton6.setIcon(resourceMap.getIcon("jButton6.icon")); // NOI18N
        jButton6.setText(resourceMap.getString("jButton6.text")); // NOI18N
        jButton6.setFocusable(false);
        jButton6.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton6.setName("jButton6"); // NOI18N
        jButton6.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton6);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, resourceMap.getString("jPanel1.border.title"), javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), resourceMap.getColor("jPanel1.border.titleColor"))); // NOI18N
        jPanel1.setName("jPanel1"); // NOI18N

        jScrollPane1.setName("jScrollPane1"); // NOI18N

        gradeProdutojTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Produto", "Quantidade", "Especificação", "Valor Unitário"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        gradeProdutojTable.setName("gradeProdutojTable"); // NOI18N
        gradeProdutojTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                gradeProdutojTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(gradeProdutojTable);
        gradeProdutojTable.getColumnModel().getColumn(0).setResizable(false);
        gradeProdutojTable.getColumnModel().getColumn(0).setPreferredWidth(30);
        gradeProdutojTable.getColumnModel().getColumn(0).setHeaderValue(resourceMap.getString("gradeProdutojTable.columnModel.title0")); // NOI18N
        gradeProdutojTable.getColumnModel().getColumn(1).setResizable(false);
        gradeProdutojTable.getColumnModel().getColumn(1).setPreferredWidth(200);
        gradeProdutojTable.getColumnModel().getColumn(1).setHeaderValue(resourceMap.getString("gradeProdutojTable.columnModel.title1")); // NOI18N
        gradeProdutojTable.getColumnModel().getColumn(2).setResizable(false);
        gradeProdutojTable.getColumnModel().getColumn(2).setPreferredWidth(30);
        gradeProdutojTable.getColumnModel().getColumn(2).setHeaderValue(resourceMap.getString("gradeProdutojTable.columnModel.title2")); // NOI18N
        gradeProdutojTable.getColumnModel().getColumn(3).setResizable(false);
        gradeProdutojTable.getColumnModel().getColumn(3).setPreferredWidth(200);
        gradeProdutojTable.getColumnModel().getColumn(3).setHeaderValue(resourceMap.getString("gradeProdutojTable.columnModel.title3")); // NOI18N
        gradeProdutojTable.getColumnModel().getColumn(4).setResizable(false);
        gradeProdutojTable.getColumnModel().getColumn(4).setPreferredWidth(30);
        gradeProdutojTable.getColumnModel().getColumn(4).setHeaderValue(resourceMap.getString("gradeProdutojTable.columnModel.title4")); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 772, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 295, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.setName("jTabbedPane1"); // NOI18N

        jPanel2.setBackground(resourceMap.getColor("jPanel2.background")); // NOI18N
        jPanel2.setName("jPanel2"); // NOI18N

        jLabel1.setText(resourceMap.getString("jLabel1.text")); // NOI18N
        jLabel1.setName("jLabel1"); // NOI18N

        codProdutojSpinner1.setFont(resourceMap.getFont("codProdutojSpinner1.font")); // NOI18N
        codProdutojSpinner1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        codProdutojSpinner1.setName("codProdutojSpinner1"); // NOI18N

        produtojTextField.setText(resourceMap.getString("produtojTextField.text")); // NOI18N
        produtojTextField.setName("produtojTextField"); // NOI18N
        produtojTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                produtojTextFieldActionPerformed(evt);
            }
        });

        jLabel2.setText(resourceMap.getString("jLabel2.text")); // NOI18N
        jLabel2.setName("jLabel2"); // NOI18N

        quantidadejTextField.setText(resourceMap.getString("quantidadejTextField.text")); // NOI18N
        quantidadejTextField.setName("quantidadejTextField"); // NOI18N

        jLabel3.setText(resourceMap.getString("jLabel3.text")); // NOI18N
        jLabel3.setName("jLabel3"); // NOI18N

        especificacaojTextField.setText(resourceMap.getString("especificacaojTextField.text")); // NOI18N
        especificacaojTextField.setName("especificacaojTextField"); // NOI18N

        jLabel4.setText(resourceMap.getString("jLabel4.text")); // NOI18N
        jLabel4.setName("jLabel4"); // NOI18N

        jLabel5.setText(resourceMap.getString("jLabel5.text")); // NOI18N
        jLabel5.setName("jLabel5"); // NOI18N

        valorUnitjFormattedTextField.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#,##0.00"))));
        valorUnitjFormattedTextField.setText(resourceMap.getString("valorUnitjFormattedTextField.text")); // NOI18N
        valorUnitjFormattedTextField.setName("valorUnitjFormattedTextField"); // NOI18N
        valorUnitjFormattedTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                valorUnitjFormattedTextFieldActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(codProdutojSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(produtojTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(quantidadejTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(especificacaojTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(valorUnitjFormattedTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(codProdutojSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(produtojTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(quantidadejTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(especificacaojTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(valorUnitjFormattedTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(37, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab(resourceMap.getString("jPanel2.TabConstraints.tabTitle"), jPanel2); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, 818, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, 0, 0, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void novojButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_novojButtonActionPerformed
        // TODO add your handling code here:
        novojButton.setEnabled(false);
        alterarjButton.setEnabled(false);
        editarjButton.setEnabled(false);
        excluirjButton.setEnabled(false);
        buscarjButton.setEnabled(true);
        salvarjButton.setEnabled(true);
        codProdutojSpinner1.setEnabled(false);
        System.out.println("cheguei até aqui !!");
     

        try {
            conexao.con.setAutoCommit(false);
        } catch (SQLException ex) {
            Logger.getLogger(jFProdutos.class.getName()).log(Level.SEVERE, null, ex);
        }

         Funcoes.limpaCampos(jPanel1);

    }//GEN-LAST:event_novojButtonActionPerformed

    private void salvarjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salvarjButtonActionPerformed
        // TODO add your handling code here:
        salvarjButton.setEnabled(false);
        alterarjButton.setEnabled(false);
        excluirjButton.setEnabled(false);
        novojButton.setEnabled(true);
        editarjButton.setEnabled(true);

        System.out.println("chegueia ki");

        Produtos oProduto = new Produtos();
        oProduto.setProduto(produtojTextField.getText());
        oProduto.setQuantidade(Float.parseFloat(quantidadejTextField.getText()));
        oProduto.setEspecificacao(especificacaojTextField.getText());
        oProduto.setValorUnit(Float.parseFloat(valorUnitjFormattedTextField.getValue().toString()));
        oProduto.setCadastrar(conexao);

        System.out.println("ok");
        try {
            conexao.con.commit();
            conexao.con.setAutoCommit(true);
        } catch (SQLException ex) {
            Logger.getLogger(jFProdutos.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            getGradeSituacao();
        } catch (ParseException ex) {
            Logger.getLogger(jFProdutos.class.getName()).log(Level.SEVERE, null, ex);
        }

        produtojTextField.setText("");
        quantidadejTextField.setText("");
        especificacaojTextField.setText("");
        valorUnitjFormattedTextField.setText("");


    }//GEN-LAST:event_salvarjButtonActionPerformed

    private void buscarjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarjButtonActionPerformed
        // TODO add your handling code here:
        
        try {
           
            getGradeSituacao();
        } catch (ParseException ex) {
            Logger.getLogger(jFProdutos.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_buscarjButtonActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
        novojButton.setEnabled(true);
        alterarjButton.setEnabled(false);
        editarjButton.setEnabled(true);
        excluirjButton.setEnabled(false);
        buscarjButton.setEnabled(true);
        salvarjButton.setEnabled(false);
        produtojTextField.grabFocus();


        conexao.conecta();
        buscarjButtonActionPerformed(null);

    }//GEN-LAST:event_formWindowOpened

    private void editarjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editarjButtonActionPerformed
        // TODO add your handling code here:
        novojButton.setEnabled(false);
        salvarjButton.setEnabled(false);
        editarjButton.setEnabled(false);
        alterarjButton.setEnabled(true);
        excluirjButton.setEnabled(true);

        try {
            conexao.con.setAutoCommit(false);
        } catch (SQLException ex) {
            Logger.getLogger(jFProdutos.class.getName()).log(Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_editarjButtonActionPerformed

    private void alterarjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_alterarjButtonActionPerformed
        // TODO add your handling code here:
        alterarjButton.setEnabled(false);
        editarjButton.setEnabled(true);
        excluirjButton.setEnabled(false);
        novojButton.setEnabled(true);

        int codProdutos = 0;
        codProdutos = Integer.parseInt(gradeProdutojTable.getValueAt(gradeProdutojTable.getSelectedRow(), 0).toString());

        Produtos oProduto = new Produtos();
        oProduto.setCodProduto(codProdutos);
        System.out.println("inicio");
        oProduto.setProduto(produtojTextField.getText());
        System.out.println("produto");
        oProduto.setQuantidade(Float.parseFloat(quantidadejTextField.getText()));
        System.out.println("quantidade");
        oProduto.setEspecificacao(especificacaojTextField.getText());
        System.out.println("especificação");
        oProduto.setValorUnit(Float.parseFloat(valorUnitjFormattedTextField.getValue().toString()));
        System.out.println("Valor");
        oProduto.setAlterar(conexao);
        System.out.println("conexão");

        try {
            conexao.con.commit();
            conexao.con.setAutoCommit(true);
        } catch (SQLException ex) {
            Logger.getLogger(jFProdutos.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            getGradeSituacao();
        } catch (ParseException ex) {
            Logger.getLogger(jFProdutos.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_alterarjButtonActionPerformed

    private void excluirjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_excluirjButtonActionPerformed
        // TODO add your handling code here:
        Object[] options = {"Sim", "Não"};
        int sd =
                JOptionPane.showOptionDialog(
                null,
                "Deseja realmente EXCLUIR este contato?",
                "Confirmação!",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.WARNING_MESSAGE,
                null,
                options,
                options[0]);

        if (sd != 0) {
            return;
        }

        alterarjButton.setEnabled(false);
        editarjButton.setEnabled(true);
        excluirjButton.setEnabled(false);
        novojButton.setEnabled(true);

         int codSituacao = 0;
        codSituacao = Integer.parseInt(gradeProdutojTable.getValueAt(gradeProdutojTable.getSelectedRow(), 0).toString());

        Produtos oProdutos = new Produtos();
        oProdutos.setCodProduto(codSituacao);
        oProdutos.setExcluir(conexao);
        try {
            conexao.con.commit();
            conexao.con.setAutoCommit(true);
        } catch (SQLException ex) {
            Logger.getLogger(jFProdutos.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            getGradeSituacao();
        } catch (ParseException ex) {
            Logger.getLogger(jFProdutos.class.getName()).log(Level.SEVERE, null, ex);
        }

        Funcoes.limpaCampos(jPanel1);
        produtojTextField.setText("");
        quantidadejTextField.setText("");
        especificacaojTextField.setText("");
        valorUnitjFormattedTextField.setText("");
         
    }//GEN-LAST:event_excluirjButtonActionPerformed

       private void getField() throws SQLException{
        Produtos oProduto = new Produtos();
        oProduto.setCodProduto(codProduto);

        ResultSet rs = null;
        rs = oProduto.getConsultar(conexao);

        rs.first();

        codProdutojSpinner1.setValue(rs.getInt("codProduto"));
        produtojTextField.setText(rs.getString("produto"));
        quantidadejTextField.setText(rs.getString("quantidade"));
        especificacaojTextField.setText(rs.getString("especificacao"));
        valorUnitjFormattedTextField.setValue(rs.getDouble("valorUnit"));

    }

    private void gradeProdutojTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_gradeProdutojTableMouseClicked
        try {
            // TODO add your handling code here:
            editarjButton.setEnabled(true);
            codProduto = Integer.parseInt(gradeProdutojTable.getValueAt(gradeProdutojTable.getSelectedRow(), 0).toString());
            if (codProduto == 0) {
                return;
            }
            getField();
        } catch (SQLException ex) {
            Logger.getLogger(jFProdutos.class.getName()).log(Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_gradeProdutojTableMouseClicked

    private void produtojTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_produtojTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_produtojTextFieldActionPerformed

    private void valorUnitjFormattedTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_valorUnitjFormattedTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_valorUnitjFormattedTextFieldActionPerformed




    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new jFProdutos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton alterarjButton;
    private javax.swing.JButton buscarjButton;
    private javax.swing.JSpinner codProdutojSpinner1;
    private javax.swing.JButton editarjButton;
    private javax.swing.JTextField especificacaojTextField;
    private javax.swing.JButton excluirjButton;
    private javax.swing.JTable gradeProdutojTable;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JButton novojButton;
    private javax.swing.JTextField produtojTextField;
    private javax.swing.JTextField quantidadejTextField;
    private javax.swing.JButton salvarjButton;
    private javax.swing.JFormattedTextField valorUnitjFormattedTextField;
    // End of variables declaration//GEN-END:variables

}

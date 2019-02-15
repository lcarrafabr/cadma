/*
 * CadmaView.java
 */

package br.com.cadma;


import org.jdesktop.application.Action;
import org.jdesktop.application.ResourceMap;
import org.jdesktop.application.SingleFrameApplication;
import org.jdesktop.application.FrameView;
import org.jdesktop.application.TaskMonitor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;
import javax.swing.Icon;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * The application's main frame.
 */
public class CadmaView extends FrameView {

    public CadmaView(SingleFrameApplication app) {
        super(app);

        initComponents();

        // status bar initialization - message timeout, idle icon and busy animation, etc
        ResourceMap resourceMap = getResourceMap();
        int messageTimeout = resourceMap.getInteger("StatusBar.messageTimeout");
        messageTimer = new Timer(messageTimeout, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                statusMessageLabel.setText("");
            }
        });
        messageTimer.setRepeats(false);
        int busyAnimationRate = resourceMap.getInteger("StatusBar.busyAnimationRate");
        for (int i = 0; i < busyIcons.length; i++) {
            busyIcons[i] = resourceMap.getIcon("StatusBar.busyIcons[" + i + "]");
        }
        busyIconTimer = new Timer(busyAnimationRate, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                busyIconIndex = (busyIconIndex + 1) % busyIcons.length;
                statusAnimationLabel.setIcon(busyIcons[busyIconIndex]);
            }
        });
        idleIcon = resourceMap.getIcon("StatusBar.idleIcon");
        statusAnimationLabel.setIcon(idleIcon);
        progressBar.setVisible(false);

        // connecting action tasks to status bar via TaskMonitor
        TaskMonitor taskMonitor = new TaskMonitor(getApplication().getContext());
        taskMonitor.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                String propertyName = evt.getPropertyName();
                if ("started".equals(propertyName)) {
                    if (!busyIconTimer.isRunning()) {
                        statusAnimationLabel.setIcon(busyIcons[0]);
                        busyIconIndex = 0;
                        busyIconTimer.start();
                    }
                    progressBar.setVisible(true);
                    progressBar.setIndeterminate(true);
                } else if ("done".equals(propertyName)) {
                    busyIconTimer.stop();
                    statusAnimationLabel.setIcon(idleIcon);
                    progressBar.setVisible(false);
                    progressBar.setValue(0);
                } else if ("message".equals(propertyName)) {
                    String text = (String)(evt.getNewValue());
                    statusMessageLabel.setText((text == null) ? "" : text);
                    messageTimer.restart();
                } else if ("progress".equals(propertyName)) {
                    int value = (Integer)(evt.getNewValue());
                    progressBar.setVisible(true);
                    progressBar.setIndeterminate(false);
                    progressBar.setValue(value);
                }
            }
        });
    }

    @Action
    public void showAboutBox() {
        if (aboutBox == null) {
            JFrame mainFrame = CadmaApp.getApplication().getMainFrame();
            aboutBox = new CadmaAboutBox(mainFrame);
            aboutBox.setLocationRelativeTo(mainFrame);
        }
        CadmaApp.getApplication().show(aboutBox);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainPanel = new javax.swing.JPanel();
        jToolBar1 = new javax.swing.JToolBar();
        empresajButton = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        pedidosjButton = new javax.swing.JButton();
        produtosjButton = new javax.swing.JButton();
        sairjButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        menuBar = new javax.swing.JMenuBar();
        javax.swing.JMenu empresafileMenu = new javax.swing.JMenu();
        empresajMenuItem = new javax.swing.JMenuItem();
        clientejMenuItem = new javax.swing.JMenuItem();
        funcionariojMenuItem = new javax.swing.JMenuItem();
        pedidosjMenuItem = new javax.swing.JMenuItem();
        produtosjMenuItem = new javax.swing.JMenuItem();
        javax.swing.JMenuItem exitMenuItem = new javax.swing.JMenuItem();
        javax.swing.JMenu helpMenu = new javax.swing.JMenu();
        javax.swing.JMenuItem aboutMenuItem = new javax.swing.JMenuItem();
        statusPanel = new javax.swing.JPanel();
        javax.swing.JSeparator statusPanelSeparator = new javax.swing.JSeparator();
        statusMessageLabel = new javax.swing.JLabel();
        statusAnimationLabel = new javax.swing.JLabel();
        progressBar = new javax.swing.JProgressBar();

        mainPanel.setName("mainPanel"); // NOI18N

        jToolBar1.setRollover(true);
        jToolBar1.setName("jToolBar1"); // NOI18N

        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance().getContext().getResourceMap(CadmaView.class);
        empresajButton.setIcon(resourceMap.getIcon("empresajButton.icon")); // NOI18N
        empresajButton.setText(resourceMap.getString("empresajButton.text")); // NOI18N
        empresajButton.setFocusable(false);
        empresajButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        empresajButton.setName("empresajButton"); // NOI18N
        empresajButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        empresajButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                empresajButtonActionPerformed(evt);
            }
        });
        jToolBar1.add(empresajButton);

        jButton1.setIcon(resourceMap.getIcon("jButton1.icon")); // NOI18N
        jButton1.setText(resourceMap.getString("jButton1.text")); // NOI18N
        jButton1.setFocusable(false);
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton1.setName("jButton1"); // NOI18N
        jButton1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton1);

        jButton2.setIcon(resourceMap.getIcon("jButton2.icon")); // NOI18N
        jButton2.setText(resourceMap.getString("jButton2.text")); // NOI18N
        jButton2.setFocusable(false);
        jButton2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton2.setName("jButton2"); // NOI18N
        jButton2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton2);

        pedidosjButton.setIcon(resourceMap.getIcon("pedidosjButton.icon")); // NOI18N
        pedidosjButton.setText(resourceMap.getString("pedidosjButton.text")); // NOI18N
        pedidosjButton.setFocusable(false);
        pedidosjButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        pedidosjButton.setName("pedidosjButton"); // NOI18N
        pedidosjButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        pedidosjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pedidosjButtonActionPerformed(evt);
            }
        });
        jToolBar1.add(pedidosjButton);

        produtosjButton.setIcon(resourceMap.getIcon("produtosjButton.icon")); // NOI18N
        produtosjButton.setText(resourceMap.getString("produtosjButton.text")); // NOI18N
        produtosjButton.setFocusable(false);
        produtosjButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        produtosjButton.setName("produtosjButton"); // NOI18N
        produtosjButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        produtosjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                produtosjButtonActionPerformed(evt);
            }
        });
        jToolBar1.add(produtosjButton);

        sairjButton.setIcon(resourceMap.getIcon("sairjButton.icon")); // NOI18N
        sairjButton.setText(resourceMap.getString("sairjButton.text")); // NOI18N
        sairjButton.setFocusable(false);
        sairjButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        sairjButton.setName("sairjButton"); // NOI18N
        sairjButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        sairjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sairjButtonActionPerformed(evt);
            }
        });
        jToolBar1.add(sairjButton);

        jLabel1.setIcon(resourceMap.getIcon("jLabel1.icon")); // NOI18N
        jLabel1.setText(resourceMap.getString("jLabel1.text")); // NOI18N
        jLabel1.setName("jLabel1"); // NOI18N

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, 857, Short.MAX_VALUE)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel1)
                .addContainerGap(43, Short.MAX_VALUE))
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(143, 143, 143)
                .addComponent(jLabel1)
                .addContainerGap(185, Short.MAX_VALUE))
        );

        menuBar.setName("menuBar"); // NOI18N

        empresafileMenu.setText(resourceMap.getString("empresafileMenu.text")); // NOI18N
        empresafileMenu.setName("empresafileMenu"); // NOI18N
        empresafileMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                empresafileMenuActionPerformed(evt);
            }
        });

        empresajMenuItem.setIcon(resourceMap.getIcon("empresajMenuItem.icon")); // NOI18N
        empresajMenuItem.setText(resourceMap.getString("empresajMenuItem.text")); // NOI18N
        empresajMenuItem.setName("empresajMenuItem"); // NOI18N
        empresajMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                empresajMenuItemActionPerformed(evt);
            }
        });
        empresafileMenu.add(empresajMenuItem);

        clientejMenuItem.setIcon(resourceMap.getIcon("clientejMenuItem.icon")); // NOI18N
        clientejMenuItem.setText(resourceMap.getString("clientejMenuItem.text")); // NOI18N
        clientejMenuItem.setName("clientejMenuItem"); // NOI18N
        clientejMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clientejMenuItemActionPerformed(evt);
            }
        });
        empresafileMenu.add(clientejMenuItem);

        funcionariojMenuItem.setIcon(resourceMap.getIcon("funcionariojMenuItem.icon")); // NOI18N
        funcionariojMenuItem.setText(resourceMap.getString("funcionariojMenuItem.text")); // NOI18N
        funcionariojMenuItem.setName("funcionariojMenuItem"); // NOI18N
        funcionariojMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                funcionariojMenuItemActionPerformed(evt);
            }
        });
        empresafileMenu.add(funcionariojMenuItem);

        pedidosjMenuItem.setIcon(resourceMap.getIcon("pedidosjMenuItem.icon")); // NOI18N
        pedidosjMenuItem.setText(resourceMap.getString("pedidosjMenuItem.text")); // NOI18N
        pedidosjMenuItem.setName("pedidosjMenuItem"); // NOI18N
        pedidosjMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pedidosjMenuItemActionPerformed(evt);
            }
        });
        empresafileMenu.add(pedidosjMenuItem);

        produtosjMenuItem.setIcon(resourceMap.getIcon("produtosjMenuItem.icon")); // NOI18N
        produtosjMenuItem.setText(resourceMap.getString("produtosjMenuItem.text")); // NOI18N
        produtosjMenuItem.setName("produtosjMenuItem"); // NOI18N
        produtosjMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                produtosjMenuItemActionPerformed(evt);
            }
        });
        empresafileMenu.add(produtosjMenuItem);

        javax.swing.ActionMap actionMap = org.jdesktop.application.Application.getInstance().getContext().getActionMap(CadmaView.class, this);
        exitMenuItem.setAction(actionMap.get("quit")); // NOI18N
        exitMenuItem.setIcon(resourceMap.getIcon("exitMenuItem.icon")); // NOI18N
        exitMenuItem.setText(resourceMap.getString("exitMenuItem.text")); // NOI18N
        exitMenuItem.setName("exitMenuItem"); // NOI18N
        empresafileMenu.add(exitMenuItem);

        menuBar.add(empresafileMenu);

        helpMenu.setText(resourceMap.getString("helpMenu.text")); // NOI18N
        helpMenu.setName("helpMenu"); // NOI18N

        aboutMenuItem.setAction(actionMap.get("showAboutBox")); // NOI18N
        aboutMenuItem.setText(resourceMap.getString("aboutMenuItem.text")); // NOI18N
        aboutMenuItem.setName("aboutMenuItem"); // NOI18N
        helpMenu.add(aboutMenuItem);

        menuBar.add(helpMenu);

        statusPanel.setName("statusPanel"); // NOI18N

        statusPanelSeparator.setName("statusPanelSeparator"); // NOI18N

        statusMessageLabel.setName("statusMessageLabel"); // NOI18N

        statusAnimationLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        statusAnimationLabel.setName("statusAnimationLabel"); // NOI18N

        progressBar.setName("progressBar"); // NOI18N

        javax.swing.GroupLayout statusPanelLayout = new javax.swing.GroupLayout(statusPanel);
        statusPanel.setLayout(statusPanelLayout);
        statusPanelLayout.setHorizontalGroup(
            statusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(statusPanelSeparator, javax.swing.GroupLayout.DEFAULT_SIZE, 857, Short.MAX_VALUE)
            .addGroup(statusPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(statusMessageLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 687, Short.MAX_VALUE)
                .addComponent(progressBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(statusAnimationLabel)
                .addContainerGap())
        );
        statusPanelLayout.setVerticalGroup(
            statusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(statusPanelLayout.createSequentialGroup()
                .addComponent(statusPanelSeparator, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(statusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(statusMessageLabel)
                    .addComponent(statusAnimationLabel)
                    .addComponent(progressBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(3, 3, 3))
        );

        setComponent(mainPanel);
        setMenuBar(menuBar);
        setStatusBar(statusPanel);
    }// </editor-fold>//GEN-END:initComponents

    private void empresajButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_empresajButtonActionPerformed
        // TODO add your handling code here:
        JEmpresa oEmpresa = new JEmpresa();
        oEmpresa.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        oEmpresa.pack();
        oEmpresa.setLocationRelativeTo(null);
        oEmpresa.setVisible(true);

    }//GEN-LAST:event_empresajButtonActionPerformed

    private void empresafileMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_empresafileMenuActionPerformed
        // TODO add your handling code here:
        JEmpresa oEmpresa = new JEmpresa();
        oEmpresa.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        oEmpresa.pack();
        oEmpresa.setLocationRelativeTo(null);
        oEmpresa.setVisible(true);
    }//GEN-LAST:event_empresafileMenuActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        jFClientes oCliente = new jFClientes();
        oCliente.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        oCliente.pack();
        oCliente.setLocationRelativeTo(null);
        oCliente.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        jFFuncionarios oFuncionario = new jFFuncionarios();
        oFuncionario.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        oFuncionario.pack();
        oFuncionario.setLocationRelativeTo(null);
        oFuncionario.setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void pedidosjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pedidosjButtonActionPerformed
        // TODO add your handling code here:
        jFPedidos oPedido = new jFPedidos();
        oPedido.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        oPedido.pack();
        oPedido.setLocationRelativeTo(null);
        oPedido.setVisible(true);
    }//GEN-LAST:event_pedidosjButtonActionPerformed

    private void produtosjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_produtosjButtonActionPerformed
        // TODO add your handling code here:
        jFProdutos oProduto = new jFProdutos();
        oProduto.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        oProduto.pack();
        oProduto.setLocationRelativeTo(null);
        oProduto.setVisible(true);
    }//GEN-LAST:event_produtosjButtonActionPerformed

    private void sairjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sairjButtonActionPerformed
        // TODO add your handling code here:
         Object[] options = {"Sim", "Não"};
        int sd =
                JOptionPane.showOptionDialog(
                null,
                "Deseja realmente sair?",
                "Confirmação!",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.INFORMATION_MESSAGE,
                null,
                options,
                options[0]);

        if (sd != 0) {
            return;
        }
        System.exit(0);
    }//GEN-LAST:event_sairjButtonActionPerformed

    private void clientejMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clientejMenuItemActionPerformed
        // TODO add your handling code here:
        jFClientes oCliente = new jFClientes();
        oCliente.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        oCliente.pack();
        oCliente.setLocationRelativeTo(null);
        oCliente.setVisible(true);

    }//GEN-LAST:event_clientejMenuItemActionPerformed

    private void pedidosjMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pedidosjMenuItemActionPerformed
        // TODO add your handling code here:
        jFPedidos oPedido = new jFPedidos();
        oPedido.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        oPedido.pack();
        oPedido.setLocationRelativeTo(null);
        oPedido.setVisible(true);

    }//GEN-LAST:event_pedidosjMenuItemActionPerformed

    private void produtosjMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_produtosjMenuItemActionPerformed
        // TODO add your handling code here:
        jFProdutos oProduto = new jFProdutos();
        oProduto.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        oProduto.pack();
        oProduto.setLocationRelativeTo(null);
        oProduto.setVisible(true);
    }//GEN-LAST:event_produtosjMenuItemActionPerformed

    private void funcionariojMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_funcionariojMenuItemActionPerformed
        // TODO add your handling code here:
        jFFuncionarios oFuncionario = new jFFuncionarios();
        oFuncionario.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        oFuncionario.pack();
        oFuncionario.setLocationRelativeTo(null);
        oFuncionario.setVisible(true);
    }//GEN-LAST:event_funcionariojMenuItemActionPerformed

    private void empresajMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_empresajMenuItemActionPerformed
        // TODO add your handling code here:
        JEmpresa oEmpresa = new JEmpresa();
        oEmpresa.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        oEmpresa.pack();
        oEmpresa.setLocationRelativeTo(null);
        oEmpresa.setVisible(true);
    }//GEN-LAST:event_empresajMenuItemActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem clientejMenuItem;
    private javax.swing.JButton empresajButton;
    private javax.swing.JMenuItem empresajMenuItem;
    private javax.swing.JMenuItem funcionariojMenuItem;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JButton pedidosjButton;
    private javax.swing.JMenuItem pedidosjMenuItem;
    private javax.swing.JButton produtosjButton;
    private javax.swing.JMenuItem produtosjMenuItem;
    private javax.swing.JProgressBar progressBar;
    private javax.swing.JButton sairjButton;
    private javax.swing.JLabel statusAnimationLabel;
    private javax.swing.JLabel statusMessageLabel;
    private javax.swing.JPanel statusPanel;
    // End of variables declaration//GEN-END:variables

    private final Timer messageTimer;
    private final Timer busyIconTimer;
    private final Icon idleIcon;
    private final Icon[] busyIcons = new Icon[15];
    private int busyIconIndex = 0;

    private JDialog aboutBox;
}
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package aplicacao;

import dao.CanetaDAO;
import dao.DAOFactory;
import dao.ModeloDAO;
import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import modelo.Caneta;
import modelo.Modelo;

/**
 *
 * @author fabiomacz
 */
public class frmCaneta extends javax.swing.JFrame {

    private Caneta caneta;
    CanetaDAO canetaDAO = DAOFactory.criarCanetaDAO();
    ModeloDAO modeloDAO = DAOFactory.criarModeloDAO();
    
    public frmCaneta(Caneta caneta) {
        initComponents();
        
        carregarCombo();
        
        this.caneta = caneta;
        if (this.caneta != null) {
            btnSalvar.setText("Editar");
            //txtModelo.setText(this.caneta.getModelo());
            
            String cor = this.caneta.getCor();
            if (cor.equalsIgnoreCase(rbAzul.getText())) {
                rbAzul.setSelected(true);
            } else if (cor.equalsIgnoreCase(rbVermelha.getText())) {
                rbVermelha.setSelected(true);
            } else if (cor.equalsIgnoreCase(rbPreta.getText())) {
                rbPreta.setSelected(true);
            } else if (cor.equalsIgnoreCase(rbVerde.getText())) {
                rbVerde.setSelected(true);
            }
            
            Float ponta = this.caneta.getPonta();
            if (ponta == (Float.parseFloat(rb07.getText()))) {
                rb07.setSelected(true);
            } else if (ponta == (Float.parseFloat(rb10.getText()))) {
                rb10.setSelected(true);
            } else if (ponta == (Float.parseFloat(rb14.getText()))) {
                rb14.setSelected(true);
            } else if (ponta == (Float.parseFloat(rb16.getText()))) {
                rb16.setSelected(true);
            }
            
            jSlider1.setValue(this.caneta.getCarga());
            
            
            if (this.caneta.isTampada()) {
                rbTampada.setSelected(true);
            } else {
                rbDestampada.setSelected(true);
            }
        } else {
            btnSalvar.setText("Inserir");
        }
    }
    
    private void carregarCombo() {
        try {
            Vector<Modelo> modelos = new Vector<>(modeloDAO.listar());
            DefaultComboBoxModel comboModel = new DefaultComboBoxModel(modelos);
            cbModelo.setModel(comboModel);
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Erro ao carregar a lista de Modelos");
        }
    }
    
    private void inserir() {
        Caneta canetaInserida = new Caneta();
        canetaInserida.setModelo((Modelo) cbModelo.getSelectedItem());
        
        if (rbAzul.isSelected()) {
            canetaInserida.setCor(rbAzul.getText());
        } else if (rbVermelha.isSelected()) {
            canetaInserida.setCor(rbVermelha.getText());
        } else if (rbPreta.isSelected()) {
            canetaInserida.setCor(rbPreta.getText());
        } else {
            canetaInserida.setCor(rbVerde.getText());
        }

        if (rb07.isSelected()) {
            canetaInserida.setPonta(Float.parseFloat(rb07.getText()));
        } else if (rb10.isSelected()) {
            canetaInserida.setPonta(Float.parseFloat(rb10.getText()));
        } else if (rb14.isSelected()) {
            canetaInserida.setPonta(Float.parseFloat(rb14.getText()));
        } else {
            canetaInserida.setPonta(Float.parseFloat(rb16.getText()));
        }

        canetaInserida.setCarga(Integer.parseInt(lblCarga.getText()));
        canetaInserida.setTampada(rbTampada.isSelected());
        
        int linha = canetaDAO.inserir(canetaInserida);
        if (linha > 0) {
            JOptionPane.showMessageDialog(this, "Caneta inserida com sucesso!");
        } else {
            JOptionPane.showMessageDialog(this, "Erro ao inserir Caneta.");
        } 
    }
    
    private void editar() {
        Caneta canetaEditada = new Caneta();
        canetaEditada.setCodigo(caneta.getCodigo());
        canetaEditada.setModelo((Modelo) cbModelo.getSelectedItem());
        if (rbAzul.isSelected()) {
            canetaEditada.setCor(rbAzul.getText());
        } else if (rbVermelha.isSelected()) {
            canetaEditada.setCor(rbVermelha.getText());
        } else if (rbPreta.isSelected()) {
            canetaEditada.setCor(rbPreta.getText());
        } else {
            canetaEditada.setCor(rbVerde.getText());
        }

        if (rb07.isSelected()) {
            canetaEditada.setPonta(Float.parseFloat(rb07.getText()));
        } else if (rb10.isSelected()) {
            canetaEditada.setPonta(Float.parseFloat(rb10.getText()));
        } else if (rb14.isSelected()) {
            canetaEditada.setPonta(Float.parseFloat(rb14.getText()));
        } else {
            canetaEditada.setPonta(Float.parseFloat(rb16.getText()));
        }

        canetaEditada.setCarga(Integer.parseInt(lblCarga.getText()));
        canetaEditada.setTampada(rbTampada.isSelected());
        
        int linha = canetaDAO.editar(canetaEditada);
        if (linha > 0) {
            JOptionPane.showMessageDialog(this, "Caneta editado com sucesso!");
        } else {
            JOptionPane.showMessageDialog(this, "Erro ao editar Caneta.");
        }
    }
    
    private void cancelar() {
        Object[] opcao = {"Não", "Sim"};
        int opcaoSelecionada = JOptionPane.showOptionDialog(this, "Deseja realmente sair?", "Aviso",
                JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, opcao, opcao[0]);
        if (opcaoSelecionada == 1) {
            this.dispose();
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup3 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        rbAzul = new javax.swing.JRadioButton();
        rbVermelha = new javax.swing.JRadioButton();
        rbPreta = new javax.swing.JRadioButton();
        rbVerde = new javax.swing.JRadioButton();
        jLabel3 = new javax.swing.JLabel();
        rb07 = new javax.swing.JRadioButton();
        rb10 = new javax.swing.JRadioButton();
        rb16 = new javax.swing.JRadioButton();
        rb14 = new javax.swing.JRadioButton();
        jLabel4 = new javax.swing.JLabel();
        lblCarga = new javax.swing.JLabel();
        jSlider1 = new javax.swing.JSlider();
        jLabel5 = new javax.swing.JLabel();
        rbDestampada = new javax.swing.JRadioButton();
        rbTampada = new javax.swing.JRadioButton();
        btnSalvar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        cbModelo = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Modelo:");

        jLabel2.setText("Cor:");

        buttonGroup1.add(rbAzul);
        rbAzul.setText("Azul");
        rbAzul.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbAzulActionPerformed(evt);
            }
        });

        buttonGroup1.add(rbVermelha);
        rbVermelha.setText("Vermelha");

        buttonGroup1.add(rbPreta);
        rbPreta.setText("Preta");

        buttonGroup1.add(rbVerde);
        rbVerde.setText("Verde");

        jLabel3.setText("Ponta:");

        buttonGroup2.add(rb07);
        rb07.setText("0.7");

        buttonGroup2.add(rb10);
        rb10.setText("1.0");

        buttonGroup2.add(rb16);
        rb16.setText("1.6");

        buttonGroup2.add(rb14);
        rb14.setText("1.4");
        rb14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb14ActionPerformed(evt);
            }
        });

        jLabel4.setText("Carga:");

        lblCarga.setText("50");

        jSlider1.setPaintLabels(true);
        jSlider1.setPaintTicks(true);
        jSlider1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSlider1StateChanged(evt);
            }
        });

        jLabel5.setText("Estado:");

        buttonGroup3.add(rbDestampada);
        rbDestampada.setText("Destampada");
        rbDestampada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbDestampadaActionPerformed(evt);
            }
        });

        buttonGroup3.add(rbTampada);
        rbTampada.setText("Tampada");
        rbTampada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbTampadaActionPerformed(evt);
            }
        });

        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel3)
                        .addGap(6, 6, 6)
                        .addComponent(rb07)
                        .addGap(12, 12, 12)
                        .addComponent(rb10)
                        .addGap(6, 6, 6)
                        .addComponent(rb14)
                        .addGap(6, 6, 6)
                        .addComponent(rb16))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel4)
                        .addGap(6, 6, 6)
                        .addComponent(jSlider1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(lblCarga))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel5)
                        .addGap(6, 6, 6)
                        .addComponent(rbTampada)
                        .addGap(36, 36, 36)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnSalvar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(rbDestampada)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel2)
                        .addGap(17, 17, 17)
                        .addComponent(rbAzul)
                        .addGap(6, 6, 6)
                        .addComponent(rbVermelha)
                        .addGap(6, 6, 6)
                        .addComponent(rbPreta)
                        .addGap(18, 18, 18)
                        .addComponent(rbVerde))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbModelo, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cbModelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(jLabel2))
                    .addComponent(rbAzul)
                    .addComponent(rbVermelha)
                    .addComponent(rbPreta)
                    .addComponent(rbVerde))
                .addGap(6, 6, 6)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(jLabel3))
                    .addComponent(rb07)
                    .addComponent(rb10)
                    .addComponent(rb14)
                    .addComponent(rb16))
                .addGap(6, 6, 6)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSlider1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(lblCarga))))
                .addGap(6, 6, 6)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(jLabel5))
                    .addComponent(rbTampada)
                    .addComponent(rbDestampada))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSalvar)
                    .addComponent(btnCancelar))
                .addGap(24, 24, 24))
        );

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recurso/tanjiro2.png"))); // NOI18N
        jLabel6.setOpaque(true);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(37, Short.MAX_VALUE)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void rbAzulActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbAzulActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rbAzulActionPerformed

    private void rb14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb14ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rb14ActionPerformed

    private void jSlider1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSlider1StateChanged
        // TODO add your handling code here:
        lblCarga.setText(String.valueOf(jSlider1.getValue()));
    }//GEN-LAST:event_jSlider1StateChanged

    private void rbDestampadaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbDestampadaActionPerformed

    }//GEN-LAST:event_rbDestampadaActionPerformed

    private void rbTampadaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbTampadaActionPerformed

    }//GEN-LAST:event_rbTampadaActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        if (caneta != null) {
            editar();
        } else {
            inserir();
        }
        dispose();

    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        Object[] opcao = {"Não", "Sim"};
        int opcaoSelecionada = JOptionPane.showOptionDialog(this, "Deseja realmente cancelar?", "Aviso",
                JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, opcao, opcao[0]);
        if (opcaoSelecionada == 1) {
            dispose();
        }
    }//GEN-LAST:event_btnCancelarActionPerformed

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
            java.util.logging.Logger.getLogger(frmCaneta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmCaneta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmCaneta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmCaneta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmCaneta(null).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnSalvar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.JComboBox<String> cbModelo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSlider jSlider1;
    private javax.swing.JLabel lblCarga;
    private javax.swing.JRadioButton rb07;
    private javax.swing.JRadioButton rb10;
    private javax.swing.JRadioButton rb14;
    private javax.swing.JRadioButton rb16;
    private javax.swing.JRadioButton rbAzul;
    private javax.swing.JRadioButton rbDestampada;
    private javax.swing.JRadioButton rbPreta;
    private javax.swing.JRadioButton rbTampada;
    private javax.swing.JRadioButton rbVerde;
    private javax.swing.JRadioButton rbVermelha;
    // End of variables declaration//GEN-END:variables
}

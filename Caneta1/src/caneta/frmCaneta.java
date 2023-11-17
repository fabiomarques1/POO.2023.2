
package caneta;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class frmCaneta extends javax.swing.JFrame {
    
    Caneta caneta = new Caneta();
    ArrayList<Caneta> canetas = new ArrayList();
    DefaultTableModel modelo;

    public frmCaneta() throws FileNotFoundException {

    
        initComponents();
        modelo = (DefaultTableModel) tblCaneta.getModel();
        modelo.addColumn("Modelo");
        modelo.addColumn("Cor");
        modelo.addColumn("Ponta");
        modelo.addColumn("Carga");
        modelo.addColumn("Tampada");
        
        modelo.getDataVector().clear();
        
        File csvFile = new File("teste.csv");
        Scanner scanner = new Scanner(csvFile);
        while (scanner.hasNext()) {
            String[] line = scanner.nextLine().split(",");
            Caneta c = new Caneta();
            c.modelo = line[0];
            c.cor = line[1];
            c.ponta = Float.parseFloat(line[2]);
            c.carga = Integer.parseInt(line[3]);
            c.tampada = Boolean.parseBoolean(line[4]);
            canetas.add(c);
            
            modelo.addRow(new Object[]{c.modelo, c.cor,
                            c.ponta, c.carga, c.tampada});
            
        }
        

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        grupoCor = new javax.swing.ButtonGroup();
        grupoPonta = new javax.swing.ButtonGroup();
        grupoEstado = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtModelo = new javax.swing.JTextField();
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
        jScrollPane1 = new javax.swing.JScrollPane();
        tblCaneta = new javax.swing.JTable();
        btnCadastrar1 = new javax.swing.JButton();
        btnExibir1 = new javax.swing.JButton();
        btnSair = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Modelo:");

        jLabel2.setText("Cor:");

        grupoCor.add(rbAzul);
        rbAzul.setText("Azul");
        rbAzul.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbAzulActionPerformed(evt);
            }
        });

        grupoCor.add(rbVermelha);
        rbVermelha.setText("Vermelha");

        grupoCor.add(rbPreta);
        rbPreta.setText("Preta");

        grupoCor.add(rbVerde);
        rbVerde.setText("Verde");

        jLabel3.setText("Ponta:");

        grupoPonta.add(rb07);
        rb07.setText("0.7");

        grupoPonta.add(rb10);
        rb10.setText("1.0");

        grupoPonta.add(rb16);
        rb16.setText("1.6");

        grupoPonta.add(rb14);
        rb14.setText("1.4");

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

        grupoEstado.add(rbDestampada);
        rbDestampada.setText("Destampada");
        rbDestampada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbDestampadaActionPerformed(evt);
            }
        });

        grupoEstado.add(rbTampada);
        rbTampada.setText("Tampada");
        rbTampada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbTampadaActionPerformed(evt);
            }
        });

        tblCaneta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tblCaneta);

        btnCadastrar1.setText("Cadastrar");
        btnCadastrar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrar1ActionPerformed(evt);
            }
        });

        btnExibir1.setText("Exibir");
        btnExibir1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExibir1ActionPerformed(evt);
            }
        });

        btnSair.setText("Sair");
        btnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnCadastrar1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnExibir1, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSair, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                            .addComponent(rbDestampada))
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
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(6, 6, 6)
                            .addComponent(jLabel1)
                            .addGap(6, 6, 6)
                            .addComponent(txtModelo, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(12, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel1))
                    .addComponent(txtModelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCadastrar1)
                    .addComponent(btnExibir1)
                    .addComponent(btnSair))
                .addGap(102, 102, 102))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 470, 380));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void rbAzulActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbAzulActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rbAzulActionPerformed

    private void jSlider1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSlider1StateChanged
        // TODO add your handling code here:
        lblCarga.setText(String.valueOf(jSlider1.getValue()));
    }//GEN-LAST:event_jSlider1StateChanged

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
        
        try {
            PrintWriter writer = new PrintWriter(new File("teste.csv"));
            StringBuilder sb = new StringBuilder();
            
            for (Caneta caneta : canetas) {
                
                sb.append(caneta.modelo + "," + caneta.cor + "," + caneta.ponta 
                        + "," + caneta.carga + "," + caneta.tampada + "\n");
            }
            
            writer.write(sb.toString());
            writer.close();
            System.out.println("done!");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(frmCaneta.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        System.exit(0);
    }//GEN-LAST:event_btnSairActionPerformed

    private void btnCadastrar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrar1ActionPerformed
       
        caneta.modelo = txtModelo.getText();
        if (rbAzul.isSelected()) {
            caneta.cor = rbAzul.getText();
        } else if (rbVermelha.isSelected()) {
            caneta.cor = rbVermelha.getText();
        } else if (rbPreta.isSelected()) {
            caneta.cor = rbPreta.getText();
        } else {
            caneta.cor = rbVerde.getText();
        }
        
        if (rb07.isSelected()) {
            caneta.ponta = Float.parseFloat(rb07.getText());
        } else if (rb10.isSelected()) {
            caneta.ponta = Float.parseFloat(rb10.getText());
        } else if (rb14.isSelected()) {
            caneta.ponta = Float.parseFloat(rb14.getText());
        } else {
            caneta.ponta = Float.parseFloat(rb16.getText());
        }
        
        caneta.carga = Integer.parseInt(lblCarga.getText());
        
        canetas.add(caneta);
        
        modelo.addRow(new Object[]{caneta.modelo, caneta.cor,
                            caneta.ponta, caneta.carga, caneta.tampada});
        
        caneta = new Caneta();
 
    }//GEN-LAST:event_btnCadastrar1ActionPerformed

    private void btnExibir1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExibir1ActionPerformed
        JOptionPane.showMessageDialog(this, caneta);
    }//GEN-LAST:event_btnExibir1ActionPerformed

    private void rbTampadaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbTampadaActionPerformed
        int erro = caneta.tampar();
        if (erro > 0) {
            JOptionPane.showMessageDialog(this, "A caneta JÁ está TAMPADA!!!");
        }
    }//GEN-LAST:event_rbTampadaActionPerformed

    private void rbDestampadaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbDestampadaActionPerformed
        int erro = caneta.destampar();
        if (erro > 0) {
            JOptionPane.showMessageDialog(this, "A caneta JÁ está DEStampada!!!");
        }
    }//GEN-LAST:event_rbDestampadaActionPerformed



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCadastrar1;
    private javax.swing.JButton btnExibir1;
    private javax.swing.JButton btnSair;
    private javax.swing.ButtonGroup grupoCor;
    private javax.swing.ButtonGroup grupoEstado;
    private javax.swing.ButtonGroup grupoPonta;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
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
    private javax.swing.JTable tblCaneta;
    private javax.swing.JTextField txtModelo;
    // End of variables declaration//GEN-END:variables
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import controller.NasabahController;
import java.io.File;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.HashMap;
import java.util.List;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JRViewer;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Toshiba
 */
public class ViewLaporanNasabah extends javax.swing.JInternalFrame {

    /**
     * Creates new form ViewLaporanNasabah
     */
    private String header[] = {"NIK", "Nama Nasabah", "Tanggal Lahir", "Pekerjaan",
        "Alamat", "Status", "Penghasilan", "No Polis", "ID Admin"};
    public NasabahController nc;

    public ViewLaporanNasabah() {
        initComponents();
        nc = new NasabahController();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cmbCari = new javax.swing.JComboBox<>();
        txtCari = new javax.swing.JTextField();
        btn_cetaklaporan = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();

        setClosable(true);
        setMaximizable(true);
        setResizable(true);

        cmbCari.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nama", "ID Admin", "Nomor Polis" }));

        btn_cetaklaporan.setText("Cetak Laporan");
        btn_cetaklaporan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cetaklaporanActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(cmbCari, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCari, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_cetaklaporan)
                        .addGap(0, 148, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbCari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_cetaklaporan))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 390, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_cetaklaporanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cetaklaporanActionPerformed
        // TODO add your handling code here:
        if (txtCari.getText().equals("")) {
              try {
            String path = "report/ReportNasabahWithoutWhere.jasper";
            String driver="oracle.jdbc.OracleDriver";
            String konek="jdbc:oracle:thin:@localhost:1521:XE";
            String user="system";
            String password="root";
            
            HashMap parameter = new HashMap();
            Class.forName(driver);
            Connection conn = DriverManager.getConnection(konek,user,password);
            File reportFile=new File(path);
//            parameter.put("kategori", txtCari.getText());
            InputStream jReport = this.getClass().getClassLoader().getResourceAsStream(reportFile.getPath());
//            JasperReport jReport = (JasperReport) JRLoader.loadObjectFromFile(reportFile.getPath());
//            JasperPrint jPrint = JasperFillManager.fillReport(jReport, parameter, conn);
            JasperPrint jp = JasperFillManager.fillReport(jReport, parameter, conn);
//            JasperViewer.viewReport(jPrint, true);
//            JasperViewer viewer = new JasperViewer(jPrint);
//            JasperViewer.setDefaultLookAndFeelDecorated(true);
//            cr.add(viewer);
//            cr.show();
            JRViewer jViewer = new JRViewer (jp);
            jViewer.setVisible(true);
            jViewer.setOpaque(true);
            jScrollPane1.add(jViewer);
            jScrollPane1.setViewportView(jViewer);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Laporan Tidak Dapat Dicetak!\n" + e.getMessage()
                ,"Cetak Laporan", JOptionPane.ERROR_MESSAGE);
        }
        }else{
           try {
            String path = "report/ReportNasabah.jasper";
            String driver="oracle.jdbc.OracleDriver";
            String konek="jdbc:oracle:thin:@localhost:1521:XE";
            String user="system";
            String password="root";
            
            HashMap parameter = new HashMap();
            Class.forName(driver);
            Connection conn = DriverManager.getConnection(konek,user,password);
            File reportFile=new File(path);
            parameter.put("kategori", txtCari.getText());
            InputStream jReport = this.getClass().getClassLoader().getResourceAsStream(reportFile.getPath());
//            JasperReport jReport = (JasperReport) JRLoader.loadObjectFromFile(reportFile.getPath());
//            JasperPrint jPrint = JasperFillManager.fillReport(jReport, parameter, conn);
            JasperPrint jp = JasperFillManager.fillReport(jReport, parameter, conn);
//            JasperViewer.viewReport(jPrint, true);
//            JasperViewer viewer = new JasperViewer(jPrint);
//            JasperViewer.setDefaultLookAndFeelDecorated(true);
//            cr.add(viewer);
//            cr.show();
            JRViewer jViewer = new JRViewer (jp);
            jViewer.setVisible(true);
            jViewer.setOpaque(true);
            jScrollPane1.add(jViewer);
            jScrollPane1.setViewportView(jViewer);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Laporan Tidak Dapat Dicetak!\n" + e.getMessage()
                ,"Cetak Laporan", JOptionPane.ERROR_MESSAGE);
        } 
        }
           

    }//GEN-LAST:event_btn_cetaklaporanActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_cetaklaporan;
    private javax.swing.JComboBox<String> cmbCari;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtCari;
    // End of variables declaration//GEN-END:variables
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import controller.PembayaranController;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Toshiba
 */
public class ViewPembayaran extends javax.swing.JInternalFrame {
    private String header[] ={" NIK "," Nama Nasabah "," Kode Asuransi ", " Jenis Asuransi ","Tanggal Bayar"};
    public PembayaranController pc;
    private List<String> datas;

    /**
     * Creates new form ViewPembayaran
     */
    public ViewPembayaran() {
        initComponents();
        datas = new ArrayList<>();
        pc = new PembayaranController();
       // pc.BindingAll(tbl_listasuransi, header);
       datas = pc.loadID(cmb_asuransi);
    }
    
    private void batal(){
        txt_nmrPolis.setText("");
        txt_nmrPembayaran.setText("");
        txt_tglPembayaran.setDate(new Date());
        cmb_asuransi.setSelectedIndex(0);
        txt_totalBayar.setText("");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        btn_cariID = new javax.swing.JButton();
        txt_cariID = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_listasuransi = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txt_nmrPolis = new javax.swing.JTextField();
        txt_nmrPembayaran = new javax.swing.JTextField();
        txt_tglPembayaran = new com.toedter.calendar.JDateChooser();
        txt_totalBayar = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        btn_bayar = new javax.swing.JButton();
        btn_batal = new javax.swing.JButton();
        cmb_asuransi = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();

        jLabel1.setText("jLabel1");

        setClosable(true);

        btn_cariID.setText("Cari ID");
        btn_cariID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cariIDActionPerformed(evt);
            }
        });

        txt_cariID.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                txt_cariIDMouseEntered(evt);
            }
        });

        tbl_listasuransi.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tbl_listasuransi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_listasuransiMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_listasuransi);

        jPanel1.setBackground(new java.awt.Color(124, 175, 143));

        jLabel2.setText("Nomor Pembayaran   :");

        jLabel3.setText("Tanggal Pembayaran :");

        jLabel4.setText("Total  Pembayaran    :");

        jLabel5.setText("Nomor Polis                :");

        txt_totalBayar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_totalBayarKeyTyped(evt);
            }
        });

        jLabel7.setText("Jenis Asuransi       :");

        btn_bayar.setText("Bayar");
        btn_bayar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_bayarActionPerformed(evt);
            }
        });

        btn_batal.setText("Batal");
        btn_batal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_batalActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_totalBayar, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_nmrPembayaran, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_nmrPolis, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(93, 93, 93)
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cmb_asuransi, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_tglPembayaran, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_batal)
                .addGap(18, 18, 18)
                .addComponent(btn_bayar)
                .addGap(19, 19, 19))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txt_nmrPolis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7)
                            .addComponent(cmb_asuransi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(21, 21, 21)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txt_nmrPembayaran, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)))
                    .addComponent(txt_tglPembayaran, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txt_totalBayar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_batal)
                    .addComponent(btn_bayar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel12.setFont(new java.awt.Font("Century", 1, 24)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 128, 33));
        jLabel12.setText("MANULA");

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/LOGO.jpg"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel12)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(344, 344, 344)
                                .addComponent(txt_cariID, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn_cariID)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel13)
                    .addComponent(jLabel12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_cariID)
                    .addComponent(txt_cariID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_cariIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cariIDActionPerformed
         // TODO add your handling code here:
         
        datas = new ArrayList<>();
         String kolom = "noPolis";
       datas =  pc.bindingSearch(tbl_listasuransi, header, kolom,
                txt_cariID.getText());
    }//GEN-LAST:event_btn_cariIDActionPerformed

    private void btn_bayarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_bayarActionPerformed
        // TODO add your handling code here:
        boolean hasil = false;
        hasil = pc.bayar(txt_nmrPembayaran.getText(), txt_tglPembayaran.getDate().getTime()+""
                , (Long.valueOf(txt_totalBayar.getText())),txt_nmrPolis.getText()
                , cmb_asuransi.getSelectedItem().toString() );
        String pesan = "gagal menginputkan data";
        if (hasil) {
            pesan = "berhasil menginputkan data";
        }
        JOptionPane.showMessageDialog(this, pesan);
        //reset();
        String kolom = "noPolis";
       datas = pc.bindingSearch(tbl_listasuransi, header, kolom,
                txt_cariID.getText());
    }//GEN-LAST:event_btn_bayarActionPerformed

    private void tbl_listasuransiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_listasuransiMouseClicked
         // TODO add your handling code here:
//         txt_kdAsuransi.setText(tbl_listasuransi.getValueAt(tbl_listasuransi.getSelectedRow(), 2)+"");
//         txt_jenisAsuransi.setText(tbl_listasuransi.getValueAt(tbl_listasuransi.getSelectedRow(), 3)+"");
         txt_nmrPolis.setText(txt_cariID.getText());
         int row = tbl_listasuransi.getSelectedRow();
         cmb_asuransi.setSelectedItem(getCombo(true).get(row));
         System.out.println(getCombo(true).get(row));
//         cmb_asuransi.setSelectedItem(tbl_listasuransi.getValueAt(row, 2));
    }//GEN-LAST:event_tbl_listasuransiMouseClicked

    private void btn_batalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_batalActionPerformed
         // TODO add your handling code here:
         batal();
    }//GEN-LAST:event_btn_batalActionPerformed

    private void txt_cariIDMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_cariIDMouseEntered
         // TODO add your handling code here:
         
   
    }//GEN-LAST:event_txt_cariIDMouseEntered

    private void txt_totalBayarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_totalBayarKeyTyped
         // TODO add your handling code here:
         if(!Character.isDigit(evt.getKeyChar())){
            evt.consume();
        }
    }//GEN-LAST:event_txt_totalBayarKeyTyped

   private List<String> getCombo(boolean isCity){
        List<String> isi = new ArrayList<>();
        String[] daftar = new String[datas.size()];
        for (String data : datas) {
            daftar = data.split(";");
            if (isCity) isi.add(daftar[0]);
            else isi.add(daftar[1]);
        }
        return isi;
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_batal;
    private javax.swing.JButton btn_bayar;
    private javax.swing.JButton btn_cariID;
    private javax.swing.JComboBox<String> cmb_asuransi;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbl_listasuransi;
    private javax.swing.JTextField txt_cariID;
    private javax.swing.JTextField txt_nmrPembayaran;
    private javax.swing.JTextField txt_nmrPolis;
    private com.toedter.calendar.JDateChooser txt_tglPembayaran;
    private javax.swing.JTextField txt_totalBayar;
    // End of variables declaration//GEN-END:variables


}


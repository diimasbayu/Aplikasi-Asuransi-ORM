/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAO.AsuransiDAO;
import DAO.NasabahDAO;
import DAO.PembayaranDAO;
import entities.Asuransi;
import entities.Nasabah;
import entities.Pembayaran;
import java.math.BigDecimal;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author dbayu
 */
public class PembayaranController {
    private final  PembayaranDAO pdao;
    private final NasabahDAO ndao;
    private final AsuransiDAO adao;
    
    public PembayaranController(){
        this.pdao = new PembayaranDAO();
        this.ndao = new NasabahDAO();
        this.adao = new AsuransiDAO();
    }
    
    
    private void bindingTable(JTable table, String[] header, List<Object> datas) {
        DefaultTableModel model = new DefaultTableModel(header, 0);
//        int i = 1;
        for (Object data : datas) {
            Pembayaran pembayaran =  (Pembayaran) data;
            String jenisasuransi = "";
            if (pembayaran.getNoPolis()!= null) {
                jenisasuransi = pembayaran.getNoPolis().toString();
            }
            Object[] data1 = {
//                i++,
                pembayaran.getNoPolis().getNik(),
                pembayaran.getNoPolis().getNmNasabah(),
                pembayaran.getKodeAsuransi(),
                pembayaran.getKodeAsuransi().getJenisAsuransi(),
                pembayaran.getTglPembayaran()
//                jenisasuransi
            };
            model.addRow(data1);
        }
        table.setModel(model);
    }
    
    
    public void BindingAll(JTable table, String[] header) {
        bindingTable(table, header, pdao.getAll());
    }
    
    
    public void bindingSearch(JTable table,
            String[] header, String category,
            String cari) {
        bindingTable(table, header, pdao.search(category, cari));

    }
    
    public boolean bayar(String no_pembayaran, String tgl_pembayaran, Long jumlah_bayar, String no_polis
    ,String kode_asuransi){
        Pembayaran p = new Pembayaran();
        p.setNoPembayaran(no_pembayaran);
        p.setTglPembayaran(new java.sql.Date(new Long(tgl_pembayaran)));
        p.setJmlhBayar(jumlah_bayar);
        p.setNoPolis(new Nasabah(no_polis));
        p.setKodeAsuransi(new Asuransi(kode_asuransi));
        return adao.insert(p);
    }
    
     public void bindingLaporanPembayaran(JTable table,String[] header, String category,String cari) {
        bindingTable(table, header, pdao.search(category, cari));

    }
    
}

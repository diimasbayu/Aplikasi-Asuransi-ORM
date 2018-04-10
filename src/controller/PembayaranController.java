/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAO.AsuransiDAO;
import DAO.NasabahDAO;
import DAO.PembayaranDAO;
import entities.Admin;
import entities.Asuransi;
import entities.Nasabah;
import entities.Pembayaran;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JComboBox;
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
    
    
    private List<String> bindingTable(JTable table, String[] header, List<Object> datas) {
        List<String> dataManager = new ArrayList<>();
        DefaultTableModel model = new DefaultTableModel(header, 0);
//        int i = 1;
        for (Object data : datas) {
            Pembayaran pembayaran =  (Pembayaran) data;
//            String jenisasuransi = "";
//            if (pembayaran.getNoPolis()!= null) {
//                jenisasuransi = pembayaran.getNoPolis().toString();
//            }
            dataManager.add(pembayaran.getKodeAsuransi().getKodeAsuransi()+" - "
                    +pembayaran.getKodeAsuransi().getJenisAsuransi());
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
        return dataManager;
    }
    
    
    public List<String> BindingAll(JTable table, String[] header) {
       return bindingTable(table, header, pdao.getAll());
    }
    
    
    public List<String> bindingSearch(JTable table,
            String[] header, String category,
            String cari) {
        String search = cari;
        if (category.equalsIgnoreCase("kodeAsuransi")) {
            Asuransi asuransi = (Asuransi) adao.search("kodeAsuransi", cari).get(0);
            if (asuransi == null) {
                asuransi = (Asuransi) adao.search("jenisAsuransi", cari).get(0);
            }
            search = asuransi.getKodeAsuransi().toString();
        }
//else if (category.equalsIgnoreCase("locationId")) {
//            List<Object> locations = lDAO.search("city", cari);
//            Locations location = (Locations) locations.get(0);
//
//            search = location.getLocationId().toString();
//        }
       return bindingTable(table, header, pdao.search(category, search));

    }
    
    public boolean bayar(String no_pembayaran, String tgl_pembayaran, Long jumlah_bayar, String no_polis
    ,String kode_asuransi){
        String[] mId = kode_asuransi.split(" ");
        Pembayaran p = new Pembayaran();
        p.setNoPembayaran(no_pembayaran);
        p.setTglPembayaran(new java.sql.Date(new Long(tgl_pembayaran)));
        p.setJmlhBayar(jumlah_bayar);
        p.setNoPolis(new Nasabah(no_polis));
        p.setKodeAsuransi((Asuransi) adao.getById(mId[0]));
        return adao.insert(p);
    }
    
     public void bindingLaporanPembayaran(JTable table,String[] header, String category,String cari) {
        bindingTable(table, header, pdao.search(category, cari));

    }
    
     public List<String> loadID(JComboBox jComboBox) {
        List<String> datas = new ArrayList<>();
        jComboBox.addItem(" - ");
        adao.getAll().stream().map((object) -> (Asuransi) object).forEachOrdered((asuransi) -> {
            String isi = asuransi.getKodeAsuransi() + " - " + asuransi.getJenisAsuransi();
            jComboBox.addItem(isi);
            datas.add(isi);
        });
        return datas;
    }
}

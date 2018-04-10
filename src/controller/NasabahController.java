/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAO.AdminDAO;
import DAO.NasabahDAO;
import entities.Admin;
import entities.Asuransi;
import entities.Nasabah;
import java.io.File;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Toshiba
 */
public class NasabahController {

    private final NasabahDAO nao;
    private final AdminDAO adao;

    public NasabahController() {
        this.nao = new NasabahDAO();
        this.adao = new AdminDAO();
    }

    

    private List<String> BindingTabels(JTable table, String[] header, List<Object> datas) { 
        List<String> datalist = new ArrayList<>();
        DefaultTableModel model = new DefaultTableModel(header, 0);
        for (Object data : datas) {
            Nasabah n = (Nasabah) data;
             datalist.add(n.getIdAdmin().getIdAdmin()+" - "
                    +n.getIdAdmin().getNamaAdmin());
            Object[] data1 = {
                n.getNik(),
                n.getNmNasabah(),
                n.getTglLahir(),
                n.getPekerjaan(),
                n.getAlamat(),
                n.getStatus(),
                n.getPengBulan(),
                n.getNoPolis(),
                n.getIdAdmin()};
            model.addRow(data1);
        }
        table.setModel(model);
        return datalist;
    }

    public boolean save(String NIK, String nmNasabah, String tglLahir, String pekerjaan, String alamat,
            String status, String penghasilan, String noPolis, String idAdmin, boolean isSave) {
//        Nasabah nasabah = new Nasabah(NIK, nmNasabah, tglLahir, pekerjaan, alamat, status, penghasilan, noPolis, idAdmin);
        Nasabah n = new Nasabah();
        String[] ID = idAdmin.split(" ");
        n.setNik(NIK);
        n.setNmNasabah(nmNasabah);
        n.setTglLahir(new java.sql.Date(new Long(tglLahir)));
        n.setPekerjaan(pekerjaan);
        n.setAlamat(alamat);
        n.setStatus(status);
        n.setPengBulan(penghasilan);
        n.setNoPolis(noPolis);
        n.setIdAdmin((Admin) adao.getById(ID[0]));
        if (isSave) {
            return nao.insert(n);
        }
        return nao.update(n);
    }

//    public boolean update(String NIK, String nmNasabah, String tglLahir, String pekerjaan, String alamat,
//            String status, String penghasilan, String noPolis, String idAdmin) {
//         Nasabah n = new Nasabah();
//        n.setNik(NIK);
//        n.setNmNasabah(nmNasabah);
//        n.setTglLahir(new java.sql.Date(new Long(tglLahir)));
//        n.setPekerjaan(pekerjaan);
//        n.setAlamat(alamat);
//        n.setStatus(status);
//        n.setPengBulan(penghasilan);
//        n.setNoPolis(noPolis);
//        n.setIdAdmin(new Admin(idAdmin));
//
////        Nasabah nasabah = new Nasabah(NIK, nmNasabah, tglLahir, pekerjaan, alamat, status, penghasilan, noPolis, idAdmin);
//        return nao.update(n);
//    }
    public boolean delete(String id) {
        return nao.delete(id);
    }

    public List<String> bindingsearch(JTable table, String[] header, String category, String search) {
        
          String cari = search;
        if (category.equalsIgnoreCase("idAdmin")) {
            Admin admin = (Admin) adao.search("idAdmin", search).get(0);
            if (admin == null) {
                admin = (Admin) adao.search("namaAdmin", search).get(0);
            }
            cari = admin.getIdAdmin().toString();
        }
        return BindingTabels(table, header, nao.search(category, cari));
    }

    public List<String> bindingall(JTable table, String[] header) {
        return BindingTabels(table, header, nao.getAll());
    }

    public List<String> loadID(JComboBox jComboBox) {
        List<String> datas = new ArrayList<>();
        jComboBox.addItem(" - ");
        adao.getAll().stream().map((object) -> (Admin) object).forEachOrdered((admin) -> {
            String isi = admin.getIdAdmin() + " - " + admin.getNamaAdmin();
            jComboBox.addItem(isi);
            datas.add(isi);
        });
        
        return datas;
    }
    
     public void bindingLaporanNasabah(JTable table,String[] header, String category,String cari) {
        BindingTabels(table, header, nao.search(category, cari));

    }
     
    
   
}

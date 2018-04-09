/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAO.AdminDAO;
import DAO.NasabahDAO;
import entities.Admin;
import entities.Nasabah;
import java.io.File;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
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

    public void BindingAll(JTable table, String[] header) {
        BindingTabels(table, header, nao.getAll());
    }

    private void BindingTabels(JTable table, String[] header, List<Object> datas) {
        DefaultTableModel model = new DefaultTableModel(header, 0);
        for (Object data : datas) {
            Nasabah n = (Nasabah) data;
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

    public void bindingsearch(JTable table, String[] header, String category, String search) {
        BindingTabels(table, header, nao.search(category, search));
    }

    public void bindingall(JTable table, String[] header) {
        BindingTabels(table, header, nao.getAll());
    }

    public void loadID(JComboBox jComboBox) {
        adao.getAll().stream().map((object) -> (Admin) object).forEachOrdered((admin) -> {
            jComboBox.addItem(admin.getIdAdmin() + " - "
                    + admin.getNamaAdmin());
        });
    }
    
     public void bindingLaporanNasabah(JTable table,String[] header, String category,String cari) {
        BindingTabels(table, header, nao.search(category, cari));

    }
     
    /**
     *
     */
    public void report(){
         
     }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAO.AdminDAO;
import DAO.NasabahDAO;
import entitites.Admin;
import entitites.Nasabah;
import java.util.Date;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

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
                n.getStatus(),
                n.getPengBulan(),
                n.getIdAdmin(),};
            model.addRow(data1);
        }
        table.setModel(model);
    }

    public boolean insert(String NIK, String nmNasabah, String tglLahir, String pekerjaan, String alamat,
            String status, String penghasilan, String idAdmin) {

        Nasabah nasabah = new Nasabah(NIK, nmNasabah, tglLahir, pekerjaan, alamat, status, penghasilan, idAdmin);
        return nao.insert(nasabah);
    }

    public boolean update(String NIK, String nmNasabah, String tglLahir, String pekerjaan, String alamat,
            String status, String penghasilan, String idAdmin) {

        Nasabah nasabah = new Nasabah(NIK, nmNasabah, tglLahir, pekerjaan, alamat, status, penghasilan, idAdmin);
        return nao.update(nasabah);
    }

    public boolean delete(String id) {
        return nao.delete(id);
    }

    public void bindingsearch(JTable table, String[] header, String category, String search) {
        BindingTabels(table, header, adao.search(category, search));
    }

    public void bindingall(JTable table, String[] header) {
        BindingTabels(table, header, adao.getAll());
    }
}

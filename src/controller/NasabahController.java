/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAO.AdminDAO;
import DAO.NasabahDAO;
import entities.Nasabah;
import java.util.Date;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Toshiba
 */
public class NasabahController {

    private final NasabahDAO nao;

    public NasabahController() {
        this.nao = new NasabahDAO();
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
                n.getIdAdmin()};
            model.addRow(data1);
        }
        table.setModel(model);
    }
    
    public boolean insert(String NIK, String nmNasabah, String tglLahir, String pekerjaan, String alamat,
            String status, String penghasilan, String idAdmin, String no_polis) {

        Nasabah nasabah = new Nasabah(NIK, nmNasabah, tglLahir, pekerjaan, alamat, status, penghasilan, idAdmin, no_polis);
        return nao.insert(nasabah);
    }

    public boolean update(String NIK, String nmNasabah, String tglLahir, String pekerjaan, String alamat,
            String status, String penghasilan, String idAdmin, String no_polis) {

        Nasabah nasabah = new Nasabah(NIK, nmNasabah, tglLahir, pekerjaan, alamat, status, penghasilan, idAdmin, no_polis);
        return nao.update(nasabah);
    }

    public boolean delete(String id) {
        return nao.delete(id);
    }

    public void bindingsearch(JTable table, String[] header, String category, String search) {
        BindingTabels(table, header, nao.search(category, search));
    }

    public void bindingall(JTable table, String[] header) {
        BindingTabels(table, header, nao.getAll());
    }

    public boolean update(String text, String text0, String text1, String text2, String name, String text3, String text4, JTextField txtIDAdmin) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

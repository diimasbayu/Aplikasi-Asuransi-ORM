/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAO.AdminDAO;
import entitites.Admin;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Toshiba
 */
public class AdminController {

    private final AdminDAO adao;

    public AdminController() {
        this.adao = new AdminDAO();
    }

    private void bindingTabels(JTable table, String[] header, List<Object> datas) {
        DefaultTableModel model = new DefaultTableModel(header, 0);

        for (Object data : datas) {
            Admin admin = (Admin) data;
            Object[] data1 = {
                admin.getIdAdmin(),
                admin.getNamaAdmin(),
                admin.getAlamat(),
                admin.getIdAdmin()
            };
            model.addRow(data1);
        }
        table.setModel(model);
    }

    public void bindingall(JTable table, String[] header) {
        bindingTabels(table, header, adao.getAll());
    }

    public boolean insert(String idAdmin, String nmAdmin, String alamat, String email) {

        Admin a = new Admin(idAdmin, nmAdmin, alamat, email);
        return adao.insert(a);
    }

    public boolean delete(String id) {
        return adao.delete(id);
    }

    public boolean update(String idAdmin, String nmAdmin, String alamat, String email) {

        Admin a = new Admin(idAdmin, nmAdmin, alamat, email);
        return adao.update(a);
    }

    public void bindingsearch(JTable table, String[] header,
            String category, String search) {
        bindingTabels(table, header, adao.search(category, search));

    }

}

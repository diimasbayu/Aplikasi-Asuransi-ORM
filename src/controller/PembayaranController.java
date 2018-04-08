/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAO.PembayaranDAO;
import entities.Pembayaran;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author dbayu
 */
public class PembayaranController {
    private final  PembayaranDAO pdao;
    
    
    public PembayaranController(){
        this.pdao = new PembayaranDAO();
    }
    
    
    private void bindingTable(JTable table, String[] header, List<Object> datas) {
        DefaultTableModel model = new DefaultTableModel(header, 0);
        int i = 1;
        for (Object data : datas) {
            Pembayaran pembayaran =  (Pembayaran) data;
//            String manager = "";
//            if (departments.getManagerId() != null) {
//                manager = departments.getManagerId().getFirstName() + " "
//                        + departments.getManagerId().getLastName();
//            }
            Object[] data1 = {
                i++,
                pembayaran.getNoPolis().getNik(),
                pembayaran.getNoPolis().getNmNasabah(),
                pembayaran.getKodeAsuransi(),
                pembayaran.getKodeAsuransi().getJenisAsuransi()
            };
            model.addRow(data1);
        }
        table.setModel(model);
    }
    
    
    public void BindingAll(JTable table, String[] header) {
        bindingTable(table, header, pdao.getAll());
    }
    
}

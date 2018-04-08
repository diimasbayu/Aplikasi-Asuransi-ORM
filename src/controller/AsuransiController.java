/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAO.AsuransiDAO;
import entities.Asuransi;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Toshiba
 */
public class AsuransiController {

public  AsuransiDAO adao = new  AsuransiDAO();

private void bindingTabels(JTable table, String[] header, List<Object> datas){
    DefaultTableModel model = new  DefaultTableModel(header, 0);
        
        for (Object data : datas) {
            Asuransi asuransi = (Asuransi) data;
            Object[] data1 = {
            asuransi.getKodeAsuransi(),
                asuransi.getJenisAsuransi()
            };
            model.addRow(data1);
        }
        table.setModel(model);
}
 public void bindingall(JTable table, String[] header){
        bindingTabels(table, header, adao.getAll());
    }
 
 public boolean insert(String kode_asuransi, String jenis_asuransi){
        Asuransi asuransi = new Asuransi();
        asuransi.setKodeAsuransi(kode_asuransi);
        asuransi.setJenisAsuransi(jenis_asuransi);
        return adao.insert(asuransi);
    }
 
 
  public boolean delete(String id) {
        return adao.delete(id);
    }
  
    public boolean update(String kode_asuransi, String jenis_asuransi){
        Asuransi asuransi = new Asuransi();
        asuransi.setKodeAsuransi(kode_asuransi);
        asuransi.setJenisAsuransi(jenis_asuransi);
        
                
        return adao.update(asuransi);
    
}
    
     public  void bindingsearch(JTable table, String[] header,
            String category, String search){
        bindingTabels(table, header, adao.search(category, search));
        
    }
}

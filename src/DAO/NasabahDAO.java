/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import entitites.Nasabah;
import java.util.List;
import org.hibernate.Transaction;

/**
 *
 * @author dbayu
 */
public class NasabahDAO implements InterfaceDAO{

    public Transaction transaction;
    
        public FunctionDAO fdao;
    @Override
    public boolean insert(Object object) {
        return fdao.insert(object);
    }

    @Override
    public boolean update(Object object) {
   
        return fdao.insert(object);
    }

    @Override
    public boolean delete(Object object) {
   
        return fdao.delete(Nasabah.class, object+"");
    }

    @Override
    public List<Object> getAll() {
        return fdao.getAll(" from Nasabah");
    }

    @Override
    public List<Object> search(String category, String search) {
        return fdao.getAll("FROM Nasabah WHERE " + category + " LIKE '%" + search + "%'"); 
    
        }

    @Override
    public Object getById(String id) {
        return fdao.getById("from Nasabah where NIK='" + id + "'");
        }
    
}

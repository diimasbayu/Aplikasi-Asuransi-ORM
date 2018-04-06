/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import entities.Pembayaran;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author dbayu
 */
public class PembayaranDAO implements InterfaceDAO{

        public Session session;
    private SessionFactory factory;
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
    return fdao.delete(Pembayaran.class, object + "");
    }

    @Override
    public List<Object> getAll() {
    return fdao.getAll("FROM Pembayaran");
    }

    @Override
    public List<Object> search(String category, String search) {
    return fdao.getAll("FROM Pembayaran WHERE " + category + " LIKE '%" + search + "%'"); 
    }

    @Override
    public Object getById(String id) {
    return fdao.getById("from Pembayaran where noPembayaran='" + id + "'");
    }
    
}

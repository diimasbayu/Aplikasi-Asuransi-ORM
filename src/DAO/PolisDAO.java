/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import entities.Polis;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import tools.HibernateUtil;

/**
 *
 * @author dbayu
 */
public class PolisDAO implements InterfaceDAO{
    
    public Session session;
    private SessionFactory factory;
    public Transaction transaction;
    
    public FunctionDAO fdao;

 public PolisDAO(){
     this.fdao = new FunctionDAO(HibernateUtil.getSessionFactory());
 }

 public List<Object> search(String category, String search) {
        return fdao.getAll("FROM Polis WHERE " + category + " LIKE '%" + search + "%'");
    }

    public Object getById(String Id) {
        return fdao.getById("from Polis where noPolis='" + Id + "'");
    }
 
 public boolean update(Object object) {
        return fdao.insert(object);
    }

    public List<Object> getAll() {
        return fdao.getAll("FROM Polis");
    }

    @Override
    public boolean insert(Object object) {
         //To change body of generated methods, choose Tools | Templates.
     return fdao.insert(object);
    }

    @Override
    public boolean delete(Object object) {
            return fdao.delete(Polis.class, object + "");

    }
    
}

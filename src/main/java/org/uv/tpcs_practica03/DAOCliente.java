package org.uv.tpcs_practica03;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

/* @author miran */

public class DAOCliente implements IDAOGeneral<Cliente, Long>{

    @Override
    public Cliente create(Cliente t) {
        
        Session session=HibernateUtil.getSession();
        Transaction transaction=session.beginTransaction();
        session.save(t);
        transaction.commit();
        session.close();
        return t;
    }

    @Override
    public boolean delete(Long id) {
        Session session=HibernateUtil.getSession();
        Transaction transaction=session.beginTransaction();
        boolean pase=false;
        Cliente cliente=session.get(Cliente.class, id);
        if(cliente!=null){
            session.delete(id);
            transaction.commit();
            pase=true;
        }
        session.close();
        return pase;
    }

    @Override
    public Cliente update(Cliente t, Long id) {
        Session session=HibernateUtil.getSession();
        Transaction transaction=session.beginTransaction();
        Cliente cliente=session.get(Cliente.class, id);
        if(cliente!=null){
            session.update(t);
            transaction.commit();
        }
        session.close();
        return t;
    }

    @Override
    public List<Cliente> findAll() {
        Session session=HibernateUtil.getSession();
        Transaction transaction=session.beginTransaction();
        List<Cliente> clientes=session.createQuery("From Cliente e order by e.clienteId").list();
        transaction.commit();
        session.close();
        return clientes;
    }

    @Override
    public Cliente findByID(Long id) {
        Session session=HibernateUtil.getSession();
        Cliente cliente=session.get(Cliente.class, id);
        session.close();
        return cliente;
    }
    
    
}

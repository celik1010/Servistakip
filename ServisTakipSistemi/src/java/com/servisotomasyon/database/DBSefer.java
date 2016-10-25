package com.servisotomasyon.database;

import com.servisotomasyon.abstracts.Listeleme;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Projections;
import com.servisotomasyon.pojos.Arac;
import com.servisotomasyon.pojos.Sefer;

public class DBSefer extends Listeleme {

    @Override
    public List list(List<Object> param) {
        Session session=HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Criteria cr=session.createCriteria(Sefer.class);
        
        List result=cr.list();
        session.close();
        return result;
    }

    @Override
    public Object select(List<Object> param) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

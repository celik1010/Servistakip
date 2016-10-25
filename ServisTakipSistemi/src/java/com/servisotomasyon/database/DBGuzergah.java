package com.servisotomasyon.database;

import com.servisotomasyon.abstracts.Listeleme;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import com.servisotomasyon.pojos.Arac;
import com.servisotomasyon.pojos.Durak;
import com.servisotomasyon.pojos.Guzergah;

public class DBGuzergah extends Listeleme {

    @Override
    public List list(List<Object> param) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Criteria cr = session.createCriteria(Guzergah.class);

        List results = cr.list();
        session.close();
        return results;
    }

    @Override
    public Object select(List<Object> param) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List guzergahAdiListesi() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Criteria cr = session.createCriteria(Guzergah.class);

        cr.setProjection(Projections.property("guzergahNo"));

        List results = cr.list();
        session.close();
        return results;
    }

    public Guzergah guzergahDonder(Integer guzergahNo) {
        Guzergah guzergah = new Guzergah();
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Criteria cr = session.createCriteria(Guzergah.class);

        cr.add(Restrictions.eq("guzergahNo", guzergahNo));

        List liste = cr.list();
        session.getTransaction().commit();
        session.close();

        guzergah = (Guzergah) liste.get(0);
        return guzergah;
    }
}

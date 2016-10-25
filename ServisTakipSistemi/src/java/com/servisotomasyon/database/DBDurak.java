package com.servisotomasyon.database;

import com.servisotomasyon.abstracts.Listeleme;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import com.servisotomasyon.pojos.Durak;

public class DBDurak extends Listeleme {

    public static void main(String[] args) {
        DBDurak dBDurak = new DBDurak();
        List<Object> list = new ArrayList<>();
        System.out.println(dBDurak.list(list));

        System.out.println(dBDurak.durakVarmi(38.69512456907445, 35.541077256202));
    }

    @Override
    public List list(List<Object> param) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Criteria cr = session.createCriteria(Durak.class);

        List results = cr.list();
        session.close();
        return results;
    }

    @Override
    public Object select(List<Object> param) {
        double konumX = (double) param.get(0);
        double konumY = (double) param.get(1);

        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Criteria cr = session.createCriteria(Durak.class);
        cr.add(Restrictions.eq("konumX", konumX));
        cr.add(Restrictions.eq("konumY", konumY));

        List results = cr.list();
        session.close();
        return results.get(0);
    }

    public boolean durakVarmi(double konumX, double konumY) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Criteria cr = session.createCriteria(Durak.class);

        cr.add(Restrictions.eq("konumX", konumX));
        cr.add(Restrictions.eq("konumY", konumY));

        List liste = cr.list();
        session.getTransaction().commit();
        session.close();

        if (!liste.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }
     public Durak durakBul(double konumX, double konumY) {
        Durak durak = new Durak();
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Criteria cr = session.createCriteria(Durak.class);

        cr.add(Restrictions.eq("konumX", konumX));
        cr.add(Restrictions.eq("konumY", konumY));

        List liste = cr.list();
        session.getTransaction().commit();
        session.close();

        
        durak = (Durak) liste.get(0);
        return durak;
    }     
       

}

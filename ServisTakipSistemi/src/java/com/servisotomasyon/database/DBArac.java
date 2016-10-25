package com.servisotomasyon.database;

import com.servisotomasyon.abstracts.Listeleme;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import com.servisotomasyon.pojos.Arac;
import com.servisotomasyon.pojos.Durak;
import com.servisotomasyon.pojos.Sirket;

public class DBArac extends Listeleme {

    @Override
    public List list(List<Object> param) {
        Sirket sirketNo = (Sirket) param.get(0);
        int sinif = (int) param.get(1);
        String marka = (String) param.get(2);
        int kapasite = (int) param.get(3);
        int durum = (int) param.get(4);

        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        Criteria cr = session.createCriteria(Arac.class);
        if (durum == 1) {
            if (kapasite == 0 & sinif == 0 & marka.equals("0")) { //Hiç bir filtre yoksa
                cr.add(Restrictions.eq("durum", durum));
                cr.add(Restrictions.eq("sirketNo", sirketNo));
            } else if (kapasite == 0 & sinif == 0) { //sadece marka kriteri varsa
                cr.add(Restrictions.eq("durum", durum));
                cr.add(Restrictions.eq("sirketNo", sirketNo));
                cr.add(Restrictions.eq("marka", marka));
            } else if (sinif == 0 & marka.equals("0")) { //sadece kapasite kriteri
                cr.add(Restrictions.eq("durum", durum));
                cr.add(Restrictions.eq("sirketNo", sirketNo));
                cr.add(Restrictions.eq("kapasite", kapasite));
            } else if (kapasite == 0 & marka.equals("0")) { //sadece sinif kriteri
                cr.add(Restrictions.eq("durum", durum));
                cr.add(Restrictions.eq("sirketNo", sirketNo));
                cr.add(Restrictions.eq("sinif", sinif));
            } else if (sinif == 0) { //marka ve kapasite kriteri var
                cr.add(Restrictions.eq("durum", durum));
                cr.add(Restrictions.eq("sirketNo", sirketNo));
                cr.add(Restrictions.eq("marka", marka));
                cr.add(Restrictions.eq("kapasite", kapasite));
            } else if (marka.equals("0")) { //kapasite ve sinif kriteri var
                cr.add(Restrictions.eq("durum", durum));
                cr.add(Restrictions.eq("sirketNo", sirketNo));
                cr.add(Restrictions.eq("sinif", sinif));
                cr.add(Restrictions.eq("kapasite", kapasite));
            } else if (kapasite == 0) { // marka ve sinif kriteri var
                cr.add(Restrictions.eq("durum", durum));
                cr.add(Restrictions.eq("sirketNo", sirketNo));
                cr.add(Restrictions.eq("sinif", sinif));
                cr.add(Restrictions.eq("marka", marka));
            } else {
                cr.add(Restrictions.eq("durum", durum));
                cr.add(Restrictions.eq("sirketNo", sirketNo));
                cr.add(Restrictions.eq("sinif", sinif));
                cr.add(Restrictions.eq("marka", marka));
                cr.add(Restrictions.eq("kapasite", kapasite));
            }
        } else {
            if (kapasite == 0 & sinif == 0 & marka.equals("0")) { //Hiç bir filtre yoksa
                cr.add(Restrictions.eq("durum", durum));
            } else if (kapasite == 0 & sinif == 0) { //sadece marka kriteri varsa
                cr.add(Restrictions.eq("durum", durum));
                cr.add(Restrictions.eq("marka", marka));
            } else if (sinif == 0 & marka.equals("0")) { //sadece kapasite kriteri
                cr.add(Restrictions.eq("durum", durum));
                cr.add(Restrictions.eq("kapasite", kapasite));
            } else if (kapasite == 0 & marka.equals("0")) { //sadece sinif kriteri
                cr.add(Restrictions.eq("durum", durum));
                cr.add(Restrictions.eq("sinif", sinif));
            } else if (sinif == 0) { //marka ve kapasite kriteri var
                cr.add(Restrictions.eq("durum", durum));
                cr.add(Restrictions.eq("marka", marka));
                cr.add(Restrictions.eq("kapasite", kapasite));
            } else if (marka.equals("0")) { //kapasite ve sinif kriteri var
                cr.add(Restrictions.eq("durum", durum));
                cr.add(Restrictions.eq("sinif", sinif));
                cr.add(Restrictions.eq("kapasite", kapasite));
            } else if (kapasite == 0) { // marka ve sinif kriteri var
                cr.add(Restrictions.eq("durum", durum));
                cr.add(Restrictions.eq("sinif", sinif));
                cr.add(Restrictions.eq("marka", marka));
            } else {
                cr.add(Restrictions.eq("durum", durum));
                cr.add(Restrictions.eq("sinif", sinif));
                cr.add(Restrictions.eq("marka", marka));
                cr.add(Restrictions.eq("kapasite", kapasite));
            }
        }

        List results = cr.list();
        session.close();
        return results;
    }

    public List markaListesi() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Criteria cr = session.createCriteria(Arac.class);

        cr.setProjection(Projections.property("marka"));
        cr.setProjection(Projections.distinct(Projections.property("marka")));

        List results = cr.list();
        session.close();
        return results;
    }

    public List kapasiteListesi() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Criteria cr = session.createCriteria(Arac.class);

        cr.setProjection(Projections.property("kapasite"));
        cr.setProjection(Projections.distinct(Projections.property("kapasite")));

        List results = cr.list();
        session.close();
        return results;
    }

    @Override
    public Object select(List<Object> param) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Arac aracDonder(Integer aracNo) {
        Arac arac = new Arac();
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Criteria cr = session.createCriteria(Arac.class);

        cr.add(Restrictions.eq("aracNo", aracNo));

        List liste = cr.list();
        session.getTransaction().commit();
        session.close();

        
        arac = (Arac) liste.get(0);
        return arac;
    }
}

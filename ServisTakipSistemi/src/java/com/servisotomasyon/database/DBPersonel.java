package com.servisotomasyon.database;

import com.servisotomasyon.abstracts.Listeleme;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import com.servisotomasyon.pojos.Personel;
import com.servisotomasyon.pojos.Sirket;

public class DBPersonel extends Listeleme {

    @Override
    public List list(List<Object> param) {
        Sirket sirketNo = (Sirket) param.get(0);

        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        Criteria cr = session.createCriteria(Personel.class);

        cr.add(Restrictions.eq("sirketNo", sirketNo));

        List results = cr.list();
        session.close();
        return results;
    }

    @Override
    public Object select(List<Object> param) {
        Long personelTc = (Long) param.get(0);
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Criteria cr = session.createCriteria(Personel.class);

        cr.add(Restrictions.eq("personelTc", personelTc));

        session.close();
        return cr.list().get(0);
    }

    public Personel select(Long personelTc) {
        Personel personel = new Personel();
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Criteria cr = session.createCriteria(Personel.class);

        cr.add(Restrictions.eq("personelTc", personelTc));

        List results = cr.list();
        session.close();

        personel = (Personel) results.get(0);
        return personel;
    }

}

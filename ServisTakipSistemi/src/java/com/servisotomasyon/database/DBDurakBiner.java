package com.servisotomasyon.database;

import com.servisotomasyon.abstracts.Listeleme;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import com.servisotomasyon.pojos.Durakbiner;

public class DBDurakBiner extends Listeleme {

    @Override
    public List list(List<Object> param) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Criteria cr = session.createCriteria(Durakbiner.class);

        List results = cr.list();
        session.close();
        return results;
    }

    @Override
    public Object select(List<Object> param) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Durakbiner select(Long personelTc) {
        Durakbiner personel = new Durakbiner();
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Criteria cr = session.createCriteria(Durakbiner.class);

        cr.add(Restrictions.eq("personelTc", personelTc));

        List results = cr.list();
        session.close();

        personel = (Durakbiner) results.get(0);
        return personel;
    }

}

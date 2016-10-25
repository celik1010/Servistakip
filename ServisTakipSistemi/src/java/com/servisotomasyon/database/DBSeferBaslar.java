package com.servisotomasyon.database;

import com.servisotomasyon.abstracts.Listeleme;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.Subqueries;
import com.servisotomasyon.pojos.Durak;
import com.servisotomasyon.pojos.GuzergahDurak;
import com.servisotomasyon.pojos.SeferBaslar;

public class DBSeferBaslar extends Listeleme {

    @Override
    public List list(List<Object> param) {
        int durakNo = (int) param.get(0);
        Durak durak = new Durak();
        durak.setDurakNo(durakNo);

        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        DetachedCriteria detachedCriteria = DetachedCriteria.forClass(GuzergahDurak.class)
                .add(Restrictions.eq("durakNo", durak))
                .setProjection(Projections.property("guzergahNo"));

        Criteria cr = session.createCriteria(SeferBaslar.class);
        cr.add(Subqueries.propertyIn("guzergahNo", detachedCriteria));
        cr.setProjection(Projections.property("aracNo"));

        List results = cr.list();
        session.close();
        return results;
    }          
   
  

    public static void main(String[] args) {
        List a = new ArrayList<>();
        a.add(2);
        DBSeferBaslar dbsb = new DBSeferBaslar();
        System.out.println(dbsb.list(a));
    }

    @Override
    public Object select(List<Object> param) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   
}

package com.servisotomasyon.database;

import com.servisotomasyon.abstracts.Listeleme;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.Subqueries;
import com.servisotomasyon.pojos.Arac;
import com.servisotomasyon.pojos.Durak;
import com.servisotomasyon.pojos.Guzergah;
import com.servisotomasyon.pojos.GuzergahDurak;
import com.servisotomasyon.pojos.SeferBaslar;

/**
 *
 * @author SELİM
 */
public class DBGuzergahDurak extends Listeleme {

    public Date getSeferSaati(List<Object> param) {
        int durakNo = (int) param.get(0);
        int aracNo = (int) param.get(1);
        Durak durak = new Durak();
        durak.setDurakNo(durakNo);
        Arac arac = new Arac();
        arac.setAracNo(aracNo);

        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        DetachedCriteria detachedCriteria = DetachedCriteria.forClass(GuzergahDurak.class)
                .add(Restrictions.eq("durakNo", durak))
                .setProjection(Projections.property("guzergahNo"));

        Criteria cr = session.createCriteria(SeferBaslar.class);
        cr.add(Subqueries.propertyIn("guzergahNo", detachedCriteria));
        cr.add(Restrictions.eq("aracNo", arac));
        cr.setProjection(Projections.property("guzergahNo"));

        List list = cr.list();
        Criteria cr0 = session.createCriteria(SeferBaslar.class);
        cr0.add(Subqueries.propertyIn("guzergahNo", detachedCriteria));
        cr0.add(Restrictions.eq("aracNo", arac));
        cr0.setProjection(Projections.property("saat"));

        Date saat = (Date) cr0.list().get(0);

        Criteria cr1 = session.createCriteria(GuzergahDurak.class);
        cr1.add(Restrictions.eq("guzergahNo", list.get(0)));
        cr1.add(Restrictions.eq("durakNo", durak));
        cr1.setProjection(Projections.property("durakSirasi"));

        int durakSirasi = (int) cr1.list().get(0);
        int dakika, saati;
        dakika = saat.getMinutes() + 3 * durakSirasi;
        saati = saat.getHours();
        if (dakika > 59) {
            saati = saati + dakika / 60;
            dakika = dakika % 60;
        }

        System.out.println(saati + ":" + dakika);
        saat.setHours(saati);
        saat.setMinutes(dakika);
        session.close();
        return saat;
    }

    public static void main(String[] args) {
        List a = new ArrayList<>();
        a.add(2);
        a.add(5);
        DBGuzergahDurak dBGuzergahDurak = new DBGuzergahDurak();
        System.out.println(dBGuzergahDurak.getSeferSaati(a));
    }

    @Override
    public Object select(List<Object> param) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List list(List<Object> param) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}

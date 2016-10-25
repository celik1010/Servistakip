package com.servisotomasyon.database;

import com.servisotomasyon.abstracts.Listeleme;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import com.servisotomasyon.pojos.Guzergah;
import com.servisotomasyon.pojos.Guzergahkonumlari;

public class DBGuzergahKonumlari extends Listeleme {

    @Override
    public List list(List<Object> param) {
        int guzergahNo = (int) param.get(0);
        Guzergah guzergah = new Guzergah();
        guzergah.setGuzergahNo(guzergahNo);

        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Criteria cr = session.createCriteria(Guzergahkonumlari.class);
        cr.add(Restrictions.eq("guzergahNo", guzergah));

        List results = cr.list();
        session.close();
        return results;
    }

    public static void main(String[] args) {
        List param=new ArrayList();
        List<Guzergahkonumlari> list=new ArrayList<>();        
        param.add(6);
        DBGuzergahKonumlari bGuzergahKonumlari=new DBGuzergahKonumlari();
        list=bGuzergahKonumlari.list(param);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).getKonumX()+"-"+list.get(i).getKonumY());
        }
        
    }
    
    @Override
    public Object select(List<Object> param) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}

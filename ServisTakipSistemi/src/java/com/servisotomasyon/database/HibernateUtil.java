package com.servisotomasyon.database;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import com.servisotomasyon.pojos.Adres;
import com.servisotomasyon.pojos.Arac;
import com.servisotomasyon.pojos.Durak;
import com.servisotomasyon.pojos.Durakbiner;
import com.servisotomasyon.pojos.Guzergah;
import com.servisotomasyon.pojos.GuzergahDurak;
import com.servisotomasyon.pojos.Guzergahkonumlari;
import com.servisotomasyon.pojos.Personel;
import com.servisotomasyon.pojos.Sahip;
import com.servisotomasyon.pojos.Sefer;
import com.servisotomasyon.pojos.SeferBaslar;
import com.servisotomasyon.pojos.Sirket;
import com.servisotomasyon.pojos.Sofor;
import com.servisotomasyon.pojos.SoforArac;

public class HibernateUtil {
    private static final SessionFactory sessionFactory;
    
    static 
    {

        AnnotationConfiguration config=new AnnotationConfiguration();
        config.addAnnotatedClass(Sirket.class);
        config.addAnnotatedClass(Personel.class);
        config.addAnnotatedClass(Arac.class);
        config.addAnnotatedClass(Durak.class);
        config.addAnnotatedClass(Adres.class);
        config.addAnnotatedClass(Durakbiner.class);
        config.addAnnotatedClass(Guzergah.class);
        config.addAnnotatedClass(GuzergahDurak.class);
        config.addAnnotatedClass(Sahip.class);
        config.addAnnotatedClass(Sefer.class);
        config.addAnnotatedClass(SeferBaslar.class);
        config.addAnnotatedClass(Sofor.class);
        config.addAnnotatedClass(SoforArac.class);
        config.addAnnotatedClass(Guzergahkonumlari.class);
        
        config.configure("hibernate.cfg.xml");
        
        sessionFactory=config.buildSessionFactory();
    
        }
    
    public static SessionFactory getSessionFactory()
    {
        return sessionFactory;
    }
}

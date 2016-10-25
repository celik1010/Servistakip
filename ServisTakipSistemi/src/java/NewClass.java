
import com.servisotomasyon.database.DBArac;
import com.servisotomasyon.database.DBSirket;
import com.servisotomasyon.database.GenelCRUD;
import com.servisotomasyon.database.HibernateUtil;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import com.servisotomasyon.pojos.Durak;
import com.servisotomasyon.pojos.Personel;
import com.servisotomasyon.pojos.Sirket;

public class NewClass {
    
//        AnnotationConfiguration config=new AnnotationConfiguration();
//        config.addAnnotatedClass(Sirket.class);
//        config.configure("hibernate.cfg.xml");
//        SessionFactory sessionFactory=config.buildSessionFactory();
//        Session session=HibernateUtil.getSessionFactory().openSession();
//        session.beginTransaction();
//         Durak d=new Durak();
//         d.setDurakNo(10);
//         d.setDurakAd("Selim");
//         d.setAciklama("Çelik");
//         d.setKonumX(Double.parseDouble("36.890257"));
//         d.setKonumY(Double.parseDouble("36.890257"));
//        Sirket s = new Sirket();
//        s.setSirketNo(78);
//        s.setSirketAdi("ced");
//        GenelCRUD db = new GenelCRUD();
//        System.out.println(db.update(d));
//        session.save(d);
//        session.getTransaction().commit();
    // Criteria cr=session.createCriteria(Sirket.class);
    //  System.out.println(cr.list().get(3));
    //   session.close();
//    }
    public List<Personel> personelList() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        Criteria cr = session.createCriteria(Sirket.class);

        List result = cr.list();
        session.close();
        return result;
    }
}

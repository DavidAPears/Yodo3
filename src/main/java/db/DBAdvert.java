package db;


import models.Advert;
import models.Advert;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

public class DBAdvert {

    private static Transaction transaction;
    private static Session session;

    public static Advert find(int id) {
        session = HibernateUtil.getSessionFactory().openSession();
        Advert advert = null;
        try {
            Criteria cr = session.createCriteria(Advert.class);
            cr.add(Restrictions.eq("id", id));
            advert = (Advert) cr.uniqueResult();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return advert;
    }


}
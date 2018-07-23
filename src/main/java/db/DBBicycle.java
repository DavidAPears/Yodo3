package db;

import models.Bicycle;
import org.hibernate.*;
import org.hibernate.criterion.Restrictions;

public class DBBicycle {

    private static Transaction transaction;
    private static Session session;

    public static Bicycle find(int id) {
        session = HibernateUtil.getSessionFactory().openSession();
        Bicycle bicycle = null;
        try {
            Criteria cr = session.createCriteria(Bicycle.class);
            cr.add(Restrictions.eq("id", id));
            bicycle = (Bicycle) cr.uniqueResult();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return bicycle;
    }


}
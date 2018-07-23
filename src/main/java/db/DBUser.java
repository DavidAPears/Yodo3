package db;

import models.Advert;
import models.User;
import models.enums.Category;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class DBUser {

    private static Session session;

    public static List<Advert> getAdvertsForUser(User user) {
        session = HibernateUtil.getSessionFactory().openSession();
        List<Advert> adverts = null;
        try {
            Criteria cr = session.createCriteria(Advert.class);
            cr.add(Restrictions.eq("user", user));
            adverts = cr.list();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return adverts;
    }

    public static List<Advert> getAdvertsForUserByCategory(User user, Category category) {
        session = HibernateUtil.getSessionFactory().openSession();
        List<Advert> adverts = null;
        try {
            Criteria cr = session.createCriteria(Advert.class);
            cr.add(Restrictions.eq("category", category));
            cr.add(Restrictions.eq("user", user));
            adverts = cr.list();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return adverts;
    }

    public static User find(int id) {
        session = HibernateUtil.getSessionFactory().openSession();
        User user = null;
        try {
            Criteria cr = session.createCriteria(User.class);
            cr.add(Restrictions.eq("id", id));
            user = (User) cr.uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return user;
    }

}
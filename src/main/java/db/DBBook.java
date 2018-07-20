package db;

import models.Advert;
import models.Book;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class DBBook {

    private static Session session;

    public static Book find(int id) {
        session = HibernateUtil.getSessionFactory().openSession();
        Book book = null;
        try {
            Criteria cr = session.createCriteria(Book.class);
            cr.add(Restrictions.eq("id", id));
            book = (Book) cr.uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return book;
    }

}
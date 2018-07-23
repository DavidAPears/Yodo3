package db;

import models.Advert;
import models.ComputerGame;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class DBComputerGame {

    private static Session session;

    public static ComputerGame find(int id) {
        session = HibernateUtil.getSessionFactory().openSession();
        ComputerGame computerGame = null;
        try {
            Criteria cr = session.createCriteria(ComputerGame.class);
            cr.add(Restrictions.eq("id", id));
            computerGame = (ComputerGame) cr.uniqueResult();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return computerGame;
    }

}
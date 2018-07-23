package db;

import models.BoardGame;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

public class DBBoardGame {

    private static Session session;

    public static BoardGame find(int id) {
        session = HibernateUtil.getSessionFactory().openSession();
        BoardGame boardGame = null;
        try {
            Criteria cr = session.createCriteria(BoardGame.class);
            cr.add(Restrictions.eq("id", id));
            boardGame = (BoardGame) cr.uniqueResult();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return boardGame;
    }

}


package dao;

import database.HibernateUtil;
import model.Editorial;
import org.hibernate.Session;

public class EditorialDAO {
    private Session session;

    public void crearEditorial(Editorial editorial){
        session = new HibernateUtil().getSessionFactory().getCurrentSession();
        session.beginTransaction();

        session.persist(editorial);

        session.getTransaction().commit();
        session.close();
    }
}

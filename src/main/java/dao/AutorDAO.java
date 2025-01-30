package dao;

import database.HibernateUtil;
import model.Autor;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class AutorDAO {
    private Session session;

    public void crearAutor(Autor autor){
        session = new HibernateUtil().getSessionFactory().getCurrentSession();
        session.beginTransaction();

        session.persist(autor);

        session.getTransaction().commit();
        session.close();
    }

    public List<Autor> obtenerAutores(){
        session = new HibernateUtil().getSessionFactory().getCurrentSession();
        session.beginTransaction();

        String querySTR = "FROM Autor";
        Query<Autor> query = session.createQuery(querySTR, Autor.class);
        List<Autor> listaAutores = query.list();

        session.getTransaction().commit();
        session.close();

        return listaAutores;
    }
}

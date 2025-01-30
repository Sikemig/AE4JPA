package dao;

import database.HibernateUtil;
import model.Libreria;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class LibreriaDAO {
    private Session session;

    public void crearLibreria(Libreria libreria){
        session = new HibernateUtil().getSessionFactory().getCurrentSession();
        session.beginTransaction();

        session.persist(libreria);

        session.getTransaction().commit();
        session.close();
    }

    public List<Libreria> libreriasLibros(){
        session = new HibernateUtil().getSessionFactory().getCurrentSession();
        session.beginTransaction();

        Query<Libreria> query = session.createNamedQuery("Libreria.findLibros", Libreria.class);
        List<Libreria> listaLibrerias = query.list();

        session.getTransaction().commit();
        session.close();

        return listaLibrerias;
    }
}

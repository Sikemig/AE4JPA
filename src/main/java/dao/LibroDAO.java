package dao;

import database.HibernateUtil;
import model.Autor;
import model.Editorial;
import model.Libreria;
import model.Libro;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class LibroDAO {
    private Session session;

    public void crearLibro(Libro libro, Autor autor, Editorial editorial){
        session = new HibernateUtil().getSessionFactory().getCurrentSession();
        session.beginTransaction();

        libro.setAutor(autor);
        libro.setEditorial(editorial);

        session.merge(libro);

        session.getTransaction().commit();
        session.close();
    }

    public void asociarLibreria(int idLibro, int idLibreria){
        session = new HibernateUtil().getSessionFactory().getCurrentSession();
        session.beginTransaction();

        Libro libro = session.get(Libro.class, idLibro);
        Libreria libreria = session.get(Libreria.class, idLibreria);

        libro.getLibrerias().add(libreria);
        libreria.getLibros().add(libro);

        session.persist(libro);
        session.persist(libreria);

        session.getTransaction().commit();
        session.close();
    }

    public List<Libro> mostrarLibros(){
        session = new HibernateUtil().getSessionFactory().getCurrentSession();
        session.beginTransaction();

        String querySTR = "FROM Libro";
        Query<Libro> query = session.createQuery(querySTR, Libro.class);
        List<Libro> listaLibros = query.list();

        session.getTransaction().commit();
        session.close();

        return listaLibros;
    }

    public List<Libro> libroLibrerias(){
        session = new HibernateUtil().getSessionFactory().getCurrentSession();
        session.beginTransaction();

        Query<Libro> query = session.createNamedQuery("Libro.findLibrerias", Libro.class);
        List<Libro> listaLibros = query.list();

        session.getTransaction().commit();
        session.close();

        return listaLibros;
    }
}

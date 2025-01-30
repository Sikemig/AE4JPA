package controller;

import dao.AutorDAO;
import dao.EditorialDAO;
import dao.LibreriaDAO;
import dao.LibroDAO;
import database.HibernateUtil;
import model.Autor;
import model.Editorial;
import model.Libreria;
import model.Libro;
import org.hibernate.Session;


public class LibrosController {
    private AutorDAO autorDAO;
    private EditorialDAO editorialDAO;
    private LibroDAO libroDAO;
    private LibreriaDAO libreriaDAO;


    public LibrosController(){
        autorDAO= new AutorDAO();
        editorialDAO=new EditorialDAO();
        libroDAO = new LibroDAO();
        libreriaDAO = new LibreriaDAO();
    }

    public void crearAutor(Autor autor){
        autorDAO.crearAutor(autor);
    }

    public void crearEditorial(Editorial editorial){
        editorialDAO.crearEditorial(editorial);
    }

    public void crearLibro(Libro libro, int idAutor, int idEditorial){
        Session session = new HibernateUtil().getSessionFactory().getCurrentSession();
        session.beginTransaction();

        Autor autor = session.get(Autor.class, idAutor);
        Editorial editorial = session.get(Editorial.class, idEditorial);

        session.getTransaction().commit();
        session.close();

        libroDAO.crearLibro(libro, autor, editorial);
    }

    public void crearLibreria(Libreria libreria){
        libreriaDAO.crearLibreria(libreria);
    }

    public void asociarLibros(int idLibro, int idLibreria){
        libroDAO.asociarLibreria(idLibro, idLibreria);
    }

    public void obtenerLibros(){
        System.out.println("El listado de libros es: ");
        for (Libro libro: libroDAO.mostrarLibros()){
            System.out.println("\tTitulo: " +libro.getTitulo());
            System.out.println("\tAutor: " + libro.getAutor().getNombre()+ " " + libro.getAutor().getApellido());
            System.out.println("\tEditorial: " + libro.getEditorial().getNombre()+"\n");
        }
    }

    public void obtenerAutores(){
        System.out.println("Mostrando autores: ");
        for(Autor autor: autorDAO.obtenerAutores()){
            System.out.println("\tNombre: "+ autor.getNombre());
            System.out.println("\tApellido: "+ autor.getApellido());
            if(autor.getFechaNacimiento()!=null){
                System.out.println("\tFecha de nacimiento: "+ autor.getFechaNacimiento());
            }
            System.out.println("\tLibros: ");
            for(Libro libro: autor.getLibros()){
                System.out.println("\t\t"+libro.getTitulo());
            }
            System.out.println("");
        }
    }

    public void obtenerLibrerias(){
        System.out.println("Mostrando librerias: ");
        for(Libreria libreria : libreriaDAO.libreriasLibros()){
            System.out.println("\tLibreria: " + libreria.getNombre());
            System.out.println("\tDueño: " + libreria.getDueño());
            System.out.println("\tDireccion: " + libreria.getDireccion());
            System.out.println("\tLibros en libreria: ");
            for(Libro libro : libreria.getLibros()){
                System.out.println("\t\t" + libro.getTitulo());
            }
            System.out.println("");
        }
    }

    public void librosEnLibrerias(){
        System.out.println("Mostrando libros: ");
        for (Libro libro: libroDAO.libroLibrerias()){
            System.out.println("\tTitulo: " +libro.getTitulo());
            System.out.println("\tEditorial: " + libro.getEditorial().getNombre());
            for(Libreria libreria : libro.getLibrerias()){
                System.out.println("\t\tDisponible en libreria: " + libreria.getNombre());
            }
            System.out.println("");
        }
    }
}

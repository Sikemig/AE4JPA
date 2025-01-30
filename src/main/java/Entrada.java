import controller.LibrosController;
import model.Autor;
import model.Editorial;
import model.Libreria;
import model.Libro;

import java.text.SimpleDateFormat;

public class Entrada {
    public static void main(String[] args) {

        LibrosController librosController = new LibrosController();

        // Añadir 3 autores
        //librosController.crearAutor(new Autor("Sikem", "Iglesias", "20-06-1990"));
        //librosController.crearAutor(new Autor("Alicia", "Lopez", "01-01-1980"));
        //librosController.crearAutor(new Autor("Borja", "Martin"));


        // Añadir 2 editoriales
        //librosController.crearEditorial(new Editorial("Planeta", "C/ Falsa, 123"));
        //librosController.crearEditorial(new Editorial("Alma", "C/ Verdadera, 987"));


        // Añadir 8 libros
        //librosController.crearLibro(new Libro("El Quijote", 19.99), 1, 1);
        //librosController.crearLibro(new Libro("El Señor de los Anillos", 29.99), 1, 1);
        //librosController.crearLibro(new Libro("Orgullo y Prejuicio", 15.99), 2, 1);
        //librosController.crearLibro(new Libro("Cronica de una Muerte Anunciada", 20.00), 3, 1);
        //librosController.crearLibro(new Libro("Muerte en el Nilo", 19.99), 2, 2);
        //librosController.crearLibro(new Libro("Asesinato en el Orient Express", 19.99), 2, 2);
        //librosController.crearLibro(new Libro("Ready Player One", 19.99), 3, 2);
        //librosController.crearLibro(new Libro("Ready Player Two", 19.99), 3, 2);

        // Añadir 2 librerias
        //librosController.crearLibreria(new Libreria("Re-read", "Pepe", "Avenida Aleatoria, 555"));
        //librosController.crearLibreria(new Libreria("Cervantes", "Paco", "Plaza Fija, 2"));

        // Asociar 4 libros a cada libreria
        //librosController.asociarLibros(1,1);
        //librosController.asociarLibros(3,1);
        //librosController.asociarLibros(5,1);
        //librosController.asociarLibros(7,1);
        //librosController.asociarLibros(2,2);
        //librosController.asociarLibros(4,2);
        //librosController.asociarLibros(6,2);
        //librosController.asociarLibros(8,2);



        //Mostrar todos los libros dados de alta, con su editorial y su autor
        //librosController.obtenerLibros();


        //Mostrar todos los autores dados de alta, con sus libros asociados
        librosController.obtenerAutores();


        ///Mostrar todas las librerías, con solamente sus libros asociados
        //librosController.obtenerLibrerias();


        ///Mostrar todos los libros dados de alta, y en la librería en la que están.
        //librosController.librosEnLibrerias();
    }
}

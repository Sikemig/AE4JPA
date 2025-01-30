package model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor

@NamedQuery(name="Libro.findLibrerias", query = "FROM Libro JOIN librerias")

@Entity
@Table(name="libros")
public class Libro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String titulo;

    @Column
    private double precio;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="id_autor")
    private Autor autor;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="id_editorial")
    private Editorial editorial;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "stock_librerias",
                joinColumns = @JoinColumn(name = "id_libro"),
                inverseJoinColumns = @JoinColumn(name = "id_libreria"))
    private List<Libreria> librerias;


    public Libro(String titulo, double precio) {
        this.titulo = titulo;
        this.precio = precio;
    }
}

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

@NamedQuery(name="Libreria.findLibros", query = "FROM Libreria JOIN libros")

@Entity
@Table(name="librerias")
public class Libreria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String nombre;

    @Column(name = "nombre_dueño")
    private String dueño;

    @Column
    private String direccion;

    @ManyToMany(mappedBy = "librerias", fetch = FetchType.EAGER)
    private List<Libro> libros;

    public Libreria(String nombre, String dueño, String direccion) {
        this.nombre = nombre;
        this.dueño = dueño;
        this.direccion = direccion;
    }
}

package com.rudy.booktify.model;

import jakarta.persistence.*;

@Entity
@Table(name = "libros")
public class Libro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String titulo;

    private String idioma;
    private int descargas;

    @ManyToOne
    @JoinColumn(name = "autor_id", nullable = false)
    private Autor autor;

    // Getters y Setters
    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public String getTitulo() { return titulo; }

    public void setTitulo(String titulo) { this.titulo = titulo; }

    public String getIdioma() { return idioma; }

    public void setIdioma(String idioma) { this.idioma = idioma; }

    public int getDescargas() { return descargas; }

    public void setDescargas(int descargas) { this.descargas = descargas; }

    public Autor getAutor() { return autor; }

    public void setAutor(Autor autor) { this.autor = autor; }

    @Override
    public String toString() {
        return "--------------LIBRO-----------\n" +
                "Titulo: " + titulo + "\n" +
                "Autor: " + (autor != null ? autor.getNombre() : "Desconocido") + "\n" +
                "Idioma: " + idioma + "\n" +
                "Numero de descargas: " + descargas + "\n" +
                "-----------------------------------";
    }
}

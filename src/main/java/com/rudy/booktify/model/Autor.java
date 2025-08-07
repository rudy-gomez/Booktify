package com.rudy.booktify.model;

import jakarta.persistence.*;

@Entity
@Table(name = "autores")
public class Autor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nombre;

    private Integer nacimiento;
    private Integer fallecimiento;

    // Getters y Setters
    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public String getNombre() { return nombre; }

    public void setNombre(String nombre) { this.nombre = nombre; }

    public Integer getNacimiento() { return nacimiento; }

    public void setNacimiento(Integer nacimiento) { this.nacimiento = nacimiento; }

    public Integer getFallecimiento() { return fallecimiento; }

    public void setFallecimiento(Integer fallecimiento) { this.fallecimiento = fallecimiento; }

    @Override
    public String toString() {
        return "-----------AUTOR-----------\n" +
                "Nombre: " + nombre + "\n" +
                "Año de nacimiento: " + (nacimiento != null ? nacimiento : "Desconocido") + "\n" +
                "Año de fallecimiento: " + (fallecimiento != null ? fallecimiento : "Desconocido") + "\n" +
                "----------------------------";
    }
}

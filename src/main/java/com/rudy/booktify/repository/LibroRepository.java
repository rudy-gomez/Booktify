package com.rudy.booktify.repository;

import com.rudy.booktify.model.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

public interface LibroRepository extends JpaRepository<Libro, Long> {
    List<Libro> findByIdioma(String idioma);
    Optional<Libro> findByTitulo(String titulo);
}

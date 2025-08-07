package com.rudy.booktify.repository;

import com.rudy.booktify.model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

public interface AutorRepository extends JpaRepository<Autor, Long> {
    List<Autor> findByNacimientoLessThanEqualAndFallecimientoGreaterThanEqual(int desde, int hasta);
    List<Autor> findByFallecimientoIsNullOrFallecimientoGreaterThan(int año);
    Optional<Autor> findByNombre(String nombre);
}

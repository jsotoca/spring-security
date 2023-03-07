package com.renitope.securirty.api.model.repository;

import com.renitope.securirty.api.model.entity.Libro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LibroRepository extends JpaRepository<Libro,Long> {
}

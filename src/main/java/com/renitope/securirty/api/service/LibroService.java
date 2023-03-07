package com.renitope.securirty.api.service;

import com.renitope.securirty.api.model.entity.Libro;

import java.util.List;

public interface LibroService {
    List<Libro> listar();
    Long guardar(Libro libro);
}

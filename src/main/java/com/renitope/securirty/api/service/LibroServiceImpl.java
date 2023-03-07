package com.renitope.securirty.api.service;

import com.renitope.securirty.api.model.entity.Libro;
import com.renitope.securirty.api.model.repository.LibroRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class LibroServiceImpl implements LibroService{

    private final LibroRepository libroRepository;

    @Override
    public List<Libro> listar() {
        return libroRepository.findAll();
    }

    @Override
    public Long guardar(Libro libro) {
        var entity = libroRepository.save(libro);
        return entity.getId();
    }
}

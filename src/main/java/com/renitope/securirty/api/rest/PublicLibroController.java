package com.renitope.securirty.api.rest;

import com.renitope.securirty.api.model.entity.Libro;
import com.renitope.securirty.api.service.LibroService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "public/libros")
@RequiredArgsConstructor
public class PublicLibroController {

    private final LibroService libroService;

    @GetMapping("")
    public ResponseEntity<List<Libro>> listar(){
        return  ResponseEntity.ok(libroService.listar());
    }

    @PostMapping("")
    public ResponseEntity<Long> guardar(@RequestBody Libro libro){
        var response = libroService.guardar(libro);
        return new ResponseEntity(HttpStatus.CREATED);
    }


}

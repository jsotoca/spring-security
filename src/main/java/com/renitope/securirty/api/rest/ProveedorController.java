package com.renitope.securirty.api.rest;

import com.renitope.securirty.api.model.entity.Cliente;
import com.renitope.securirty.api.model.entity.Proveedor;
import com.renitope.securirty.api.service.ProveedorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "proveedor")
public class ProveedorController {
    private final ProveedorService proveedorService;

    @GetMapping("")
    public ResponseEntity<List<Proveedor>> listar(){
        return ResponseEntity.ok(proveedorService.listar());
    }
}

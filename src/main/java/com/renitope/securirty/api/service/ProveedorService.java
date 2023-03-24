package com.renitope.securirty.api.service;

import com.renitope.securirty.api.model.entity.Proveedor;
import com.renitope.securirty.api.model.repository.ProveedorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ProveedorService {
    private final ProveedorRepository proveedorRepository;

    public List<Proveedor> listar(){
        return proveedorRepository.findAll();
    }
}

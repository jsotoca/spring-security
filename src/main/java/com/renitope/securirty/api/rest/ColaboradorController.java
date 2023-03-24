package com.renitope.securirty.api.rest;

import com.renitope.securirty.api.model.entity.Colaborador;
import com.renitope.securirty.api.model.entity.Proveedor;
import com.renitope.securirty.api.service.ColaboradorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "colaborador")
@Secured("ROLE_ADMIN")
public class ColaboradorController {
    private final ColaboradorService colaboradorService;

    @GetMapping("")
    public ResponseEntity<List<Colaborador>> listar(){
        return ResponseEntity.ok(colaboradorService.listar());
    }
}

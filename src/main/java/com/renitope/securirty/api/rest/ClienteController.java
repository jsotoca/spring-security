package com.renitope.securirty.api.rest;

import com.renitope.securirty.api.model.entity.Cliente;
import com.renitope.securirty.api.service.ClienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "cliente")
@Secured({"ROLE_USER","ROLE_ADMIN"})
public class ClienteController {
    private final ClienteService clienteService;

    @GetMapping("")
    public ResponseEntity<List<Cliente>> listar(){
        return ResponseEntity.ok(clienteService.listar());
    }
}

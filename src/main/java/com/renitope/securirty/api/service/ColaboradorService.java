package com.renitope.securirty.api.service;

import com.renitope.securirty.api.model.entity.Colaborador;
import com.renitope.securirty.api.model.repository.ColaboradorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ColaboradorService {
    private final ColaboradorRepository colaboradorRepository;

    public List<Colaborador> listar(){
        return colaboradorRepository.findAll();
    }
}

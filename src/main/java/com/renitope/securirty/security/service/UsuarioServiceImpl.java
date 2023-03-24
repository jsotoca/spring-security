package com.renitope.securirty.security.service;

import com.renitope.securirty.security.entity.UsuarioEntity;
import com.renitope.securirty.security.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import static java.util.Objects.isNull;

@Slf4j
@RequiredArgsConstructor
@Service
public class UsuarioServiceImpl {

    private final UsuarioRepository usuarioRepository;

    public UsuarioEntity buscarUsuario(String username){
        UsuarioEntity usuarioEntity= usuarioRepository.loadUserByUsuario(username).orElseThrow(null);
        log.info("usuarioEntity {}",usuarioEntity);
        if (isNull(usuarioEntity)) {
            throw new UsernameNotFoundException("Usuario no encontrado!");
        }
        usuarioEntity.setClave("null");
        return usuarioEntity;
    }
}

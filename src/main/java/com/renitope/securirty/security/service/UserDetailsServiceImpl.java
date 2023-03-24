package com.renitope.securirty.security.service;

import com.renitope.securirty.security.entity.AuthorityEntity;
import com.renitope.securirty.security.entity.UsuarioEntity;
import com.renitope.securirty.security.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static java.util.Objects.isNull;

@Slf4j
@RequiredArgsConstructor
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        try {

            UsuarioEntity usuarioEntity= usuarioRepository.loadUserByUsuario(username).orElseThrow(null);
            log.info("usuarioEntity {}",usuarioEntity);
            if (isNull(usuarioEntity)) {
                throw new UsernameNotFoundException("Usuario no encontrado!");
            }

            return User
                    .builder()
                    .username(usuarioEntity.getUsuario())
                    .password(usuarioEntity.getClave())
                    .authorities(getAuthorities(usuarioEntity.getAuthorities()))
                    .build();

        } catch (Exception e) {
            throw new UsernameNotFoundException("Error al cargar usuario!");
        }
    }

    private List<GrantedAuthority> getAuthorities(Set<AuthorityEntity> authorities){
        List<GrantedAuthority> authorityList = new ArrayList<>();
        for (AuthorityEntity authorityEntity : authorities) {
            authorityList.add(new SimpleGrantedAuthority(authorityEntity.getNombre()));
        }
        log.info("authorityList {}",authorityList);
        return authorityList;
    }


}

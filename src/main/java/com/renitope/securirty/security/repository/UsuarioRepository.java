package com.renitope.securirty.security.repository;

import com.renitope.securirty.security.entity.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioEntity, Long> {
    @Query(value = "select * from usuario as temp where temp.usuario=?1 and temp.estado='1'", nativeQuery = true)
    Optional<UsuarioEntity> loadUserByUsuario(String usuario);
}

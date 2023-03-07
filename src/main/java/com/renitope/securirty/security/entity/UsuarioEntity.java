package com.renitope.securirty.security.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@Table(name = "usuario")
public class UsuarioEntity {

    @Id
    @Column(name = "usuario_id")
    private Long id;
    private String usuario;
    private String clave;
    private String nombre;
    private String estado;

    // Authorities
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "usuario_authority", joinColumns = { @JoinColumn(name = "usuario_id") }, inverseJoinColumns = {
            @JoinColumn(name = "authority_id") })
    private Set<AuthorityEntity> authorities = new HashSet<>();
}

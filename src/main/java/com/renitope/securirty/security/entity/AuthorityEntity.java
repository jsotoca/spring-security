package com.renitope.securirty.security.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "roles")
public class AuthorityEntity {
    @Id
    @Column(name = "authority_id")
    private Long id = 0L;

    @Column(name = "nombre")
    private String nombre = "";
}

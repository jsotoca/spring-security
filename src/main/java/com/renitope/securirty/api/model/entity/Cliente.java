package com.renitope.securirty.api.model.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "cliente")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long    id;
    private String  dni;
    private String  nombres;
    private String  redsocial;
    private String  cuenta;
    private String  direccion;
    private String  telefono;
    private String  email;
    private String  usuario;
}

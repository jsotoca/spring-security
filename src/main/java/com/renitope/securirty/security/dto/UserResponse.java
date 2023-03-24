package com.renitope.securirty.security.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserResponse {
    private Long   id;
    private String usuario;
    private String clave;
    private String nombre;
    private String estado;
}

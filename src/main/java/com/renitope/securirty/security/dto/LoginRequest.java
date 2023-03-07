package com.renitope.securirty.security.dto;

import lombok.Data;

@Data
public class LoginRequest {
    private String usuario;
    private String clave;
}

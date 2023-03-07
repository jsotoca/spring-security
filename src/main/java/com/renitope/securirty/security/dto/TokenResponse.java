package com.renitope.securirty.security.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Builder.Default;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class TokenResponse {
    @Default
    private String type = "Bearer";
    private String token;
    private String refreshToken;
    private String user;
    private List<String> authorities;
}

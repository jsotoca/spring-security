package com.renitope.securirty.security.api;

import com.renitope.securirty.security.dto.LoginRequest;
import com.renitope.securirty.security.dto.TokenResponse;
import com.renitope.securirty.security.exceptions.TokenException;
import com.renitope.securirty.security.utils.JWTUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Slf4j
@RestController
@RequestMapping("/auth")
public class ApiSecurity {

    @Autowired
    private final UserDetailsService userDetailsService;

    @Autowired
    private final JWTUtils jwtUtils;

    @Autowired
    private final AuthenticationManagerBuilder authenticationManagerBuilder;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest ) throws TokenException {
        try {

            log.info("loginRequest {}", loginRequest);

            UsernamePasswordAuthenticationToken upat = new UsernamePasswordAuthenticationToken(
                    loginRequest.getUsuario(), loginRequest.getClave());

            Authentication authentication = authenticationManagerBuilder.getObject().authenticate(upat);

            SecurityContextHolder.getContext().setAuthentication(authentication);

            UserDetails userDetails = (UserDetails) authentication.getPrincipal();

            String token = jwtUtils.generateJwtToken(authentication);
            //String token = jwtUtils.generateJwtToken(authentication, false);
            //String refeshToken = jwtUtils.generateJwtToken(authentication, true);

            List<String> authorities = userDetails.getAuthorities().stream().map(item -> item.getAuthority())
                    .collect(Collectors.toList());

            return ResponseEntity.ok().body(TokenResponse.builder().user(userDetails.getUsername()).token(token)
                    .refreshToken("refeshToken").authorities(authorities).build());

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("attemptAuthentication " + e.getMessage());
            throw new TokenException(e);
        }
    }
}

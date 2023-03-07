package com.renitope.securirty.security.constants;

public class Constants {
    public static final String LOGIN_URL 					= "/login";
    public static final String HEADER_AUTHORIZACION_KEY 	= "Authorization";
    public static final String TOKEN_BEARER_PREFIX 		    = "Bearer ";
    public static final String AUTHORITIES					= "authorities";

    public static final String ISSUER_INFO                  = "http://www.galaxy.edu.pe/";
    public static final String SUPER_SECRET_KEY 			= "r4u7x!A%D*G-KaP"; //123
    public static final long   TOKEN_EXPIRATION_TIME 		= 86_400_000; // 1 day  86_400_000
}

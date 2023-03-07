package com.renitope.securirty;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class SecurirtyApplication {

	public static void main(String[] args) {
		System.out.println( new BCryptPasswordEncoder().encode("123"));

		BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder();
		System.out.println(bcrypt.matches("123","$2a$10$F9GK/h0mRCZH4JEy8GWucufwtAD35whC5ogSN/IxYKxDeqMkHmxtyx"));
		SpringApplication.run(SecurirtyApplication.class, args);
	}

}

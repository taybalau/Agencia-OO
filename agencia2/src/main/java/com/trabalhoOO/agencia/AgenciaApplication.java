package com.trabalhoOO.agencia;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.UserDetailsServiceAutoConfiguration;

@SpringBootApplication
public class AgenciaApplication {

	public static void main(String[] args) {
		SpringApplication.run(AgenciaApplication.class, args);
	}
//(exclude= {UserDetailsServiceAutoConfiguration.class})
}

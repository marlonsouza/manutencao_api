package com.souza.manutencao;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;

@EnableJpaAuditing
@SpringBootApplication
@EnableAuthorizationServer
public class ManutencaoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ManutencaoApplication.class, args);
	}

}

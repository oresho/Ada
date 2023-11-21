package com.payverdict.PayVerdict;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@OpenAPIDefinition(
		info =
		@io.swagger.v3.oas.annotations.info.Info(
				description = "Ada marketmate application backend",
				title = "Ada App",
				version = "1.0"
		),
		servers = {
				@Server(
						url = "http://localhost:9191",
						description = "DEV Server"
				)
		},
		security = {
				@io.swagger.v3.oas.annotations.security.SecurityRequirement(
						name = "Bearer Authentication")
		})
@SecurityScheme(
		name = "Bearer Authentication",
		description = "JWT Authentication",
		scheme = "bearer",
		type = SecuritySchemeType.HTTP,
		bearerFormat = "JWT",
		in = SecuritySchemeIn.HEADER
)
@SpringBootApplication
public class PayVerdictApplication {

	public static void main(String[] args) {
		SpringApplication.run(PayVerdictApplication.class, args);
	}

}

package com.client.ws.rasmooplus;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(
		info = @Info(
				title = "Rasmoo Plus",
				description = "API para atender o client Rasmoo Plus",
				version = "v0",
				license = @License(name = "Guilherme Ribeiro")
		)
)
public class WsRasmooPlusApplication {

	public static void main(String[] args) {
		SpringApplication.run(WsRasmooPlusApplication.class, args);
	}

}

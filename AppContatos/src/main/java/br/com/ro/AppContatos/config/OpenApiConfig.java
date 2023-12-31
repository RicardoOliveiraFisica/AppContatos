package br.com.ro.AppContatos.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityScheme;

@Configuration
public class OpenApiConfig {

	@Bean
	public OpenAPI customOpenAPI() {
		return new OpenAPI()
				.components(new Components().addSecuritySchemes("basicScheme", 
						new SecurityScheme().type(SecurityScheme.Type.HTTP).scheme("basic")))
				.info(new Info()
						.title("App Cadastro de Contatos")
						.description("Este aplicativo faz controle de pessoas e seus contatos")
						.contact(new Contact()
								.name("Ricardo de Oliveira")
								.email("ricardo2006oliveira@gmail.com")
								.url("https://github.com/RicardoOliveiraFisica/AppContatos.git"))
						.version("Versao 0.0.1-SNASHOT")
						);					
				
	}
}

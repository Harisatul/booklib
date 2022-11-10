package org.gdsc.booklib;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
@OpenAPIDefinition(
		info = @Info(contact =  @Contact(name = "Harisatul Aulia", email = "haris.auia404@gmail.com"),
				title = "GDSC Book Lib API", version = "1.0.0",
				description = "Simple Book lib API with Spring REST. provide basic CRUD Operation for Book and user API"),
		servers = {@Server(url = "http://localhost:8080/", description = "Development"),
				@Server(url = "https://booklib-production.up.railway.app/swagger-ui/index.html", description = "Production")},
		tags = {
				@Tag(name = "User", description = "This is the simple CRUD operation for User entities."),
				@Tag(name = "Books", description = "This is the simple CRUD operation for Book entities."),
		}
)
public class BooklibApplication {

	public static void main(String[] args) {
		SpringApplication.run(BooklibApplication.class, args);
	}

}

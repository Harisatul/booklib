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
				title = "User API", version = "1.0.0",
				description = "Simple User API with Spring REST. provide basic CRUD Operation for User API"),
		servers = {@Server(url = "http://localhost:8080/cinema/api/v1", description = "Development"),
				@Server(url = "https://harisatulauliacinemaapp.up.railway.app/cinema/api/v1", description = "Production")},
		tags = {
				@Tag(name = "User", description = "This is the simple CRUD operation for User entities."),
		}
)
public class BooklibApplication {

	public static void main(String[] args) {
		SpringApplication.run(BooklibApplication.class, args);
	}

}

package com.example.annonceapi;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(
        info = @Info(
                title = "Annonces API Documentation",
                description = "les docs sont générés automatiquement",
                contact = @Contact(
                        name = "Abdallah Hameur Lain",
                        email = "hameurlain.abdallah@gmail.com",
                        url = "https://www.linkedin.com/in/hameurlain-abdallah/"
                ),
                version = "1.0.alpha"
        ),
        servers = {
                @Server(
                        url = "http://localhost:8082",
                        description = "local : Intellij IDEA"
                ),
                @Server(
                        url = "http://aws.someurl.com",
                        description = "Remote docker thing"
                )
        }
)
public class AnnonceApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(AnnonceApiApplication.class, args);
    }

}

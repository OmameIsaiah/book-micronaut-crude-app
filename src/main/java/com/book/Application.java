package com.book;

import io.micronaut.runtime.Micronaut;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;

@OpenAPIDefinition(
        info = @Info(
                title = "Book Micronaut API",
                version = "0.0",
                description = "Simple Book CRUD Operation with Micronaut",
                license = @License(name = "Apache 2.0", url = "http://localhost:8086/"),
                contact = @Contact(url = "https://github.com/OmameIsaiah/book-micronaut-crude-app", name = "Isaiah Omame", email = "omameazy@gmail.com")
        )
)
public class Application {

    public static void main(String[] args) {
        Micronaut.run(Application.class, args);
    }
}
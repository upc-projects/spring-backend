package io.proyection.projection;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class ProjectionApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProjectionApplication.class, args);
    }


}

package net.jordimp.katas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@EnableMongoRepositories("net.jordimp.katas.repository.mongo.**")
@EnableJpaRepositories("net.jordimp.katas.repository.h2.**")
@ComponentScan(basePackages = { "net.jordimp.katas.*" })
@EntityScan("net.jordimp.katas.entity.**")
@SpringBootApplication
public class Application {

    public static void main(final String[] args) {
        SpringApplication.run(Application.class, args);
    }

}

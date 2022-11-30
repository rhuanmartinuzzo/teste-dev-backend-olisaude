package br.com.olisaude;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Service;

import javax.persistence.Entity;


@SpringBootApplication()
@EnableJpaRepositories(basePackages = "br.com.olisaude.repositories")
@EntityScan(basePackages = "br.com.olisaude.model")
public class Startup {

    public static void main(String[] args) {

        SpringApplication.run(Startup.class, args);
    }

}

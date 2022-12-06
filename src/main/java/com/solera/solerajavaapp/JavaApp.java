package com.solera.solerajavaapp;

import org.slf4j.Logger;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import static org.slf4j.LoggerFactory.getLogger;


@SpringBootApplication
public class JavaApp {

    private static final Logger log = getLogger(JavaApp.class);

    public static void main(String[] args) {
        SpringApplication.run(JavaApp.class, args);
    }

    @Bean
    public CommandLineRunner demo(PersonRepo repository) {
        return (args) -> {
            repository.save(new Person("John", "Smith", 1011, "a@a.com"));
            repository.save(new Person("Kielder", "Francis", 1012, "b@b.com"));
            repository.save(new Person("Tim", "Lee", 1013, "c@c.com"));
            repository.save(new Person("Advait", "Kumar", 1014, "d@d.com"));

            log.info("Person found with findAll():");
            log.info("-------------------------------");
            for (Person person : repository.findAll()) {
                log.info(person.toString());
            }
            log.info("");

            Person person = repository.findById(2L);
            log.info("Person found with findById(1L):");
            log.info("--------------------------------");
            log.info(person.toString());
            log.info("");

            // fetch persons by last name
            log.info("Person found with findByLastName('Bauer'):");
            log.info("--------------------------------------------");
            repository.findByLastName("Bruh").forEach(bruh -> {
                log.info(bruh.toString());
            });
            log.info("");


        };
    }
}

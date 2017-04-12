package by.epam.rafalovich.ws;

import de.codecentric.boot.admin.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@EnableAdminServer
@ComponentScan("by.epam.rafalovich.ws")
public class SpringBootWSApplication {

    public static void main(String[] args) {

        SpringApplication.run(SpringBootWSApplication.class, args);
    }

}

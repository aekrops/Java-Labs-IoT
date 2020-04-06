package ua.lviv.iot.lawFirm.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan({ "ua.lviv.iot.lawFirm.dataaccess", 
                 "ua.lviv.iot.lawFirm.business",
                 "ua.lviv.iot.lawFirm.spring.controller" 
               })
@EnableJpaRepositories({ "ua.lviv.iot.lawFirm.dataaccess" })
public class RestApplication {

    public static void main(String[] args) {
        SpringApplication.run(RestApplication.class, args);
    }

}

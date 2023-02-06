package ua.com.shop.ehcachehibernate2023;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class EhcacheHibernate2023Application {

    public static void main(String[] args) {
        SpringApplication.run(EhcacheHibernate2023Application.class, args);
    }

}

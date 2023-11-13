package com.events.center.events_center;


import com.events.center.events_center.entity.User;
import com.events.center.events_center.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class EventsCenterApplication {

    public static void main(String[] args) {
        SpringApplication.run(EventsCenterApplication.class, args);
    }

    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(EventsCenterApplication.class);
    }

    @Bean
    CommandLineRunner run(UserRepository userRepository) {
        return args -> {
            if (userRepository.findAll().size() == 0) {
                userRepository.save(new User("admin", "admin", "ADMIN"));
                userRepository.save(new User("vendor", "vendor", "VENDOR"));
                userRepository.save(new User("user", "user", "USER"));
                userRepository.save(new User("user2", "user2", "USER"));
                userRepository.save(new User("user3", "user3", "USER"));
            }
        };
    }
}

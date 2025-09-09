package com.example.demo;

import com.example.demo.entity.UserEntity;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Arrays;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    //private final PasswordEncoder encode;
    public DemoApplication(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        if (userRepository.findByUsername("pepe").isEmpty()) {
            userRepository.save(
                    UserEntity.builder()
                            .username("pepe")
                            .password(passwordEncoder.encode("123"))
                            .roles(Arrays.asList("ADMIN"))
                            .available(true)
                            .build()
            );
        }
        if (userRepository.findByUsername("carlos").isEmpty()) {
            userRepository.save(
                    UserEntity.builder()
                            .username("carlos")
                            .password(passwordEncoder.encode("123"))
                            .roles(Arrays.asList("USER"))
                            .available(true)
                            .build()
            );
        }
        if (userRepository.findByUsername("maria").isEmpty()) {
            userRepository.save(
                    UserEntity.builder()
                            .username("maria")
                            .password(passwordEncoder.encode("123"))
                            .roles(Arrays.asList("OTROS"))
                            .available(true)
                            .build()
            );
        }


    }
}
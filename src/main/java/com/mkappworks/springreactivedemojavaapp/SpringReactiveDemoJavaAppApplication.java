package com.mkappworks.springreactivedemojavaapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringReactiveDemoJavaAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringReactiveDemoJavaAppApplication.class, args);
    }

//    @Bean
//    public CommandLineRunner runner(StudentRepository repository) {
//        return args -> {
//            for (int i = 0; i < 3000; i++) {
//                repository.save(
//                        Student.builder()
//                                .firstName("Test" + i)
//                                .lastName("test" + i)
//                                .age(i)
//                                .build()
//                ).subscribe();
//            }
//        };
//    }
}

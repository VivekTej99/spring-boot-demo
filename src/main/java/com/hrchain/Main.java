package com.hrchain;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Objects;

@SpringBootApplication(scanBasePackages = "com.hrchain")
@RestController
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }



//    @GetMapping("/greet")
//    public GreetResponse greet() {
//        String id = "143b";
//        List<String> languages = List.of("Java", "Python", "Golang");
//        Person personOne = new Person("Sumith", 22, 60_000);
//        return new GreetResponse(id, languages, personOne);
//    }

//    record Person(String name, int age, double savings){}
//    record GreetResponse(
//            String id,
//            List<String> favLanguages,
//            Person person
//    ){}

//    class GreetResponse{
//        private final String name;
//        GreetResponse(String name) {
//            this.name = name;
//        }
//
//        public String getName(){
//            return this.name;
//        }
//
//        @Override
//        public String toString() {
//            return "GreetResponse{" +
//                    "name='" + name + '\'' +
//                    '}';
//        }
//
//        @Override
//        public boolean equals(Object o) {
//            if (this == o) return true;
//            if (o == null || getClass() != o.getClass()) return false;
//            GreetResponse that = (GreetResponse) o;
//            return Objects.equals(name, that.name);
//        }
//
//        @Override
//        public int hashCode() {
//            return Objects.hash(name);
//        }
//    }
}

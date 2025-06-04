package com.MARM.mediciones_api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableScheduling
public class MedicionesApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(MedicionesApiApplication.class, args);
	}

}
@RestController
@RequestMapping("/api")
class HelloController {
	@GetMapping("/hello")
	public String hello() {
		return "¡Hola, mundo desde Spring Boot con Gradle!";
	}
}
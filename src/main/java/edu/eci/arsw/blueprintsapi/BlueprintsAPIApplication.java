package edu.eci.arsw.blueprintsapi;

import edu.eci.arsw.blueprints.controllers.BlueprintAPIController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"edu.eci.arsw.blueprints"})
public class BlueprintsAPIApplication {

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication((BlueprintAPIController.class));
		app.run(args);
	}
}

package guru.springframework.spring5webapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Spring5webappApplication {

	public static void main(String[] args) {
		System.out.println("main \t ==> \t SpringApplication.run(Spring5webappApplication.class, args)");
		SpringApplication.run(Spring5webappApplication.class, args);
	}
}

package kg.edu.iaau.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableWebMvc
@ComponentScan(basePackages = { "kg.edu.iaau.core.**" })
public class BeelineApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(BeelineApiApplication.class, args);
	}
}

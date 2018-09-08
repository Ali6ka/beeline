package kg.edu.iaau.beeline;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@Configuration
public class BeelineApplication
{
	public static void main(String[] args) {
		SpringApplication.run(BeelineApplication.class, args);
	}
}

package kg.edu.iaau.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class })
@ComponentScan(basePackages = { "kg.edu.iaau.api.*","kg.edu.iaau.core.**" })
public class BeelineApiApplication extends SpringBootServletInitializer{

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(BeelineApiApplication.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(BeelineApiApplication.class, args);
	}
}

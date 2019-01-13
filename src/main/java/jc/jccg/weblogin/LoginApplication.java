package jc.jccg.weblogin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;

@SpringBootApplication
public class LoginApplication extends SpringBootServletInitializer {
	@Override protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(LoginApplication.class);
	}
	
	public static void main(String[] args) {
		SpringApplication.run(LoginApplication.class, args);
	}
}

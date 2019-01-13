package jc.jccg;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;

import jc.jccg.entity.Card;
import jc.jccg.service.card.CardService;

@SpringBootApplication
public class Application extends SpringBootServletInitializer {

	@Override protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(Application.class);
	}
	
	public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
	
	@Bean ApplicationRunner init(CardService cardService) {
		return args -> {
			Card.fromFile().forEach(card -> cardService.saveCard(card));
			cardService.getCards().forEach(System.out::println);
		};
		
	}

}

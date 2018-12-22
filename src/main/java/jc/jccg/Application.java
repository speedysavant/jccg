package jc.jccg;

import java.util.stream.Stream;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

	
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

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
			Stream.of("Card1", "Card2", "Card3").forEach(name -> {
				Card card = new Card();
				card.setName(name);
				cardService.saveCard(card);
			});
			cardService.getCards().forEach(System.out::println);
			};
	}

}

package jc.jccg;

import java.util.Arrays;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;

import jc.jccg.entity.Card;
import jc.jccg.entity.Player;
import jc.jccg.service.card.CardService;
import jc.jccg.service.player.PlayerService;

@SpringBootApplication
public class Application extends SpringBootServletInitializer {

	@Override protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(Application.class);
	}
	
	public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
	
	@Bean ApplicationRunner initCardService(CardService cardService) {
		return args -> {
			Card.fromFile().forEach(card -> cardService.saveCard(card));
		};
	}
	
	@Bean ApplicationRunner initPlayerService(PlayerService playerService) {
		return args -> {
			Player.testPlayers(5)
				.forEach(player -> playerService.savePlayer(player));
		};
	}

}

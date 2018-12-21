package jc.jccg;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(CardController.BASE_URL)
public class CardController 
{
	public static final String BASE_URL = "/jccg";
	
	private final CardService cardService;
	
	public CardController(CardService cardService) {
		this.cardService = cardService;
	}
	
	@RequestMapping("/cards")
	List<Card> home() {
		return cardService.getCards();
	}
	
	@RequestMapping("/cards/{id}")
	public Optional<Card> getCard(@PathVariable Long id){
		return cardService.getCardById(id);
	}
}

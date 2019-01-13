package jc.jccg.service.card;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jc.jccg.entity.Card;

@RestController
@RequestMapping(CardController.BASE_URL)
public class CardController 
{
	public static final String BASE_URL = "/jccg";
	
	@Autowired private CardService cardService;
	
	public CardController() {
		
	}
	
	public CardController(CardService cardService) {
		this.cardService = cardService;
	}
	
	@RequestMapping("/cards")
	List<Card> home() {
		return cardService.getCards();
	}
	
	@RequestMapping("/cards/{id}")
	public Card getCard(@PathVariable String id){
		return cardService.getCardById(id);
	}
}

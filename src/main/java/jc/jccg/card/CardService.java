package jc.jccg.card;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class CardService {
	@Autowired private CardRepository cardRepository;
	
//	public CardService(CardRepository cardRepository) {
//		this.cardRepository = cardRepository;
//	}
	
	public List<Card> getCards(){
		return cardRepository.findAll();
	}
	public Card getCardById(String id){
		return cardRepository.findOne(id);
	}
	public Card saveCard(Card card) {
		return cardRepository.save(card);
	}
	public void deleteCard(Card card) {
		cardRepository.delete(card);
	}
}
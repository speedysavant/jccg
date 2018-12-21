package jc.jccg;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

@Service
@Transactional
public class CardService {
	private final CardRepository cardRepository;
	public CardService(CardRepository cardRepository) {
		this.cardRepository = cardRepository;
	}
	
	public List<Card> getCards(){
		return cardRepository.findAll();
	}
	public Optional<Card> getCardById(Long id){
		return cardRepository.findById(id);
	}
	public Card saveCard(Card card) {
		return cardRepository.save(card);
	}
	public void deleteCard(Card card) {
		cardRepository.delete(card);
	}
}
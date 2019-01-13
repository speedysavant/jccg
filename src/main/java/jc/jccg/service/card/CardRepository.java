package jc.jccg.service.card;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import jc.jccg.entity.Card;

@Repository
public interface CardRepository  extends JpaRepository<Card, String>{

}

package jc.jccg;

import java.io.IOException;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class Card {
	@Id private String id;
	private String name;
	private String keywords;
	private String description;
	private String img;
	private String cardType;
	private Integer resourceCost;
	private Integer volatilesCost;
	private Integer health;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getKeywords() {
		return keywords;
	}
	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public String getCardType() {
		return cardType;
	}
	public void setCardType(String cardType) {
		this.cardType = cardType;
	}
	public Integer getResourceCost() {
		return resourceCost;
	}
	public void setResourceCost(Integer resourceCost) {
		this.resourceCost = resourceCost;
	}
	public Integer getVolatilesCost() {
		return volatilesCost;
	}
	public void setVolatilesCost(Integer volatilesCost) {
		this.volatilesCost = volatilesCost;
	}
	public Integer getHealth() {
		return health;
	}
	public void setHealth(Integer health) {
		this.health = health;
	}

	public String toString() {
		return "[" + this.getId() + "] " 
				+ this.getName() 
				+ " (" + this.getResourceCost() + ", " + this.getVolatilesCost() + ", " + this.getHealth() + ")" ;
	}
	
	public static Card fromString(String raw) {
		Card card = new Card();
		
		return card;
	}
	
	public static Collection<Card> fromFile() throws IOException {
		return CardBuilder.fromFile();
	}
	
}
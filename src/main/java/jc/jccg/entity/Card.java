package jc.jccg.entity;

import java.io.IOException;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.Id;

import jc.jccg.service.card.CardBuilder;


@Entity
public class Card {
	@Id private String id;
	
	private String name;
	private String faction;
	private String keywords;
	private String description;
	private String img;
	private String cardType;
	private Integer resourceCost;
	private Integer volatilesCost;
	private Integer health;
	
	private Integer combatShort = 0;
	private Integer combatMid = 0;
	private Integer combatLong = 0;
	private Integer defense = 0;
	
	private Integer resourceProduction = 0;
	private Integer volatileProduction = 0;
	private Integer constructionBays = 0;
	
	public String getId() { return id; }
	public void setId(String id) { this.id = id; }
	public String getName() { return name; }
	public void setName(String name) { this.name = name; }
	public String getFaction() { return faction; }
	public void setFaction(String faction) { this.faction = faction; }
	public String getKeywords() { return keywords; }
	public void setKeywords(String keywords) { this.keywords = keywords; }
	public String getDescription() { return description; }
	public void setDescription(String description) { this.description = description; }
	public String getImg() { return img; }
	public void setImg(String img) { this.img = img; }
	public String getCardType() { return cardType; }
	public void setCardType(String cardType) { this.cardType = cardType; }
	public Integer getResourceCost() { return resourceCost; }
	public void setResourceCost(Integer resourceCost) { this.resourceCost = resourceCost; }
	public Integer getVolatilesCost() { return volatilesCost; }
	public void setVolatilesCost(Integer volatilesCost) { this.volatilesCost = volatilesCost; }
	public Integer getHealth() { return health; }
	public void setHealth(Integer health) { this.health = health; }
	public Integer getCombatShort() { return combatShort; }
	public void setCombatShort(Integer combatShort) { this.combatShort = combatShort; }
	public Integer getCombatMid() { return combatMid; }
	public void setCombatMid(Integer combatMid) { this.combatMid = combatMid; }
	public Integer getCombatLong() { return combatLong; }
	public void setCombatLong(Integer combatLong) { this.combatLong = combatLong; }
	public Integer getDefense() { return defense; }
	public void setDefense(Integer defense) { this.defense = defense; }
	public Integer getResourceProduction() { return resourceProduction; }
	public void setResourceProduction(Integer resourceProduction) { this.resourceProduction = resourceProduction; }
	public Integer getVolatileProduction() { return volatileProduction; }
	public void setVolatileProduction(Integer volatileProduction) { this.volatileProduction = volatileProduction; }
	public Integer getConstructionBays() { return constructionBays; }
	public void setConstructionBays(Integer constructionBays) { this.constructionBays = constructionBays; }

	public String toString() { 
		String s = "[" + this.getId() + "] "
				+ this.getName() 
				+ " (" + this.getResourceCost() + ", " + this.getVolatilesCost() + ", " + this.getHealth() + ")" ;
		
		if (defense != 0 ) s=s.concat(" def " + this.getDefense());
		if (combatShort != 0 || combatMid != 0 || combatLong != 0)
			s=s.concat(" atk " + this.getCombatShort() + "/" + this.getCombatMid() + "/" + this.getCombatLong());
		if (resourceProduction != 0 || volatileProduction != 0)
			s=s.concat(" prod " + this.getResourceProduction() + "/" + this.getVolatileProduction());
		if (constructionBays != 0)
			s=s.concat(" bays " + this.getConstructionBays());
		
		return s;
	}
	
	public static Card fromString(String raw) {
		Card card = new Card();
		
		return card;
	}
	
	public static Collection<Card> fromFile() throws IOException {
		return CardBuilder.fromFile();
	}
	
}
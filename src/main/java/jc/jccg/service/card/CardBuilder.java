package jc.jccg.service.card;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import jc.jccg.entity.Card;


public class CardBuilder {
	
	private static String prefix = "card";
	private static String filename = "src/assets/prototypes.txt";
	
	public static Collection<Card> fromFile() throws IOException {
		return buildCardsFromEntries(
			Files.lines(Paths.get(filename))
				.filter(line -> line.startsWith(prefix))
				.map(CardBuilder::toEntry)
				.collect(Collectors.toList())
			);
	}
	
	private static Pattern firstColon = Pattern.compile("^(\\w+)!(\\w+):(.+)$");
	private static Entry toEntry(String line) {
		Matcher matcher = firstColon.matcher(line);
		Entry entry = new Entry();
		if (matcher.find()) {
			entry.id = matcher.group(1);
			entry.field = matcher.group(2);
			entry.value = matcher.group(3);
			// System.out.println(entry.id + ", " + entry.field + ", " + entry.value);
		}
		return entry;
	}
	
	private static Collection<Card> buildCardsFromEntries(List<Entry> entries) {
		HashMap<String, Card> cardMap = new HashMap<>();
		
		entries.forEach(entry -> {
			if (!cardMap.containsKey(entry.id))
				cardMap.put(entry.id, CardBuilder.rawCardForKey(entry.id));
			setCardField(cardMap.get(entry.id), entry);
		});
		
		return cardMap.values();
	}
	
	private static Card rawCardForKey(String key) {
		Card card = new Card();
		card.setId(key);
		return card;
	}
	private static void setCardField(Card card, Entry entry) {
		switch (entry.field.toLowerCase()) {
			case "name": card.setName(entry.value); break;
			case "faction": card.setFaction(entry.value); break;
			case "keywords": card.setKeywords(entry.value); break;
			case "description": card.setDescription(entry.value); break;
			case "img": card.setImg(entry.value); break;
			case "cardtype": card.setCardType(entry.value); break;
			case "resourcecost": card.setResourceCost(Integer.valueOf(entry.value)); break;
			case "volatilescost": card.setVolatilesCost(Integer.valueOf(entry.value)); break;
			case "health": card.setHealth(Integer.valueOf(entry.value)); break;
			
			case "combatshort": card.setCombatShort(Integer.valueOf(entry.value)); break;
			case "combatmid": card.setCombatMid(Integer.valueOf(entry.value)); break;
			case "combatlong": card.setCombatLong(Integer.valueOf(entry.value)); break;
			case "defense": card.setDefense(Integer.valueOf(entry.value)); break;
			
			case "resourceproduction": card.setResourceProduction(Integer.valueOf(entry.value)); break;
			case "volatileproduction": card.setVolatileProduction(Integer.valueOf(entry.value)); break;
			case "constructionbays": card.setConstructionBays(Integer.valueOf(entry.value)); break;
		}
	}

}

class Entry {
	String id;
	String field;
	String value;
}


package jc.jccg.service.player;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jc.jccg.entity.Player;

@RestController
@RequestMapping(PlayerController.BASE_URL)
public class PlayerController {

	public static final String BASE_URL = "/jccg";
	
	@Autowired private PlayerService service;
	
	public PlayerController() {
		
	}
	
	@RequestMapping("/players")
	List<Player> players() {
		return service.getAllPlayers();
	}
	
	@RequestMapping("/player/{player}")
	public Player getPlayer(@PathVariable String player) {
		return service.getPlayerById(player);
	}
}

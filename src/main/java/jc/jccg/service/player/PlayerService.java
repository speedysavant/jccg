package jc.jccg.service.player;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jc.jccg.entity.Player;

@Service
@Transactional
public class PlayerService {
	@Autowired private PlayerRepository repo;

	public List<Player> getAllPlayers() {
		return repo.findAll();
	}
	public Player getPlayerById(String id) {
		return repo.findOne(id);
	}
	public Player savePlayer(Player player) {
		return repo.save(player);
	}
	public void deletePlayer(Player player) {
		repo.delete(player);
	}
}

package jc.jccg.entity;

import java.util.LinkedList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Player {
	@Id 
	private String username;
	private String password;
	@ManyToMany(mappedBy = "Game")
	private Game currentGame; // TODO: have to set this up as a relation with another table in hibernate

	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Game getCurrentGame() {
		return currentGame;
	}
	public void setCurrentGame(Game currentGame) {
		this.currentGame = currentGame;
	}
	
	public String toString() {
		return "@" + username + ":" + password;
	}
	
	public static Player testPlayer() {
		Player player = new Player();
		player.username = "Test Player";
		player.password = String.valueOf(System.currentTimeMillis());
		
		return player;
	}
	public static List<Player> testPlayers(int num){
		List<Player> list = new LinkedList<>();
		for (int i = 0; i < num; i++) {
			Player player = testPlayer();
			player.username += "-" + i;
			list.add(player);
		}
		return list;
	}
}

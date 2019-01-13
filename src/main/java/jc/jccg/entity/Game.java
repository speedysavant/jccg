package jc.jccg.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Game {
	@Id 
	private String id;
	private Long startTime;
	
	@ManyToMany(cascade = { CascadeType.ALL })
	@JoinTable(
			name = "Game_Players",
			joinColumns = { @JoinColumn (name = "id") },
			inverseJoinColumns = { @JoinColumn (name = "username") }
	)
	private List<Player> players;
	
	public static int MAX_PLAYERS = 4;

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Long getStartTime() {
		return startTime;
	}
	public void setStartTime(Long startTime) {
		this.startTime = startTime;
	}
	public List<Player> getPlayers() {
		return players;
	}
	public void setPlayers(List<Player> players) {
		this.players = players;
	}
	
}

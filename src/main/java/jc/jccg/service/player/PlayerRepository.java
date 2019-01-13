package jc.jccg.service.player;

import org.springframework.data.jpa.repository.JpaRepository;

import jc.jccg.entity.Player;

public interface PlayerRepository extends JpaRepository<Player, String> {

}

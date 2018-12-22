package jc.jccg.player;

public interface UserService {
    void save(User user);

    User findByUsername(String username);
}
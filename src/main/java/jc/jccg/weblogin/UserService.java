package jc.jccg.weblogin;

public interface UserService {
    void save(User user);

    User findByUsername(String username);
}
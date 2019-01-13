package jc.jccg.weblogin;

public interface SecurityService {
    String findLoggedInUsername();

    void autologin(String username, String password);
}
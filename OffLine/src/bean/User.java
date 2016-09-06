package bean;

import java.util.List;

/**
 * Created by fang on 2016/7/20.
 */
public class User {
    private String username;
    private String password;
    private String links;

    public User() {
        // TODO Auto-generated constructor stub
    }

    public User(String username, String password, String links) {
        this.username = username;
        this.password = password;
        this.links = links;
    }

    public String toURL() {
        return "&username=" + username + "&password=" + password + "&links=" + links ;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", links=" + links +
                '}';
    }

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

    public String getLinks() {
        return links;
    }

    public void setLinks(String links) {
        this.links = links;
    }
}

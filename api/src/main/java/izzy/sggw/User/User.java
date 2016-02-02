package izzy.sggw.User;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by Paweł on 31.01.2016.
 */
@Document(collection = "users")
public class User {
    @Id
    private String id;

    private String username;

    private String email;

    private String password;

    public User(){
    }

    public User(User user){
        super();
        this.username = user.getUsername();
        this.id = user.getId();
        this.email = user.getEmail();
        this.password = user.getPassword();
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public void seUsername(String name) {
        this.username = name;
    }
}

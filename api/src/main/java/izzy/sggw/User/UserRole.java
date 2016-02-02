package izzy.sggw.User;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.annotation.Id;
import org.springframework.security.core.GrantedAuthority;

/**
 * Created by Paweł on 31.01.2016.
 */
public class UserRole implements GrantedAuthority {

    private static final long serialVersionUID = 1L;

    @Id
    private String id;

    @NotEmpty
    private String name;

    public UserRole(String name) {
        this.name = name;
    }

    @Override
    public String getAuthority() {
        return name;
    }
}
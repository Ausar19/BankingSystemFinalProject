package System.Banking.Final.Project.W5.dto;

import System.Banking.Final.Project.W5.models.users.Role;
import javax.validation.constraints.NotEmpty;
import java.util.HashSet;
import java.util.Set;

public class ThirdPartyDTO {

    @NotEmpty
    private String username;
    @NotEmpty
    private String password;
    @NotEmpty
    private String name;
    private String hashedKey;
    private Set<Role> roles = new HashSet<>();


    //========================================CONSTRUCTOR========================================//


    public ThirdPartyDTO() {
    }



    //========================================GETTERS AND SETTERS========================================//


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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHashedKey() {
        return hashedKey;
    }

    public void setHashedKey(String hashedKey) {
        this.hashedKey = hashedKey;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}

package System.Banking.Final.Project.W5.models.users;

import System.Banking.Final.Project.W5.models.accounts.Account;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String userName;
    private String password;

    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<Role> roles = new HashSet<>();


    //========================================CONSTRUCTOR========================================//


    public User() {
    }

    public User(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }


    //========================================GETTERS AND SETTERS========================================//


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public void addRole(Role role) {roles.add(role);}

    public List<Account> getSecondaryAccounts() {
        return null;
    }
}

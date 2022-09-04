package System.Banking.Final.Project.W5.models.users;

import javax.persistence.*;

@Entity
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long roleId;

    private String role;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    //========================================CONSTRUCTOR========================================//


    public Role(String role, User user) {
        this.role = role;
        this.user = user;
    }

    public Role() {
    }


    //========================================GETTERS AND SETTERS========================================//



    public Role(String role) {this.role = role;}

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}

package System.Banking.Final.Project.W5.models.users;

import javax.persistence.*;

@Entity
public class Admin extends User{

    private String name;


    //========================================CONSTRUCTOR========================================//

    public Admin() {
    }

    public Admin(String username, String password, String name) {
        super(username, password);
        this.name = name;
    }


    //========================================GETTERS AND SETTERS========================================//


    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }
}

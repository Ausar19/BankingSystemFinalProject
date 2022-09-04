package System.Banking.Final.Project.W5.models.users;

import javax.persistence.*;

@Entity
public class ThirdParty extends User{

    private String name;

    @Column(unique = true)
    private Long hashedKey;


    //========================================CONSTRUCTOR========================================//


    public ThirdParty() {
    }

    public ThirdParty(String userName,String password, Long hashedKey, String name) {

        super(userName, password);
        this.hashedKey = hashedKey;
        this.name = name;
    }

    public ThirdParty(String username, String encode, String name, String hashedKey) {
    }


    //========================================GETTERS AND SETTERS========================================//


    public Long getHashedKey() {
        return hashedKey;
    }

    public void setHashedKey(Long hashedKey) {
        this.hashedKey = hashedKey;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

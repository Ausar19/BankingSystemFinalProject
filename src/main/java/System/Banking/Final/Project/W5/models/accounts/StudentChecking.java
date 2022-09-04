package System.Banking.Final.Project.W5.models.accounts;

import System.Banking.Final.Project.W5.enums.status.Status;
import System.Banking.Final.Project.W5.models.users.AccountHolder;
import System.Banking.Final.Project.W5.models.users.User;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;
import java.time.LocalDate;


@Entity
public class StudentChecking extends Account{

    @NotEmpty
    private String secretKey;

    private Status status;


    //========================================CONSTRUCTOR========================================//


    public StudentChecking() {
    }

    public StudentChecking(BigDecimal balance, AccountHolder primaryOwner, AccountHolder secondaryOwner,
                           String secretKey, Status status) {

        super(balance, primaryOwner, secondaryOwner);
        this.secretKey = secretKey;
        this.status = status;


    }

    public StudentChecking(BigDecimal bigDecimal, AccountHolder user4, AccountHolder user1, String sssssddd44) {
    }


    //========================================GETTERS AND SETTERS========================================//


    public String getSecretKey() {
        return secretKey;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}

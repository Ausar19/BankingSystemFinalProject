package System.Banking.Final.Project.W5.models.users;

import System.Banking.Final.Project.W5.models.accounts.Account;
import System.Banking.Final.Project.W5.models.addresses.Address;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;


@Entity
public class AccountHolder extends User{

    private String name;

    @NotNull
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate birthDate;
    @Embedded
    @NotNull
    private Address primaryAddress;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name="country", column = @Column(name = "mailing_country")),
            @AttributeOverride(name="city", column = @Column(name = "mailing_city")),
            @AttributeOverride(name="street", column = @Column(name = "mailing_street")),
            @AttributeOverride(name="postalCode", column = @Column(name = "mailing_postalCode")),
            @AttributeOverride(name="apartmentNumber", column = @Column(name = "mailing_apartmentNumber"))
    })
    private Address mailingAddress;

    @OneToMany(mappedBy = "primaryOwner")
    @JsonIgnore
    private List<Account> primaryAccount;

    @OneToMany(mappedBy = "secondaryOwner")
    @JsonIgnore
    private List<Account> secondaryAccount;




    //========================================CONSTRUCTOR========================================//


    public AccountHolder() {
    }

    public AccountHolder(String username, String password, String name, LocalDate birthDate, Address primaryAddress) {
        super(username, password);
        this.name = name;
        this.birthDate = birthDate;
        this.primaryAddress = primaryAddress;
    }

    public AccountHolder(String username, String password, String name, LocalDate birthDate, Address primaryAddress, Address mailingAddress) {
        super(username, password);
        this.name = name;
        this.birthDate = birthDate;
        this.primaryAddress = primaryAddress;
        this.mailingAddress = mailingAddress;
    }

    public AccountHolder(String username, String password, String name, LocalDate birthDate, Address primaryAddress,
                         Address mailingAddress, List<Account> primaryAccount, List<Account> secondaryAccount) {

        super(username, password);
        this.birthDate = birthDate;
        this.primaryAddress = primaryAddress;
        this.mailingAddress = mailingAddress;
        this.primaryAccount = primaryAccount;
        this.secondaryAccount = secondaryAccount;
    }


    //========================================GETTERS AND SETTERS========================================//


    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public Address getPrimaryAddress() {
        return primaryAddress;
    }

    public void setPrimaryAddress(Address primaryAddress) {
        this.primaryAddress = primaryAddress;
    }

    public Address getMailingAddress() {
        return mailingAddress;
    }

    public void setMailingAddress(Address mailingAddress) {
        this.mailingAddress = mailingAddress;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Account> getPrimaryAccount() {
        return primaryAccount;
    }

    public void setPrimaryAccount(List<Account> primaryAccount) {
        this.primaryAccount = primaryAccount;
    }

    public List<Account> getSecondaryAccount() {
        return secondaryAccount;
    }

    public void setSecondaryAccount(List<Account> secondaryAccount) {
        this.secondaryAccount = secondaryAccount;
    }

    public List<Account> getPrimaryAccounts() {
        return null;
    }
}

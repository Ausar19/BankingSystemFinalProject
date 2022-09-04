package System.Banking.Final.Project.W5.models.accounts;

import System.Banking.Final.Project.W5.enums.status.Status;
import System.Banking.Final.Project.W5.models.users.AccountHolder;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private BigDecimal balance;

    @ManyToOne
    @NotNull
    private AccountHolder primaryOwner;

    @ManyToOne
    @NotNull
    private AccountHolder secondaryOwner;
    private final BigDecimal penaltyFee = new BigDecimal(40);

    private LocalDate creationDate;

    @Enumerated(EnumType.STRING)
    private Status status = Status.ACTIVE;




    //========================================CONSTRUCTOR========================================//


    public Account(BigDecimal balance, AccountHolder primaryOwner, AccountHolder secondaryOwner) {

        this.balance = balance;
        this.primaryOwner = primaryOwner;
        this.secondaryOwner = secondaryOwner;
        creationDate = LocalDate.now();
    }

    public Account() {

    }

    public void freezeAccount(){

        this.setStatus(Status.FROZEN);
    }


    //========================================GETTERS AND SETTERS========================================//


    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public AccountHolder getPrimaryOwner() {
        return primaryOwner;
    }

    public void setPrimaryOwner(AccountHolder primaryOwner) {
        this.primaryOwner = primaryOwner;
    }

    public AccountHolder getSecondaryOwner() {
        return secondaryOwner;
    }

    public void setSecondaryOwner(AccountHolder secondaryOwner) {
        this.secondaryOwner = secondaryOwner;
    }

    public BigDecimal getPenaltyFee() {
        return penaltyFee;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public boolean getAccountId() {
        return false;
    }
}

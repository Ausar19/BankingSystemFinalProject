package System.Banking.Final.Project.W5.models.accounts;

import System.Banking.Final.Project.W5.enums.status.Status;
import System.Banking.Final.Project.W5.models.users.AccountHolder;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Period;


@Entity
public class Checking extends Account{
    @NotEmpty
    private String secretKey;
    private BigDecimal minimumBalance = new BigDecimal(250);
    private BigDecimal monthlyMaintenanceFee = new BigDecimal(12);
    private LocalDate creationDate;
    private Status status;


    //========================================CONSTRUCTOR========================================//


    public Checking() {
    }

    public Checking(BigDecimal balance, AccountHolder primaryOwner, AccountHolder secondaryOwner, String secretKey,
                    BigDecimal minimumBalance, BigDecimal monthlyMaintenanceFee, LocalDate creationDate, Status status) {

        super(balance, primaryOwner, secondaryOwner);
        this.secretKey = secretKey;
        this.minimumBalance = minimumBalance;
        this.monthlyMaintenanceFee = monthlyMaintenanceFee;
        this.creationDate = creationDate;
        this.status = status;

    }

    public Checking(BigDecimal bigDecimal, AccountHolder user2, Object o, String pepepe888) {
    }


    //========================================METHODS========================================//

    @Override
    public void setBalance(BigDecimal balance) {
        if(balance.compareTo(minimumBalance) < 0) {

            balance = balance.subtract(getPenaltyFee());

        }super.setBalance(balance);
    }

    public void applyMaintenanceFee(){
        if (LocalDate.now().getMonthValue() > this.getCreationDate().getMonthValue() && LocalDate.now().getYear() >= this.getCreationDate().getYear()) {
            for (int i = LocalDate.now().getMonthValue(); i > this.getCreationDate().getMonthValue() ; i--) {
                this.setBalance(this.getBalance().subtract(monthlyMaintenanceFee));
            }
            this.setCreationDate(LocalDate.now());
        }
    }





    //========================================GETTERS AND SETTERS========================================//


    public String getSecretKey() {
        return secretKey;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }

    public BigDecimal getMinimumBalance() {
        return minimumBalance;
    }

    public void setMinimumBalance(BigDecimal minimumBalance) {
        this.minimumBalance = minimumBalance;
    }

    public BigDecimal getMonthlyMaintenanceFee() {
        return monthlyMaintenanceFee;
    }

    public void setMonthlyMaintenanceFee(BigDecimal monthlyMaintenanceFee) {
        this.monthlyMaintenanceFee = monthlyMaintenanceFee;
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

}

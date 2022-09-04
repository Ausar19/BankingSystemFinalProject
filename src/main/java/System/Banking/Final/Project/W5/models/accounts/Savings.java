package System.Banking.Final.Project.W5.models.accounts;

import System.Banking.Final.Project.W5.enums.status.Status;
import System.Banking.Final.Project.W5.models.users.AccountHolder;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;
import java.time.*;

@Entity
public class Savings extends Account{

    @NotEmpty
    private String secretKey;
    private BigDecimal minimumBalance = new BigDecimal(1000);
    private LocalDate creationDate = LocalDate.now();
    private Status status;
    private BigDecimal interestRate = new BigDecimal(0.0025);

    private LocalDate lastInterestDate = LocalDate.now();


    //========================================CONSTRUCTOR========================================//


    public Savings() {
    }

    public Savings(BigDecimal balance, AccountHolder primaryOwner, AccountHolder secondaryOwner, String secretKey,
                   BigDecimal minimumBalance, LocalDate creationDate, Status status, BigDecimal interestRate) {

        super(balance, primaryOwner, secondaryOwner);
        this.secretKey = secretKey;
        this.minimumBalance = minimumBalance;
        this.creationDate = creationDate;
        this.status = status;
        this.interestRate = interestRate;

    }

    public Savings(BigDecimal bigDecimal, AccountHolder user2, Object o, BigDecimal bigDecimal1, BigDecimal bigDecimal2, String sssssddd44) {
    }

    public Savings(BigDecimal bigDecimal, AccountHolder user5, Object o, String sssssddd44) {
    }


    //========================================GETTERS AND SETTERS========================================//



    public void setMinimumBalance(BigDecimal minimumBalance) {
        if (minimumBalance.intValue() > 1000 || minimumBalance.intValue() < 100) {

            throw new IllegalArgumentException("The minimum balance amount has to be between 1,000 and 100");

        } this.minimumBalance = minimumBalance;
    }


    public void setInterestRate(BigDecimal interestRate) {
        if(interestRate.doubleValue() > 0.5) {
            throw new IllegalArgumentException("The interest rate must be lower than 0.5");


        }    this.interestRate = interestRate;

    }
    @Override
    public void setBalance(BigDecimal balance) {
        applyInterest();
        if(balance.compareTo(minimumBalance) < 0) {

            balance = balance.subtract(getPenaltyFee());

        }super.setBalance(balance);


    }

    @Override
    public BigDecimal getBalance() {
        applyInterest();
        return super.getBalance();
    }

    public void applyInterest() {

        if(Period.between(lastInterestDate, LocalDate.now()).getYears() >= 1) {

            setBalance(getBalance().multiply(getInterestRate()).multiply(BigDecimal.valueOf(Period.between(lastInterestDate, LocalDate.now()).getYears())).add(getBalance()));

            lastInterestDate.plusYears(Period.between(lastInterestDate, LocalDate.now()).getYears());
        }

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

    public BigDecimal getInterestRate() {
        return interestRate;
    }

    public String getSecretKey() {
        return secretKey;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }

    public BigDecimal getMinimumBalance() {
        return minimumBalance;
    }
}

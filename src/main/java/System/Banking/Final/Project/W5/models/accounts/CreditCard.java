package System.Banking.Final.Project.W5.models.accounts;

import System.Banking.Final.Project.W5.models.users.AccountHolder;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Period;

@Entity
public class CreditCard extends Account{

    @NotNull
    private BigDecimal creditLimit = new BigDecimal(100);
    @NotNull
    private BigDecimal interestRate = new BigDecimal(0.2);
    private LocalDate lastInterestDate = LocalDate.now();


    //========================================CONSTRUCTOR========================================//


    public CreditCard() {
    }

    public CreditCard(BigDecimal balance, AccountHolder primaryOwner, AccountHolder secondaryOwner,
                      BigDecimal creditLimit, BigDecimal interestRate) {

        super(balance, primaryOwner, secondaryOwner);
        this.creditLimit = creditLimit;
        this.interestRate = interestRate;

    }


    //========================================METHODS========================================//


    public void setCreditLimit(BigDecimal creditLimit) {
        if(creditLimit.intValue() < 100 || creditLimit.intValue() > 100000) {

            throw new IllegalArgumentException("The credit limit must be lower than 100,000 and higher than 100");

        }this.creditLimit = creditLimit;
    }

    public void setInterestRate(BigDecimal interestRate) {

        if(interestRate.doubleValue() > 0.2 || interestRate.doubleValue() < 0.1) {

            throw new IllegalArgumentException("The interest rate must be lower than 0.2 and higher than 0.1");

        } this.interestRate = interestRate;
    }

    public void applyInterest() {

        if(Period.between(lastInterestDate, LocalDate.now()).getMonths() >= 1) {

            setBalance(getBalance().multiply(getInterestRate()).multiply(BigDecimal.valueOf(Period.between(lastInterestDate, LocalDate.now()).getMonths())).add(getBalance()));

            lastInterestDate.plusMonths(Period.between(lastInterestDate, LocalDate.now()).getMonths());
        }
    }

    @Override
    public BigDecimal getBalance() {
        applyInterest();
        return super.getBalance();
    }


    //========================================GETTERS AND SETTERS========================================//


    public BigDecimal getInterestRate() {
        return interestRate;
    }
    public BigDecimal getCreditLimit() {
        return creditLimit;
    }

}

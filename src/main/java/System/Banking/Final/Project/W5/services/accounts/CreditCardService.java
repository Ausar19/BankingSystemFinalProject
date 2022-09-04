package System.Banking.Final.Project.W5.services.accounts;

import System.Banking.Final.Project.W5.models.accounts.CreditCard;
import System.Banking.Final.Project.W5.repository.accounts.CreditCardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CreditCardService {

    @Autowired
    CreditCardRepository creditCardRepository;

    public List<CreditCard> allCreditCardAccounts() {
        return creditCardRepository.findAll();
    }




}

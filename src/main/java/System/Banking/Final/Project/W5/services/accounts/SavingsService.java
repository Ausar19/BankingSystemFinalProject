package System.Banking.Final.Project.W5.services.accounts;

import System.Banking.Final.Project.W5.models.accounts.Savings;
import System.Banking.Final.Project.W5.repository.accounts.SavingsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SavingsService {

    @Autowired
    SavingsRepository savingsRepository;


    public List<Savings> allSavingsAccounts() {
        return savingsRepository.findAll();
    }
}

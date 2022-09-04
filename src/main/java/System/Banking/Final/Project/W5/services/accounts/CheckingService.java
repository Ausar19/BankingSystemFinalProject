package System.Banking.Final.Project.W5.services.accounts;

import System.Banking.Final.Project.W5.models.accounts.Checking;
import System.Banking.Final.Project.W5.repository.accounts.CheckingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CheckingService {

    @Autowired
    CheckingRepository checkingRepository;

    public List<Checking> allCheckingAccounts() {
        return checkingRepository.findAll();
    }




}

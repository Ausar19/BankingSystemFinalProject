package System.Banking.Final.Project.W5.repository.accounts;

import System.Banking.Final.Project.W5.models.accounts.Account;
import System.Banking.Final.Project.W5.models.users.AccountHolder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

    List<Account> findByPrimaryOwner(AccountHolder user);

    List<Account> findAll();

}

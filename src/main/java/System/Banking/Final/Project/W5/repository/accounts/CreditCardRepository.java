package System.Banking.Final.Project.W5.repository.accounts;

import System.Banking.Final.Project.W5.models.accounts.CreditCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CreditCardRepository extends JpaRepository<CreditCard, Long> {
}

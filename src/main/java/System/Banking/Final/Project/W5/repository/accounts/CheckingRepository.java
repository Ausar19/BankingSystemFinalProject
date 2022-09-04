package System.Banking.Final.Project.W5.repository.accounts;

import System.Banking.Final.Project.W5.models.accounts.Checking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CheckingRepository extends JpaRepository<Checking, Long> {
}

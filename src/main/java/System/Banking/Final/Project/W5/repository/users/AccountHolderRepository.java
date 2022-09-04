package System.Banking.Final.Project.W5.repository.users;

import System.Banking.Final.Project.W5.models.users.AccountHolder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AccountHolderRepository extends JpaRepository<AccountHolder, Long> {

    Optional<AccountHolder> findByUserName(String userName);

    Optional<AccountHolder> findByName(String name);

    List<Object> findByUsername(String username);
}

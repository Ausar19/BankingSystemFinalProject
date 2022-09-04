package System.Banking.Final.Project.W5.repository.accounts;

import System.Banking.Final.Project.W5.models.accounts.StudentChecking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentCheckingRepository extends JpaRepository<StudentChecking, Long> {
}

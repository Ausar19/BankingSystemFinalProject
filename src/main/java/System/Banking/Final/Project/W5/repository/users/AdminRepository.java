package System.Banking.Final.Project.W5.repository.users;

import System.Banking.Final.Project.W5.models.users.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Long> {
}

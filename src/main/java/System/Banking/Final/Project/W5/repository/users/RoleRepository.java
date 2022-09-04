package System.Banking.Final.Project.W5.repository.users;

import System.Banking.Final.Project.W5.models.users.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {


}

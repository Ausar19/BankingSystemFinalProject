package System.Banking.Final.Project.W5.services.users;


import System.Banking.Final.Project.W5.dto.ThirdPartyDTO;
import System.Banking.Final.Project.W5.models.users.Role;
import System.Banking.Final.Project.W5.models.users.ThirdParty;
import System.Banking.Final.Project.W5.repository.users.RoleRepository;
import System.Banking.Final.Project.W5.repository.users.ThirdPartyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class ThirdPartyService {


    @Autowired
    ThirdPartyRepository thirdPartyRepository;

    @Autowired
    RoleRepository roleRepository;

    PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();




    public ThirdParty createThirdParty(ThirdPartyDTO thirdPartyDTO) {
        ThirdParty newThirdParty = new ThirdParty(thirdPartyDTO.getUsername(), passwordEncoder.encode(thirdPartyDTO.getPassword()), thirdPartyDTO.getName(), thirdPartyDTO.getHashedKey());
        thirdPartyRepository.save(newThirdParty);
        Role role = new Role("THIRD PARTY", newThirdParty);
        roleRepository.save(role);
        return newThirdParty;
    }

}

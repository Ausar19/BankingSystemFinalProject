package System.Banking.Final.Project.W5.services.users;

import System.Banking.Final.Project.W5.models.users.AccountHolder;


import System.Banking.Final.Project.W5.repository.users.UserRepository;
import System.Banking.Final.Project.W5.security.CustomUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomUserDetailsService {



    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<AccountHolder> user = userRepository.findByUsername(username);
        if (!user.isPresent()) {
            throw new UsernameNotFoundException("User doesn't exist");
        }

        CustomUserDetails customUserDetails = new CustomUserDetails(user.get());

        return customUserDetails;
    }
}

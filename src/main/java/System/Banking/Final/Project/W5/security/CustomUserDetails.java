package System.Banking.Final.Project.W5.security;

import System.Banking.Final.Project.W5.models.users.AccountHolder;
import System.Banking.Final.Project.W5.models.users.Role;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.HashSet;

public class CustomUserDetails implements UserDetails {

    private AccountHolder user;


    //========================================CONSTRUCTOR========================================//


    public CustomUserDetails(AccountHolder user) {
        this.user = user;
    }


    //========================================METHODS========================================//


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        Collection<GrantedAuthority> authorities = new HashSet<>();

        for (Role role : user.getRoles()) {
            authorities.add(new SimpleGrantedAuthority("ROLE_" + role.getRole()));
        }

        return authorities;
    }


    //========================================GETTERS AND SETTERS========================================//


    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public String getUsername() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }
}

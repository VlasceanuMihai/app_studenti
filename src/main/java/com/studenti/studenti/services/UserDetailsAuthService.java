package com.studenti.studenti.services;

import com.studenti.studenti.models.Privilege;
import com.studenti.studenti.models.Role;
import com.studenti.studenti.models.User;
import com.studenti.studenti.repository.UserRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class UserDetailsAuthService implements UserDetailsService {

    private UserRepository userRepository;

    public UserDetailsAuthService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findByEmail(email);
        if (user.isEmpty()) {
            throw new UsernameNotFoundException("No user found with username: " + email);
        }

        boolean enabled = true;
        boolean accountNonExpired = true;
        boolean credentialsNonExpired = true;
        boolean accountNonLocked = true;

        return new org.springframework.security.core.userdetails.User(user.get().getEmail(),
                user.get().getPassword(),
                enabled,
                accountNonExpired,
                credentialsNonExpired,
                accountNonLocked, getAuthorities(user.get().getRoles()));
    }

    private Collection<? extends GrantedAuthority> getAuthorities(Collection<Role> roles) {
        return getGrantedAuthorities(getPrivileges(roles));
    }

    private List<GrantedAuthority> getGrantedAuthorities(List<String> privileges) {
        return privileges.stream().map(SimpleGrantedAuthority::new).collect(Collectors.toList());
    }

    private List<String> getPrivileges(Collection<Role> roles) {
        List<Privilege> collectionOfPrivileges = new ArrayList<>();
        for (Role role : roles) {
            collectionOfPrivileges.addAll(role.getPrivileges());
        }

        return collectionOfPrivileges.stream().map(Privilege::getStatus).collect(Collectors.toList());
    }
}

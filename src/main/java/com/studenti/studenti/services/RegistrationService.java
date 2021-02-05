package com.studenti.studenti.services;

import com.studenti.studenti.dto.UserDto;
import com.studenti.studenti.exceptions.UserAlreadyExistsException;
import com.studenti.studenti.models.*;
import com.studenti.studenti.repository.PrivilegeRepository;
import com.studenti.studenti.repository.RoleRepository;
import com.studenti.studenti.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;

@Service
@Slf4j
public class RegistrationService {

    private Privilege DEFAULT_PRIVILEGE = Privilege.builder().status(PrivilegeStatus.ALL.name()).build();
    private Role DEFAULT_ROLE = Role.builder().status(RoleStatus.USER_DEFAULT.name()).build();

    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private PrivilegeRepository privilegeRepository;

    @Autowired
    public RegistrationService(UserRepository userRepository,
                               RoleRepository roleRepository,
                               PrivilegeRepository privilegeRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.privilegeRepository = privilegeRepository;
    }

    @Transactional
    public User registrationProcess(UserDto userDto) throws UserAlreadyExistsException {
        if (existsEmail(userDto.getEmail())) {
            throw new UserAlreadyExistsException("There is an account with that email address: " + userDto.getEmail());
        }

        Privilege privilege = privilegeRepository.findByStatus(PrivilegeStatus.ALL.name());
        Role role = roleRepository.findByStatus(RoleStatus.USER_DEFAULT.name());
        role.setPrivileges(Collections.singletonList(privilege));

        User newUser = User.builder()
                .firstName(userDto.getFirstName())
                .lastName(userDto.getLastName())
                .email(userDto.getEmail())
                .password(userDto.getPassword())
                .roles(Collections.singletonList(role))
                .build();

        return userRepository.save(newUser);
    }

    public void deleteAll() {
        userRepository.deleteAll();
    }

    private boolean existsEmail(String email) {
        return this.userRepository.existsByEmail(email);
    }
}

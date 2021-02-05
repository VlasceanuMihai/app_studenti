package com.studenti.studenti.repository;

import com.studenti.studenti.models.Role;
import com.studenti.studenti.models.RoleStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

    Role findByStatus(String status);

//    Role findByStatus(String name);

}

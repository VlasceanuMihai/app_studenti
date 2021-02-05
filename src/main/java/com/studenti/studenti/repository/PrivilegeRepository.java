package com.studenti.studenti.repository;

import com.studenti.studenti.models.Privilege;
import com.studenti.studenti.models.PrivilegeStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PrivilegeRepository extends JpaRepository<Privilege, Long> {

    Privilege findByStatus(String status);

//    Privilege findByStatus(String name);

}

package com.studenti.studenti.repository;

import com.studenti.studenti.models.Materie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MaterieRepository extends JpaRepository<Materie, Long> {

    Optional<Materie> findByNume(String nume);
}

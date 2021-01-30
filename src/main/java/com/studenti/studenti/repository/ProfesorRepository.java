package com.studenti.studenti.repository;

import com.studenti.studenti.models.Profesor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProfesorRepository extends JpaRepository<Profesor, Long> {

    @Query(value = "SELECT p FROM Profesor p WHERE p.nume = :nume")
    Optional<Profesor> findProfesorByNume(@Param("nume") String nume);
}

package com.studenti.studenti.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "materii")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = {"nume"})
@ToString(of = {"nume", "profesor"})
public class Materie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public Long id;

    @Column(name = "nume", unique = true, nullable = false)
    public String nume;

    @ManyToOne
    @JoinColumn(name = "id_profesor")
    public Profesor profesor;

    @ManyToMany(mappedBy = "cursuri")
    @JsonIgnore
    public Set<Student> studenti;

    @OneToMany(mappedBy = "materie")
    @JsonIgnore
    public Set<StudentiToMaterii> inscrieri;
}

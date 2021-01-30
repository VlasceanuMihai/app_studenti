package com.studenti.studenti.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "studenti")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = {"cnp"})
@ToString(of = {"nume", "prenume", "cnp"})
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public Long id;

    @Column(nullable = false)
    public String nume;

    @Column(nullable = false)
    public String prenume;

    @Column(name = "date_of_birth", nullable = false)
    public LocalDate dateOfBirth;

    @Column(name = "cnp", unique = true, nullable = false)
    public String cnp;

    @Column(name = "email", unique = true, nullable = false)
    public String email;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @JoinTable(
            name = "studenti_to_materii",
            joinColumns = @JoinColumn(name = "id_student"),
            inverseJoinColumns = @JoinColumn(name = "id_materie"))
    private Set<Materie> cursuri;

    @OneToMany(mappedBy = "student")
    @JsonIgnore
    public Set<StudentiToMaterii> inscrieri;
}

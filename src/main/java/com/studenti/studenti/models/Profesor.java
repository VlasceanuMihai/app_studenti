package com.studenti.studenti.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "profesori")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = {"nume"})
@ToString(of = {"nume"})
public class Profesor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    public Long id;

    @Column(name = "nume", nullable = false)
    public String nume;

    @Column(name = "cnp", unique = true, nullable = false)
    public String cnp;

    @OneToMany(mappedBy = "profesor")
    @JsonIgnore
    public Set<Materie> materiiPredate;
}

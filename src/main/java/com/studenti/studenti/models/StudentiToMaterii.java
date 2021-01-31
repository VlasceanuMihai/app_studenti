package com.studenti.studenti.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "studenti_to_materii")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StudentiToMaterii {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public Long id;

    @ManyToOne
    @JoinColumn(name = "id_student")
    public Student student;

    @ManyToOne
    @JoinColumn(name = "id_materie")
    public Materie materie;
}

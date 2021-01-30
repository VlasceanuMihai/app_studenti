package com.studenti.studenti.models;

import lombok.Data;

import javax.persistence.*;

/**
 * Project: studenti
 * Author: mihai
 * Date: 1/24/2021
 */

@Entity
@Table(name = "studenti_to_materii")
@Data
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

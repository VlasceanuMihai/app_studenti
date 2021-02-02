package com.studenti.studenti.models;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "privilege")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = {"status"})
@ToString(of = {"id", "status"})
public class Privilege {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "status", unique = true)
    private String status;

    @ManyToMany(mappedBy = "privileges")
    private List<Role> roles;

}

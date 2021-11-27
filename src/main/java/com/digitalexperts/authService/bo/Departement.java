package com.digitalexperts.authService.bo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@ToString(exclude = {"arrondissements", "communes"})
@Builder
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class Departement {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(unique = true)
    private String libelle;

    @ManyToOne
    private Region region;

    @JsonIgnore
    @OneToMany(mappedBy = "departement")
    private List<Arrondissement> arrondissements;

    @JsonIgnore
    @OneToMany(mappedBy = "departement")
    private List<Commune> communes;
}

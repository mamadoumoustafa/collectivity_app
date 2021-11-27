package com.digitalexperts.authService.bo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@ToString(exclude = { "communes"})
@Builder
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class Arrondissement {

    @Id
    private Long id;

    @Column(unique = true)
    private String libelle;

    @ManyToOne
    private Departement departement;

    @JsonIgnore
    @OneToMany(mappedBy = "arrondissement")
    private List<Commune> communes;
}

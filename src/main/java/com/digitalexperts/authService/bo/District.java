package com.digitalexperts.authService.bo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.List;

/**
 * @author Babacar FAYE (babacar.faye@mns-consulting.com)
 * @since 20/05/2020 01:17
 */

@Entity
@Getter
@Setter
@ToString
@Builder
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class District {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String libelle;

    @ManyToOne
    private Arrondissement arrondissement;

    @ManyToOne
    private Departement departement;

    private Double fraisLivraison = 0d;

    @JsonIgnore
    @OneToMany(mappedBy = "district")
    private List<Commune> communes;
}

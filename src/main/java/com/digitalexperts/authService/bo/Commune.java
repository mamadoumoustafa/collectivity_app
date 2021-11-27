package com.digitalexperts.authService.bo;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@ToString
@Builder
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class Commune {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String libelle;

    @ManyToOne
    private Arrondissement arrondissement;

    @ManyToOne
    private Departement departement;

    @ManyToOne
    private District district;
}

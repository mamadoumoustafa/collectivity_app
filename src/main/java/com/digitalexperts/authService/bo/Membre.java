package com.digitalexperts.authService.bo;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@NoArgsConstructor
@Data
public class Membre {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    private String nom;
    @NotNull
    private String prenom;
    @NotNull
    private String password;

    private String email;

    @NotNull
    private String telephone;
    private String telephoneReferent;

    @NotNull
    private String numCarteElecteur;
    @NotNull
    private String numCarteIdentite;

    @NotNull
    @OneToOne
    private District quartier;
}

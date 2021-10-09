package com.digitalexperts.authService.bo;


import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Membre {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String prenom;

    private String nom;

    @NotNull
    @Size(min = 9,max = 9)
    private String telephone;

    @NotNull
    @Size(max = 9)
    private Long numCartElec;

    @NotNull
    @Size(max = 13)
    private Long numCartCedeao;

    @NotNull
    private String commune;

    @NotNull @Email
    private String email;

    @OneToMany
    private List<Parrain> parrains = new ArrayList<>();

}


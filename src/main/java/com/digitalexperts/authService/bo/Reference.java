package com.digitalexperts.authService.bo;

import javax.persistence.*;

@Entity
public class Reference {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idReference;


    @ManyToOne
    private Membre membre;

}

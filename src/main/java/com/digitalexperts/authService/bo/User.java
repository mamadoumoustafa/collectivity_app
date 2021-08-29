package com.digitalexperts.authService.bo;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;

@Data
@Entity
public class User {

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

    @NotNull
    @Size(min = 5,max = 10)
    private String password;

    @OneToMany
    private List<Role> roles = new ArrayList<>();

    @CreationTimestamp
    @Column(updatable = false,nullable = false)
    private LocalDateTime createDateTime;

    @UpdateTimestamp
    private LocalDateTime updateDateTime;
    
   
}

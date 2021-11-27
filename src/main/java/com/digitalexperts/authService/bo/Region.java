package com.digitalexperts.authService.bo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@Getter
@Setter
@ToString(exclude = {"departements"})
@Builder
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class Region {

    @Id
    private Long id;

    @Column(unique = true)
    private String libelle;

    @JsonIgnore
    @OneToMany(mappedBy = "region")
    private List<Departement> departements;
}

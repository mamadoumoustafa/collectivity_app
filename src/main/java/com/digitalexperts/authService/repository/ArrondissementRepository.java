package com.digitalexperts.authService.repository;

import com.digitalexperts.authService.bo.Arrondissement;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ArrondissementRepository extends JpaRepository<Arrondissement, Long> {

    List<Arrondissement> findAll();

    List<Arrondissement> findAllByDepartement_Id(Long id);

    List<Arrondissement> findAllByDepartement_Region_Id(Long id);
}

package com.digitalexperts.authService.repository;

import com.digitalexperts.authService.bo.Departement;
import org.springframework.data.repository.CrudRepository;
import reactor.core.publisher.Flux;

import java.util.Collection;
import java.util.List;
import java.util.Optional;


public interface DepartementRepository extends CrudRepository<Departement, Long> {

    List<Departement> findAllBy();

    Flux<Departement> findAllByRegion_Id(Long id);

    Optional<Departement> findByLibelle(String libelle);
}

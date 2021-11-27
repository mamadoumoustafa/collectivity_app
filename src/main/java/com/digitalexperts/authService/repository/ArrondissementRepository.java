package com.digitalexperts.authService.repository;

import com.digitalexperts.authService.bo.Arrondissement;
import org.springframework.data.repository.CrudRepository;
import reactor.core.publisher.Flux;

import java.util.Collection;
import java.util.List;

public interface ArrondissementRepository extends CrudRepository<Arrondissement, Long> {

    List<Arrondissement> findAll();

    Flux<Arrondissement> findAllByDepartement_Id(Long id);

    Flux<Arrondissement> findAllByDepartement_Region_Id(Long id);
}

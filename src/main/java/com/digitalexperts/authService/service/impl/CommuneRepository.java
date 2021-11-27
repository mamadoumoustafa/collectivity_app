package com.digitalexperts.authService.service.impl;

import com.digitalexperts.authService.bo.Commune;
import org.springframework.data.repository.CrudRepository;
import reactor.core.publisher.Flux;

import java.util.Collection;
import java.util.List;

public interface CommuneRepository extends CrudRepository<Commune, Long> {


    List<Commune> findAll();

    Flux<Commune> findAllByDepartement_Id(Long id);

    Flux<Commune> findAllByDepartement_Region_Id(Long id);

    Flux<Commune> findAllByArrondissement_Id(Long id);

    Flux<Commune> findAllByDistrict_Id(Long id);
}

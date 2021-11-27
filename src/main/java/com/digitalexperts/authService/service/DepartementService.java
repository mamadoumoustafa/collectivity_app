package com.digitalexperts.authService.service;

import com.digitalexperts.authService.bo.Departement;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Optional;


public interface DepartementService {

    List<Departement> findAllBy();

    Flux<Departement> findAllByRegion_Id(Long id);

    Optional<Departement> findOneById(Long id);
}

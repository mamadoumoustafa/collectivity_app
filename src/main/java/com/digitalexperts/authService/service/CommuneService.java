package com.digitalexperts.authService.service;

import com.digitalexperts.authService.bo.Commune;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Optional;

public interface CommuneService {

    List<Commune> findAllBy();

    Flux<Commune> findAllByDepartement_Id(Long id);

    Flux<Commune> findAllByDepartement_Region_Id(Long id);

    Flux<Commune> findAllByArrondissement_Id(Long id);

    Flux<Commune> findAllByDistrict_Id(Long id);

    Optional<Commune> findOneById(Long id);
}

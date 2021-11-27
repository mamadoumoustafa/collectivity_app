package com.digitalexperts.authService.service;

import com.digitalexperts.authService.bo.Arrondissement;
import reactor.core.publisher.Flux;

import java.util.List;

public interface ArrondissementService {

    List<Arrondissement> findAll();

    Flux<Arrondissement> findAllByDepartement_Id(Long id);

    Flux<Arrondissement> findAllByDepartement_Region_Id(Long id);
}

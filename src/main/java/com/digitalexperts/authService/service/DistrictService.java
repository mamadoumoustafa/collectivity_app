package com.digitalexperts.authService.service;

import com.digitalexperts.authService.bo.District;

import reactor.core.publisher.Flux;

import java.util.Optional;

/**
 * @author Babacar FAYE (babacar.faye@mns-consulting.com)
 * @since 20/05/2020 01:26
 */
public interface DistrictService {

    Flux<District> findAllBy();

    Flux<District> findAllByDepartement_Id(Long id);

    Flux<District> findAllByDepartement_Region_Id(Long id);

    Flux<District> findAllByArrondissement_Id(Long id);

    Optional<District> findOneById(Long id);
}


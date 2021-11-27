package com.digitalexperts.authService.repository;

import com.digitalexperts.authService.bo.District;
import org.springframework.data.repository.CrudRepository;
import reactor.core.publisher.Flux;

import java.util.Collection;

/**
 * @author Babacar FAYE (babacar.faye@mns-consulting.com)
 * @since 20/05/2020 01:19
 */
public interface DistrictRepository extends CrudRepository<District, Long> {

    Flux<District> findAllBy();

    Flux<District> findAllByDepartement_Id(Long id);

    Flux<District> findAllByDepartement_Region_Id(Long id);

    Flux<District> findAllByArrondissement_Id(Long id);

}

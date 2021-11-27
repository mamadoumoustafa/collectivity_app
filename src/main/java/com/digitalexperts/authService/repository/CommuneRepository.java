package com.digitalexperts.authService.repository;

import com.digitalexperts.authService.bo.Commune;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;

public interface CommuneRepository extends CrudRepository<Commune, Long> {

    Collection<Commune> findAllBy();

    Collection<Commune> findAllByDepartement_Id(Long id);

    Collection<Commune> findAllByDepartement_Region_Id(Long id);

    Collection<Commune> findAllByArrondissement_Id(Long id);

    Collection<Commune> findAllByDistrict_Id(Long id);
}

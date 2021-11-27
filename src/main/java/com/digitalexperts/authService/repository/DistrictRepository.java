package com.digitalexperts.authService.repository;

import com.digitalexperts.authService.bo.District;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * @author Babacar FAYE (babacar.faye@mns-consulting.com)
 * @since 20/05/2020 01:19
 */
public interface DistrictRepository extends CrudRepository<District, Long> {

    List<District> findAllBy();

    List<District> findAllByDepartement_Id(Long id);

    List<District> findAllByDepartement_Region_Id(Long id);

    List<District> findAllByArrondissement_Id(Long id);

}

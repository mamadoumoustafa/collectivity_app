package com.digitalexperts.authService.service.impl;

import com.digitalexperts.authService.bo.District;
import com.digitalexperts.authService.repository.DistrictRepository;
import com.digitalexperts.authService.service.DistrictService;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.Optional;

/**
 * @author Babacar FAYE (babacar.faye@mns-consulting.com)
 * @since 20/05/2020 01:28
 */

@Service
public class DistrictServiceImpl implements DistrictService {

    private final DistrictRepository DistrictRepository;

    public DistrictServiceImpl(DistrictRepository DistrictRepository) {
        this.DistrictRepository = DistrictRepository;
    }


    @Override
    public Flux<District> findAllBy() {
        return Flux.fromIterable( DistrictRepository.findAllBy());
    }

    @Override
    public Flux<District> findAllByDepartement_Id(Long id) {
        return Flux.fromIterable( DistrictRepository.findAllByDepartement_Id(id));
    }

    @Override
    public Flux<District> findAllByDepartement_Region_Id(Long id) {
        return Flux.fromIterable( DistrictRepository.findAllByDepartement_Region_Id(id));
    }

    @Override
    public Flux<District> findAllByArrondissement_Id(Long id) {
       return Flux.fromIterable(DistrictRepository.findAllByArrondissement_Id(id));
    }

    @Override
    public Optional<District> findOneById(Long id) {
      return   DistrictRepository.findById(id);
    }
}



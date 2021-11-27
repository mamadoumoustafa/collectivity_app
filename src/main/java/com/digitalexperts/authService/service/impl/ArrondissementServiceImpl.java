package com.digitalexperts.authService.service.impl;

import com.digitalexperts.authService.bo.Arrondissement;
import com.digitalexperts.authService.repository.ArrondissementRepository;
import com.digitalexperts.authService.service.ArrondissementService;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.List;


@Service
public class ArrondissementServiceImpl implements ArrondissementService {

    private final ArrondissementRepository arrondissementRepository;

    public ArrondissementServiceImpl(ArrondissementRepository arrondissementRepository) {
        this.arrondissementRepository = arrondissementRepository;
    }

    @Override
    public List<Arrondissement> findAll() {
        return arrondissementRepository.findAll();
    }

    @Override
    public Flux<Arrondissement> findAllByDepartement_Id(Long id) {
        return Flux.fromIterable(arrondissementRepository.findAllByDepartement_Id(id));
    }

    @Override
    public Flux<Arrondissement> findAllByDepartement_Region_Id(Long id) {
        return Flux.fromIterable(arrondissementRepository.findAllByDepartement_Region_Id(id));
    }
}

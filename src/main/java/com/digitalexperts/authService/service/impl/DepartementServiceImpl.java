package com.digitalexperts.authService.service.impl;

import com.digitalexperts.authService.bo.Departement;
import com.digitalexperts.authService.repository.DepartementRepository;
import com.digitalexperts.authService.service.DepartementService;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.List;
import java.util.Optional;


@Service
public class DepartementServiceImpl implements DepartementService {

    private final DepartementRepository departementRepository;

    public DepartementServiceImpl(DepartementRepository departementRepository) {
        this.departementRepository = departementRepository;
    }

    @Override
    public List<Departement> findAllBy() {
        return departementRepository.findAllBy();
    }

    @Override
    public Flux<Departement> findAllByRegion_Id(Long id) {
        return Flux.fromIterable(departementRepository.findAllByRegion_Id(id));
    }

    @Override
    public Optional<Departement> findOneById(Long id) {
        return departementRepository.findById(id);
    }
}

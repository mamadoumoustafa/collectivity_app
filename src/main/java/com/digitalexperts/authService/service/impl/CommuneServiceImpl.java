package com.digitalexperts.authService.service.impl;


import com.digitalexperts.authService.bo.Commune;
import com.digitalexperts.authService.repository.CommuneRepository;
import com.digitalexperts.authService.service.CommuneService;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.List;
import java.util.Optional;

@Service
public class CommuneServiceImpl implements CommuneService {

    private final CommuneRepository communeRepository;

    public CommuneServiceImpl(CommuneRepository communeRepository) {
        this.communeRepository = communeRepository;
    }


    @Override
    public List<Commune> findAllBy() {
        return (List<Commune>) communeRepository.findAll();
    }

    @Override
    public Flux<Commune> findAllByDepartement_Id(Long id) {
        return Flux.fromIterable( communeRepository.findAllByDepartement_Id(id));
    }

    @Override
    public Flux<Commune> findAllByDepartement_Region_Id(Long id) {
        return Flux.fromIterable(communeRepository.findAllByDepartement_Region_Id(id));
    }

    @Override
    public Flux<Commune> findAllByArrondissement_Id(Long id) {
        return Flux.fromIterable( communeRepository.findAllByArrondissement_Id(id));
    }

    @Override
    public Flux<Commune> findAllByDistrict_Id(Long id) {
        return Flux.fromIterable( communeRepository.findAllByDistrict_Id(id));
    }

    @Override
    public Optional<Commune> findOneById(Long id) {
        return communeRepository.findById(id);
    }
}

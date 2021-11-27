package com.digitalexperts.authService.service.impl;


import com.digitalexperts.authService.bo.Region;
import com.digitalexperts.authService.repository.RegionRepository;
import com.digitalexperts.authService.service.RegionService;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Optional;


@Service
public class RegionServiceImpl implements RegionService {

    private final RegionRepository regionRepository;

    public RegionServiceImpl(RegionRepository regionRepository) {
        this.regionRepository = regionRepository;
    }


    @Override
    public List<Region> findAllBy() {
        return regionRepository.findAll();
    }

    @Override
    public Optional<Region> findById(Long id) {
        return regionRepository.findById(id);
    }
}

package com.digitalexperts.authService.service;

import com.digitalexperts.authService.bo.Region;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Optional;

public interface RegionService {

    List<Region> findAllBy();

    Optional<Region> findById(Long id);
}

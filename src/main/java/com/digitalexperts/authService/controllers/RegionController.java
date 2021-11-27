package com.digitalexperts.authService.controllers;

import com.digitalexperts.authService.bo.Region;
import com.digitalexperts.authService.service.RegionService;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/adresse/regions")
public class RegionController {

    private final RegionService regionService;

    public RegionController(RegionService regionService) {
        this.regionService = regionService;
    }

    @RequestMapping(method = RequestMethod.GET, value = "")
    public List<Region> findAllBy() {
        return regionService.findAllBy();
    }

    @GetMapping( value = "/{id}")
    public Optional<Region> findById(@PathVariable Long id) {
        return regionService.findById(id);
    }

}

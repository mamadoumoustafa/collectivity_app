package com.digitalexperts.authService.controllers;


import com.digitalexperts.authService.bo.District;
import com.digitalexperts.authService.service.DistrictService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.util.Optional;

/**
 * @author Babacar FAYE (babacar.faye@mns-consulting.com)
 * @since 20/05/2020 02:28
 */

@RestController
@RequestMapping("/api/adresse/districts")
@Slf4j
public class DistrictController {

    private final DistrictService districtService;

    public DistrictController(DistrictService districtService) {
        this.districtService = districtService;
    }

    @RequestMapping(method = RequestMethod.GET, value = "")
    public Flux<District> findAll() {
        return districtService.findAllBy();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public Optional<District> findOneById(@PathVariable Long id){
        log.info("districtService id ============= {}",id);
        return districtService.findOneById(id);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/arrondissement/{id}")
    public Flux<District> findAllByArrondissement(@PathVariable Long id) {
        return districtService.findAllByArrondissement_Id(id);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/departement/{id}")
    public Flux<District> findAllByDepartement(@PathVariable Long id) {
        return districtService.findAllByDepartement_Id(id);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/region/{id}")
    public Flux<District> findAllByRegion(@PathVariable Long id) {
        return districtService.findAllByDepartement_Region_Id(id);
    }

}


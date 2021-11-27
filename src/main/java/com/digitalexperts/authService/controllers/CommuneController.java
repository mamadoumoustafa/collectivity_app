package com.digitalexperts.authService.controllers;


import com.digitalexperts.authService.bo.Commune;
import com.digitalexperts.authService.service.CommuneService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/adresse/communes")
@Slf4j
public class CommuneController {

    private final CommuneService communeService;

    public CommuneController(CommuneService communeService) {
        this.communeService = communeService;
    }

    @RequestMapping(method = RequestMethod.GET, value = "")
    public List<Commune> findAll() {
        return communeService.findAllBy();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public Optional<Commune> findOneById(@PathVariable Long id){
        log.info("commune id ============= {}",id);
        return communeService.findOneById(id);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/arrondissement/{id}")
    public Flux<Commune> findAllByArrondissement(@PathVariable Long id) {
        return communeService.findAllByArrondissement_Id(id);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/departement/{id}")
    public Flux<Commune> findAllByDepartement(@PathVariable Long id) {
        return communeService.findAllByDepartement_Id(id);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/region/{id}")
    public Flux<Commune> findAllByRegion(@PathVariable Long id) {
        return communeService.findAllByDepartement_Region_Id(id);
    }

}

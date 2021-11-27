package com.digitalexperts.authService.controllers;


import com.digitalexperts.authService.bo.Arrondissement;
import com.digitalexperts.authService.service.ArrondissementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.util.List;

@RestController
@RequestMapping("/api/adresse/arrondissements")
public class ArrondissementController {

    private final ArrondissementService arrondissementService;

    @Autowired
    public ArrondissementController(ArrondissementService arrondissementService) {
        this.arrondissementService = arrondissementService;
    }

    @RequestMapping(method = RequestMethod.GET, value = "")
    public List<Arrondissement> findAll() {
        return arrondissementService.findAll();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/region/{id}")
    public Flux<Arrondissement> findAllByRegion(@PathVariable Long id) {
        return arrondissementService.findAllByDepartement_Region_Id(id);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/departement/{id}")
    public Flux<Arrondissement> findAllByDepartement(@PathVariable Long id) {
        return arrondissementService.findAllByDepartement_Id(id);
    }
}

package com.digitalexperts.authService.controllers;



import com.digitalexperts.authService.bo.Departement;
import com.digitalexperts.authService.service.DepartementService;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/adresse/departements")
public class DepartementController {

    private final DepartementService departementService;

    public DepartementController(DepartementService departementService) {
        this.departementService = departementService;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/region/{id}")
    public Flux<Departement> findAllByRegion(@PathVariable Long id) {
        return departementService.findAllByRegion_Id(id);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public Optional<Departement> findOneById(@PathVariable Long id){
        return departementService.findOneById(id);
    }

    @RequestMapping(method = RequestMethod.GET, value = "")
    public List<Departement> findAll(Pageable pageable) {
        return departementService.findAllBy();
    }
}

package com.digitalexperts.authService.repository;

import com.digitalexperts.authService.bo.Region;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;
import java.util.List;


public interface RegionRepository extends CrudRepository<Region, Long> {

    List<Region> findAll();
}

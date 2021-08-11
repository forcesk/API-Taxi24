package com.ecastillo.taxi24.Repositories;

import com.ecastillo.taxi24.Models.ConductoresModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ConductoresRepository extends MongoRepository<ConductoresModel,String> {
    List<ConductoresModel> findByDisponibleIsTrue();
}

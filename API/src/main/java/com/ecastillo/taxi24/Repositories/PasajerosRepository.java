package com.ecastillo.taxi24.Repositories;

import com.ecastillo.taxi24.Models.PasajerosModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PasajerosRepository extends MongoRepository<PasajerosModel,String> {

}

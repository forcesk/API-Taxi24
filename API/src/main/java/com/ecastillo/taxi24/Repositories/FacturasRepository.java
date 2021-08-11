package com.ecastillo.taxi24.Repositories;

import com.ecastillo.taxi24.Models.FacturasModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FacturasRepository extends MongoRepository<FacturasModel,String> {
}

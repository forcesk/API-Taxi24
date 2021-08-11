package com.ecastillo.taxi24.Repositories;

import com.ecastillo.taxi24.Models.ConductoresModel;
import com.ecastillo.taxi24.Models.ViajesModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ViajesRepository extends MongoRepository<ViajesModel,String> {
    List<ViajesModel> findByEnCursoTrue();
}

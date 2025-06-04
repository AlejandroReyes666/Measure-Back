package com.MARM.mediciones_api.persistence.crud;

import com.MARM.mediciones_api.persistence.Entity.Ubicaciones;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface UbicacionesCrudRepository extends CrudRepository<Ubicaciones,Integer > {

    Optional <Ubicaciones> findById( Integer Id);
}

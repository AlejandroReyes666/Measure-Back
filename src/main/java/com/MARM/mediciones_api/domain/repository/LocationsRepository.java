package com.MARM.mediciones_api.domain.repository;

import com.MARM.mediciones_api.domain.dto.Locations;

import java.util.List;
import java.util.Optional;

public interface LocationsRepository {
    List<Locations>getAll();
    Optional<Locations>getLocation(int locationID);
    Locations save(Locations locations);
    void delete(int locationID);

}

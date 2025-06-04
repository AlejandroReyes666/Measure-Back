package com.MARM.mediciones_api.domain.service;

import com.MARM.mediciones_api.domain.dto.Locations;
import com.MARM.mediciones_api.domain.repository.LocationsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UbicacionesService {
    @Autowired
    private LocationsRepository locationsRepository;

    public List<Locations> getAll(){
        return locationsRepository.getAll();
    }

    public Optional<Locations> getLocation(int locationId){
        return locationsRepository.getLocation(locationId);
    }

    public Locations save(Locations locations){
        if (locations.getLocationID() == null || locations.getLocationID() == 0) {
            locations.setLocationID(null);
        }
        return locationsRepository.save(locations);

    }

    public Boolean delete(int locationId){
       return getLocation(locationId).map(locations -> {
           locationsRepository.delete(locationId);
           return true;
       }).orElse(false);
    }

}

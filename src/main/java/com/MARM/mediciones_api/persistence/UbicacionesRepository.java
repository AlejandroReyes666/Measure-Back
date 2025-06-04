package com.MARM.mediciones_api.persistence;

import com.MARM.mediciones_api.domain.dto.Locations;
import com.MARM.mediciones_api.domain.repository.LocationsRepository;
import com.MARM.mediciones_api.persistence.Entity.Ubicaciones;
import com.MARM.mediciones_api.persistence.crud.UbicacionesCrudRepository;
import com.MARM.mediciones_api.persistence.mapper.LocationsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class UbicacionesRepository implements LocationsRepository {
    @Autowired
    private UbicacionesCrudRepository ubicacionesCrudRepository;

    @Autowired
    private LocationsMapper mapper;


    @Override
    public List<Locations> getAll() {
        List< Ubicaciones> ubicaciones=(List<Ubicaciones>)ubicacionesCrudRepository.findAll();
        return mapper.toLocationsList(ubicaciones);
    }

    @Override
    public Optional<Locations> getLocation(int locationID) {

        return ubicacionesCrudRepository.findById(locationID).map(ubicaciones -> mapper.tolocation(ubicaciones));
    }

    @Override
    public Locations save(Locations locations) {
        System.out.println("🟢 Antes del mapeo (DTO): " + locations);
        System.out.println("📌 ID: " + locations.getLocationID());
        System.out.println("📌 Nombre: " + locations.getNameLocation());
        //System.out.println("📌 Dispositivos: " + locations.getDispositivos());

        Ubicaciones ubicaciones = mapper.toUbicaciones(locations);

        System.out.println("🟡 Después del mapeo (Entidad): " + ubicaciones);
        System.out.println("📌 ID: " + ubicaciones.getIdUbicaciones());
        System.out.println("📌 Nombre: " + ubicaciones.getNombreUbicaciones());
        //System.out.println("📌 Dispositivos: " + ubicaciones.getDispositivos());

        if (ubicaciones.getDispositivos() == null) {
            ubicaciones.setDispositivos(new ArrayList<>());  // 🔥 Asegurar que no sea null
        }

        Ubicaciones savedUbicacion = ubicacionesCrudRepository.save(ubicaciones);
        System.out.println("🔵 Después de guardar (Entidad con ID): " + savedUbicacion);

        Locations savedLocation = mapper.tolocation(savedUbicacion);
        System.out.println("🟣 Después de guardar (DTO): " + savedLocation);

        return savedLocation;
    }


    @Override
    public void delete(int ubicacionId) {
        ubicacionesCrudRepository.deleteById(ubicacionId);
    }
}

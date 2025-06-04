package com.MARM.mediciones_api.persistence.mapper;
import com.MARM.mediciones_api.domain.dto.Locations;
import com.MARM.mediciones_api.persistence.Entity.Ubicaciones;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface LocationsMapper {
    @Mappings({
            @Mapping(source = "idUbicaciones", target = "locationID"),
            @Mapping(source = "nombreUbicaciones", target = "nameLocation"),
            //@Mapping(target = "dispositivos", expression = "java(new ArrayList<>())")
    })


    Locations tolocation(Ubicaciones ubicaciones);
    @InheritInverseConfiguration
    Ubicaciones toUbicaciones(Locations location);
    List<Locations> toLocationsList(List<Ubicaciones>ubicaciones);
    List<Ubicaciones> toUbicacionesList(List<Locations>locations);


}

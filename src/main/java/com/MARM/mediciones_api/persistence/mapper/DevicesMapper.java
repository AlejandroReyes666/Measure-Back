package com.MARM.mediciones_api.persistence.mapper;


import com.MARM.mediciones_api.domain.dto.Devices;
import com.MARM.mediciones_api.domain.dto.Locations;
import com.MARM.mediciones_api.persistence.Entity.Dispositivos;
import com.MARM.mediciones_api.persistence.Entity.Ubicaciones;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring",uses = {LocationsMapper.class})
public interface DevicesMapper {
    @Mappings({
            @Mapping(source="idDispositivo",target="devicesId"),
            @Mapping(source="nombreDispositivo",target="devicesName"),
            @Mapping(source="createIn",target="createdDate"),
            @Mapping(source="updateIn",target="updatedDate"),
            @Mapping(source = "estado",target = "state"),
            @Mapping(source = "ubicacion.idUbicaciones", target = "idUbicacion"),


            //@Mapping(source = "ubicacion", targetget = "measureWeek"),
            //            //@Mapping(source = "medidaMonth", target = "measureMonth"),
            //            //@Mapping(source = "medidaYear", target = "measureYear") = "ubicacion"),
            //@Mapping(source = "medidasDiarias", target = "measureDay"),
            //@Mapping(source = "medidasSemana", tar
    })
    Devices toDevices(Dispositivos dispositivos);

    @InheritInverseConfiguration
    @Mapping(source = "idUbicacion", target = "ubicacion", qualifiedByName = "mapUbicacion")

    Dispositivos toDispositivos(Devices devices);

    List<Devices> toDevicesList(List<Dispositivos> dispositivos);

    List<Dispositivos> toDispositivosList(List<Devices> devices);

    @Named("mapUbicacion")
    default Ubicaciones mapUbicacion(Integer idUbicacion) {
        if (idUbicacion == null) {
            return null;
        }
        Ubicaciones ubicacion = new Ubicaciones();
        ubicacion.setIdUbicaciones(idUbicacion);
        return ubicacion;
    }


}

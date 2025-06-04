package com.MARM.mediciones_api.persistence.mapper;


import com.MARM.mediciones_api.domain.dto.MesureDay;
import com.MARM.mediciones_api.domain.dto.MesureWeek;
import com.MARM.mediciones_api.persistence.Entity.MedidadDia;
import com.MARM.mediciones_api.persistence.Entity.MedidasSemana;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MesureWeekMapper {
    @Mappings({
            @Mapping(source ="idMeditionweek" ,target ="mesureWeekId" ),
            @Mapping(source = "idDispositivo",target ="deviceId" ),
            @Mapping(source ="voltageWeek" ,target = "voltageMesureWeek"),
            @Mapping(source = "distanceWeek",target = "distanceMesureWeek"),
            @Mapping(source ="levelgeWeek" ,target ="levelMesureWeek" ),
            @Mapping(source ="lightWeek" ,target ="lightMesureWeek" ),
            @Mapping(source ="dateWeek" ,target ="mesureDate" ),
            //@Mapping(target = "dispositivoSemana", ignore = true)


    })
    MesureWeek toMesureWeek(MedidasSemana medidasSemana);
    @InheritInverseConfiguration
    MedidasSemana toMedidasSemana(MesureWeek mesureWeek);

    List<MesureWeek> toMesureWeekList(List<MedidasSemana>medidasSemanas);
    List<MedidasSemana> toMedidasSemana(List<MesureWeek>mesureWeeks);
}

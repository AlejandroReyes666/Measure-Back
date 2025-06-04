package com.MARM.mediciones_api.persistence.mapper;


import com.MARM.mediciones_api.domain.dto.MesureMonth;
import com.MARM.mediciones_api.domain.dto.MesureWeek;
import com.MARM.mediciones_api.persistence.Entity.MedidasMes;
import com.MARM.mediciones_api.persistence.Entity.MedidasSemana;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MesureMonthMapper {

    @Mappings({
            @Mapping(source ="idMeditionMonth" ,target ="mesureMonthId" ),
            @Mapping(source = "idDispositivo",target ="deviceId" ),
            @Mapping(source ="voltageMonth" ,target = "voltageMesureMonth"),
            @Mapping(source = "distanceMonth",target = "distanceMesureMoth"),
            @Mapping(source ="levelgeMonth" ,target ="levelMesureMonth" ),
            @Mapping(source ="lightWeek" ,target ="lightMesureMonth" ),
            @Mapping(source ="dateMonth" ,target ="mesureDate" ),
            //@Mapping(target = "dispositivoMonth", ignore = true)


    })
    MesureMonth toMesureMonth(MedidasMes medidasMes);
    @InheritInverseConfiguration
    MedidasMes toMedidasMes(MesureMonth mesureMonth);

    List<MesureMonth> toMesureMonthList(List<MedidasMes>medidasMes);
    List<MedidasMes> toMedidasMes(List<MesureMonth>mesureMonths);
}

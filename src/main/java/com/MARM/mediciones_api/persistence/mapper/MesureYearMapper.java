package com.MARM.mediciones_api.persistence.mapper;

import com.MARM.mediciones_api.domain.dto.MesureMonth;
import com.MARM.mediciones_api.domain.dto.MesureYear;
import com.MARM.mediciones_api.persistence.Entity.MedidasAño;
import com.MARM.mediciones_api.persistence.Entity.MedidasMes;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MesureYearMapper {
    @Mappings({
            @Mapping(source ="idMeditionYear" ,target ="mesureYearId" ),
            @Mapping(source = "idDispositivo",target ="deviceId" ),
            @Mapping(source ="voltageYear" ,target = "voltageMesureYear"),
            @Mapping(source = "distanceYear",target = "distanceMesureYear"),
            @Mapping(source ="levelgeYear" ,target ="levelMesureYear" ),
            @Mapping(source ="lightYear" ,target ="lightMesureYear" ),
            @Mapping(source ="dateYear" ,target ="mesureDate" ),
            //@Mapping(target = "dispositivoYear", ignore = true)


    })
    MesureYear toMesureYear(MedidasAño medidasAño);
    @InheritInverseConfiguration
    MedidasAño toMedidasAño(MesureYear mesureYear);

    List<MesureYear> toMesureYearList(List<MedidasAño>medidasAños);
    List<MedidasAño> toMedidasAño(List<MesureYear>mesureYears);
}

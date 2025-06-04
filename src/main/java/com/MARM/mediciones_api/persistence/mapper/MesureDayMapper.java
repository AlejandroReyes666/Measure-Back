package com.MARM.mediciones_api.persistence.mapper;


import com.MARM.mediciones_api.domain.dto.Devices;
import com.MARM.mediciones_api.domain.dto.MesureDay;
import com.MARM.mediciones_api.persistence.Entity.Dispositivos;
import com.MARM.mediciones_api.persistence.Entity.MedidadDia;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MesureDayMapper {
    @Mappings({
            @Mapping(source ="idMeditiondaily" ,target ="mesureDayId" ),
            @Mapping(source = "idDispositivo",target ="deviceId" ),
            @Mapping(source ="voltageDaily" ,target = "voltageDay"),
            @Mapping(source = "distanceDaily",target = "distanceDay"),
            @Mapping(source ="levelgeDaily" ,target ="levelDay" ),
            @Mapping(source ="lightDaily" ,target ="lightgeDay" ),
            @Mapping(source ="dateToDay" ,target ="mesureDate" ),
            //@Mapping(target = "dispositivoDia", ignore = true)

    })
    MesureDay toMesureDay(MedidadDia medidadDia);
    @InheritInverseConfiguration
    MedidadDia toMedidadDia(MesureDay mesureDay);

    List<MesureDay> toMesureDayList(List<MedidadDia>medidadDias);
    List<MedidadDia> toMedidadDia(List<MesureDay>mesureDays);
}

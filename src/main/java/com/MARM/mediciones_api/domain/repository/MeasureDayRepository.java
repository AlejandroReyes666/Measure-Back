package com.MARM.mediciones_api.domain.repository;

import com.MARM.mediciones_api.domain.dto.MesureDay;
import com.MARM.mediciones_api.persistence.Entity.Dispositivos;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface MeasureDayRepository {
    List<MesureDay> getAll();
    List<MesureDay>getByDeviceId(int deviceId);

    //List<MesureDay> getByDeviceId(Dispositivos deviceId);

    Optional<MesureDay> getById(int mesureDayId);
    MesureDay save(MesureDay mesureDay);
    void delete ( int mesureDayId);

    List<MesureDay>getByMedureDate(LocalDateTime date);
    List<MesureDay>getByMesureDateBetween(LocalDateTime startDate,LocalDateTime endDate);
    List<MesureDay>getByMesureDateAfter(LocalDateTime date);
    List<MesureDay>getByMesureDateBefore(LocalDateTime date);
    List<MesureDay> getByDeviceIdAndMesureDateBetween
            (int deviceID, LocalDateTime startDate, LocalDateTime endDate);



}

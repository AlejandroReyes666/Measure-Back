package com.MARM.mediciones_api.domain.repository;

import com.MARM.mediciones_api.domain.dto.MesureWeek;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface MesureWeekResposirory {
    List<MesureWeek> getAll();
    Optional<MesureWeek> getById(int mesureWeekId);
    List<MesureWeek>getByDevice(int deviceId);
    MesureWeek save(MesureWeek mesureWeek);
    void delete ( int mesureWeekId);

    List<MesureWeek>getByMedureDate(LocalDateTime date);
    List<MesureWeek>getByMesureDateBetween(LocalDateTime startDate,LocalDateTime endDate);
    List<MesureWeek>getByMesureDateAfter(LocalDateTime date);
    List<MesureWeek>getByMesureDateBefore(LocalDateTime date);
    List<MesureWeek> getByDeviceIdAndMesureDateBetween
            (int deviceID, LocalDateTime startDate, LocalDateTime endDate);
}

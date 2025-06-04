package com.MARM.mediciones_api.domain.repository;

import com.MARM.mediciones_api.domain.dto.MesureYear;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface MesureYearRepository {
    List<MesureYear> getAll();
    Optional getById(int mesureYearId);
    List<MesureYear>getByDevice(int deviceId);
    MesureYear save(MesureYear mesureYear);
    void delete ( int mesureYearId);

    List<MesureYear>getByMesureDate(LocalDateTime date);
    List<MesureYear>getByMesureDateBetween(LocalDateTime startDate,LocalDateTime endDate);
    List<MesureYear>getByMesureDateAfter(LocalDateTime date);
    List<MesureYear>getByMesureDateBefore(LocalDateTime date);
    List<MesureYear> getByDeviceIdAndMesureDateBetween
            (int deviceId, LocalDateTime startDate, LocalDateTime endDate);
}

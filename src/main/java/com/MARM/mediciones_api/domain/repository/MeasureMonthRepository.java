package com.MARM.mediciones_api.domain.repository;

import com.MARM.mediciones_api.domain.dto.MesureMonth;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface MeasureMonthRepository {

    List<MesureMonth> getAll();
    Optional<MesureMonth> getById(int mesureMonthId);
    List<MesureMonth>getByDevice(int deviceId);
    MesureMonth save(MesureMonth mesureMonth);
    void delete ( int mesureMonthId);

    List<MesureMonth>getByMesureDate(LocalDateTime date);
    List<MesureMonth>getByMesureDateBetween(LocalDateTime startDate,LocalDateTime endDate);
    List<MesureMonth>getByMesureDateAfter(LocalDateTime date);
    List<MesureMonth>getByMesureDateBefore(LocalDateTime date);
    List<MesureMonth> getByDeviceIdAndMesureDateBetween
            (int deviceId, LocalDateTime startDate, LocalDateTime endDate);
}

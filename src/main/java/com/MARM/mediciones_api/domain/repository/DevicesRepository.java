package com.MARM.mediciones_api.domain.repository;

import com.MARM.mediciones_api.domain.dto.Devices;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface DevicesRepository {
    List<Devices> getAll();
    Optional<Devices>getById(int devicesId);
    List<Devices>getByLocation(int locationID);
    Devices save(Devices devices);
    void delete ( int devicesID);

    List<Devices> getByCreatedBefore(LocalDateTime date);
    List<Devices> getByCreatedAfter(LocalDateTime date);
    List<Devices> getByCreatedBetween(LocalDateTime startDate, LocalDateTime endtDate);

    List<Devices> getByUpdateBefore(LocalDateTime date);
    List<Devices> getByUpdateAfter(LocalDateTime date);
    List<Devices> getByUpdatedBetween(LocalDateTime startDate, LocalDateTime endtDate);
    List<Devices> getByState(String state);

}

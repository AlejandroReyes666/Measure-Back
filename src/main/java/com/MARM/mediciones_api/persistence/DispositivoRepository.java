package com.MARM.mediciones_api.persistence;


import com.MARM.mediciones_api.domain.dto.Devices;
import com.MARM.mediciones_api.domain.repository.DevicesRepository;
import com.MARM.mediciones_api.persistence.Entity.Dispositivos;
import com.MARM.mediciones_api.persistence.crud.DispositivoCrudRepository;
import com.MARM.mediciones_api.persistence.mapper.DevicesMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public class DispositivoRepository implements DevicesRepository {
    @Autowired
    private DispositivoCrudRepository dispositivoCrudRepository;
    @Autowired
    private DevicesMapper mapper;

    @Override
    public List<Devices> getAll() {
        List<Dispositivos> dispositivos=(List<Dispositivos>) dispositivoCrudRepository.findAll();
        return mapper.toDevicesList(dispositivos);
    }

    @Override
    public Optional<Devices> getById(int devicesId) {
        return dispositivoCrudRepository.findById(devicesId)
                .map(dispositivos -> mapper.toDevices(dispositivos));
    }

    @Override
    public List<Devices> getByLocation(int locationID) {
        List<Dispositivos> dispositivos;
        dispositivos = (List<Dispositivos>) dispositivoCrudRepository
                .findByUbicacion_IdUbicacionesOrderByNombreDispositivoAsc(locationID);
        return mapper.toDevicesList(dispositivos);
    }

    @Override
    public Devices save(Devices devices) {

        System.out.println("-----Datos en el repositorio---- " );
        System.out.println("Guardando DTO: " + devices);

        Dispositivos dispositivos= mapper.toDispositivos(devices);

        System.out.println("Guardando entidad: " + dispositivos);
        return mapper.toDevices(dispositivoCrudRepository.save(dispositivos));
    }

    @Override
    public void delete(int idDispositivo) {
        dispositivoCrudRepository.deleteById(idDispositivo);

    }

    @Override
    public List<Devices> getByCreatedBefore(LocalDateTime date) {
        List<Dispositivos>dispositivos=(List<Dispositivos>)dispositivoCrudRepository
                .findByCreateInBefore(date);
        return mapper.toDevicesList(dispositivos);
    }

    @Override
    public List<Devices> getByCreatedAfter(LocalDateTime date) {
        List<Dispositivos> dispositivos=(List<Dispositivos>)dispositivoCrudRepository
                .findByCreateInAfter(date);
        return mapper.toDevicesList(dispositivos);
    }

    @Override
    public List<Devices> getByCreatedBetween(LocalDateTime startDate, LocalDateTime endtDate) {
        List<Dispositivos> dispositivos=(List<Dispositivos>)dispositivoCrudRepository
                .findByCreateInBetween(startDate,endtDate);
        return mapper.toDevicesList(dispositivos);
    }

    @Override
    public List<Devices> getByUpdateBefore(LocalDateTime date) {
        List<Dispositivos> dispositivos=(List<Dispositivos>) dispositivoCrudRepository
                .findByUpdateInBefore(date);
        return mapper.toDevicesList(dispositivos);
    }

    @Override
    public List<Devices> getByUpdateAfter(LocalDateTime date) {
        List<Dispositivos> dispositivos=(List<Dispositivos>)dispositivoCrudRepository
                .findByUpdateInAfter(date);
        return mapper.toDevicesList(dispositivos);
    }

    @Override
    public List<Devices> getByUpdatedBetween(LocalDateTime startDate, LocalDateTime endtDate) {
        List<Dispositivos> dispositivos=(List<Dispositivos>) dispositivoCrudRepository
                .findByUpdateInBetween(startDate,endtDate);
        return mapper.toDevicesList(dispositivos);
    }

    @Override
    public List<Devices> getByState(String state) {
        List<Dispositivos> dispositivos=(List<Dispositivos>) dispositivoCrudRepository
                .findByEstado(state);
        return mapper.toDevicesList(dispositivos);
    }

}

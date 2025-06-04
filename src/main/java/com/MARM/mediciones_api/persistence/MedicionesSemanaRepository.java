package com.MARM.mediciones_api.persistence;

import com.MARM.mediciones_api.domain.dto.MesureWeek;
import com.MARM.mediciones_api.domain.repository.MesureWeekResposirory;
import com.MARM.mediciones_api.persistence.Entity.MedidasSemana;
import com.MARM.mediciones_api.persistence.crud.MedidasSemanaCrudRepository;
import com.MARM.mediciones_api.persistence.mapper.MesureWeekMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public class MedicionesSemanaRepository implements MesureWeekResposirory {
    @Autowired
    private MedidasSemanaCrudRepository medidasSemanaCrudRepository;

    @Autowired
    private MesureWeekMapper mapper;

    @Override
    public List<MesureWeek> getAll() {
        List<MedidasSemana> medidasSemanas= (List<MedidasSemana>) medidasSemanaCrudRepository
                .findAll();
        return mapper.toMesureWeekList(medidasSemanas);
    }

    @Override
    public Optional<MesureWeek> getById(int mesureWeekId) {

        return medidasSemanaCrudRepository.findById(mesureWeekId).map(mapper::toMesureWeek);
    }

    @Override
    public List<MesureWeek> getByDevice(int deviceId) {
        List<MedidasSemana>medidasSemanas=(List<MedidasSemana>) medidasSemanaCrudRepository
                .findByIdDispositivo(deviceId);
        return mapper.toMesureWeekList(medidasSemanas);
    }

    @Override
    public MesureWeek save(MesureWeek mesureWeek) {
        MedidasSemana medidasSemana= mapper.toMedidasSemana(mesureWeek);
        System.out.println("Guardado en la BD con ID: " +medidasSemana.getIdMeditionweek());
        medidasSemana=medidasSemanaCrudRepository.save(medidasSemana);
        return mapper.toMesureWeek(medidasSemana);
    }

    @Override
    public void delete(int mesureWeekId) {
        medidasSemanaCrudRepository.deleteById(mesureWeekId);

    }

    @Override
    public List<MesureWeek> getByMedureDate(LocalDateTime date) {
        List<MedidasSemana> medidasSemanas=(List<MedidasSemana>) medidasSemanaCrudRepository
                .findByDateWeek(date);
        return mapper.toMesureWeekList(medidasSemanas);
    }

    @Override
    public List<MesureWeek> getByMesureDateBetween(LocalDateTime startDate, LocalDateTime endDate) {
        List<MedidasSemana> medidasSemanas=(List<MedidasSemana>)medidasSemanaCrudRepository
                .findByDateWeekBetween(startDate,endDate);
        return mapper.toMesureWeekList(medidasSemanas);
    }

    @Override
    public List<MesureWeek> getByMesureDateAfter(LocalDateTime date) {
        List<MedidasSemana> medidasSemanas=(List<MedidasSemana>)medidasSemanaCrudRepository
                .findByDateWeekAfter(date);
        return mapper.toMesureWeekList(medidasSemanas);
    }

    @Override
    public List<MesureWeek> getByMesureDateBefore(LocalDateTime date) {
        List<MedidasSemana> medidasSemanas=(List<MedidasSemana>)medidasSemanaCrudRepository
                .findByDateWeekBefore(date);
        return mapper.toMesureWeekList(medidasSemanas);
    }

    @Override
    public List<MesureWeek> getByDeviceIdAndMesureDateBetween(int deviceID, LocalDateTime startDate, LocalDateTime endDate) {
        List<MedidasSemana> medidasSemanas=(List<MedidasSemana>)medidasSemanaCrudRepository
                .findByIdDispositivoAndDateWeekBetween(deviceID,startDate,endDate);
        return mapper.toMesureWeekList(medidasSemanas);
    }
}

package com.MARM.mediciones_api.persistence;


import com.MARM.mediciones_api.domain.dto.MesureMonth;
import com.MARM.mediciones_api.domain.repository.MeasureMonthRepository;
import com.MARM.mediciones_api.persistence.Entity.MedidasMes;
import com.MARM.mediciones_api.persistence.crud.MedidadMensualesCrudRepository;
import com.MARM.mediciones_api.persistence.mapper.MesureMonthMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public class MedicionesMesRepository implements MeasureMonthRepository {
    @Autowired
    private MedidadMensualesCrudRepository medidadMensualesCrudRepository;
    @Autowired
    private MesureMonthMapper mapper;

    @Override
    public List<MesureMonth> getAll() {
        List<MedidasMes> medidasMes= (List<MedidasMes>) medidadMensualesCrudRepository
                .findAll();
        return mapper.toMesureMonthList(medidasMes);
    }

    @Override
    public Optional<MesureMonth> getById(int mesureMonthId) {
        return medidadMensualesCrudRepository.findById(mesureMonthId).map(mapper::toMesureMonth);
    }

    @Override
    public List<MesureMonth> getByDevice(int deviceId) {
        List<MedidasMes> medidasMes= (List<MedidasMes>)medidadMensualesCrudRepository
                .findByIdDispositivo(deviceId);
        return mapper.toMesureMonthList(medidasMes);
    }

    @Override
    public MesureMonth save(MesureMonth mesureMonth) {
        MedidasMes medidasMes= mapper.toMedidasMes(mesureMonth);
        System.out.println("Guardado en la BD con ID: " +medidasMes.getIdMeditionMonth());
        medidasMes=medidadMensualesCrudRepository.save(medidasMes);
        return mapper.toMesureMonth(medidasMes);
    }

    @Override
    public void delete(int mesureMonthId) {
        medidadMensualesCrudRepository.deleteById(mesureMonthId);

    }

    @Override
    public List<MesureMonth> getByMesureDate(LocalDateTime date) {
        List<MedidasMes> medidasMes= (List<MedidasMes>)medidadMensualesCrudRepository
                .findByDateMonth(date);
        return mapper.toMesureMonthList(medidasMes);
    }

    @Override
    public List<MesureMonth> getByMesureDateBetween(LocalDateTime startDate, LocalDateTime endDate) {

        List<MedidasMes> medidasMes= (List<MedidasMes>)medidadMensualesCrudRepository
                .findByDateMonthBetween(startDate,endDate);
        return mapper.toMesureMonthList(medidasMes);
    }

    @Override
    public List<MesureMonth> getByMesureDateAfter(LocalDateTime date) {

        List<MedidasMes> medidasMes= (List<MedidasMes>)medidadMensualesCrudRepository
                .findByDateMonthAfter(date);
        return mapper.toMesureMonthList(medidasMes);
    }

    @Override
    public List<MesureMonth> getByMesureDateBefore(LocalDateTime date) {
        List<MedidasMes> medidasMes= (List<MedidasMes>)medidadMensualesCrudRepository
                .findByDateMonthBefore(date);
        return mapper.toMesureMonthList(medidasMes);
    }

    @Override
    public List<MesureMonth> getByDeviceIdAndMesureDateBetween(int deviceId, LocalDateTime startDate, LocalDateTime endDate) {
        List<MedidasMes> medidasMes= (List<MedidasMes>)medidadMensualesCrudRepository
                .findByIdDispositivoAndDateMonthBetween(deviceId,startDate,endDate);
        return mapper.toMesureMonthList(medidasMes);
    }
}

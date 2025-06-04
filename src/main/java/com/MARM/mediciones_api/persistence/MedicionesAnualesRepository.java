package com.MARM.mediciones_api.persistence;

import com.MARM.mediciones_api.domain.dto.MesureYear;
import com.MARM.mediciones_api.domain.repository.MesureYearRepository;
import com.MARM.mediciones_api.persistence.Entity.MedidasAño;
import com.MARM.mediciones_api.persistence.crud.MedidasAnualesCrudRepository;
import com.MARM.mediciones_api.persistence.mapper.MesureYearMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public class MedicionesAnualesRepository implements MesureYearRepository {
    @Autowired
    private MedidasAnualesCrudRepository medidasAnualesCrudRepository;
    @Autowired
    private MesureYearMapper mapper;

    @Override
    public List<MesureYear> getAll() {
        List<MedidasAño> medidasAños=(List<MedidasAño>) medidasAnualesCrudRepository
                .findAll();
        return mapper.toMesureYearList(medidasAños);
    }

    @Override
    public Optional getById(int mesureYearId) {

        return medidasAnualesCrudRepository.findById(mesureYearId).map(mapper::toMesureYear);
    }

    @Override
    public List<MesureYear> getByDevice(int deviceId) {
        List<MedidasAño> medidasAños=(List<MedidasAño>)medidasAnualesCrudRepository
                .findByIdDispositivo(deviceId);
        return mapper.toMesureYearList(medidasAños);
    }

    @Override
    public MesureYear save(MesureYear mesureYear) {
        MedidasAño medidasAño=mapper.toMedidasAño(mesureYear);
        System.out.println("Guardado en la BD con ID: " +medidasAño.getIdMeditionYear());

        medidasAño=medidasAnualesCrudRepository.save(medidasAño);
        return mapper.toMesureYear(medidasAño);
    }

    @Override
    public void delete(int mesureYearId) {
        medidasAnualesCrudRepository.deleteById(mesureYearId);

    }

    @Override
    public List<MesureYear> getByMesureDate(LocalDateTime date) {
        List<MedidasAño> medidasAños=(List<MedidasAño>)medidasAnualesCrudRepository
                .findByDateYear(date);
        return mapper.toMesureYearList(medidasAños);
    }

    @Override
    public List<MesureYear> getByMesureDateBetween(LocalDateTime startDate, LocalDateTime endDate) {
        List<MedidasAño> medidasAños=(List<MedidasAño>) medidasAnualesCrudRepository
                .findByDateYearBetween(startDate,endDate);
        return mapper.toMesureYearList(medidasAños);
    }

    @Override
    public List<MesureYear> getByMesureDateAfter(LocalDateTime date) {
        List<MedidasAño> medidasAños=(List<MedidasAño>)medidasAnualesCrudRepository
                .findByDateYearAfter(date);
        return mapper.toMesureYearList(medidasAños);
    }

    @Override
    public List<MesureYear> getByMesureDateBefore(LocalDateTime date) {
        List<MedidasAño> medidasAños=(List<MedidasAño>)medidasAnualesCrudRepository
                .findByDateYearBefore(date);
        return mapper.toMesureYearList(medidasAños);
    }

    @Override
    public List<MesureYear> getByDeviceIdAndMesureDateBetween(int deviceId, LocalDateTime startDate, LocalDateTime endDate) {
        List<MedidasAño> medidasAños=(List<MedidasAño>)medidasAnualesCrudRepository
                .findByIdDispositivoAndDateYearBetween(deviceId,startDate,endDate);
        return mapper.toMesureYearList(medidasAños);
    }
}

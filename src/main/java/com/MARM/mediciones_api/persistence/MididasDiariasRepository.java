package com.MARM.mediciones_api.persistence;

import com.MARM.mediciones_api.domain.dto.MesureDay;
import com.MARM.mediciones_api.domain.repository.MeasureDayRepository;
import com.MARM.mediciones_api.persistence.Entity.Dispositivos;
import com.MARM.mediciones_api.persistence.Entity.MedidadDia;
import com.MARM.mediciones_api.persistence.crud.MedidasDiariasCrudRepository;
import com.MARM.mediciones_api.persistence.mapper.MesureDayMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public class MididasDiariasRepository implements MeasureDayRepository {

    @Autowired
    private MedidasDiariasCrudRepository medidasDiariasCrudRepository;
    @Autowired
    private MesureDayMapper mapper;

    @Override
    public List<MesureDay> getAll() {
        List<MedidadDia> medidadDias=(List<MedidadDia>) medidasDiariasCrudRepository
                .findAll();

        return mapper.toMesureDayList(medidadDias);
    }


    @Override
    public List<MesureDay> getByDeviceId(int deviceId) {
        List<MedidadDia> medidadDias= (List<MedidadDia>) medidasDiariasCrudRepository
                .findByIdDispositivo(deviceId);
        return mapper.toMesureDayList(medidadDias);    }



    @Override
    public Optional<MesureDay> getById(int mesureDayId) {
        return medidasDiariasCrudRepository.findById(mesureDayId).map(mapper::toMesureDay);
    }

    @Override
    public MesureDay save(MesureDay mesureDay) {
        MedidadDia medidadDia=mapper.toMedidadDia(mesureDay);
        medidadDia=medidasDiariasCrudRepository.save(medidadDia);
        return mapper.toMesureDay(medidadDia);
    }

    @Override
    public void delete(int mesureDayId) {
        medidasDiariasCrudRepository.deleteById(mesureDayId);

    }

    @Override
    public List<MesureDay> getByMedureDate(LocalDateTime date) {
        List<MedidadDia>medidadDias=(List<MedidadDia>)medidasDiariasCrudRepository
                .findByDateToDay(date);
        return mapper.toMesureDayList(medidadDias);
    }

    @Override
    public List<MesureDay> getByMesureDateBetween(LocalDateTime startDate, LocalDateTime endDate) {
        List<MedidadDia>medidadDias=(List<MedidadDia>) medidasDiariasCrudRepository
                .findByDateToDayBetween(startDate,endDate);
        return mapper.toMesureDayList(medidadDias);
    }

    @Override
    public List<MesureDay> getByMesureDateAfter(LocalDateTime date) {
        List<MedidadDia>medidadDias=(List<MedidadDia>) medidasDiariasCrudRepository
                .findByDateToDayAfter(date);
        return mapper.toMesureDayList(medidadDias);
    }

    @Override
    public List<MesureDay> getByMesureDateBefore(LocalDateTime date) {
        List<MedidadDia> medidadDias=(List<MedidadDia>) medidasDiariasCrudRepository
                .findByDateToDayBefore(date);
        return mapper.toMesureDayList(medidadDias);
    }

    @Override
    public List<MesureDay> getByDeviceIdAndMesureDateBetween(int deviceID, LocalDateTime startDate, LocalDateTime endDate) {
        List<MedidadDia> medidadDias=(List<MedidadDia>)medidasDiariasCrudRepository
                .findByIdDispositivoAndDateToDayBetween(deviceID,startDate,endDate);
        return mapper.toMesureDayList(medidadDias);
    }
}
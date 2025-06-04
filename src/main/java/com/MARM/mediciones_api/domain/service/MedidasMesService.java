package com.MARM.mediciones_api.domain.service;

import com.MARM.mediciones_api.domain.dto.MesureMonth;
import com.MARM.mediciones_api.domain.repository.MeasureMonthRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class MedidasMesService {
    @Autowired
    private MeasureMonthRepository measureMonthRepository;

    public List<MesureMonth> getAll(){
        return measureMonthRepository.getAll();
    }

    public Optional<MesureMonth> getById(int mesureMonthId){
        Optional<MesureMonth>mesureMonth=measureMonthRepository.getById(mesureMonthId);
        return mesureMonth;
    }

    public List<MesureMonth>getByDevice(int deviceId){
        List<MesureMonth>mesureMonths=measureMonthRepository.getByDevice(deviceId);
        return mesureMonths;

    }

    public MesureMonth save(MesureMonth mesureMonth){
        return measureMonthRepository.save(mesureMonth);
    }

    public Boolean delete ( int mesureMonthId){
        return measureMonthRepository.getById(mesureMonthId).map(mesureMonth -> {
            measureMonthRepository.delete(mesureMonthId);
            return true;
        }).orElse(false);
    }

    public List<MesureMonth>getByMesureDate(LocalDateTime date){
        List<MesureMonth>mesureMonths=measureMonthRepository.getByMesureDate(date);
        return mesureMonths;
    }

    public List<MesureMonth>getByMesureDateBetween(LocalDateTime startDate,LocalDateTime endDate){
        List<MesureMonth>mesureMonths=measureMonthRepository.getByMesureDateBetween(startDate,endDate);
        return mesureMonths;
    }

    public List<MesureMonth>getByMesureDateAfter(LocalDateTime date){
        List<MesureMonth>mesureMonths=measureMonthRepository.getByMesureDateAfter(date);
        return mesureMonths;
    }

    public List<MesureMonth>getByMesureDateBefore(LocalDateTime date){
        List<MesureMonth>mesureMonths=measureMonthRepository.getByMesureDateBefore(date);
        return mesureMonths;
    }

    public List<MesureMonth> getByDeviceIdAndMesureDateBetween
            (int deviceId, LocalDateTime startDate, LocalDateTime endDate){
        List<MesureMonth>mesureMonths=measureMonthRepository.
                getByDeviceIdAndMesureDateBetween(deviceId,startDate,endDate);
        return mesureMonths;
    }
}

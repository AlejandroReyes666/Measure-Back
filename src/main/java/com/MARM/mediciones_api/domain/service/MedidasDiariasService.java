package com.MARM.mediciones_api.domain.service;

import com.MARM.mediciones_api.domain.dto.MesureDay;
import com.MARM.mediciones_api.domain.dto.MesureWeek;
import com.MARM.mediciones_api.domain.repository.MeasureDayRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class MedidasDiariasService {
    @Autowired
    private MeasureDayRepository measureDayRepository;

    public List<MesureDay> getAll(){
        return measureDayRepository.getAll();
    }

    public Optional<MesureDay> getById(int mesureWeekId){
        Optional<MesureDay> measureDayList=measureDayRepository.getById(mesureWeekId);
        return measureDayList;
    }


    public  List<MesureDay>getByDeviceId(int deviceId){
        List<MesureDay> measureDays= measureDayRepository.getByDeviceId(deviceId);
        System.out.println("buscando datos para el id dipositivo"+deviceId);
        System.out.println("la lista es"+measureDays);
        return measureDays;
    }

    public MesureDay save(MesureDay mesureDay){
        return measureDayRepository.save(mesureDay);
    }

    public Boolean delete(int measureDayId) {
        return measureDayRepository.getById(measureDayId)
                .map(mesureDay -> {
                    measureDayRepository.delete(measureDayId);
                    return true;
                }).orElse(false);
    }

    public  List<MesureDay>getByMedureDate(LocalDateTime date){
        List<MesureDay> measureDays= measureDayRepository.getByMedureDate(date);
        return  measureDays;
    }

    public List<MesureDay>getByMesureDateBetween(LocalDateTime startDate,LocalDateTime endDate){
        List<MesureDay> measureDays= measureDayRepository.getByMesureDateBetween(startDate,endDate);
        return measureDays;
    }

    public  List<MesureDay>getByMesureDateAfter(LocalDateTime date){
        List<MesureDay> measureDays= measureDayRepository.getByMesureDateAfter(date);
        return measureDays;
    }

    public  List<MesureDay>getByMesureDateBefore(LocalDateTime date){
        List<MesureDay> measureDays= measureDayRepository.getByMesureDateBefore(date);
        return measureDays;
    }

    public List<MesureDay> getByDeviceIdAndMesureDateBetwennt (int deviceID, LocalDateTime startDate, LocalDateTime endDate){
        List<MesureDay> measureDays= measureDayRepository.getByDeviceIdAndMesureDateBetween(deviceID,startDate,endDate);
        return measureDays;
    }

}

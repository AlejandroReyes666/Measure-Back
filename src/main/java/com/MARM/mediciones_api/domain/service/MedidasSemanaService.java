package com.MARM.mediciones_api.domain.service;

import com.MARM.mediciones_api.domain.dto.MesureWeek;
import com.MARM.mediciones_api.domain.repository.MesureWeekResposirory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class MedidasSemanaService {
    @Autowired
    private MesureWeekResposirory mesureWeekResposirory;

    public List<MesureWeek> getAll(){
        return mesureWeekResposirory.getAll();
    }

    public Optional<MesureWeek> getById(int mesureWeekId){
        Optional<MesureWeek> measureWeekList=mesureWeekResposirory.getById(mesureWeekId);
        return measureWeekList;
    }

    public List<MesureWeek>getByDevice(int deviceId){
        List<MesureWeek> measureWeekList=mesureWeekResposirory.getByDevice(deviceId);
        return measureWeekList;
    }


    public MesureWeek save(MesureWeek mesureWeek){
        return mesureWeekResposirory.save(mesureWeek);
    }

    public Boolean delete(int measureWeekId){
        return mesureWeekResposirory.getById(measureWeekId).
                map(measureWeek->{
                    mesureWeekResposirory.delete(measureWeekId);
                    return true;

                }).orElse (false);
    }

    public List<MesureWeek>getByMedureDate(LocalDateTime date){
        List<MesureWeek> measureWeekList=mesureWeekResposirory.getByMedureDate(date);
        return measureWeekList;

    }

    public List<MesureWeek>getByMesureDateBetween(LocalDateTime startDate,LocalDateTime endDate){
        List<MesureWeek> measureWeekList=mesureWeekResposirory.getByMesureDateBetween(startDate,endDate);
        return measureWeekList;

    }

    public List<MesureWeek>getByMesureDateAfter(LocalDateTime date){
        List<MesureWeek> measureWeekList=mesureWeekResposirory.getByMesureDateAfter(date);
        return measureWeekList;

    }

    public List<MesureWeek>getByMesureDateBefore(LocalDateTime date){
        List<MesureWeek> measureWeekList=mesureWeekResposirory.getByMesureDateBefore(date);
        return measureWeekList;
    }


    public List<MesureWeek> getByDeviceIdAndMesureDateBetween
            (int deviceID, LocalDateTime startDate, LocalDateTime endDate){
        List<MesureWeek> measureWeekList=mesureWeekResposirory.
                getByDeviceIdAndMesureDateBetween(deviceID,startDate,endDate);
        return measureWeekList;


    }

}

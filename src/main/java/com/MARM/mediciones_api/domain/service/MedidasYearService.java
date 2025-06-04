package com.MARM.mediciones_api.domain.service;

import com.MARM.mediciones_api.domain.dto.MesureYear;
import com.MARM.mediciones_api.domain.repository.MesureYearRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class MedidasYearService {
    @Autowired
    private MesureYearRepository mesureYearRepository;

    public List<MesureYear> getAll(){
        return mesureYearRepository.getAll();
    }

    public Optional getById(int mesureYearId){
        Optional<MesureYear>mesureYear= mesureYearRepository.getById(mesureYearId);
        return mesureYear;
    }

    public List<MesureYear>getByDevice(int deviceId){
        List<MesureYear> mesureYears=mesureYearRepository.getByDevice(deviceId);
        return mesureYears;
    }

    public MesureYear save(MesureYear mesureYear){
       return mesureYearRepository.save(mesureYear);
    }


    public Boolean delete ( int mesureYearId){
        return (Boolean) mesureYearRepository.getById(mesureYearId).
                map(mesureYear->{
                    mesureYearRepository.delete(mesureYearId);
                    return true;
                }).orElse(false);
    }


    public List<MesureYear>getByMesureDate(LocalDateTime date){
        List<MesureYear> mesureYears=mesureYearRepository.getByMesureDate(date);
        return mesureYears;
    }

    public List<MesureYear>getByMesureDateBetween(LocalDateTime startDate,LocalDateTime endDate){
        List<MesureYear> mesureYears=mesureYearRepository.getByMesureDateBetween(startDate,endDate);
        return mesureYears;
    }


    public List<MesureYear>getByMesureDateAfter(LocalDateTime date){
        List<MesureYear> mesureYears=mesureYearRepository.getByMesureDateAfter(date);
        return mesureYears;
    }

    public List<MesureYear>getByMesureDateBefore(LocalDateTime date){
        List<MesureYear> mesureYears=mesureYearRepository.getByMesureDateBefore(date);
        return mesureYears;

    }


    public List<MesureYear> getByDeviceIdAndMesureDateBetween
            (int deviceId, LocalDateTime startDate, LocalDateTime endDate){
        List<MesureYear> mesureYears=mesureYearRepository.
                getByDeviceIdAndMesureDateBetween(deviceId,startDate,endDate);
        return mesureYears;
    }
}

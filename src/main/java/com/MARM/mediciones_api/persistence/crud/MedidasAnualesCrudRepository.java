package com.MARM.mediciones_api.persistence.crud;

import com.MARM.mediciones_api.persistence.Entity.MedidasAño;
import com.MARM.mediciones_api.persistence.Entity.MedidasMes;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface MedidasAnualesCrudRepository extends CrudRepository <MedidasAño,Integer>{
    List<MedidasAño> findByIdDispositivo(int idDispositivo);
    List<MedidasAño> findByDateYear(LocalDateTime dateTime);
    List<MedidasAño>findByDateYearBetween(LocalDateTime startDataTime, LocalDateTime endDataTime);
    List<MedidasAño> findByDateYearAfter(LocalDateTime dateTime);
    List<MedidasAño> findByDateYearBefore(LocalDateTime dateTime);
    List<MedidasAño> findByIdDispositivoAndDateYearBetween
            (int idDispositivo,LocalDateTime startDataTime, LocalDateTime endDataTime);

}

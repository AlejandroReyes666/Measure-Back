package com.MARM.mediciones_api.persistence.crud;

import com.MARM.mediciones_api.persistence.Entity.MedidasMes;
import com.MARM.mediciones_api.persistence.Entity.MedidasSemana;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface MedidadMensualesCrudRepository extends CrudRepository<MedidasMes,Integer> {
    List<MedidasMes> findByIdDispositivo(int idDispositivo);
    List<MedidasMes> findByDateMonth(LocalDateTime dateTime);
    List<MedidasMes>findByDateMonthBetween(LocalDateTime startDataTime, LocalDateTime endDataTime);
    List<MedidasMes> findByDateMonthAfter(LocalDateTime dateTime);
    List<MedidasMes> findByDateMonthBefore(LocalDateTime dateTime);
    List<MedidasMes> findByIdDispositivoAndDateMonthBetween
            (int idDispositivo,LocalDateTime startDataTime, LocalDateTime endDataTime);
}

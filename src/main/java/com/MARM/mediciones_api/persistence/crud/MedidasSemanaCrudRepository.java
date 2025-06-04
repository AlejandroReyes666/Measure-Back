package com.MARM.mediciones_api.persistence.crud;

import com.MARM.mediciones_api.persistence.Entity.MedidadDia;
import com.MARM.mediciones_api.persistence.Entity.MedidasSemana;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface MedidasSemanaCrudRepository extends CrudRepository <MedidasSemana,Integer> {
    List<MedidasSemana> findByIdDispositivo(int idDispositivo);
    List<MedidasSemana> findByDateWeek(LocalDateTime dateTime);
    List<MedidasSemana>findByDateWeekBetween(LocalDateTime startDataTime, LocalDateTime endDataTime);
    List<MedidasSemana> findByDateWeekAfter(LocalDateTime dateTime);
    List<MedidasSemana> findByDateWeekBefore(LocalDateTime dateTime);
    List<MedidasSemana> findByIdDispositivoAndDateWeekBetween
            (int idDispositivo,LocalDateTime startDataTime, LocalDateTime endDataTime);
}

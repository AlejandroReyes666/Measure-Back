package com.MARM.mediciones_api.persistence.crud;
import com.MARM.mediciones_api.persistence.Entity.Dispositivos;
import com.MARM.mediciones_api.persistence.Entity.MedidadDia;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface MedidasDiariasCrudRepository extends CrudRepository<MedidadDia,Integer> {
    List<MedidadDia> findByIdDispositivo(int idDispositivo);
    List<MedidadDia> findByDateToDay(LocalDateTime dateTime);
    List<MedidadDia>findByDateToDayBetween(LocalDateTime startDataTime, LocalDateTime endDataTime);
    List<MedidadDia> findByDateToDayAfter(LocalDateTime dateTime);
    List<MedidadDia> findByDateToDayBefore(LocalDateTime dateTime);
    List<MedidadDia> findByIdDispositivoAndDateToDayBetween
            (int idDispositivo,LocalDateTime startDataTime, LocalDateTime endDataTime);
}

package com.MARM.mediciones_api.persistence.crud;

import com.MARM.mediciones_api.persistence.Entity.Dispositivos;
import com.MARM.mediciones_api.persistence.Entity.Ubicaciones;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface DispositivoCrudRepository extends CrudRepository<Dispositivos,Integer> {
    List<Dispositivos> findByUbicacion_IdUbicacionesOrderByNombreDispositivoAsc(Integer idUbicacion);
    //List<Dispositivos> findByIdUbicacionOrderByNombreDispositivoAsc(Integer idUbicacion);
    List<Dispositivos> findByEstado(String estado);

    List<Dispositivos> findByCreateInBefore(LocalDateTime createIn);
    List<Dispositivos> findByCreateInAfter(LocalDateTime createIn);
    List<Dispositivos> findByCreateInBetween(LocalDateTime startdate ,LocalDateTime endDate);


    List<Dispositivos> findByUpdateInBefore(LocalDateTime updateIn);
    List<Dispositivos> findByUpdateInAfter(LocalDateTime updateIn);
    List<Dispositivos> findByUpdateInBetween(LocalDateTime startDate ,LocalDateTime endDate);




}

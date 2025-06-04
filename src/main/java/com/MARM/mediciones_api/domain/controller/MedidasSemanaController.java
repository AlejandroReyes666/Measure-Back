package com.MARM.mediciones_api.domain.controller;


import com.MARM.mediciones_api.domain.dto.MesureDay;
import com.MARM.mediciones_api.domain.dto.MesureWeek;
import com.MARM.mediciones_api.domain.service.MedidasSemanaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("Medidas-semana")
public class MedidasSemanaController {
    @Autowired
    private MedidasSemanaService medidasSemanaService;

    @GetMapping("/all")
    public ResponseEntity<List<MesureWeek>> getAll() {
        return new ResponseEntity<>(medidasSemanaService.getAll(),HttpStatus.OK);
    }

    @GetMapping("/{measureId}")
    public ResponseEntity<MesureWeek> getMeasure(@PathVariable("measureId") int measureId ) {
        return medidasSemanaService.getById(measureId).map(mesureWeek ->
                new ResponseEntity<>(mesureWeek,HttpStatus.OK)).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/dispositivo/{deviceId}")
    public ResponseEntity<List<MesureWeek>> getMesureDevice(@PathVariable("deviceId") int deviceId ) {
        List<MesureWeek>mesureWeeks=medidasSemanaService.getByDevice(deviceId);
        if (mesureWeeks.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(mesureWeeks,HttpStatus.OK);
    }

    @GetMapping("/between/{startDate}/{endDate}")
    public ResponseEntity<List<MesureWeek>> getByMesureDateBetween(
            @PathVariable ("startDate")@DateTimeFormat(iso=DateTimeFormat.ISO.DATE_TIME) LocalDateTime startDate,
            @PathVariable ("endDate")@DateTimeFormat(iso=DateTimeFormat.ISO.DATE_TIME) LocalDateTime endDate){
        return  new ResponseEntity<>(medidasSemanaService.getByMesureDateBetween(startDate,endDate),HttpStatus.OK);
    }


    @GetMapping("/Date/{dateTime}")

    public ResponseEntity<List<MesureWeek>> getByMedureDate(
            @PathVariable("dateTime")
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime dateTime){
        return  new ResponseEntity<>(medidasSemanaService.getByMedureDate(dateTime),HttpStatus.OK);
    }

    @GetMapping("/after/{dateTime}")
    public ResponseEntity<List<MesureWeek>> getByMesureDateAfter(
            @PathVariable ("dateTime")
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)LocalDateTime dateTime){
        return  new ResponseEntity<>(medidasSemanaService.getByMesureDateAfter(dateTime),HttpStatus.OK);
    }


    @GetMapping("/before/{dateTime}")
    public ResponseEntity<List<MesureWeek>> getByMesureDateBefore(
            @PathVariable ("dateTime")
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)LocalDateTime dateTime){
        return  new ResponseEntity<>(medidasSemanaService.getByMesureDateBefore(dateTime),HttpStatus.OK);
    }

    @GetMapping("/between/device/{deviceId}/{startDate}/{endDate}")
    public ResponseEntity<List<MesureWeek>> getByMesureDateBetween(
            @PathVariable("deviceId")int deviceId,
            @PathVariable ("startDate")@DateTimeFormat(iso=DateTimeFormat.ISO.DATE_TIME) LocalDateTime startDate,
            @PathVariable ("endDate")@DateTimeFormat(iso=DateTimeFormat.ISO.DATE_TIME) LocalDateTime endDate){
        return  new ResponseEntity<>(medidasSemanaService.getByDeviceIdAndMesureDateBetween(deviceId,startDate,endDate),HttpStatus.OK);
    }


    @PostMapping("/save")
    public ResponseEntity<MesureWeek> save(@RequestBody MesureWeek mesureWeek) {
        return new ResponseEntity<>(medidasSemanaService.save(mesureWeek), HttpStatus.OK);

    }

    @DeleteMapping("/delete/{Id}")
    public ResponseEntity delete(@PathVariable("Id") int measureWeekID) {
        if (medidasSemanaService.delete(measureWeekID)) {
            return new ResponseEntity(HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }



}

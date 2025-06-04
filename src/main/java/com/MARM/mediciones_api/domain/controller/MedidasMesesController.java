package com.MARM.mediciones_api.domain.controller;


import com.MARM.mediciones_api.domain.dto.MesureDay;
import com.MARM.mediciones_api.domain.dto.MesureMonth;
import com.MARM.mediciones_api.domain.dto.MesureWeek;
import com.MARM.mediciones_api.domain.service.MedidasMesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("Medidas-meses")
public class MedidasMesesController {
    @Autowired
    private MedidasMesService medidasMesService;


    @GetMapping("/all")
    public ResponseEntity<List<MesureMonth>> getAll() {
        return new ResponseEntity<>(medidasMesService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{measureId}")
    public ResponseEntity<MesureMonth> getMeasure(@PathVariable("measureId") int measureId ) {
        return medidasMesService.getById(measureId).map(mesureWeek ->
                new ResponseEntity<>(mesureWeek,HttpStatus.OK)).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/dispositivo/{deviceId}")
    public ResponseEntity<List<MesureMonth>> getMesureDevice(@PathVariable("deviceId") int deviceId ) {
        List<MesureMonth>mesureMonths=medidasMesService.getByDevice(deviceId);
        if (mesureMonths.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(mesureMonths,HttpStatus.OK);
    }

    @GetMapping("/between/{startDate}/{endDate}")
    public ResponseEntity<List<MesureMonth>> getByMesureDateBetween(
            @PathVariable ("startDate")@DateTimeFormat(iso=DateTimeFormat.ISO.DATE_TIME) LocalDateTime startDate,
            @PathVariable ("endDate")@DateTimeFormat(iso=DateTimeFormat.ISO.DATE_TIME) LocalDateTime endDate){
        return  new ResponseEntity<>(medidasMesService.getByMesureDateBetween(startDate,endDate),HttpStatus.OK);
    }


    @GetMapping("/Date/{dateTime}")
    public ResponseEntity<List<MesureMonth>> getByMesureDate(
            @PathVariable("dateTime")
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime dateTime){
        return  new ResponseEntity<>(medidasMesService.getByMesureDate(dateTime),HttpStatus.OK);
    }


    @GetMapping("/after/{dateTime}")
    public ResponseEntity<List<MesureMonth>> getByMesureDateAfter(
            @PathVariable ("dateTime")
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)LocalDateTime dateTime){
        return  new ResponseEntity<>(medidasMesService.getByMesureDateAfter(dateTime),HttpStatus.OK);
    }


    @GetMapping("/before/{dateTime}")
    public ResponseEntity<List<MesureMonth>> getByMesureDateBefore(
            @PathVariable ("dateTime")
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)LocalDateTime dateTime){
        return  new ResponseEntity<>(medidasMesService.getByMesureDateBefore(dateTime),HttpStatus.OK);
    }

    @GetMapping("/between/device/{deviceId}/{startDate}/{endDate}")
    public ResponseEntity<List<MesureMonth>> getByDeviceIdAndMesureDateBetween(
            @PathVariable("deviceId")int deviceId,
            @PathVariable ("startDate")@DateTimeFormat(iso=DateTimeFormat.ISO.DATE_TIME) LocalDateTime startDate,
            @PathVariable ("endDate")@DateTimeFormat(iso=DateTimeFormat.ISO.DATE_TIME) LocalDateTime endDate){
        return  new ResponseEntity<>(medidasMesService.getByDeviceIdAndMesureDateBetween(deviceId,startDate,endDate),HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<MesureMonth> save(@RequestBody MesureMonth mesureMonth) {
        return new ResponseEntity<>(medidasMesService.save(mesureMonth), HttpStatus.OK);

    }

    @DeleteMapping("/delete/{Id}")
    public ResponseEntity delete(@PathVariable("Id") int measureWeekID) {
        if (medidasMesService.delete(measureWeekID)) {
            return new ResponseEntity(HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }
}

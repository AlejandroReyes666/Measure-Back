package com.MARM.mediciones_api.domain.controller;

import com.MARM.mediciones_api.domain.dto.MesureMonth;
import com.MARM.mediciones_api.domain.dto.MesureYear;
import com.MARM.mediciones_api.domain.service.MedidasYearService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("Medidas-año")
public class MedidasAñoController {
    @Autowired
    private MedidasYearService medidasYearService;

    @GetMapping("/all")
    public ResponseEntity<List<MesureYear>> getAll() {
        return new ResponseEntity<>(medidasYearService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{measureId}")
    public ResponseEntity<MesureYear> getMeasure(@PathVariable("measureId") int measureId ) {
        return (ResponseEntity<MesureYear>) medidasYearService.getById(measureId).map(mesureYear ->
                new ResponseEntity<>(mesureYear,HttpStatus.OK)).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/dispositivo/{deviceId}")
    public ResponseEntity<List<MesureYear>> getMesureDevice(@PathVariable("deviceId") int deviceId ) {
        List<MesureYear>mesureYears=medidasYearService.getByDevice(deviceId);
        if (mesureYears.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(mesureYears,HttpStatus.OK);
    }

    @GetMapping("/between/{startDate}/{endDate}")
    public ResponseEntity<List<MesureYear>> getByMesureDateBetween(
            @PathVariable ("startDate")@DateTimeFormat(iso=DateTimeFormat.ISO.DATE_TIME) LocalDateTime startDate,
            @PathVariable ("endDate")@DateTimeFormat(iso=DateTimeFormat.ISO.DATE_TIME) LocalDateTime endDate){
        return  new ResponseEntity<>(medidasYearService.getByMesureDateBetween(startDate,endDate),HttpStatus.OK);
    }


    @GetMapping("/Date/{dateTime}")
    public ResponseEntity<List<MesureYear>> getByMesureDate(
            @PathVariable("dateTime")
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime dateTime){
        return  new ResponseEntity<>(medidasYearService.getByMesureDate(dateTime),HttpStatus.OK);
    }


    @GetMapping("/after/{dateTime}")
    public ResponseEntity<List<MesureYear>> getByMesureDateAfter(
            @PathVariable ("dateTime")
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)LocalDateTime dateTime){
        return  new ResponseEntity<>(medidasYearService.getByMesureDateAfter(dateTime),HttpStatus.OK);
    }


    @GetMapping("/before/{dateTime}")
    public ResponseEntity<List<MesureYear>> getByMesureDateBefore(
            @PathVariable ("dateTime")
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)LocalDateTime dateTime){
        return  new ResponseEntity<>(medidasYearService.getByMesureDateBefore(dateTime),HttpStatus.OK);
    }

    @GetMapping("/between/device/{deviceId}/{startDate}/{endDate}")
    public ResponseEntity<List<MesureYear>> getByMesureDateBetween(
            @PathVariable("deviceId")int deviceId,
            @PathVariable ("startDate")@DateTimeFormat(iso=DateTimeFormat.ISO.DATE_TIME) LocalDateTime startDate,
            @PathVariable ("endDate")@DateTimeFormat(iso=DateTimeFormat.ISO.DATE_TIME) LocalDateTime endDate){
        return  new ResponseEntity<>(medidasYearService.getByDeviceIdAndMesureDateBetween(deviceId,startDate,endDate),HttpStatus.OK);
    }





    @PostMapping("/save")
    public ResponseEntity<MesureYear> save(@RequestBody MesureYear mesureYear) {
        return new ResponseEntity<>(medidasYearService.save(mesureYear), HttpStatus.OK);

    }

    @DeleteMapping("/delete/{Id}")
    public ResponseEntity delete(@PathVariable("Id") int measureYearId) {
        if (medidasYearService.delete(measureYearId)) {
            return new ResponseEntity(HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }


}

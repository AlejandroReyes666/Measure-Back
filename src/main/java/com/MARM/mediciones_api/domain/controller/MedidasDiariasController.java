package com.MARM.mediciones_api.domain.controller;

import com.MARM.mediciones_api.domain.dto.Devices;
import com.MARM.mediciones_api.domain.dto.MesureDay;
import com.MARM.mediciones_api.domain.dto.MesureWeek;
import com.MARM.mediciones_api.domain.service.MedidasDiariasService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("Medidas-diarias")
@Tag(name = "Mediciones diarias", description = "API para la gestión de dispositivos")

public class MedidasDiariasController {
    @Autowired
    private MedidasDiariasService medidasDiariasService;

    @GetMapping("/all")
    public ResponseEntity<List<MesureDay>> getAll() {
        return new ResponseEntity<>(medidasDiariasService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{measureId}")
    public ResponseEntity<MesureDay> getMeasure(@PathVariable("measureId") int measureId ) {
        return medidasDiariasService.getById(measureId).map(mesureWeek ->
                new ResponseEntity<>(mesureWeek,HttpStatus.OK)).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/dispositivo/{deviceId}")
    public ResponseEntity<List<MesureDay>> getByDeviceId(@PathVariable("deviceId") Integer deviceId ) {
        List<MesureDay>mesureDays=medidasDiariasService.getByDeviceId(deviceId);
        if (mesureDays.isEmpty()){
            System.out.println("la lista de dipositivos es "+mesureDays);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(mesureDays,HttpStatus.OK);
    }

    @GetMapping("/between/{startDate}/{endDate}")
    public ResponseEntity<List<MesureDay>> getByMesureDateBetween(
            @PathVariable ("startDate")@DateTimeFormat(iso=DateTimeFormat.ISO.DATE_TIME) LocalDateTime startDate,
            @PathVariable ("endDate")@DateTimeFormat(iso=DateTimeFormat.ISO.DATE_TIME) LocalDateTime endDate){
        return  new ResponseEntity<>(medidasDiariasService.getByMesureDateBetween(startDate,endDate),HttpStatus.OK);
    }



    @GetMapping("/Date/{dateTime}")
    public ResponseEntity<List<MesureDay>> getByMedureDate(
            @PathVariable("dateTime")
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime dateTime){
        return  new ResponseEntity<>(medidasDiariasService.getByMedureDate(dateTime),HttpStatus.OK);
    }

    @GetMapping("/after/{dateTime}")
    public ResponseEntity<List<MesureDay>> getByMesureDateAfter(
            @PathVariable ("dateTime")
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)LocalDateTime dateTime){
        return  new ResponseEntity<>(medidasDiariasService.getByMesureDateAfter(dateTime),HttpStatus.OK);
    }

    @GetMapping("/before/{dateTime}")
    public ResponseEntity<List<MesureDay>> getByMesureDateBefore(
            @PathVariable ("dateTime")
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)LocalDateTime dateTime){
        return  new ResponseEntity<>(medidasDiariasService.getByMesureDateBefore(dateTime),HttpStatus.OK);
    }

    @GetMapping("/between/device/{deviceId}/{startDate}/{endDate}")
    public ResponseEntity<List<MesureDay>> getByMesureDateBetween(
            @PathVariable("deviceId")int deviceId,
            @PathVariable ("startDate")@DateTimeFormat(iso=DateTimeFormat.ISO.DATE_TIME) LocalDateTime startDate,
            @PathVariable ("endDate")@DateTimeFormat(iso=DateTimeFormat.ISO.DATE_TIME) LocalDateTime endDate){
        return  new ResponseEntity<>(medidasDiariasService.getByDeviceIdAndMesureDateBetwennt(deviceId,startDate,endDate),HttpStatus.OK);
    }



    @PostMapping("/save")
    public ResponseEntity<MesureDay> save(@RequestBody MesureDay mesureDay) {
        return new ResponseEntity<>(medidasDiariasService.save(mesureDay), HttpStatus.OK);

    }

    @DeleteMapping("/delete/{Id}")
    public ResponseEntity delete(@PathVariable("Id") int measureDayID) {
        if (medidasDiariasService.delete(measureDayID)) {
            return new ResponseEntity(HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }
}

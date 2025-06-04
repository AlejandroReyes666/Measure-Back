package com.MARM.mediciones_api.domain.controller;

import com.MARM.mediciones_api.domain.dto.Devices;
import com.MARM.mediciones_api.domain.dto.Locations;
import com.MARM.mediciones_api.domain.service.DispositivosService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("dispositivos")
@Tag(name = "Dispositivos", description = "API para la gestión de dispositivos")

public class DispositivosController {

    @Autowired
    private DispositivosService dispositivosService;

    @GetMapping("/all")
    @Operation(summary = "Obtener todos los dispositivos",
            description = "Retorna una lista de dispositivos registrados")
    public ResponseEntity<List<Devices>> getAll() {
        return new ResponseEntity<>(dispositivosService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{deviceId}")
    @Operation(summary = "Obtener un diapositivo especifico",
            description = "Retorna no de los dispositivos registrados")
    public ResponseEntity<Devices> getDevice(@PathVariable("deviceId") int deviceId) {
        return dispositivosService.getById(deviceId).
                map(devices -> new ResponseEntity<>(devices, HttpStatus.OK)).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/ubicacion/{locationId}")
    @Operation(summary = "Obtener todos los dispositivos en esa ubicación",
            description = "Retorna una lista de dispositivos registrados en esa ubicación")
    public ResponseEntity <List<Devices>> getDeviceByLocationId(@PathVariable("locationId") int locationId) {
        return new ResponseEntity<>(dispositivosService.getByLocation(locationId),HttpStatus.OK);

    }

    @GetMapping("/created-before/{dateTime}")
    @Operation(summary = "Obtener todos los dispositivos",
            description = "Retorna una lista de dispositivos registrados")
    public ResponseEntity<List<Devices>> getByCreatedBefore(@PathVariable ("dateTime")LocalDateTime dateTime){
        return  new ResponseEntity<>(dispositivosService.getByCreatedBefore(dateTime),HttpStatus.OK);
    }

    @GetMapping("/created-after/{dateTime}")
    @Operation(summary = "Obtener todos los dispositivos registrados dspues de una fecha en especifico",
            description = "Retorna una lista de dispositivos registrados depues de una fecha puntual")
    public ResponseEntity<List<Devices>> getByCreatedAfter(@PathVariable ("dateTime")LocalDateTime dateTime){
        return  new ResponseEntity<>(dispositivosService.getByCreatedAfter(dateTime),HttpStatus.OK);
    }

    @GetMapping("/created-between/{startDate}/{endDate}")
    @Operation(summary = "Obtener todos los dispositivos",
            description = "Retorna la lista de dipositivos creados en un randgo de fechas especificas")
    public ResponseEntity<List<Devices>> getByCreatedBetween(
            @PathVariable ("startDate")@DateTimeFormat(iso=DateTimeFormat.ISO.DATE_TIME) LocalDateTime startDate,
            @PathVariable ("endDate")@DateTimeFormat(iso=DateTimeFormat.ISO.DATE_TIME) LocalDateTime endDate){
        return  new ResponseEntity<>(dispositivosService.getByCreatedBetween(startDate,endDate),HttpStatus.OK);
    }

//////////////////////

    @GetMapping("/updated-before/{dateTime}")
    @Operation(summary = "Obtener todos los dispositivos",
            description = "Retorna una lista de dispositivos registrados")
    public ResponseEntity<List<Devices>> getByUpdateBefore(@PathVariable ("dateTime")LocalDateTime dateTime){
        return  new ResponseEntity<>(dispositivosService.getByUpdateBefore(dateTime),HttpStatus.OK);
    }

    @GetMapping("/updated-after/{dateTime}")
    @Operation(summary = "Obtener todos los dispositivos actualizado en una fecha puntual",
            description = "Retorna una lista de dispositivos  aactualizados en una fecha puentual")
    public ResponseEntity<List<Devices>> getByUpdateAfter(@PathVariable ("dateTime")LocalDateTime dateTime){
        return  new ResponseEntity<>(dispositivosService.getByUpdateAfter(dateTime),HttpStatus.OK);
    }

    @GetMapping("/updated-between/{startDate}/{endDate}")
    @Operation(summary = "Obtener todos los dispositivos actualizados en un rango especifico",
            description = "Retorna una lista de dispositivos actualizados en un rango de fechas")
    public ResponseEntity<List<Devices>> getByUpdatedBetween(
            @PathVariable ("startDate")@DateTimeFormat(iso=DateTimeFormat.ISO.DATE_TIME) LocalDateTime startDate,
            @PathVariable ("endDate")@DateTimeFormat(iso=DateTimeFormat.ISO.DATE_TIME) LocalDateTime endDate){
        return  new ResponseEntity<>(dispositivosService.getByUpdatedBetween(startDate,endDate),HttpStatus.OK);
    }

    @GetMapping("/status/{state}")
    public ResponseEntity<List<Devices>> getByUpdatedBetween(
            @PathVariable ("state") String state){
        return  new ResponseEntity<>(dispositivosService.getByState(state),HttpStatus.OK);
    }







    /*@PostMapping("/save")
    public ResponseEntity<Devices> save(@RequestBody Devices devices) {
        System.out.println("devices es: " + devices);
        System.out.println("Nombre: " + devices.getDevicesName());
        System.out.println("Estado: " + devices.getState());
        System.out.println("ID Ubicación: " + devices.getIdUbicacion()); // Esto es clave

        return new ResponseEntity<>(dispositivosService.save(devices), HttpStatus.CREATED);

    }*/

    @PostMapping("/save")
    @Operation(summary = "crea o actualiza un dispositivos",
            description = " crea o actualiza algun dipositivo")
    public ResponseEntity<?> save(@RequestBody Devices device) {
        if (device == null) {
            return ResponseEntity.badRequest().body("El objeto device es null en el controlador");
        }

        System.out.println("---- Datos en el controlador ----");
        System.out.println("Nombre: " + device.getDevicesName());
        System.out.println("Estado: " + device.getState());
        System.out.println("ID Ubicación: " + device.getIdUbicacion());

        //dispositivosService.saveOrUpdate(device);

        //return ResponseEntity.ok("Dispositivo guardado correctamente");
        return new ResponseEntity<>(dispositivosService.save(device),HttpStatus.CREATED);


    }

    @DeleteMapping("/delete/{Id}")
    @Operation(summary = "Elimina un dipositivo segun el id",
            description = "Elimina el dipositivo segun el id")
    public ResponseEntity delete(@PathVariable("Id") int deviceId) {
        if (dispositivosService.delete(deviceId)) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

}
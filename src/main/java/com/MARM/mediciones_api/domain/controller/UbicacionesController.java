package com.MARM.mediciones_api.domain.controller;

import com.MARM.mediciones_api.domain.dto.Locations;
import com.MARM.mediciones_api.domain.service.UbicacionesService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.hibernate.sql.results.spi.LoadContexts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("ubicaciones")
@Tag(name = "Ubicaciones", description = "API para la gestión de dispositivos")
public class UbicacionesController {

    @Autowired
    private UbicacionesService ubicacionesService;

    @Operation(summary = "Obtener todos las ubicaiones", description = "Retorna una lista de ubicaiones registradas")
    @GetMapping("/all")
    public ResponseEntity<List<Locations>>getAll(){
        return new ResponseEntity<>(ubicacionesService.getAll(), HttpStatus.OK);
    }

    @Operation(summary = "Obtener una de las ubicaiones", description = "Retorna una ubicación en especifico")
    @GetMapping("/{ubicacionId}")
    public ResponseEntity<Locations>getLocation(@PathVariable("ubicacionId")int ubicacionId){
        return ubicacionesService.getLocation(ubicacionId).
                map(locations -> new ResponseEntity<>(locations,HttpStatus.OK)).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @Operation(summary = "guardar una nueva ubicación o actualizar las ubicaiones",
            description = "guarda o actualiza las ubicaciones")
    @PostMapping("/save")
    public ResponseEntity<Locations>save(@RequestBody Locations locations){
        System.out.println("🟢 Recibido en el controlador: " + locations);
        return new ResponseEntity<>(ubicacionesService.save(locations),HttpStatus.CREATED);

    }

    @Operation(summary = "elimina una ubicación en especifico",
            description = "elimina una ubicación segun el id")
    @DeleteMapping("/delete/{Id}")
    public ResponseEntity<String> delete(@PathVariable("Id")int locationId){
        if(ubicacionesService.delete(locationId)){
            return new ResponseEntity<>("Se ha eliminado la ubicación con exito",HttpStatus.NO_CONTENT);
        }
        else{
            return new ResponseEntity<>("No se ha eliminado la ubicación",HttpStatus.NOT_FOUND);
        }

    }






}

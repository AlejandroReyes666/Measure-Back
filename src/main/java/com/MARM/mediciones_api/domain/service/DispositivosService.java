package com.MARM.mediciones_api.domain.service;

import com.MARM.mediciones_api.domain.dto.Devices;
import com.MARM.mediciones_api.domain.repository.DevicesRepository;
import com.MARM.mediciones_api.persistence.Entity.Ubicaciones;
import com.MARM.mediciones_api.persistence.crud.UbicacionesCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.Optional;

@Service

public class DispositivosService {
    @Autowired
    private DevicesRepository devicesRepository;

    public List<Devices>getAll(){
        return devicesRepository.getAll();

    }


    public Optional<Devices>getById(int devicesId){
        return devicesRepository.getById(devicesId);
    }

    public List<Devices> getByLocation(int locationId){
        return devicesRepository.getByLocation(locationId);
    }

    /*public  Devices save(Devices devices) {

        // Buscar la ubicación en la base de datos
        Devices device = null;
        Ubicaciones ubicacion = ubicacionRepository.findById(device.getIdUbicacion())
                .orElseThrow(() -> new RuntimeException("Ubicación no encontrada"));

        // Crear el objeto Device y asignar valores
        device = new Devices();
        device.setDevicesName(device.getDevicesName());
        device.setState(device.getState());
        device.setIdUbicacion(ubicacion.getIdUbicaciones()); // Asigna la ubicación correctamente

        // Guardar en la base de datos
        return devicesRepository.save(device);
    }*/

    public Devices save(Devices device) {
        if (device == null) {
            throw new IllegalArgumentException("El objeto device es null en el servicio");
        }
        System.out.println("---- Datos en el servicio ----");
        System.out.println("Nombre: " + device.getDevicesName());
        System.out.println("Estado: " + device.getState());
        System.out.println("ID Ubicación: " + device.getIdUbicacion());
        return devicesRepository.save(device);
    }

    public Devices saveOrUpdate(Devices device) {
        if (device == null) {
            throw new IllegalArgumentException("El objeto device es null en el servicio");
        }

        System.out.println("---- Datos en el servicio ----");
        System.out.println("Nombre: " + device.getDevicesName());
        System.out.println("Estado: " + device.getState());
        System.out.println("ID Ubicación: " + device.getIdUbicacion());

        // Si el ID no es nulo y el dispositivo ya existe, mantenemos la fecha de creación
        if (device.getDevicesId() != null){
            //&& devicesRepository.getById(device.getDevicesId()).isPresent()) {
            Optional<Devices> existingDevice = devicesRepository.getById(device.getDevicesId());

            if(existingDevice.isPresent()){
                Devices existing= existingDevice.get();
                if(device.getCreatedDate()==null){
                    device.setCreatedDate(existing.getCreatedDate());
                    //System.out.println(("Fecha de creación:"+ existingDevice.get().getCreatedDate()));
                    //System.out.println(("Fecha de Actualizacion:"+ device.getUpdatedDate()));
                }
                System.out.println("Fecha de creación en BD: " + existing.getCreatedDate());
                System.out.println("Fecha de creación en objeto: " + device.getCreatedDate());
                System.out.println("Fecha de actualización antes de guardar: " + device.getUpdatedDate());

            }
            else {
                System.out.println("El dispositivo con ID " + device.getDevicesId() + " no existe en la base de datos.");
            }

            //existingDevice.ifPresent(existing -> device.setCreatedDate(existing.getCreatedDate())); // Mantener la fecha original
        }

        else {
            // Si es un nuevo dispositivo, asignar la fecha de creación
            if (device.getCreatedDate() == null) {
                device.setCreatedDate(LocalDateTime.now(ZoneId.of("America/Bogota")));
            }
            System.out.println("Asignando nueva fecha de creación: " + device.getCreatedDate());
        }

        return devicesRepository.save(device);
    }


    public Boolean delete (int deviceId){
        return getById(deviceId).map(devices -> {
            devicesRepository.delete(deviceId);
            return true;
        }).orElse(false);
    }

    public List<Devices> getByCreatedBefore(LocalDateTime date){

        List<Devices> devices= devicesRepository.getByCreatedBefore(date);
        return devices;
    }

    public List<Devices> getByCreatedAfter(LocalDateTime date){
        List<Devices> devices= devicesRepository.getByCreatedAfter(date);
        return devices;
    }

    public List<Devices> getByCreatedBetween(LocalDateTime startDate, LocalDateTime endDate){
        List<Devices> devices= devicesRepository.getByCreatedBetween(startDate,endDate);
        return devices;
    }

    public List<Devices> getByUpdateBefore(LocalDateTime date){
        List<Devices> devices= devicesRepository.getByUpdateBefore(date);
        return devices;

    }

    public  List<Devices> getByUpdateAfter(LocalDateTime date){
        List<Devices> devices= devicesRepository.getByUpdateAfter(date);
        return devices;
    }

    public List<Devices> getByUpdatedBetween(LocalDateTime startDate, LocalDateTime endDate){
        List<Devices> devices= devicesRepository.getByUpdatedBetween(startDate,endDate);
        return devices;
    }

    public List<Devices> getByState(String state){
        List<Devices> devices= devicesRepository.getByState(state);
        return devices;
    }

}

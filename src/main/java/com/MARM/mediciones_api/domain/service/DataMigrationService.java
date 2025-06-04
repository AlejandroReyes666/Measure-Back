package com.MARM.mediciones_api.domain.service;

import com.MARM.mediciones_api.domain.dto.MesureDay;
import com.MARM.mediciones_api.domain.dto.MesureMonth;
import com.MARM.mediciones_api.domain.dto.MesureWeek;
import com.MARM.mediciones_api.domain.dto.MesureYear;
import com.MARM.mediciones_api.persistence.MedicionesAnualesRepository;
import com.MARM.mediciones_api.persistence.MedicionesMesRepository;
import com.MARM.mediciones_api.persistence.MedicionesSemanaRepository;
import com.MARM.mediciones_api.persistence.MididasDiariasRepository;
import com.MARM.mediciones_api.persistence.crud.MedidasAnualesCrudRepository;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class DataMigrationService {
    private final MididasDiariasRepository mididasDiariasRepository;
    private final MedicionesSemanaRepository medicionesSemanaRepository;
    private final MedicionesMesRepository medicionesMesRepository;
    private final MedicionesAnualesRepository medicionesAnualesRepository;

    public DataMigrationService(MididasDiariasRepository mididasDiariasRepository,
                                MedicionesSemanaRepository medicionesSemanaRepository,
                                MedicionesMesRepository medicionesMesRepository,
                                MedicionesAnualesRepository medicionesAnualesRepository) {
        this.mididasDiariasRepository = mididasDiariasRepository;
        this.medicionesSemanaRepository = medicionesSemanaRepository;
        this.medicionesMesRepository = medicionesMesRepository;
        this.medicionesAnualesRepository = medicionesAnualesRepository;
    }


   @Scheduled(cron = "0 0 0 * * *")
    public void moveDaylytoWeekly(){
        LocalDateTime cutOffDate=LocalDateTime.now().minusDays( 1);
        List<MesureDay>mesureDays=mididasDiariasRepository.getByMesureDateBefore(cutOffDate);
        System.out.println("Datos a migrar: " + mesureDays.size());
        if(!mesureDays.isEmpty()){
            for(MesureDay daily:mesureDays){
                MesureWeek mesureWeek=new MesureWeek();
                mesureWeek.setDeviceId(daily.getDeviceId());
                mesureWeek.setMesureDate(daily.getMesureDate());
                mesureWeek.setDistanceMesureWeek(daily.getDistanceDay());
                mesureWeek.setLevelMesureWeek(daily.getLevelDay());
                mesureWeek.setVoltageMesureWeek(daily.getVoltageDay());
                mesureWeek.setLightMesureWeek(daily.getLevelDay());
                mesureWeek.setMesureWeekId(null);

                // 📌 Verificar los ID de dispositivos antes de guardar
                System.out.println("Intentando guardar dispositivo_id: " + mesureWeek.getDeviceId());

                System.out.println("Guardando: " + mesureWeek);
                medicionesSemanaRepository.save(mesureWeek);
                System.out.println("ID generado: " + mesureWeek.getMesureWeekId());


            }
            System.out.println(("Dateo migrados a la bitacora semanal"));
        }
        else{
            System.out.println(("No se encontraron datos del dia"));
        }

    }


    @Scheduled(cron = "0 0 0 * * SUN")
    public void moveWeeklytoMonthly(){
        LocalDateTime cutOffDate=LocalDateTime.now().minusDays(7);
        List<MesureWeek>mesureWeek=medicionesSemanaRepository.getByMesureDateBefore(cutOffDate);
        if(!mesureWeek.isEmpty()){
            for(MesureWeek weekly:mesureWeek){
                MesureMonth mesureMonth=new MesureMonth();
                mesureMonth.setDeviceId(weekly.getDeviceId());
                mesureMonth.setMesureDate(weekly.getMesureDate());
                mesureMonth.setDistanceMesureMoth(weekly.getDistanceMesureWeek());
                mesureMonth.setLevelMesureMonth(weekly.getLevelMesureWeek());
                mesureMonth.setVoltageMesureMonth(weekly.getVoltageMesureWeek());
                mesureMonth.setLightMesureMonth(weekly.getLevelMesureWeek());
                mesureMonth.setMesureMonthId(null);

                System.out.println("Intentando guardar dispositivo_id: " + mesureMonth.getDeviceId());
                System.out.println("Guardando medida en mes: " + mesureMonth);

                medicionesMesRepository.save(mesureMonth);
                System.out.println("ID generado: " + mesureMonth.getMesureMonthId());

            }
            System.out.println(("Dateo migrados a la bitacora Mensual"));
        }
        else{
            System.out.println(("No se encontraron datos de la Semana"));
        }

    }


    @Scheduled(cron = "0 0 0 30 * *")
    public void moveMonthlytoYear(){
        LocalDateTime cutOffDate=LocalDateTime.now().minusDays(7);
        List<MesureMonth>mesureMonths=medicionesMesRepository.getByMesureDateBefore(cutOffDate);
        if(!mesureMonths.isEmpty()){
            for(MesureMonth months:mesureMonths){
                MesureYear mesureYear=new MesureYear();
                mesureYear.setDeviceId(months.getDeviceId());
                mesureYear.setMesureDate(months.getMesureDate());
                mesureYear.setDistanceMesureYear(months.getDistanceMesureMoth());
                mesureYear.setLevelMesureYear(months.getLevelMesureMonth());
                mesureYear.setVoltageMesureYear(months.getVoltageMesureMonth());
                mesureYear.setLightMesureYear(months.getLevelMesureMonth());
                mesureYear.setMesureYearId(null);

                System.out.println("Intentando guardar dispositivo_id: " + mesureYear.getDeviceId());
                System.out.println("Guardando medida en año: " + mesureYear);
                medicionesAnualesRepository.save(mesureYear);

            }
            System.out.println(("Dateo migrados a la bitacora Anual"));
        }
        else{
            System.out.println(("No se encontraron datos del mes"));
        }

    }




}

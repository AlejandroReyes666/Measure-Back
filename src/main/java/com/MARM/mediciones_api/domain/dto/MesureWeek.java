package com.MARM.mediciones_api.domain.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
@Getter
@Setter
public class MesureWeek {

    private Integer mesureWeekId;
    private int deviceId;
    private double voltageMesureWeek;
    private double distanceMesureWeek;
    private double levelMesureWeek;
    private double lightMesureWeek;
    private LocalDateTime mesureDate;
}

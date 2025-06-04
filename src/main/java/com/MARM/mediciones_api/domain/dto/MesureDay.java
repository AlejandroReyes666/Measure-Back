package com.MARM.mediciones_api.domain.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class MesureDay {
    private Integer mesureDayId;
    private int deviceId;
    private double voltageDay;
    private double distanceDay;
    private double levelDay;
    private double lightgeDay;
    private LocalDateTime mesureDate;


}

package com.MARM.mediciones_api.domain.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter

public class MesureMonth {

    private Integer mesureMonthId;
    private int deviceId;
    private double voltageMesureMonth;
    private double distanceMesureMoth;
    private double levelMesureMonth;
    private double lightMesureMonth;
    private LocalDateTime mesureDate;
}

package com.MARM.mediciones_api.domain.dto;

import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;

@Getter
@Setter
public class MesureYear {
    private Integer mesureYearId;
    private int deviceId;
    private double voltageMesureYear;
    private double distanceMesureYear;
    private double levelMesureYear;
    private double lightMesureYear;
    private LocalDateTime mesureDate;
}

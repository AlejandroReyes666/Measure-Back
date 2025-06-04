package com.MARM.mediciones_api.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "mediciones_diarias")
//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "idMeditiondaily")
public class MedidadDia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "id", updatable = false, nullable = false)
    private Integer idMeditiondaily;

    @Column(name = "dispositivo_id")
    private Integer idDispositivo;

    @Column(name = "voltaje")
    private Double voltageDaily;

    @Column(name = "distancia")
    private Double distanceDaily;

    @Column(name = "nivel")
    private Double levelgeDaily;

    @Column(name = "luminocidad")
    private Double lightDaily;

    @Column(name = "fecha")
    private LocalDateTime dateToDay;

    @ManyToOne
    @JoinColumn(name = "dispositivo_id",referencedColumnName = "id",insertable = false,updatable = false)
    //@JsonBackReference
    @JsonIgnore
    private Dispositivos dispositivoDia;



    public Integer getIdMeditiondaily() {
        return idMeditiondaily;
    }

    public void setIdMeditiondaily(Integer idMeditiondaily) {
        this.idMeditiondaily = idMeditiondaily;
    }

    public Integer getIdDispositivo() {
        return idDispositivo;
    }

    public void setIdDispositivo(Integer idDispositivo) {
        this.idDispositivo = idDispositivo;
    }

    public Double getVoltageDaily() {
        return voltageDaily;
    }

    public void setVoltageDaily(Double voltageDaily) {
        this.voltageDaily = voltageDaily;
    }

    public Double getDistanceDaily() {
        return distanceDaily;
    }

    public void setDistanceDaily(Double distanceDaily) {
        this.distanceDaily = distanceDaily;
    }

    public Double getLevelgeDaily() {
        return levelgeDaily;
    }

    public void setLevelgeDaily(Double levelgeDaily) {
        this.levelgeDaily = levelgeDaily;
    }

    public Double getLightDaily() {
        return lightDaily;
    }

    public void setLightDaily(Double lightDaily) {
        this.lightDaily = lightDaily;
    }

    public LocalDateTime getDateToDay() {
        return dateToDay;
    }

    public void setDateToDay(LocalDateTime dateToDay) {
        this.dateToDay = dateToDay;
    }

    public Dispositivos getDispositivoDia() {
        return dispositivoDia;
    }

    public void setDispositivoDia(Dispositivos dispositivoDia) {
        this.dispositivoDia = dispositivoDia;
    }
}

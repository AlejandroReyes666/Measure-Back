package com.MARM.mediciones_api.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "mediciones_semanales")
public class MedidasSemana {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "id", updatable = false, nullable = false)
    private Integer idMeditionweek;

    @Column(name = "dispositivo_id")
    private Integer idDispositivo;

    @Column(name = "voltaje")
    private Double voltageWeek;

    @Column(name = "distancia")
    private Double distanceWeek;

    @Column(name = "nivel")
    private Double levelgeWeek;

    @Column(name = "luminocidad")
    private Double lightWeek;

    @Column(name = "fecha")
    private LocalDateTime dateWeek;

    @ManyToOne
    @JoinColumn(name = "dispositivo_id" ,referencedColumnName = "id",insertable = false,updatable = false)
    @JsonIgnore
    private Dispositivos dispositivoSemana;

    public Integer getIdMeditionweek() {
        return idMeditionweek;
    }

    public void setIdMeditionweek(Integer idMeditionweek) {
        this.idMeditionweek = idMeditionweek;
    }

    public Integer getIdDispositivo() {
        return idDispositivo;
    }

    public void setIdDispositivo(Integer idDispositivo) {
        this.idDispositivo = idDispositivo;
    }

    public Double getVoltageWeek() {
        return voltageWeek;
    }

    public void setVoltageWeek(Double voltageWeek) {
        this.voltageWeek = voltageWeek;
    }

    public Double getDistanceWeek() {
        return distanceWeek;
    }

    public void setDistanceWeek(Double distanceWeek) {
        this.distanceWeek = distanceWeek;
    }

    public Double getLevelgeWeek() {
        return levelgeWeek;
    }

    public void setLevelgeWeek(Double levelgeWeek) {
        this.levelgeWeek = levelgeWeek;
    }

    public Double getLightWeek() {
        return lightWeek;
    }

    public void setLightWeek(Double lightWeek) {
        this.lightWeek = lightWeek;
    }

    public LocalDateTime getDateWeek() {
        return dateWeek;
    }

    public void setDateWeek(LocalDateTime dateWeek) {
        this.dateWeek = dateWeek;
    }

    public Dispositivos getDispositivoSemana() {
        return dispositivoSemana;
    }

    public void setDispositivoSemana(Dispositivos dispositivoSemana) {
        this.dispositivoSemana = dispositivoSemana;
    }
}

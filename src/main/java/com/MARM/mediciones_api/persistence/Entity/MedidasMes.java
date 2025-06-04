package com.MARM.mediciones_api.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "mediciones_mensuales")
public class MedidasMes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",updatable = false, nullable = false)
    @JsonIgnore
    private Integer idMeditionMonth;

    @Column(name = "dispositivo_id")
    private Integer idDispositivo;

    @Column(name = "voltaje")
    private Double voltageMonth;

    @Column(name = "distancia")
    private Double distanceMonth;

    @Column(name = "nivel")
    private Double levelgeMonth;

    @Column(name = "luminocidad")
    private Double lightWeek;

    @Column(name = "fecha")
    private LocalDateTime dateMonth;

    @ManyToOne
    @JoinColumn(name = "dispositivo_id",referencedColumnName = "id",updatable = false, insertable = false)
    private Dispositivos dispositivoMonth;

    public Integer getIdMeditionMonth() {
        return idMeditionMonth;
    }

    public void setIdMeditionMonth(Integer idMeditionMonth) {
        this.idMeditionMonth = idMeditionMonth;
    }

    public Integer getIdDispositivo() {
        return idDispositivo;
    }

    public void setIdDispositivo(Integer idDispositivo) {
        this.idDispositivo = idDispositivo;
    }

    public Double getVoltageMonth() {
        return voltageMonth;
    }

    public void setVoltageMonth(Double voltageMonth) {
        this.voltageMonth = voltageMonth;
    }

    public Double getDistanceMonth() {
        return distanceMonth;
    }

    public void setDistanceMonth(Double distanceMonth) {
        this.distanceMonth = distanceMonth;
    }

    public Double getLevelgeMonth() {
        return levelgeMonth;
    }

    public void setLevelgeMonth(Double levelgeMonth) {
        this.levelgeMonth = levelgeMonth;
    }

    public Double getLightWeek() {
        return lightWeek;
    }

    public void setLightWeek(Double lightWeek) {
        this.lightWeek = lightWeek;
    }

    public LocalDateTime getDateMonth() {
        return dateMonth;
    }

    public void setDateMonth(LocalDateTime dateMonth) {
        this.dateMonth = dateMonth;
    }

    public Dispositivos getDispositivoMonth() {
        return dispositivoMonth;
    }

    public void setDispositivoMonth(Dispositivos dispositivoMonth) {
        this.dispositivoMonth = dispositivoMonth;
    }
}

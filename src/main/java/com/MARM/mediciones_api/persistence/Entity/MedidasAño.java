package com.MARM.mediciones_api.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "mediciones_anuales")

public class MedidasAño {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer idMeditionYear;


    @Column(name = "dispositivo_id",updatable = false, nullable = false)
    private Integer idDispositivo;

    @Column(name = "voltaje")
    private Double voltageYear;

    @Column(name = "distancia")
    private Double distanceYear;

    @Column(name = "nivel")
    private Double levelgeYear;

    @Column(name = "luminocidad")
    private Double lightYear;

    @Column(name = "fecha")
    private LocalDateTime dateYear;

    @ManyToOne
    @JoinColumn(name = "dispositivo_id", referencedColumnName = "id",updatable = false, insertable = false)
    @JsonIgnore
    private Dispositivos dispositivoYear;

    public Integer getIdMeditionYear() {
        return idMeditionYear;
    }

    public void setIdMeditionYear(Integer idMeditionYear) {
        this.idMeditionYear = idMeditionYear;
    }

    public Integer getIdDispositivo() {
        return idDispositivo;
    }

    public void setIdDispositivo(Integer idDispositivo) {
        this.idDispositivo = idDispositivo;
    }

    public Double getVoltageYear() {
        return voltageYear;
    }

    public void setVoltageYear(Double voltageYear) {
        this.voltageYear = voltageYear;
    }

    public Double getDistanceYear() {
        return distanceYear;
    }

    public void setDistanceYear(Double distanceYear) {
        this.distanceYear = distanceYear;
    }

    public Double getLevelgeYear() {
        return levelgeYear;
    }

    public void setLevelgeYear(Double levelgeYear) {
        this.levelgeYear = levelgeYear;
    }

    public Double getLightYear() {
        return lightYear;
    }

    public void setLightYear(Double lightYear) {
        this.lightYear = lightYear;
    }

    public LocalDateTime getDateYear() {
        return dateYear;
    }

    public void setDateYear(LocalDateTime dateYear) {
        this.dateYear = dateYear;
    }

    public Dispositivos getDispositivoYear() {
        return dispositivoYear;
    }

    public void setDispositivoYear(Dispositivos dispositivoYear) {
        this.dispositivoYear = dispositivoYear;
    }
}

package com.MARM.mediciones_api.persistence.Entity;

import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;

//@JsonIgnoreProperties({"medidasDiarias","medidasSemana","medidaMonth","medidaYear"})
@Entity
@Table(name="dispositivos")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "idDispositivo")

public class Dispositivos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer idDispositivo;

    @Column (name = "nombre")
    private String nombreDispositivo;

    //@Column (name ="Ubicacion_id", insertable = false,updatable = false)
    //private Integer idUbicacion;

    @Column(name ="estado")
    private String estado;

    @CreationTimestamp
    @Column (name = "created_at", updatable = false)
    private LocalDateTime createIn;

    @UpdateTimestamp
    @Column (name = "updated_at")
    private LocalDateTime updateIn;

    @PrePersist
    protected void onCreate() {
        if(this.createIn==null){
            this.createIn = LocalDateTime.now(ZoneId.of("America/Bogota"));
        }

        this.updateIn = LocalDateTime.now(ZoneId.of("America/Bogota"));
    }

    @PreUpdate
    protected void onUpdate() {
        this.updateIn = LocalDateTime.now(ZoneId.of("America/Bogota"));
    }

    @ManyToOne
    @JoinColumn(name = "ubicacion_id", nullable = false)
    @JsonBackReference
    private Ubicaciones ubicacion;

    @OneToMany (mappedBy = "dispositivoDia")

    @JsonIgnore
    private List<MedidadDia> medidasDiarias;

    @OneToMany (mappedBy = "dispositivoSemana")
    //@JsonIgnore
    private List<MedidasSemana> medidasSemana;

    @OneToMany (mappedBy = "dispositivoMonth")
   // @JsonIgnore
    private List<MedidasMes> medidaMonth;

    @OneToMany (mappedBy = "dispositivoYear")
    @JsonIgnore
    private List<MedidasAño> medidaYear;

    public List<MedidasSemana> getMedidasSemana() {
        return medidasSemana;
    }

    public void setMedidasSemana(List<MedidasSemana> medidasSemana) {
        this.medidasSemana = medidasSemana;
    }

    public List<MedidasMes> getMedidaMonth() {
        return medidaMonth;
    }

    public void setMedidaMonth(List<MedidasMes> medidaMonth) {
        this.medidaMonth = medidaMonth;
    }

    public List<MedidasAño> getMedidaYear() {
        return medidaYear;
    }

    public void setMedidaYear(List<MedidasAño> medidaYear) {
        this.medidaYear = medidaYear;
    }

    public List<MedidadDia> getMedidasDiarias() {
        return medidasDiarias;
    }

    public void setMedidasDiarias(List<MedidadDia> medidasDiarias) {
        this.medidasDiarias = medidasDiarias;
    }

    public Integer getIdDispositivo() {
        return idDispositivo;
    }

    public void setIdDispositivo(Integer idDispositivo) {
        this.idDispositivo = idDispositivo;
    }

    public String getNombreDispositivo() {
        return nombreDispositivo;
    }

    public void setNombreDispositivo(String nombreDispositivo) {
        this.nombreDispositivo = nombreDispositivo;
    }


    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public LocalDateTime getCreateIn() {
        return createIn;
    }

    public LocalDateTime setCreateIn(LocalDateTime createIn) {
        return this.createIn;
    }

    public LocalDateTime getUpdateIn() {
        return updateIn;
    }

    public void setUpdateIn(LocalDateTime updateIn) {
        this.updateIn = updateIn;
    }

    public Ubicaciones getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(Ubicaciones ubicacion) {
        this.ubicacion = ubicacion;
    }



    @Override
    public String toString() {
        return "Dispositivos{" +
                "id=" + idDispositivo +
                ", nombre='" + nombreDispositivo + '\'' +
                ", estado='" + estado + '\'' +
                ", createIn=" + createIn +
                ", updateIn=" + updateIn +
                '}'+
                (ubicacion != null ? ubicacion.getIdUbicaciones() : "null")
                +"}";
    }
}

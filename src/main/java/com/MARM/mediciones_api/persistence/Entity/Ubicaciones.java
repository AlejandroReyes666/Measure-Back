package com.MARM.mediciones_api.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "ubicaciones")


public class Ubicaciones {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer idUbicaciones;


    @Column(name="nombre", nullable = false)
    private String nombreUbicaciones;

    @OneToMany(mappedBy="ubicacion",cascade =CascadeType.ALL,orphanRemoval = true,fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<Dispositivos> dispositivos =new ArrayList<>();;

    public Integer getIdUbicaciones() {
        return idUbicaciones;
    }

    public void setIdUbicaciones(Integer idUbicaciones) {
        this.idUbicaciones = idUbicaciones;
    }

    public String getNombreUbicaciones() {
        return nombreUbicaciones;
    }

    public void setNombreUbicaciones(String nombreUbicaciones) {
        this.nombreUbicaciones = nombreUbicaciones;
    }

    public List<Dispositivos> getDispositivos() {
        return dispositivos;
    }

    public void setDispositivos(List<Dispositivos> dispositivos) {
        this.dispositivos = dispositivos;
    }

    @Override
    public String toString() {
        return "Ubicaciones{" +
                "idUbicaciones=" + idUbicaciones +
                ", nombreUbicaciones='" + nombreUbicaciones + '\'' +
                ", dispositivos=" + (dispositivos != null ? dispositivos.size() : "null") +
                '}';
    }
}

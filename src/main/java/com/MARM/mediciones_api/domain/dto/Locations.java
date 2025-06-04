package com.MARM.mediciones_api.domain.dto;

import lombok.Getter;
import lombok.Setter;


public class Locations {
    private Integer locationID;
    private  String nameLocation;


    public Integer getLocationID() {
        return locationID;
    }

    public void setLocationID(Integer locationID) {
        this.locationID = locationID;
    }

    public String getNameLocation() {
        return nameLocation;
    }

    public void setNameLocation(String nameLocation) {
        this.nameLocation = nameLocation;
    }

    @Override
    public String toString() {
        return "Locations{" +
                "locationID=" + locationID +
                ", nameLocation='" + nameLocation + '\'' +
                '}';
    }
}


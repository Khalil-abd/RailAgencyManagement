package com.ms.oncf.trajet.models.station;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;


public class Station implements Serializable {
    private static final long serialVersionUID = 1L;


    private String stationId;


    private String stationName;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getStationId() {
        return stationId;
    }

    public void setStationId(String stationId) {
        this.stationId = stationId;
    }

    public String getStationName() {
        return stationName;
    }

    public void setStationName(String stationName) {
        this.stationName = stationName;
    }

    public Station() {
    }

    public Station(String stationId, String stationName) {
        this.stationId = stationId;
        this.stationName = stationName;
    }
}
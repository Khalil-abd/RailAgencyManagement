package com.ms.oncf.stationservice.models;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
@Data
public class Station implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "stationid", insertable = false, nullable = false)
    private String stationId;

    @Column(name = "stationname")
    private String stationName;

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
}
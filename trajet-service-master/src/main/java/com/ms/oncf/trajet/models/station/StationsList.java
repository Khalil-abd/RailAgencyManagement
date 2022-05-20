package com.ms.oncf.trajet.models.station;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class StationsList implements Serializable {

    private List<Station> stations;

    public StationsList(){
        stations= new ArrayList<>();
    }
    public List<Station> getStations() {
        return stations;
    }

    public void setStations(List<Station> stations) {
        this.stations = stations;
    }
}

package com.ms.oncf.voyage.repositories;

import com.ms.oncf.voyage.models.station.Station;
import com.ms.oncf.voyage.models.station.StationsList;

public class StationCach {
    private static StationCach stationCach=null;
    private StationsList stations;

    private StationCach(){
        stations= new StationsList();
    }

    public static StationCach getInstance(){
        if(stationCach==null)
            stationCach=new StationCach();
        return stationCach;
    }

    public Station findById(String id)
    {
        for(Station s : stations.getStations())
            if (s.getStationId().equals(id))
                return s;
        return new Station("No_St","No Station");
    }

    public void addStation(Station station)
    {
        for(Station s : stations.getStations())
        {
            if (s.equals(station))
                return ;

        }
        stations.getStations().add(station);
    }

    public void addAll(StationsList stationsList){
        for(Station s : stationsList.getStations())
            addStation(s);
    }

    public StationsList getStations() {
        return stations;
    }

    public void setStations(StationsList stations) {
        this.stations = stations;
    }
}

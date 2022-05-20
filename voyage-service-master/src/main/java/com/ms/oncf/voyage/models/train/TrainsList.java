package com.ms.oncf.voyage.models.train;

import java.util.ArrayList;
import java.util.List;

public class TrainsList {

    private List<Train> trains;

    public TrainsList(){
        trains = new ArrayList<>();
    }

    public List<Train> getTrains() {
        return trains;
    }

    public void setTrains(List<Train> trains) {
        this.trains = trains;
    }
}

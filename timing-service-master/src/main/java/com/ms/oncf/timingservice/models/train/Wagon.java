package com.ms.oncf.timingservice.models.train;

import java.util.List;


public class Wagon {

    private int id;

    private int num_Wagon;

    private Train train;

    private List<Place> palces;

    public Wagon() {
    }

    public List<Place> getPalces() {
        return palces;
    }

    public int getId() {
        return id;
    }

    public int getNum_Wagon() {
        return num_Wagon;
    }

    public Train getTrain() {
        return train;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNum_Wagon(int num_Wagon) {
        this.num_Wagon = num_Wagon;
    }

    public void setTrain(Train train) {
        this.train = train;
    }

    public void setPalces(List<Place> palces) {
        this.palces = palces;
    }
}

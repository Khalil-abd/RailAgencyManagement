package com.ms.oncf.voyage.repositories;

import com.ms.oncf.voyage.models.train.Train;
import com.ms.oncf.voyage.models.train.TrainsList;

import java.util.ArrayList;

public class TrainCach {

    private static TrainCach trainCach=null;
    private TrainsList trains;

    private TrainCach(){
        trains = new TrainsList();
    }

    public static TrainCach getInstance(){
        if (trainCach==null)
            trainCach = new TrainCach();
        return trainCach;
    }

    public Train findById(Integer id)
    {
        for (Train t : trains.getTrains())
            if (t.getId() == id)
                return t;
        return new Train(0,3526,new ArrayList<>());
    }

    public void addTrain(Train train)
    {
        for (Train t : trains.getTrains())
            if (t.equals(train))
                return;
        trains.getTrains().add(train);
    }

    public void addAll(TrainsList trainsList)
    {
        for (Train t : trainsList.getTrains())
            addTrain(t);
    }

    public TrainsList getTrains() {
        return trains;
    }

    public void setTrains(TrainsList trains) {
        this.trains = trains;
    }
}

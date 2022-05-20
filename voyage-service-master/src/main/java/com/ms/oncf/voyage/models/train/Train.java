package com.ms.oncf.voyage.models.train;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;


public class Train {

    private int id;
    private long num_train;
    private List<Wagon> wagons;

    public Train() {
    }

    public Train(int id, long num_train, List<Wagon> wagons) {
        this.id = id;
        this.num_train = num_train;
        this.wagons = wagons;
    }

    public int getId() {
        return id;
    }

    public long getNum_train() {
        return num_train;
    }

    public List<Wagon> getWagons() {
        return wagons;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNum_train(long num_train) {
        this.num_train = num_train;
    }

    public void setWagons(List<Wagon> wagons) {
        this.wagons = wagons;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Train train = (Train) o;
        return id == train.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}

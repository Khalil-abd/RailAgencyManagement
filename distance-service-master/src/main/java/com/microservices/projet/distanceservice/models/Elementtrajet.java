package com.microservices.projet.distanceservice.models;

import java.util.Objects;

public class Elementtrajet {

    public Elementtrajet(String actualStation, Double distance, String nextStation, Trajet trajet) {
        this.actualStation = actualStation;
        this.distance = distance;
        this.nextStation = nextStation;
        this.trajetid = trajet;
    }


    public Elementtrajet(Integer id, String actualStation, Double distance, String nextStation, String trajet) {
        this.id = id;
        this.actualStation = actualStation;
        this.distance = distance;
        this.nextStation = nextStation;

    }

    public Elementtrajet(){}

    private Integer id;

    private String actualStation;

    private Double distance;

    private String nextStation;

    private Trajet trajetid;

    public String getTrajetid() {
        return trajetid.getTrajetId();
    }

    public void setTrajetid(Trajet trajet) {
        this.trajetid = trajet;
    }

    public String getActualStation() {
        return actualStation;
    }

    public void setActualStation(String actualStation) {
        this.actualStation = actualStation;
    }

    public Double getDistance() {
        return distance;
    }

    public void setDistance(Double distance) {
        this.distance = distance;
    }

    public String getNextStation() {
        return nextStation;
    }

    public void setNextStation(String nextStation) {
        this.nextStation = nextStation;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Elementtrajet that = (Elementtrajet) o;
        return id.equals(that.id) &&
                actualStation.equals(that.actualStation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, actualStation);
    }

}

package com.ms.oncf.trajet.models.trajet;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;


@Entity
public class Elementtrajet implements Serializable {
    private static final long serialVersionUID = 1L;

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

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "actualstation")
    private String actualStation;

    @Column(name = "distance")
    private Double distance;

    @Column(name = "nextstation")
    private String nextStation;

    @ManyToOne(targetEntity = Trajet.class)
    @JoinColumn(name = "trajetid", referencedColumnName = "trajetid", nullable = false)
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
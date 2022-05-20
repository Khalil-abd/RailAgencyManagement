package com.ms.oncf.trajet.models.trajet;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class Trajet implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    private String trajetid;

    @Column(name = "startstation")
    private String startStation;

    @OneToMany(mappedBy="trajetid",cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Elementtrajet> elementtrajets;

    public Trajet() {}

    public Trajet(String trajetid) {
        this.trajetid = trajetid;
    }

    public Trajet(String trajetid, String startStation, List<Elementtrajet> elementtrajets) {
        this.trajetid = trajetid;
        this.startStation = startStation;
        this.elementtrajets = elementtrajets;
    }

    public String getTrajetId() {
        return trajetid;
    }

    public void setTrajetId(String trajetId) {
        this.trajetid = trajetId;
    }

    public String getStartStation() {
        return startStation;
    }

    public void setStartStation(String startStation) {
        this.startStation = startStation;
    }

    public List<Elementtrajet> getElementtrajets() {
        return elementtrajets;
    }

    public void setElementstrajet(List<Elementtrajet> elementstrajet) {
        this.elementtrajets = elementstrajet;
    }
}
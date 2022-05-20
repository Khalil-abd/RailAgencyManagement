package com.ms.oncf.voyage.models.trajet;

import java.util.List;
import java.util.Objects;

public class Trajet {

    private String trajetid;

    private String startStation;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Trajet trajet = (Trajet) o;
        return trajetid.equals(trajet.trajetid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(trajetid);
    }

    public Elementtrajet getStartElement()
    {
        for (Elementtrajet et : elementtrajets)
            if (et.getActualStation().equals(startStation))
                return et;
        return null;
    }

    public Elementtrajet getElementById(String id)
    {
        for (Elementtrajet et : elementtrajets)
            if (et.getActualStation().equals(id))
                return et;
        return null;
    }
}

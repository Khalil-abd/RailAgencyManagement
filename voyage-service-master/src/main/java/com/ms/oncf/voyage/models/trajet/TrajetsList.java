package com.ms.oncf.voyage.models.trajet;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class TrajetsList implements Serializable {
    private List<Trajet> trajets;
    public TrajetsList(){
        trajets = new ArrayList<>();
    }
    public List<Trajet> getTrajets() {
        return trajets;
    }

    public void setTrajets(List<Trajet> trajets) {
        this.trajets = trajets;
    }
}

package com.ms.oncf.timingservice.models.voyage;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class VoyagesList implements Serializable {


    private List<Voyage> voyages;

    public VoyagesList(){
        voyages = new ArrayList<>();
    }

    public List<Voyage> getVoyages() {
        return voyages;
    }

    public void setVoyages(List<Voyage> voyages) {
        this.voyages = voyages;
    }
}

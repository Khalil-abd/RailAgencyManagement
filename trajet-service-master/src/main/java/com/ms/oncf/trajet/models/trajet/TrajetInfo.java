package com.ms.oncf.trajet.models.trajet;

import java.util.ArrayList;
import java.util.List;

public class TrajetInfo {
    private String startStation;
    private List<ElementTrajetInfo> elementTrajetInfos;

    public TrajetInfo(){
        elementTrajetInfos = new ArrayList<>();
    }

    public String getStartStation() {
        return startStation;
    }

    public void setStartStation(String startStation) {
        this.startStation = startStation;
    }

    public List<ElementTrajetInfo> getElementTrajetInfos() {
        return elementTrajetInfos;
    }

    public void setElementTrajetInfos(List<ElementTrajetInfo> elementTrajetInfos) {
        this.elementTrajetInfos = elementTrajetInfos;
    }
}

package com.ms.oncf.timingservice.models.voyage;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@AllArgsConstructor
@NoArgsConstructor
public class VoyageInfo {

    public VoyageInfo(Voyage voyage){
        dateVoyage = voyage.getDateVoyage();
        heureDepart = voyage.getHeureDepart();
        voyageId = voyage.getVoyageId();
        matriculeTrain = Long.valueOf(voyage.getTrainId());
    }
    private String voyageId;
    private LocalDate dateVoyage;
    private LocalTime heureDepart;
    private String startStation;
    private String endStation;
    private Long matriculeTrain;

    public String getVoyageId() {
        return voyageId;
    }

    public void setVoyageId(String voyageId) {
        this.voyageId = voyageId;
    }

    public LocalDate getDateVoyage() {
        return dateVoyage;
    }

    public void setDateVoyage(LocalDate dateVoyage) {
        this.dateVoyage = dateVoyage;
    }

    public LocalTime getHeureDepart() {
        return heureDepart;
    }

    public void setHeureDepart(LocalTime heureDepart) {
        this.heureDepart = heureDepart;
    }

    public String getStartStation() {
        return startStation;
    }

    public void setStartStation(String startStation) {
        this.startStation = startStation;
    }

    public String getEndStation() {
        return endStation;
    }

    public void setEndStation(String endStation) {
        this.endStation = endStation;
    }

    public Long getMatriculeTrain() {
        return matriculeTrain;
    }

    public void setMatriculeTrain(Long matriculeTrain) {
        this.matriculeTrain = matriculeTrain;
    }
}

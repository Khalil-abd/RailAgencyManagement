package com.ms.oncf.voyage.controllers;

import com.ms.oncf.voyage.models.station.Station;
import com.ms.oncf.voyage.models.train.Train;
import com.ms.oncf.voyage.models.trajet.Elementtrajet;
import com.ms.oncf.voyage.models.trajet.Trajet;
import com.ms.oncf.voyage.models.voyage.Voyage;
import com.ms.oncf.voyage.models.voyage.VoyageInfo;
import com.ms.oncf.voyage.models.voyage.VoyagesList;
import com.ms.oncf.voyage.repositories.VoyageRepository;
import com.ms.oncf.voyage.services.StationProxy;
import com.ms.oncf.voyage.services.TrainProxy;
import com.ms.oncf.voyage.services.TrajetProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/voyages")
public class VoyageController {

    @Autowired
    private VoyageRepository voyageRepository;

    @GetMapping
    public List<Voyage> findAllVoyages()
    {
        return voyageRepository.findAll();
    }

    @GetMapping("/all")
    public VoyagesList findAll()
    {
        VoyagesList voyages = new VoyagesList();
        voyages.setVoyages(voyageRepository.findAll());
        return voyages;
    }

    @GetMapping("/{id}")
    public Voyage findById(@PathVariable String id){
        return voyageRepository.findById(id).get();
    }

    @Autowired
    private StationProxy stationProxy;

    @Autowired
    private TrajetProxy trajetProxy;

    @Autowired
    private TrainProxy trainProxy;

    @GetMapping("/voyageInfo/{id}")
    public VoyageInfo getVoyageInfo(@PathVariable String id){
        Voyage voyage =  findById(id);
        VoyageInfo voyageInfo = new VoyageInfo(voyage);
        Station startStation = stationProxy.getStation(voyage.getStartStation());
        Station endStation = stationProxy.getStation(voyage.getEndStation());
        voyageInfo.setStartStation(startStation.getStationName());
        voyageInfo.setEndStation(endStation.getStationName());
        Train train = trainProxy.getTrain(voyage.getTrainId());
        voyageInfo.setMatriculeTrain(train.getNum_train());
        return voyageInfo;
    }

    @PostMapping
    public String addVoyage(@RequestBody Voyage voyage)
    {
        if (checkStationOrdre(voyage))
        {
            voyageRepository.save(voyage);
            return "All right";
        }
        return "Erreur lors de l'Ajout, verifier les information saisis ";

    }

    private boolean checkStationOrdre(Voyage voyage)
    {
        Trajet trajet = trajetProxy.getTrajet(voyage.getTrajetId());
        Elementtrajet et = trajet.getStartElement();
        boolean valid = true ;
        while (et != null)
        {
            if (et.getActualStation().equals(voyage.getEndStation()))
                return false; // return false si la station d'arrivee vient avant station de depart
            if (et.getActualStation().equals(voyage.getStartStation()))
                return true; // return true si la station de depart vient avant station d'arrivee
            et = trajet.getElementById(et.getNextStation());
        }
        return valid;
    }

    @PutMapping
    public String updateVoyage(@RequestBody Voyage voyage)
    {
        if (checkStationOrdre(voyage))
        {
            voyageRepository.save(voyage);
            return "All right";
        }
        return "Erreur lors de l'Ajout, verifier les information saisis ";
    }

    @DeleteMapping
    public void deleteVoyage(@RequestBody Voyage voyage)
    {
        voyageRepository.delete(voyage);
    }

}

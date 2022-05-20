package com.ms.oncf.trajet.controllers;

import com.ms.oncf.trajet.models.station.Station;
import com.ms.oncf.trajet.models.trajet.*;
import com.ms.oncf.trajet.repositories.TrajetRepository;
import com.ms.oncf.trajet.services.StationProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/trajets")
public class TrajetController {

    @Autowired
    private TrajetRepository trajetRepository;

    @GetMapping()
    public TrajetsList findAll()
    {
        TrajetsList trajets = new TrajetsList();
        trajets.setTrajets(trajetRepository.findAll());
        return trajets;
    }

    @GetMapping("/{id}")
    public Trajet findById(@PathVariable String id){
        return trajetRepository.findById(id).get();
    }

    @Autowired
    private StationProxy stationProxy;

    @GetMapping("/trajetInfo/{id}")
    public TrajetInfo getTrajetInfo(@PathVariable String id){
        Trajet t = findById(id);
        TrajetInfo trajetInfo = new TrajetInfo();
        trajetInfo.setStartStation(stationProxy.getStation(t.getStartStation()).getStationName());
        for (Elementtrajet et : t.getElementtrajets())
        {
            ElementTrajetInfo eti = new ElementTrajetInfo();
            Station s = stationProxy.getStation(et.getActualStation());
            eti.setActualStation(s.getStationName());
            s=new Station();
            if (et.getNextStation() != null)
            {
                s=stationProxy.getStation(et.getNextStation());
                eti.setNextStation(s.getStationName());
            }
            else
            {
                eti.setNextStation("");
            }

            eti.setDistance(et.getDistance());
            trajetInfo.getElementTrajetInfos().add(eti);
        }
        return trajetInfo;
    }

    @PostMapping
    public void addTrajet(@RequestBody Trajet trajet)
    {
        trajetRepository.save(trajet);
    }

    @PutMapping
    public void updateTrajet(@RequestBody Trajet trajet)
    {
        trajetRepository.save(trajet);
    }

    @DeleteMapping
    public void deleteTrajet(@RequestBody Trajet trajet)
    {
        trajetRepository.delete(trajet);
    }

}

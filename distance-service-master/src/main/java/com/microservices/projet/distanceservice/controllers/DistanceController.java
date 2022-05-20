package com.microservices.projet.distanceservice.controllers;

import com.microservices.projet.distanceservice.models.Elementtrajet;
import com.microservices.projet.distanceservice.models.Trajet;
import com.microservices.projet.distanceservice.services.TrajetProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/distance")
public class DistanceController {

    @Autowired
    private TrajetProxy trajetProxy;
    @GetMapping("/{trajet}")
    private Trajet getTrajet(@PathVariable String trajet)
    {
        return trajetProxy.getTrajet(trajet);
    }
    @GetMapping("/{trajetId}/{stationDepart}/{stationArrivee}")
    private Double calculDistance(@PathVariable String trajetId, @PathVariable String stationDepart,
                                  @PathVariable String stationArrivee){
        Trajet trajet = trajetProxy.getTrajet(trajetId);
        Elementtrajet et = trajet.getElementById(stationDepart);
        Double distance = 0.0;
        try{

            while(et.getNextStation()!=null)
            {
                distance+=et.getDistance();
                et = trajet.getElementById(et.getNextStation());
                if(et.getActualStation().equals(stationArrivee))
                    break;
            }
        }catch (NullPointerException e){}

        return distance;
    }
}

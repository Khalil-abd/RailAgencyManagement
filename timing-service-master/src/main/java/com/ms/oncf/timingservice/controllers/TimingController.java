package com.ms.oncf.timingservice.controllers;

import com.ms.oncf.timingservice.models.train.Train;
import com.ms.oncf.timingservice.models.voyage.Voyage;
import com.ms.oncf.timingservice.services.DistanceProxy;
import com.ms.oncf.timingservice.services.TrainProxy;
import com.ms.oncf.timingservice.services.VoyageProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalTime;

@RestController
@RequestMapping
public class TimingController {

    @Autowired
    private TrainProxy trainProxy;
    @Autowired
    private VoyageProxy voyageProxy;
    @Autowired
    private DistanceProxy distanceProxy;

    @GetMapping("/time/{voyageId}/{station}")
    public LocalTime getTime(@PathVariable String voyageId, @PathVariable String station)
    {
        Voyage voyage = voyageProxy.getVoyage(voyageId);
        Double distance;
        if( station.equals(voyage.getStartStation()))
            distance = 0.0;
        else
            distance= distanceProxy.getDistance(voyage.getTrajetId(),
                voyage.getStartStation(),station);
        Train train = trainProxy.getTrain(voyage.getTrainId());
        long duree = (long)((double)distance/train.getVitesse());
        long dureeSeconds = duree*3600;
        LocalTime timeArrivee = voyage.getHeureDepart().plusSeconds(dureeSeconds);
        return timeArrivee;
    }

    @GetMapping("/duree/{voyageId}/{startStation}/{endStation}")
    public String getDuree(@PathVariable String voyageId, @PathVariable String startStation,
                           @PathVariable String endStation)
    {
        Voyage voyage = voyageProxy.getVoyage(voyageId);
        Train train = trainProxy.getTrain(voyage.getTrainId());
        double distance=0 ;
        if (!endStation.equals(startStation))
            distance+=distanceProxy.getDistance(voyage.getTrajetId(), startStation,endStation);
        double duree = (double)distance/train.getVitesse();
        return duree+" heures";
    }


}

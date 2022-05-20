package com.ms.oncf.stationservice.controllers;

import com.ms.oncf.stationservice.models.Station;
import com.ms.oncf.stationservice.models.StationsList;
import com.ms.oncf.stationservice.repositories.StationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/stations")
public class StationController {

    @Autowired
    private StationRepository stationRepository;

    @GetMapping
    public StationsList findAll()
    {
        StationsList stations = new StationsList();
        stations.setStations(stationRepository.findAll());
        return stations;
    }

    @GetMapping("/{id}")
    public Station findById(@PathVariable  String id)
    {
        return stationRepository.findById(id).get();
    }

    @PostMapping
    public void addStation(@RequestBody Station station)
    {
        stationRepository.save(station);
    }

    @DeleteMapping("/{id}")
    public void addStation(@RequestBody String id)
    {
        stationRepository.delete(findById(id));
    }

    @PutMapping
    public void updateStation(@RequestBody Station station)
    {
        stationRepository.save(station);
    }
}

package com.ms.oncf.voyage.services;

import com.ms.oncf.voyage.models.station.Station;
import com.ms.oncf.voyage.repositories.StationCach;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class StationProxy {

    @Autowired
    RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "getFallBackStation",
            commandProperties = {
                    @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "2000"),
                    @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "5"),
                    @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "50"),
                    @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "5000")
            })
    public Station getStation(String id) {
        Station station = restTemplate.getForObject("http://station-service/stations/"+id, Station.class);
        StationCach.getInstance().addStation(station);
        return station;
    }
    public Station getFallBackStation(String id){
        return StationCach.getInstance().findById(id);
    }
}

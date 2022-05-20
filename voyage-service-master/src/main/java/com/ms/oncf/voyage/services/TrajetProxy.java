package com.ms.oncf.voyage.services;

import com.ms.oncf.voyage.models.trajet.Trajet;
import com.ms.oncf.voyage.repositories.TrajetCach;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class TrajetProxy {

    @Autowired
    RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "getFallBackTrajet",
            commandProperties = {
                    @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "2000"),
                    @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "5"),
                    @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "50"),
                    @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "5000")
            })
    public Trajet getTrajet(String id) {
        return restTemplate.getForObject("http://trajet-service/trajets/"+id, Trajet.class);
    }
    public Trajet getFallBackTrajet(String id){
        return TrajetCach.getInstance().findById(id);
    }

}

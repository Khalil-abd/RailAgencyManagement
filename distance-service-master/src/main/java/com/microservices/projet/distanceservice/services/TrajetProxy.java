package com.microservices.projet.distanceservice.services;

import com.microservices.projet.distanceservice.models.Trajet;
import com.microservices.projet.distanceservice.repositories.TrajetCach;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class TrajetProxy {

    @Autowired
    RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "getFallBackTrajet")
    public Trajet getTrajet(String id) {
        return restTemplate.getForObject("http://trajet-service/trajets/"+id, Trajet.class);
    }
    public Trajet getFallBackTrajet(String id){
        return TrajetCach.getInstance().findById(id);
    }

}

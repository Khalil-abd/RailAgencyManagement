package com.ms.oncf.timingservice.services;

import com.ms.oncf.timingservice.models.train.Train;
import com.ms.oncf.timingservice.repositories.TrainCach;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class TrainProxy {

    @Autowired
    RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "getFallBackTrajet",
            commandProperties = {
                    @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "2000"),
                    @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "5"),
                    @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "50"),
                    @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "5000")
            })
    public Train getTrain(Integer id) {
        return restTemplate.getForObject("http://anass-train-microservice/Trains/"+id, Train.class);
    }
    public Train getFallBackTrajet(Integer id){
        return TrainCach.getInstance().findById(id);
    }
}

package com.ms.oncf.stationservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import com.ms.oncf.stationservice.models.Station;
import org.springframework.stereotype.Repository;

@Repository
public interface StationRepository extends JpaRepository<Station, String>, JpaSpecificationExecutor<Station> {

}
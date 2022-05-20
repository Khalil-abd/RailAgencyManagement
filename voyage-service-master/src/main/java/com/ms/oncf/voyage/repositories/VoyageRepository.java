package com.ms.oncf.voyage.repositories;

import com.ms.oncf.voyage.models.voyage.Voyage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface VoyageRepository extends JpaRepository<Voyage, String>, JpaSpecificationExecutor<Voyage> {

}
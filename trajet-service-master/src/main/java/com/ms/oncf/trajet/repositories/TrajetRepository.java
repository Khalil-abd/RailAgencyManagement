package com.ms.oncf.trajet.repositories;

import com.ms.oncf.trajet.models.trajet.Trajet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrajetRepository extends JpaRepository<Trajet, String> {

}
package com.ms.oncf.voyage.repositories;

import com.ms.oncf.voyage.models.trajet.Trajet;
import com.ms.oncf.voyage.models.trajet.TrajetsList;

import java.util.ArrayList;

public class TrajetCach {
    private static TrajetCach trajetCach=null;
    private TrajetsList trajets;

    private TrajetCach(){
        trajets = new TrajetsList();
    }

    public static TrajetCach getInstance(){
        if (trajetCach==null)
            trajetCach=new TrajetCach();
        return trajetCach;
    }

    public Trajet findById(String id)
    {
        for(Trajet t : trajets.getTrajets())
            if (t.getTrajetId().equals(id))
                return t;
        return new Trajet("No_trj","No Trajet",new ArrayList<>());
    }

    public void addTrajet(Trajet trajet)
    {
        for (Trajet t : trajets.getTrajets())
            if (t.equals(trajet))
                return;
        trajets.getTrajets().add(trajet);
    }

    public void addAll(TrajetsList trajetsList){
        for(Trajet t : trajetsList.getTrajets())
            addTrajet(t);
    }

    public TrajetsList getTrajets() {
        return trajets;
    }

    public void setTrajets(TrajetsList trajets) {
        this.trajets = trajets;
    }
}

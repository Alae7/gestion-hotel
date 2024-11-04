package com.example.reservation.Mapper;

import com.example.reservation.DTO.ReservationDTOReponse;
import com.example.reservation.DTO.ReservationDTORequest;
import com.example.reservation.Entities.Reservation;
import org.springframework.stereotype.Component;

@Component
public class ReservationMapImp implements ReservationMapInterface{


    @Override
    public Reservation ReponseToReservation(ReservationDTORequest req) {

        Reservation r=new Reservation();
        r.setDate_debut(req.getDate_debut());
        r.setNbr_jours(req.getNbr_jours());
        r.setIdClient(req.getIdClient());
        r.setIdChambre(req.getIdChambre());
        return r;
    }

    @Override
    public ReservationDTOReponse ReservationToReponse(Reservation r) {

        ReservationDTOReponse rep=new ReservationDTOReponse();
        rep.setDate_debut(r.getDate_debut());
        rep.setNbr_jours(r.getNbr_jours());
        rep.setClient(r.getClient());
        rep.setChambre(r.getChambre());
        rep.setId(r.getId());

        return rep;
    }
}

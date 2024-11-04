package com.example.reservation.service;

import com.example.reservation.DTO.ReservationDTOReponse;
import com.example.reservation.DTO.ReservationDTORequest;
import com.example.reservation.Entities.Reservation;
import com.example.reservation.Mapper.ReservationMapInterface;
import com.example.reservation.Model.Chambre;
import com.example.reservation.Model.Client;
import com.example.reservation.Model.NumberPerson;
import com.example.reservation.Repository.ReservatioRepository;
import com.example.reservation.openFeingController.ChambreOpenFeingController;
import com.example.reservation.openFeingController.ClientOpenFeingController;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class ReservationServiceServiceImp implements ReservationServiceInterface {

    @Autowired
    ReservatioRepository repository;
    @Autowired
    ReservationMapInterface reservationMapInterface;

    @Autowired
    ClientOpenFeingController clientOpenFeingController;

    @Autowired
    ChambreOpenFeingController chambreOpenFeingController;


    @Override
    public void add(ReservationDTORequest reservationDTORequest) {


        Reservation r=new Reservation();

        r=reservationMapInterface.ReponseToReservation(reservationDTORequest);
        repository.save(r);
    }

    @Override
    public ReservationDTOReponse getoneReservation(Integer id) {

        Reservation r=new Reservation();

        r=repository.findById(id).get();

       Client c=clientOpenFeingController.getClient(r.getIdClient());
        Chambre chambre=chambreOpenFeingController.getChambre(r.getIdChambre());


    r.setClient(c);

    r.setChambre(chambre);

ReservationDTOReponse rep=reservationMapInterface.ReservationToReponse(r);

        return rep;
    }

    @Override
    public List<ReservationDTOReponse> allReservation() {

        List<Reservation> lr=new ArrayList<>();
        List<Client> lc=new ArrayList<>();
        List<Chambre>lch=new ArrayList<>();

    lr=repository.findAll();
    lc=clientOpenFeingController.getAllClient();
    lch=chambreOpenFeingController.getAllChambre();

    for(Reservation r: lr){

        for(Client c: lc){

            if(r.getIdClient()==c.getId()){

                r.setClient(c);
                break;
            }

        }

        for(Chambre ch:lch){

            if(r.getIdChambre()==ch.getNb_chambre()){

                r.setChambre(ch);
                break;
            }
        }
    }
    List<ReservationDTOReponse> lp=new ArrayList<>();
    for(Reservation r:lr){

        lp.add(reservationMapInterface.ReservationToReponse(r));
    }
        return lp;
    }

    @Override
    public void updateReservation(Integer id, ReservationDTORequest req) {

        Reservation r=new Reservation();
        r=repository.findById(id).get();
        if(req.getDate_debut()!=null){
            r.setDate_debut(req.getDate_debut());
        }

        if(req.getNbr_jours()!=null){
        r.setNbr_jours(req.getNbr_jours());
        }

        if(req.getIdClient()!=null){
            r.setIdClient(req.getIdClient());
        }

        if(req.getIdChambre()!=null){

            r.setIdChambre(req.getIdChambre());
        }

    }

    @Override
    public void delete(Integer id) {

        repository.deleteById(id);
    }
}

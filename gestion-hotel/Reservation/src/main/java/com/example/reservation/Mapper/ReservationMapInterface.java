package com.example.reservation.Mapper;

import com.example.reservation.DTO.ReservationDTOReponse;
import com.example.reservation.DTO.ReservationDTORequest;
import com.example.reservation.Entities.Reservation;
import org.springframework.stereotype.Component;

@Component
public interface ReservationMapInterface {

    public  Reservation ReponseToReservation(ReservationDTORequest req);
    public ReservationDTOReponse ReservationToReponse(Reservation r);
}

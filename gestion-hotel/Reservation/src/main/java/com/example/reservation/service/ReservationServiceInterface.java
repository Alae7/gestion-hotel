package com.example.reservation.service;

import com.example.reservation.DTO.ReservationDTOReponse;
import com.example.reservation.DTO.ReservationDTORequest;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ReservationServiceInterface {

    //	##########     POST    ##########

    public void add(ReservationDTORequest reservationDTORequest);

    //	##########     GET    ##########

    public ReservationDTOReponse getoneReservation(Integer id);

    //	##########     GET ALL    ##########

    public List<ReservationDTOReponse> allReservation();

    // 	##########     PUT    ##########

    public void updateReservation(Integer id , ReservationDTORequest chambreRequistDTO);

    // 	##########     DELETE    ##########

    public void delete(Integer id);
}

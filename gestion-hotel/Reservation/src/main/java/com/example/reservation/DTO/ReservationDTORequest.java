package com.example.reservation.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ReservationDTORequest {

    String Date_debut ;

    Integer Nbr_jours;

    Integer idClient;
    Integer idChambre;

}

package com.example.reservation.DTO;

import com.example.reservation.Model.Chambre;
import com.example.reservation.Model.Client;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ReservationDTOReponse {

    Integer id;
    String Date_debut ;

    Integer Nbr_jours;

    Client client;
    Chambre chambre;
}

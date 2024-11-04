package com.example.reservation.Entities;


import com.example.reservation.Model.Chambre;
import com.example.reservation.Model.Client;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Reservation {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    String Date_debut ;

    Integer Nbr_jours;

    Integer idClient;
    Integer idChambre;

    @Transient
    Client client;
    @Transient
    Chambre chambre;
}

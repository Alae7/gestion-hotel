package com.example.reservation.Model;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class Client {

    Integer id;
    String nom;
    String prenom;

    String CIN;
}

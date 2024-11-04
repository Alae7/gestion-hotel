package com.example.client.DTO;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class ClientReponseDTO {


    Integer id;
    String nom;
    String prenom;

    String CIN;
}

package com.example.client.DTO;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class ClientRequestDTO {

    String nom;
    String prenom;

    String CIN;
}

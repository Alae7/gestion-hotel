package com.example.chambre.DTO;

import com.example.chambre.Entites.NumberPerson;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class ChambreReponseDTO {
    private Integer nb_chambre;
    private Integer prix;
    private Boolean reserved;
    private NumberPerson nb_person;
}

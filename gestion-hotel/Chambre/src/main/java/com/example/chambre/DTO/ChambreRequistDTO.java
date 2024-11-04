package com.example.chambre.DTO;

import com.example.chambre.Entites.NumberPerson;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class ChambreRequistDTO {
    private Integer prix;
    private Boolean reserved;
    private NumberPerson nb_person;
}

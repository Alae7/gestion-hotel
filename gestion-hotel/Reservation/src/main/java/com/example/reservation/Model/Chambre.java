package com.example.reservation.Model;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Chambre {


    private Integer nb_chambre;
    private Integer prix;
    private Boolean reserved;

    private NumberPerson nb_person;
}

package com.example.chambre.Entites;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor @Builder @ToString @Setter @Getter
public class Chambre {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer nb_chambre;
    private Integer prix;
    private Boolean reserved;
    @Enumerated(EnumType.STRING)
    private NumberPerson nb_person;


}

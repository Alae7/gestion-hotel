package com.example.client.Entities;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Client {

@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    String nom;
    String prenom;

    String CIN;
}

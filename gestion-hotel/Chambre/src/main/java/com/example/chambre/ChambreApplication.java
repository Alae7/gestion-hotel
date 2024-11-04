package com.example.chambre;

import com.example.chambre.Entites.Chambre;
import com.example.chambre.Entites.NumberPerson;
import com.example.chambre.Repository.ChambreRepository;
import com.example.chambre.config.GlobalConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties({GlobalConfig.class})
public class ChambreApplication implements CommandLineRunner {

    @Autowired
    ChambreRepository chambreRepository;

    public static void main(String[] args) {
        SpringApplication.run(ChambreApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        chambreRepository.save(new Chambre(null,500,true, NumberPerson.ONE_Personne));
        chambreRepository.save(new Chambre(null,700,true, NumberPerson.ONE_Personne));
        chambreRepository.save(new Chambre(null,650,true, NumberPerson.TOW_Personne));
        chambreRepository.save(new Chambre(null,850,false, NumberPerson.TOW_Personne));
        chambreRepository.save(new Chambre(null,700,true, NumberPerson.FOUR_Personne));
        chambreRepository.save(new Chambre(null,900,false, NumberPerson.FOUR_Personne));

        System.out.println("Chambre tres bien");
    }
}

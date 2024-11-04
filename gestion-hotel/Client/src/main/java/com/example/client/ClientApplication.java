package com.example.client;

import com.example.client.Entities.Client;
import com.example.client.Repository.ClientRepository;
import com.example.client.config.GlobalConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties({GlobalConfig.class})
public class ClientApplication implements CommandLineRunner {

    @Autowired
    ClientRepository clientRepository;

    public static void main(String[] args) {
        SpringApplication.run(ClientApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        Client c1=new Client(null,"Mohcine","Aimane","JD14247");
        Client c2=new Client(null,"Mchimcha","Alae","JE452435");
        Client c3=new Client(null,"Boukhress","Badr","JM45241");
        Client c4=new Client(null,"Ouzih","Zouhair","JB526516");
        Client c5=new Client(null,"Hassouni","Adnan","JF52656");

        clientRepository.save(c1);
        clientRepository.save(c2);
        clientRepository.save(c3);
        clientRepository.save(c4);
        clientRepository.save(c5);

        System.out.println("Client marche tres bien");


    }
}

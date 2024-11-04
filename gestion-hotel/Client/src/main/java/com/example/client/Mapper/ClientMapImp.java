package com.example.client.Mapper;

import com.example.client.DTO.ClientReponseDTO;
import com.example.client.DTO.ClientRequestDTO;
import com.example.client.Entities.Client;
import org.springframework.stereotype.Component;

@Component
public class ClientMapImp implements ClientMapInter{
    @Override
    public Client fromRequestToClient(ClientRequestDTO req) {

        Client c=new Client();
        c.setNom(req.getNom());
        c.setPrenom(req.getPrenom());
        c.setCIN(req.getCIN());
        return c;
    }

    @Override
    public ClientReponseDTO fromClientToRepnse(Client client) {

        ClientReponseDTO rep=new ClientReponseDTO();

        rep.setId(client.getId());
        rep.setNom(client.getNom());
        rep.setCIN(client.getCIN());
        rep.setPrenom(client.getPrenom());

        return rep;
    }
}

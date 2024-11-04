package com.example.client.Mapper;

import com.example.client.DTO.ClientReponseDTO;
import com.example.client.DTO.ClientRequestDTO;
import com.example.client.Entities.Client;
import org.springframework.stereotype.Component;

@Component
public interface ClientMapInter {

    public Client fromRequestToClient(ClientRequestDTO req);
    public ClientReponseDTO fromClientToRepnse(Client client);
}

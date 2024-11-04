package com.example.client.service;

import com.example.client.DTO.ClientReponseDTO;
import com.example.client.DTO.ClientRequestDTO;

import java.util.List;

public interface ClientServiceinter {


    // ---------------Post ------------------------------
    public ClientReponseDTO  add(ClientRequestDTO clientRequestDTO);

    // ---------------Get one ---------------------
    public ClientReponseDTO getClient(Integer id);


    //------------------Get All ------------------------------

    public List<ClientReponseDTO> getAllClient();

    // -------------------------Put---------------------------
    public void updateClient(Integer id ,ClientRequestDTO req);

    //-------------------delete-------------------------
    public  void delete (Integer id);





}

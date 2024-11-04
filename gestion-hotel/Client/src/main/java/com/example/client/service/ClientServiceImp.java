package com.example.client.service;

import com.example.client.DTO.ClientReponseDTO;
import com.example.client.DTO.ClientRequestDTO;
import com.example.client.Entities.Client;
import com.example.client.Mapper.ClientMapInter;
import com.example.client.Repository.ClientRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class ClientServiceImp implements ClientServiceinter{

    @Autowired
    ClientRepository clientRepository;

   @Autowired
   ClientMapInter clientMapInter;


    @Override
    public ClientReponseDTO add(ClientRequestDTO clientRequestDTO) {

        Client c=new Client();
        c=clientMapInter.fromRequestToClient(clientRequestDTO);
        clientRepository.save(c);
        c=clientRepository.findById(c.getId()).get();
        ClientReponseDTO rep=clientMapInter.fromClientToRepnse(c);
        return rep;


    }

    @Override
    public ClientReponseDTO getClient(Integer id) {

        Client c=new Client();
        c=clientRepository.findById(id).get();

        ClientReponseDTO rep=clientMapInter.fromClientToRepnse(c);
        return rep;
    }

    @Override
    public List<ClientReponseDTO> getAllClient() {
        List<Client> lc=new ArrayList<>();
        lc=clientRepository.findAll();

        List<ClientReponseDTO> ldto=new ArrayList<>();

        for(Client c : lc){

            ldto.add(clientMapInter.fromClientToRepnse(c));
        }
        return ldto;
    }

    @Override
    public void updateClient(Integer id, ClientRequestDTO req) {

        Client c=new Client();
        c=clientRepository.findById(id).get();

        if(req.getNom()!=null){

            c.setNom(req.getNom());
        }
        if(req.getCIN()!=null){
            c.setCIN(req.getCIN());
        }
        if(req.getPrenom()!=null){
            c.setPrenom(req.getPrenom());
        }


    }

    @Override
    public void delete(Integer id) {

        clientRepository.deleteById(id);

    }
}

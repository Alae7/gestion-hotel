package com.example.client.web;

import com.example.client.DTO.ClientReponseDTO;
import com.example.client.DTO.ClientRequestDTO;
import com.example.client.config.GlobalConfig;
import com.example.client.service.ClientServiceinter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@org.springframework.web.bind.annotation.RestController

@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200")
public class Controller {
    @Autowired
    ClientServiceinter clientServiceinter;

    @Autowired
    GlobalConfig globalConfig;


    @GetMapping("/globaleconfig")
    public GlobalConfig globalConfig(){return globalConfig;}


    @GetMapping("/clients")

    public List<ClientReponseDTO> getAll(){

        return  clientServiceinter.getAllClient();
    }

    @GetMapping("/clients/{id}")

    public  ClientReponseDTO getone(@PathVariable("id") Integer id ){

        return clientServiceinter.getClient(id);
    }


    @PostMapping("/clients")

    public ClientReponseDTO addClient(@RequestBody ClientRequestDTO req){

       return clientServiceinter.add(req);


    }

    @PutMapping("/clients/{id}")

    public void update(@PathVariable("id") Integer id , @RequestBody ClientRequestDTO req){

        clientServiceinter.updateClient(id,req);

    }
    @DeleteMapping("/clients/{id}")
    public void delete (@PathVariable("id") Integer id){

        clientServiceinter.delete(id);

    }


}

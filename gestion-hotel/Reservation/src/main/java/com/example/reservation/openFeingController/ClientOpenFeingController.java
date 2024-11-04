package com.example.reservation.openFeingController;

import com.example.reservation.Model.Client;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name="CLIENT-SERVICE")
public interface ClientOpenFeingController {

    @GetMapping("/api/clients")

    public List<Client> getAllClient();

    @GetMapping("/api/clients/{id}")

    public  Client getClient(@PathVariable  Integer id);


}

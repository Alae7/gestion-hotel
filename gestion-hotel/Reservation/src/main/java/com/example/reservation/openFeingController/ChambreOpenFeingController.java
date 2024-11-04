package com.example.reservation.openFeingController;

import com.example.reservation.Model.Chambre;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name="CHAMBRE-SERVICE")
public interface ChambreOpenFeingController {

        @GetMapping("/api/Chambres")

    public List<Chambre> getAllChambre ();

     @GetMapping("/api/Chambres/{id}")

    public Chambre getChambre(@PathVariable Integer id);
}

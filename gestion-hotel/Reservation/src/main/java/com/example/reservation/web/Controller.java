package com.example.reservation.web;

import com.example.reservation.DTO.ReservationDTOReponse;
import com.example.reservation.DTO.ReservationDTORequest;
import com.example.reservation.service.ReservationServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@org.springframework.web.bind.annotation.RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api")
public class Controller {

@Autowired
ReservationServiceInterface reservationServiceInterface;

    @GetMapping("/reservations/{id}")

    public ReservationDTOReponse getone(@PathVariable("id") Integer id ){

        return reservationServiceInterface.getoneReservation(id);
    }

@GetMapping("/reservations")

    public List<ReservationDTOReponse> gettAll(){

        return  reservationServiceInterface.allReservation();
}

@PostMapping("/reservations")

    public void addReservation(@RequestBody ReservationDTORequest req){

    reservationServiceInterface.add(req);

}

@PutMapping("/reservations/{id}")

public void  update(@PathVariable Integer id, @RequestBody ReservationDTORequest req){

    reservationServiceInterface.updateReservation(id,req);

}

@DeleteMapping("/reservations/{id}")

    public void delete (@PathVariable Integer id){

    reservationServiceInterface.delete(id);
}


    // Options request for CORS preflight for DELETE
    @RequestMapping(value = "/reservations/{id}", method = RequestMethod.OPTIONS)
    public ResponseEntity<?> handleOptions() {
        return ResponseEntity.ok().header(HttpHeaders.ALLOW, HttpMethod.DELETE.name()).build();
    }

}

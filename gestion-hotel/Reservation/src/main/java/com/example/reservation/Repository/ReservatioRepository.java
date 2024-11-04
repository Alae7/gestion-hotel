package com.example.reservation.Repository;

import com.example.reservation.Entities.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservatioRepository extends JpaRepository<Reservation,Integer> {
}

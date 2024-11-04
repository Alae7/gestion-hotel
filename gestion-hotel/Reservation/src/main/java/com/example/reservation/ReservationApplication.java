package com.example.reservation;

import com.example.reservation.Entities.Reservation;
import com.example.reservation.Repository.ReservatioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ReservationApplication implements CommandLineRunner {

	@Autowired
	ReservatioRepository reservatioRepository;

	public static void main(String[] args) {
		SpringApplication.run(ReservationApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Reservation r1=new Reservation(null,"12/12/2023",2,1,1,null,null);
		Reservation r2=new Reservation(null,"01/12/2023",1,2,2,null,null);
		Reservation r3=new Reservation(null,"06/12/2023",5,3,3,null,null);
		Reservation r5=new Reservation(null,"14/12/2023",15,5,5,null,null);


		reservatioRepository.save(r1);
		reservatioRepository.save(r2);
		reservatioRepository.save(r3);
		reservatioRepository.save(r5);
System.out.println("Reservation marche tres bien ");

	}
}

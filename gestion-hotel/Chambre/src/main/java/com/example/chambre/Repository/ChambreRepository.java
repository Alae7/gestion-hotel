package com.example.chambre.Repository;

import com.example.chambre.Entites.Chambre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.webmvc.RepositoryRestController;

@RepositoryRestController
public interface ChambreRepository extends JpaRepository<Chambre,Integer> {

}

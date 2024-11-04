package com.example.chambre.Mapper;

import com.example.chambre.DTO.ChambreReponseDTO;
import com.example.chambre.DTO.ChambreRequistDTO;
import com.example.chambre.Entites.Chambre;
import org.springframework.stereotype.Component;

@Component
public interface ChambreMapInter {
    public Chambre FromRequist2Chambre(ChambreRequistDTO requistDTO);
    public ChambreReponseDTO FromChambre2Reponse(Chambre chambre);
}

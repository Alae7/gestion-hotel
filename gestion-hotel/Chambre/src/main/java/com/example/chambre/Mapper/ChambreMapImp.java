package com.example.chambre.Mapper;

import com.example.chambre.DTO.ChambreReponseDTO;
import com.example.chambre.DTO.ChambreRequistDTO;
import com.example.chambre.Entites.Chambre;
import org.springframework.stereotype.Component;

@Component
public class ChambreMapImp implements ChambreMapInter{
    @Override
    public Chambre FromRequist2Chambre(ChambreRequistDTO requistDTO) {
        Chambre chambre = new Chambre();
        chambre.setPrix(requistDTO.getPrix());
        chambre.setReserved(requistDTO.getReserved());
        chambre.setNb_person(requistDTO.getNb_person());
        return chambre;
    }

    @Override
    public ChambreReponseDTO FromChambre2Reponse(Chambre chambre) {
        ChambreReponseDTO chambreReponseDTO = new ChambreReponseDTO();
        chambreReponseDTO.setNb_chambre(chambre.getNb_chambre());
        chambreReponseDTO.setPrix(chambre.getPrix());
        chambreReponseDTO.setReserved(chambre.getReserved());
        chambreReponseDTO.setNb_person(chambre.getNb_person());
        return chambreReponseDTO;
    }
}

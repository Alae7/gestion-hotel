package com.example.chambre.Service;

import com.example.chambre.DTO.ChambreReponseDTO;
import com.example.chambre.DTO.ChambreRequistDTO;
import com.example.chambre.Entites.Chambre;
import com.example.chambre.Mapper.ChambreMapInter;
import com.example.chambre.Repository.ChambreRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class ChambreServImp implements ChambreServInter{

    @Autowired
    ChambreRepository chambreRepository;

    @Autowired
    ChambreMapInter chambreMapInter;



    @Override
    public void add(ChambreRequistDTO chambreRequistDTO) {
        Chambre chambre = new Chambre();
        chambre = chambreMapInter.FromRequist2Chambre(chambreRequistDTO);
        chambreRepository.save(chambre);
    }

    @Override
    public ChambreReponseDTO getonechambre(Integer id) {
        Chambre chambre = chambreRepository.findById(id).get();
        return chambreMapInter.FromChambre2Reponse(chambre);
    }

    @Override
    public List<ChambreReponseDTO> allchambres() {
        List<Chambre> l = chambreRepository.findAll();
        List<ChambreReponseDTO> ldto = new ArrayList<>();
        for(Chambre chambre:l){
            ldto.add(chambreMapInter.FromChambre2Reponse(chambre));
        }

        return ldto;
    }

    @Override
    public void updatechambre(Integer id, ChambreRequistDTO chambreRequistDTO) {
        Chambre chambre = chambreRepository.findById(id).get();
        if(chambreRequistDTO.getPrix()!=null){
            chambre.setPrix(chambreRequistDTO.getPrix());
        }
        if (chambreRequistDTO.getReserved()!=null){
            chambre.setReserved(chambreRequistDTO.getReserved());
        }
        if(chambreRequistDTO.getNb_person()!=null){
            chambre.setNb_person(chambreRequistDTO.getNb_person());
        }

    }

    @Override
    public void delete(Integer id) {

        chambreRepository.deleteById(id);
    }
}

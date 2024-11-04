package com.example.chambre.Service;

import com.example.chambre.DTO.ChambreReponseDTO;
import com.example.chambre.DTO.ChambreRequistDTO;

import java.util.List;

public interface ChambreServInter {
    //	##########     POST    ##########

    public void add(ChambreRequistDTO chambreRequistDTO);

    //	##########     GET    ##########

    public ChambreReponseDTO getonechambre(Integer id);

    //	##########     GET ALL    ##########

    public List<ChambreReponseDTO> allchambres();

    // 	##########     PUT    ##########

    public void updatechambre(Integer id , ChambreRequistDTO chambreRequistDTO);

    // 	##########     DELETE    ##########

    public void delete(Integer id);

}

package com.example.chambre.Web;

import com.example.chambre.DTO.ChambreReponseDTO;
import com.example.chambre.DTO.ChambreRequistDTO;
import com.example.chambre.Service.ChambreServInter;
import com.example.chambre.config.GlobalConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@org.springframework.web.bind.annotation.RestController
@RequestMapping ("/api")
@CrossOrigin(origins = "http://localhost:4200")
public class RestController {

    @Autowired
    ChambreServInter chambreServInter;

    @Autowired
    GlobalConfig globalConfig;


    //	##################### get all #########################
    @GetMapping("/globaleconfig")
    public GlobalConfig globalConf(){return globalConfig;}





    //	##################### get all #########################
    @GetMapping("/Chambres")
    public List<ChambreReponseDTO> getall(){return chambreServInter.allchambres();}

    //	##################### get  #########################
    @GetMapping("/Chambres/{ID}")
    public ChambreReponseDTO getone(@PathVariable("ID") Integer id){return chambreServInter.getonechambre(id);}

    //	##################### post #########################
    @PostMapping("/Chambres")
    public void add(@RequestBody ChambreRequistDTO chambreRequistDTO){chambreServInter.add(chambreRequistDTO);}

    //	##################### update #########################
    @PutMapping("/Chambres/{ID}")
    public void update(@PathVariable("ID") Integer id,@RequestBody ChambreRequistDTO chambreRequistDTO){chambreServInter.updatechambre(id,chambreRequistDTO);}

    //	##################### delete #########################
    @DeleteMapping("/Chambres/{ID}")
    public void delete(@PathVariable("ID") Integer id){chambreServInter.delete(id);}

}

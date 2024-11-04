import { Injectable } from '@angular/core';
import {HttpClient,HttpClientModule} from "@angular/common/http";
import {Chambre} from "../../../Model/Chambre.model";

@Injectable({
  providedIn: 'root'
})
export class ChambreService {

  constructor(private http:HttpClient) { }

  getallchambre(){
  return this.http.get<Array<Chambre>>("http://localhost:8888/CHAMBRE-SERVICE/api/Chambres");
  }
  updatechambre(id:number,rom:any){
  return this.http.put(`http://localhost:8888/CHAMBRE-SERVICE/api/Chambres/${id}`,rom)  ;
  }

}

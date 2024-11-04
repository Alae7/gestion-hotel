import { Injectable } from '@angular/core';
import {HttpClient,HttpClientModule} from "@angular/common/http";
import {Reservation} from "../../../Model/Reservation.model";

@Injectable({
  providedIn: 'root'
})
export class ReservationService {

  constructor(private http:HttpClient) { }

  getallreservation(){
   return  this.http.get<Array<Reservation>>("http://localhost:8888/RESERVATION-SERVICE/api/reservations");
  }
  deletereservation(id:number){
    return this.http.delete(`http://localhost:8888/RESERVATION-SERVICE/api/reservations/${id}`);
  }
  updatereservation(id:number,reservation:any){
    return this.http.put<any>(`http://localhost:8888/RESERVATION-SERVICE/api/reservations/${id}`,reservation);
  }
  postreservation(reservation:any){
  return this.http.post("http://localhost:8888/RESERVATION-SERVICE/api/reservations",reservation);
  }
}

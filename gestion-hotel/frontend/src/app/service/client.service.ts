import { Injectable } from '@angular/core';
import {HttpClient,HttpClientModule} from "@angular/common/http";
import {Client} from "../../../Model/Client.model";

@Injectable({
  providedIn: 'root'
})
export class ClientService {

  constructor(private http:HttpClient) { }

  getallclient(){
   return  this.http.get<Array<Client>>("http://localhost:8888/CLIENT-SERVICE/api/clients");
  }
  updateclient(id:number,client:any){
    return this.http.put<any>(`http://localhost:8888/CLIENT-SERVICE/api/clients/${id}`,client)
  }
  postclient(client:any){
    return this.http.post<Client>("http://localhost:8888/CLIENT-SERVICE/api/clients",client)
  }

  deleteclient(id:number){
    return  this.http.delete(`http://localhost:8888/CLIENT-SERVICE/api/clients/${id}`)
  }

}

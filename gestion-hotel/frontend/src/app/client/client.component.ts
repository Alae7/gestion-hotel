import {Component, OnInit} from '@angular/core';
import {Location, NgForOf} from "@angular/common";
import {HttpClient, HttpClientModule} from "@angular/common/http";
import {Client} from "../../../Model/Client.model";
import {FormsModule, NgForm, ReactiveFormsModule} from "@angular/forms";
import {Reservation} from "../../../Model/Reservation.model";
import {Router} from '@angular/router';
import {ClientService} from "../service/client.service";
import {ReservationService} from "../service/reservation.service";


@Component({
  selector: 'app-client',
  standalone: true,
  imports: [NgForOf, HttpClientModule, FormsModule, ReactiveFormsModule],
  templateUrl: './client.component.html',
  styleUrl: './client.component.css'
})
export class ClientComponent implements OnInit{
  archive : Array<Reservation> = [];
  cl!:Client;
  //pour stocker les clients
  client : Array<Client>=[];
  test ={nom:"", prenom:"", cin:""}
  constructor(private http: HttpClient,public router:Router,public location:Location,private clientservice:ClientService,private reservation:ReservationService){}
  ngOnInit(): void {
        this.getclient();
        this.getarchive();
   }

   //pour lister les clients
   getclient(){
    this.clientservice.getallclient().subscribe({
      next:value => {this.client=value},error:err => {console.log(err)}
    });
   }

    //for update
   updateclient(upd:NgForm){
     alert("update successful");
     let valeur = upd.value;
     if(valeur.nom==""){
       valeur.nom=this.cl.nom;
     }
     if(valeur.prenom==""){
       valeur.prenom=this.cl.prenom;
     }
     if(valeur.cin==""){
       valeur.cin=this.cl.cin;
     }
     let ce= {nom:valeur.nom, prenom:valeur.prenom, cin:valeur.cin};
    this.clientservice.updateclient(this.cl.id,ce).subscribe({next:value => {},error:err => {console.log(err)}})
   }

   //for post
  postclient(add:NgForm){
    alert("Post successful")
    let valeur = add.value;
    let ce= {nom:valeur.nom, prenom:valeur.prenom, cin:valeur.cin};
    this.clientservice.postclient(ce).subscribe({
      next:value => {},error:err => {console.log(err)}
    })
  }

  deleteclient(client_delete:Client){
    if (confirm("Are you sure?")) {
      let check = true;
      for (let reservation of this.archive) {
        if (client_delete.id == reservation.client.id) {
          check = false;
        }
      }
      if (check) {
        alert("Delete successful");
        this.clientservice.deleteclient(client_delete.id).subscribe({
          next: value => {
          }
        });
      } else {
        alert("delete failed .  this client has already booked a rom")
      }

    }}
  getarchive(){
    this.reservation.getallreservation().subscribe({
      next:value => {this.archive=value},
      error:err => {console.log(err)}
    })
  }

  prendcclient(client:Client):Client{
    return this.cl=client;
  }

  refresh(){
    this.router.navigateByUrl("/home",{skipLocationChange:true}).then(()=>{this.router.navigate(['/client']).then(()=>{window.location.reload();})})
  }
}


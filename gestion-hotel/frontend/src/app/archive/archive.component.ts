import {Component, OnInit} from '@angular/core';
import {HttpClient, HttpClientModule} from "@angular/common/http";
import {NgForOf} from "@angular/common";
import {Reservation} from "../../../Model/Reservation.model";
import {FormsModule, NgForm} from "@angular/forms";
import {Router} from '@angular/router';
import {Location} from "@angular/common";
import {Chambre} from "../../../Model/Chambre.model";
import {ReservationService} from "../service/reservation.service";
import {ChambreService} from "../service/chambre.service";
import {ClientService} from "../service/client.service";


@Component({
  selector: 'app-archive',
  standalone: true,
  imports: [HttpClientModule, NgForOf, FormsModule],
  templateUrl: './archive.component.html',
  styleUrl: './archive.component.css'
})
export class ArchiveComponent  implements  OnInit{
  //table de reservation
  archive : Array<Reservation> = [];
  roms : Array<Chambre> = [];
  reservation!:Reservation;
  nr_roms : Array<Chambre> = [];
  test={nb_chambre:"", nbr_jours:"", date_debut:""}
  constructor(private http:HttpClient,public router:Router,public location:Location,private reservationservice:ReservationService,private chambrereservation:ChambreService,private clientservice:ClientService) {}
    ngOnInit(): void {
      this.getarchive();
      this.getroms();
    }
    //pour lister les reservations
    getarchive(){
    this.reservationservice.getallreservation().subscribe({
      next:value => {this.archive=value},
      error:err => {console.log(err)}
    })
    }
    getroms(){
    this.chambrereservation.getallchambre().subscribe({
      next:value =>{this.roms=value;
        for(let r of this.roms){
          if(!r.reserved){
            this.nr_roms.push(r);
          }
        }},
      error:err => {console.log(err)}
    })
  }
    //for delete
    deletearchive(r:Reservation){
      if (confirm("Are you sure?")) {
        alert("delete successful");
        this.reservationservice.deletereservation(r.id).subscribe({
          next:value => {},
          error:err => {console.log(err)}
        })
      }
    }
    updateromfordelete(r:Reservation){
     r.chambre.reserved=!r.chambre.reserved;
     this.chambrereservation.updatechambre(r.chambre.nb_chambre,{"prix":r.chambre.prix,"reserved":r.chambre.reserved,"nb_person":r.chambre.nb_person}).subscribe({next:value => {}});
   }
    updatearchive(upd:NgForm){
    alert("update successful")
    let valeur = upd.value;
    if(valeur.date_debut==""){
      valeur.date_debut=this.reservation.date_debut;
    }
    if (valeur.nbr_jours==""){
      valeur.nbr_jours=this.reservation.nbr_jours;
    }
    let updatereservation= {idClient:this.reservation.client.id, idChambre:this.reservation.chambre.nb_chambre, nbr_jours:valeur.nbr_jours,date_debut:valeur.date_debut};
    this.reservationservice.updatereservation(this.reservation.id,updatereservation).subscribe({next:value => {},error:err => {console.log(err)}})
  }
  refresh(){
      this.router.navigateByUrl("/home",{skipLocationChange:true}).then(()=>{this.router.navigate(['/archive']).then(()=>{window.location.reload();})})
  }
  prendreservation(reservation:Reservation){
    return this.reservation=reservation;
  }
}

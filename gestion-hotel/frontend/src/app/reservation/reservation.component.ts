import {Component, OnInit} from '@angular/core';
import {HttpClient, HttpClientModule} from "@angular/common/http";
import {Chambre} from "../../../Model/Chambre.model";
import {Location, NgForOf} from "@angular/common";
import {FormsModule, NgForm} from "@angular/forms";
import {Client} from "../../../Model/Client.model";
import {Router} from "@angular/router";
import {ReservationService} from "../service/reservation.service";
import {ChambreService} from "../service/chambre.service";
import {ClientService} from "../service/client.service";

@Component({
  selector: 'app-reservation',
  standalone: true,
  imports: [NgForOf, HttpClientModule, FormsModule],
  templateUrl: './reservation.component.html',
  styleUrl: './reservation.component.css'
})
export class ReservationComponent implements OnInit{
  roms : Array<Chambre> = [];
 // n=0;
  client: Array<Client> = [] ;
  nr_roms : Array<Chambre> = [];
  test ={
    prenom:"",
    nom:"",
    cin:"",
    date_debut:"",
    nbr_jours:"",
    idClient:"",
    nb_chambre:""
  };
  constructor(private http: HttpClient,public router:Router,public location:Location,private reservationservice:ReservationService,private chambreservice:ChambreService,private clientservice:ClientService){}
  ngOnInit(): void {
    this.getroms();
    this.getclient();
  }

  getroms(){
    this.chambreservice.getallchambre().subscribe({
      next:value =>{this.roms=value;
        for(let r of this.roms){
          if(!r.reserved){
            this.nr_roms.push(r);
          }
        }},
      error:err => {console.log(err)}
    })
  }


  getclient(){
    this.clientservice.getallclient().subscribe({
      next:value => {this.client=value},error:err => {console.log(err)}
    });
  }

  postreservation(res:NgForm){
    alert("Post successful")
    let valeur = res.value;
    let reservation = {
     idClient:valeur.idClient,
     idChambre:valeur.nb_chambre,
     nbr_jours:valeur.nbr_jours,
     date_debut:valeur.date_debut
   };
   this.refresh();
   this.reservationservice.postreservation(reservation).subscribe({next:value => {}});
  }

  updaterom(res:NgForm){
    let valeur = res.value;
    for(let rom of this.roms){
      if(rom.nb_chambre==valeur.nb_chambre){
        rom.reserved=!rom.reserved;
        this.chambreservice.updatechambre(rom.nb_chambre,{"prix":rom.prix,"reserved":rom.reserved,"nb_person":rom.nb_person}).subscribe({next:value => {}});
        break;
      }
    }
  }

  refresh(){
    this.router.navigateByUrl("/home",{skipLocationChange:true}).then(()=>{this.router.navigate(['/reservation']).then(()=>{window.location.reload();})})
  }

}

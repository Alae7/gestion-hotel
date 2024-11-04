import {Component, OnInit} from '@angular/core';
import {NgForOf} from "@angular/common";
import {Chambre} from "../../../Model/Chambre.model";
import {HttpClient, HttpClientModule} from "@angular/common/http";
import {Reservation} from "../../../Model/Reservation.model";
import {ChambreService} from "../service/chambre.service";

@Component({
  selector: 'app-roms',
  standalone: true,
  imports: [NgForOf,HttpClientModule],
  templateUrl: './roms.component.html',
  styleUrl: './roms.component.css'
})
export class RomsComponent implements OnInit{

  //pour stocker touts les chambres
  roms : Array<Chambre> = [];
  //pour stocker les chambres reservées
  r_roms : Array<Chambre> = [];
  //pour stocker les chambre non reservées
  nr_roms : Array<Chambre> =[] ;
  constructor(private http: HttpClient,private chambreservice:ChambreService) {}
    ngOnInit(): void {
      this.getroms();
    }
    //pour lister les chambres
    getroms(){
      this.chambreservice.getallchambre().subscribe({
        next:value =>{this.roms=value;
        for(let r of this.roms){
            if(r.reserved){
              this.r_roms.push(r);
            }
            else {
              this.nr_roms.push(r);
            }
        }},
        error:err => {console.log(err)}
      })
    }

}

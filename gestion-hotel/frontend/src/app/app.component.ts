import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import {RouterLink, RouterOutlet,Router} from '@angular/router';
import {Location} from "@angular/common";

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [CommonModule, RouterOutlet,RouterLink],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'frontend';
  constructor(public router:Router,public location:Location) {}
  refresh(s:String){
    if(s=="roms"){
      this.router.navigateByUrl("/home",{skipLocationChange:true}).then(()=>{this.router.navigate(['/roms']).then(()=>{window.location.reload();})})
    }
    if(s=="client"){
      this.router.navigateByUrl("/home",{skipLocationChange:true}).then(()=>{this.router.navigate(['/client']).then(()=>{window.location.reload();})})
    }
    if(s=="reservation"){
      this.router.navigateByUrl("/home",{skipLocationChange:true}).then(()=>{this.router.navigate(['/reservation']).then(()=>{window.location.reload();})})

    }
    if(s=="archive"){
      this.router.navigateByUrl("/home",{skipLocationChange:true}).then(()=>{this.router.navigate(['/archive']).then(()=>{window.location.reload();})})
    }
  }
}

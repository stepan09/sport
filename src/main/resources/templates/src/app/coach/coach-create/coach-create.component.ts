import { Component, OnInit } from '@angular/core';
import {Coach} from "../coach";
import {CoachService} from "../coach.service";
import {Router} from "@angular/router";



@Component({
  selector: 'app-coach-create',
  templateUrl: './coach-create.component.html',
  styleUrls: ['./coach-create.component.css'],
  providers: [CoachService]
})
export class CoachCreateComponent implements OnInit {

  postStatus: any;
  private coach1: Coach;
  constructor(private router: Router,
              private coachService: CoachService) { }

  ngOnInit() {
  }

  saveCoach(newCoach: Coach){
    this.coach1 = new Coach(newCoach.lastName, newCoach.firstName, newCoach.middleName, newCoach.birthDate);
    this.coachService.saveCoach(this.coach1)
      .subscribe( coach =>  {
        alert("Coach "+ this.coach1.lastName + " created successfully.");
      });
  }



}

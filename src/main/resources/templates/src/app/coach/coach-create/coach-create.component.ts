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

  constructor(private router: Router,
              private coachService: CoachService) { }

  ngOnInit() {
  }

  saveCoach(coach: Coach){
    console.log(coach.lastName);
    console.log(coach.firstName);
    console.log(coach.middleName);
    console.log(coach.birthDate);
    this.coachService.saveCoach(coach)
      .subscribe( data => {
        alert("User created successfully.");
      });
    console.log(coach.lastName);
  }



}

import { Component, OnInit } from '@angular/core';
import {Coach} from "../coach";
import {CoachService} from "../coach.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-coach-list',
  templateUrl: './coach-list.component.html',
  styleUrls: ['./coach-list.component.css'],
  providers: [CoachService]
})
export class CoachListComponent implements OnInit {

  private coaches: Coach[];

  constructor(private router: Router,
              private coachService: CoachService) { }

  ngOnInit() {
    this.getAllCoaches();
  }

  getAllCoaches() {
    this.coachService.findAll().subscribe(
      coaches => {
        this.coaches = coaches;
      },
      err => {
        console.log(err)
      }
    );
  }

  redirectNewCoachPage() {
    this.router.navigate(['/coach/create']);
  }

  editCoachPage(coach: Coach) {
    if (coach) {
      this.router.navigate(['/coach/edit', coach.coachId]);
    }
  }

  deleteCoach(coach: Coach) {
    this.coachService.deleteUserById(coach)
      .subscribe(data => {
        this.coaches = this.coaches.filter(c => c !== coach);
      })
    console.log('Delete Coach');
  }

}

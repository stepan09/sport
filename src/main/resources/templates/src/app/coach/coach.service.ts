import { Injectable } from '@angular/core';
import {Observable} from "rxjs/Observable";
import {Coach} from "./coach";
import 'rxjs/add/operator/map'
import 'rxjs/add/operator/catch';
import {Http, Response} from "@angular/http";


@Injectable()
export class CoachService {

  private apiUrl = 'http://localhost:8080/api/coaches';

  constructor(private http: Http) { }

  findAll() {
    return this.http.get(this.apiUrl)
      .map((res:Response) => res.json())
      .catch((error:any) => Observable.throw(error.json().error || 'Server error'));
  }



  public saveCoach(coach: Coach) {
    return this.http.post(this.apiUrl, coach)
      .map(res=>res.json());
  }

  deleteUserById(coach: Coach) {
    console.log(coach.coachId);
    return this.http.delete(this.apiUrl + coach.coachId);
      }

  updateUser(coach: Coach) {
    return this.http.put(this.apiUrl, coach)
      .map(res=>res.json());
  }



}

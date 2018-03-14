import { Injectable } from '@angular/core';
import {Observable} from "rxjs/Observable";
import {Coach} from "./coach";
import 'rxjs/add/operator/map'
import 'rxjs/add/operator/catch';
import {HttpClient, HttpHeaders} from "@angular/common/http";


const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};
@Injectable()
export class CoachService {

  private apiUrl = 'http://localhost:8080/api/coaches';

  constructor(private http: HttpClient) { }

  findAll() {
    return this.http.get(this.apiUrl);
  }



  public saveCoach(coach: Coach) {
    console.log(coach.lastName);
    return this.http.post(this.apiUrl, coach);
  }

  deleteUserById(coach: Coach) {
    console.log(coach.coachId);
    return this.http.delete(this.apiUrl + "/del/" + coach.coachId);
      }

  updateUser(coach: Coach): Observable<Coach> {
    return null;
  }



}

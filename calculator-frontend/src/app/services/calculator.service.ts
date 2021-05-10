import { Injectable } from '@angular/core';
import { Calculation } from '../dto/Calculation';
import { HttpClient, HttpHeaders } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class CalculatorService {
  private BASE_URL = 'http://localhost:8080/api/calculations';
  private httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json'
    })
  };

  constructor(private http: HttpClient) {}

  saveCalculation(calculation: Calculation): void {
    const url = `${this.BASE_URL}`;
    this.http.post(url, calculation, this.httpOptions).subscribe(
      val => {
        console.log('Successfully saved calculation');
      },
      response => {
        console.log('Error statuscode: ', response.status);
      }
    );
  }
}

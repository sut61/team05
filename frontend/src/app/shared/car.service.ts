import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';

@Injectable({
  providedIn: 'root'
})
export class CarService {

  public API = '//localhost:8080';

  constructor(private http: HttpClient) {}

  getCar(): Observable<any> {
    return this.http.get(this.API + '/cars');
  }

  getCarBrand(): Observable<any> {
    return this.http.get(this.API + '/carBrands');
  }

  getCarInsurance(): Observable<any> {
    return this.http.get(this.API + '/carInsurances');
  }

  getProvince(): Observable<any> {
    return this.http.get(this.API + '/province');
  }

  createCar(car: Object): Observable<Object> {
    return this.http.post(this.API + '/cars', car);
  }
}

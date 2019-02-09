import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CarcontrolService {

  public API = '//localhost:8080';

  constructor(private http: HttpClient) {}

  getCarcontrol(): Observable<any> {
    return this.http.get(this.API + '/carcontrols');
  }

  getCarInformation(): Observable<any> {
    return this.http.get(this.API + '/CarInformation');
}

  getCarStatus(): Observable<any> {
    return this.http.get(this.API + '/carStatuss');
  }

  getProvince(): Observable<any> {
    return this.http.get(this.API + '/province');
  }

  createCarcontrol(carcontrol: Object): Observable<Object> {
    return this.http.post(this.API + '/carcontrols', carcontrol);
  }
}

import { Injectable } from '@angular/core';

import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
    providedIn: 'root'
})

export class RepairinfoService {
    httpOptions = {
        headers: new HttpHeaders({
          'Content-Type':  'application/json'
        })
      };

      public API = '//localhost:8080';
      constructor(
        private http: HttpClient
      ) {
      }

      getCar(): Observable<any> {
        return this.http.get(this.API + '/Car');
      }

      getRepairinfo(): Observable<any> {
        return this.http.get(this.API + '/Repairinfo');
      }

      getDamage(): Observable<any> {
        return this.http.get(this.API + '/Damage');
      }

      getDriver(): Observable<any> {
        return this.http.get(this.API + '/Driver');
      }

      getName(): Observable<any> {
        return this.http.get(this.API + '/CarInformation')
      }
}

/*export class Car {
  carId: any;
  carname: string;
}

export class Damage {
  damageId: any;
  damagename: string;
}*/

export class Repairinfo {
  name: any;
  repairinfoid: any;
  car: any;
  damage: any;
  driver: any;
  phone: any;
}

/*export class Driver {
  driverId: any;
  drivername: string;
}*/


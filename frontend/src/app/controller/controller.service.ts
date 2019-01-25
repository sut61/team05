import { Injectable } from "@angular/core";
import { HttpClient } from "@angular/common/http";
import { Observable } from "rxjs";

@Injectable()

export class Controller {
public API = '//localhost:8080';

constructor(
            private httpClient:HttpClient
    ){}

      getCarry(): Observable<any> {
        return this.httpClient.get(this.API + '/carrys');
      }
      
      getLink(): Observable<any> {
        return this.httpClient.get(this.API + '/linkeds');
      }
      
      getPackages(): Observable<any> {
        return this.httpClient.get(this.API + '/packages');
      }

      getProvince(): Observable<any> {
      return this.httpClient.get(this.API + '/provinces');
      }
      
      getReceiver(): Observable<any> {
        return this.httpClient.get(this.API + '/receivers');
      }

      createCarry(carry: Object): Observable<Object> {
        return this.httpClient.post(this.API + '/carrys', carry);
      }

}

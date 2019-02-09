import { Injectable } from '@angular/core';
import { HttpClient } from "@angular/common/http";
import { Observable } from "rxjs";

@Injectable({
providedIn: 'root'
})
export class BounceService {
public API = '//localhost:8080';

constructor(private httpClient:HttpClient) {}

      getBounce(): Observable<any> {
      return this.httpClient.get(this.API + '/bounce');
      }

      getTypeproduct(): Observable<any> {
      return this.httpClient.get(this.API + '/typeproduct');
      }

      getSender(): Observable<any> {
        return this.httpClient.get(this.API + '/sender');
      }

      getReceiver(): Observable<any> {
        return this.httpClient.get(this.API + '/receiver');
      }

      getProvince(): Observable<any> {
      return this.httpClient.get(this.API + '/province');
      }

      getProvincesen(): Observable<any> {
      return this.httpClient.get(this.API + '/provincesen');
      }

      getlink(): Observable<any> {
        return this.httpClient.get(this.API + '/Link');
      }

}


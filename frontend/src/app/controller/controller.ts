import { Injectable } from "@angular/core";
import { HttpClient } from "@angular/common/http";
import { Observable } from "rxjs";

@Injectable()

export class Controller {
public API = '//localhost:8080';

constructor(
            private httpClient:HttpClient
    ){}

      getsender(): Observable<any> {
        return this.httpClient.get(this.API + '/Sender');
      }

      getreceiver(): Observable<any> {
        return this.httpClient.get(this.API + '/Receiver');
      }

      getlink(): Observable<any> {
        return this.httpClient.get(this.API + '/Link');
      }

      getprovince(): Observable<any> {
      return this.httpClient.get(this.API + '/Province');
      }

      getprovincesen(): Observable<any> {
      return this.httpClient.get(this.API + '/Provincesen');
      }

      getgender(): Observable<any> {
      return this.httpClient.get(this.API + '/Gender');
      }

      getInformationemp(): Observable<any> {
      return this.httpClient.get(this.API + '/Informationemp');
      }

      getPosition(): Observable<any> {
      return this.httpClient.get(this.API + '/Position');
      }

      getBankemp(): Observable<any> {
        return this.httpClient.get(this.API + '/Bankemp');
      }
}

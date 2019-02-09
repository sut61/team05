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
      return this.httpClient.get(this.API + '/province');
      }

      getprovincesen(): Observable<any> {
      return this.httpClient.get(this.API + '/Provincesen');
      }

      getgender(): Observable<any> {
      return this.httpClient.get(this.API + '/Gender');
      }

      getBankemp(): Observable<any> {
        return this.httpClient.get(this.API + '/Bankemp');
      }

      getInformationemp(): Observable<any> {
      return this.httpClient.get(this.API + '/Informationemp');
      }

      getPosition(): Observable<any> {
      return this.httpClient.get(this.API + '/Position');
      }

      getGender(): Observable<any> {
      return this.httpClient.get(this.API + '/Gender');
      }

      getCarbrand(): Observable<any>{
        return this.httpClient.get(this.API + '/Car');
      }

      getProvince(): Observable<any> {
        return this.httpClient.get(this.API + '/province');
        }

      getCarInformation(): Observable<any> {
          return this.httpClient.get(this.API + '/CarInformation');
      }

      getPackages(): Observable<any> {
        return this.httpClient.get(this.API + '/packages');
      }

      getReceiver(): Observable<any> {
        return this.httpClient.get(this.API + '/receiver');
      }

      getDeduetion(): Observable<any> {
         return this.httpClient.get(this.API + '/Deduetion');
      }

      getSalary(): Observable<any> {
         return this.httpClient.get(this.API + '/Salary');
      }
}

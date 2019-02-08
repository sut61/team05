import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { BehaviorSubject, Observable, Subject } from 'rxjs';
import { Employee } from '../../employee';

@Injectable({
  providedIn: 'root'
})
export class PackageService {
  public API = '//localhost:8080';

  private employee = new  BehaviorSubject(new Employee())
  currentEmployee = this.employee.asObservable()

  constructor(private http: HttpClient) {}

  getSender(): Observable<any> {
    return this.http.get(this.API + '/sender');
  }

  getReceiver(): Observable<any> {
    return this.http.get(this.API + '/receiver');
  }

  getProvince(): Observable<any> {
    return this.http.get(this.API + '/province');
  }

  getEmployee(): Observable<any> {
    return this.http.get(this.API + '/Informationemp');
  }

  getCarry() : Observable<any> {
    return this.http.get(this.API + '/carrys');
  }

  getStatus() : Observable<any> {
      return this.http.get(this.API + '/status');
  }

  login(user: string,password : string): Observable<any> {
    return this.http.get(this.API + '/Login/'+user+'/'+password);
  }

  setEmployee(data: Employee) {
    this.employee.next(data);
  }
  //wtf
}


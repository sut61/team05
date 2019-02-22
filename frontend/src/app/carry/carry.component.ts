import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Controller } from '../controller/controller';
import { Router } from "@angular/router";

@Component({
  selector: 'app-carry',
  templateUrl: './carry.component.html',
  styleUrls: ['./carry.component.css']
})
export class CarryComponent implements OnInit {
  packageId : Array<any>
  status : Array<any>
  receivers : Array<any>
  provinces : Array<any>
  
  select: any = {
    packageId : '',
    date : '',
    carryNumber : '',
    status : '',
    firstname : '',
    lastname : '',
    Address : '',
    Telephone : '',
    province : ''
    
   
  };
 
  constructor(private router:Router, private controllerService: Controller,private httpClient: HttpClient) { }

  ngOnInit() {
    this.controllerService.getPackages().subscribe(data => {
      this.packageId = data;
      console.log(this.packageId);
    });
    this.controllerService.getProvince().subscribe(data => {
      this.provinces = data;
      console.log(this.provinces);
    });
    this.controllerService.getReceiver().subscribe(data => {
      this.receivers = data;
      console.log(this.receivers);
    });
  }

  save() {
      this.httpClient.post('http://localhost:8080/carrys/' + this.select.packageId + '/' + this.select.date + '/' 
      + this.select.carryNumber + '/' + this.select.status + '/' + this.select.firstname + '/' + this.select.province ,this.select)
      .subscribe(
          data => {
              console.log('PUT Request is successful', data);
              alert("Success");
          },
          error => {
              console.log('Error to PUT Request', error);
              alert("Jesus Christ!! Fail");
          }
      );
    }
}



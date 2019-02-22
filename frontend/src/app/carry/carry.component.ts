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
    if (this.select.packageId == null || this.select.packageId == '') {
      alert('กรุณาเลือกเลขที่ใบรับสินค้า');
    }
    else if (this.select.date == null || this.select.date == '') {
      alert('กรุณาระบุวันที่');
    }
    else if (this.select.carryNumber == null || this.select.carryNumber == '') {
      alert('กรุณาระบุเลขที่ใบส่งสินค้า');
    }
    else if (this.select.status == null || this.select.status == '') {
      alert('กรุณาระบุสถานะ');
    } 
    else if (this.select.firstname == null || this.select.firstname == '') {
      alert('กรุณาเลือกชื่อผู้ส่ง');
    } 
    else if (this.select.province == null || this.select.province == '') {
      alert('กรุณาเลือกจังหวัด');
    }else {
      console.log(this.select.packageId);
      console.log(this.select.date);
      console.log(this.select.carryNumber);
      console.log(this.select.status);
      console.log(this.select.firstname);
      console.log(this.select.province);
      this.httpClient.post('http://localhost:8080/carrys/' + this.select.packageId + '/' + this.select.date + '/' 
      + this.select.carryNumber + '/' + this.select.status + '/' + this.select.firstname + '/' + this.select.province ,this.select)
      .subscribe(
          data => {
              console.log('PUT Request is successful', data);
              alert("บันทึกสำเร็จ !!");
          },
          error => {
              console.log('Error to PUT Request', error);
              alert("FAIL");
          }
      );
    }
}
}

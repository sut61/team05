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
    codenamecarry : '',
    namecarry : '',
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
    if (this.select.codenamecarry == null || this.select.codenamecarry == '') {
      alert('กรุณาระบุรหัสชื่อผู้ออกใบส่งสินค้า');
    }
    else if (this.select.namecarry == null || this.select.namecarry == '') {
      alert('กรุณาระบุชื่อผู้ออกใบส่งสินค้า');
    }
    else if (this.select.packageId == null || this.select.packageId == '') {
      alert('กรุณาเลือกใบรับสินค้า');
    }
    else if (this.select.date == null || this.select.date == '') {
      alert('กรุณาเลือกวันที่');
    }
    else if (this.select.carryNumber == null || this.select.carryNumber == '') {
      alert('กรุณาระบุใบส่งสินค้า');
    }
    else if (this.select.status == null || this.select.status == '') {
      alert('กรุณาระบุสถานะ');
    }
    else if (this.select.firstname == null || this.select.firstname == '') {
      alert('กรุณาเลือกชื่อผู้รับ');
    }
    else if (this.select.lastname == null || this.select.lastname == '') {
      alert('กรุณาเลือกนามสกุลผู้รับ');
    }
    else if (this.select.Address == null || this.select.Address == '') {
      alert('กรุณาเลือกที่อยู่ผู้รับ');
    }
    else if (this.select.Telephone == null || this.select.Telephone == '') {
      alert('กรุณาเลือกเบอร์โทรผู้รับ');
    }
    else if (this.select.province == null || this.select.province == '') {
      alert('กรุณาเลือกจังหวัด');
    } else {
      console.log(this.select.codenamecarry);
      console.log(this.select.namecarry);
      console.log(this.select.packageId);
      console.log(this.select.date);
      console.log(this.select.carryNumber);
      console.log(this.select.status);
      console.log(this.select.firstname);
      console.log(this.select.lastname);
      console.log(this.select.Address);
      console.log(this.select.Telephone);
      console.log(this.select.province);
      this.httpClient.post('http://localhost:8080/carrys/' + this.select.codenamecarry + '/' + this.select.namecarry + '/' + this.select.packageId + '/' + this.select.date + '/' 
      + this.select.carryNumber + '/' + this.select.status + '/' + this.select.firstname + '/' + this.select.province ,this.select)
      .subscribe(
          data => {
              console.log('PUT Request is successful', data);
              alert("บันทึกสำเร็จ !!");
          },
          error => {
              console.log('Error to PUT Request', error);
              alert("บันทึกไม่สำเร็จ !!");
          }
      );
    }
  }
}

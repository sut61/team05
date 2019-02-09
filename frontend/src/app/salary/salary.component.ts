import { Component, OnInit } from '@angular/core';
import {HttpClient} from '@angular/common/http';
// tslint:disable-next-line:import-spacing
import { Controller } from'../controller/controller';
import { RouterModule, Routes } from '@angular/router';
import { Router } from '@angular/router';

@Component({
  selector: 'app-salary',
  templateUrl: './salary.component.html',
  styleUrls: ['./salary.component.css']
})
export class SalaryComponent implements OnInit {

  position: Array<any>;
  positionid = '';

  deduetion: Array<any>;
  deduetionid = '';

  bank: Array<any>;
  bankempid = '';

 name: Array<any>;
 banknumber: Array<any>;
 balance: Array<any>;

   views: any = {

  name: '',
  positionid: '',
  bankempid: '',
  banknumber: '',
  deduetionid: '',
  balance: '',
 };

constructor(private controller: Controller, private httpClient: HttpClient,private router: Router) { }

 ngOnInit() {

 this.controller.getPosition().subscribe(data => {
           this.position = data;
           console.log(this.position);
         });

 this.controller.getDeduetion().subscribe(data => {
           this.deduetion = data;
           console.log(this.deduetion);
         });
 this.controller.getBankemp().subscribe(data => {
           this.bank = data;
           console.log(this.bank);
         });

 }
 save() {

 if (this.views.name == null || this.views.name == '') {
       alert('กรุณาเระบุชื่อ');
     }
     else if (this.views.positionid == null || this.views.positionid == '') {
       alert('กรุณาเลือกตำแหน่่ง');
     }
     else if (this.views.bankempid == null || this.views.bankempid == '') {
       alert('กรุณาเลือกธนาคาร');
     }
     else if (this.views.banknumber == null || this.views.banknumber == '') {
       alert('กรุณาระบุเลขที่บัญชี่');
     }
      else if (this.views.deduetionid == null || this.views.deduetionid == '') {
             alert('กรุณาเลือกจำนวนเงินที่หัก');
      }
      else if (this.views.balance == null || this.views.balance == '') {
             alert('กรุณาระบุุจำนวนเงินคงเหลือ');
      }

      else {
       console.log(this.views.name);
       console.log(this.views.positionid);
       console.log(this.views.bankempid);
       console.log(this.views.banknumber);
       console.log(this.views.deduetionid);
       console.log(this.views.balance);


  this.httpClient.post('http://localhost:8080/salary/' + this.views.name + '/' + this.views.positionid + '/'
                       + this.views.bankempid + '/' + this.views.banknumber + '/'  + this.views.deduetionid + '/'
                      + this.views.balance, this.views)
  .subscribe(
    data => {
      alert("บันทึกสำเร็จ")
        console.log('PUT Request is successful', data);
        this.router.navigate(['/slip'])
    },
    error => {
        console.log('Error to PUT Request', error);
          alert('กรุณากรอกข้อมูลให้ครบถ้วน');
    }
  );
}
}
}

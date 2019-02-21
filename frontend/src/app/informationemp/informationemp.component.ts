import { Component, OnInit } from '@angular/core';
import {HttpClient} from '@angular/common/http';
// tslint:disable-next-line:import-spacing
import { Controller } from'../controller/controller';
import { RouterModule, Routes } from '@angular/router';
import { Router } from '@angular/router';

@Component({
  selector: 'app-informationemp',
  templateUrl: './informationemp.component.html',
  styleUrls: ['./informationemp.component.css']
})
export class InformationempComponent implements OnInit {

  position: Array<any>;
  positionid = '';

  gender: Array<any>;
  genderid = '';

  bank: Array<any>;
  bankempid = '';

 firstname: Array<any>;
 lastname: Array<any>;
 phone: Array<any>;
 address: Array<any>;
 banknumber: Array<any>;
 email: Array<any>;
 password: Array<any>;


   views: any = {

  firstname: '',
  lastname: '',
  genderid: '',
  phone: '',
  address: '',
  positionid: '',
  bankempid: '',
  banknumber: '',
  email: '',
  password: '',
 };

constructor(private controller: Controller, private httpClient: HttpClient ,private router: Router) { }

 ngOnInit() {

 this.controller.getPosition().subscribe(data => {
           this.position = data;
           console.log(this.position);
         });

 this.controller.getgender().subscribe(data => {
           this.gender = data;
           console.log(this.gender);
         });
 this.controller.getBankemp().subscribe(data => {
           this.bank = data;
           console.log(this.bank);
         });

 }
 save() {

 if (this.views.firstname == null || this.views.firstname == '') {
         alert('กรุณาเระบุชื่อ');
       }
       else if (this.views.lastname == null || this.views.lastname == '') {
         alert('กรุณาเระบุนามสกุล');
       }
       else if (this.views.genderid == null || this.views.genderid == '') {
         alert('กรุณาเลือกเพศ');
       }
       else if (this.views.phone == null || this.views.phone == '') {
         alert('กรุณาระบุเบอร์โทรศัพท์');
       }
        else if (this.views.address == null || this.views.address == '') {
          alert('กรุณาเลือกระบุที่อยู่');
        }
        else if (this.views.positionid == null || this.views.positionid == '') {
          alert('กรุณาเลือกตำแหน่ง');
        }
        else if (this.views.bankempid == null || this.views.bankempid == '') {
           alert('กรุณาเลือกธนาคาร');
        }
        else if (this.views.banknumber == null || this.views.banknumber == '') {
           alert('กรุณาระบุเลขที่บัญชี่');
        }
        else if (this.views.email == null || this.views.email == '') {
           alert('กรุณาระบุ Email');
        }
        else if (this.views.password == null || this.views.password == '') {
           alert('กรุณาระบุ Password');
        }

        else {
         console.log(this.views.firstname);
         console.log(this.views.lastname);
         console.log(this.views.genderid);
         console.log(this.views.phone);
         console.log(this.views.address);
         console.log(this.views.positionid);
         console.log(this.views.bankempid);
         console.log(this.views.banknumber);
         console.log(this.views.email);
         console.log(this.views.password);

  this.httpClient.post('http://localhost:8080/informationemp/' + this.views.firstname + '/' + this.views.lastname
                       + '/' + this.views.genderid + '/' + this.views.phone + '/' + this.views.address + '/'
                       + this.views.positionid + '/' + this.views.bankempid + '/' + this.views.banknumber + '/'
                       + this.views.email + '/' + this.views.password, this.views)
  .subscribe(
    data => {
        alert("บันทึกสำเร็จ");
                console.log('PUT Request is successful', data);
                   this.router.navigate(['/app-loginemployee']);
    },
    error => {
        console.log('Error to PUT Request', error);
         alert('กรุณากรอกข้อมูลให้ครบถ้วน');
    }
  );
}

}
}




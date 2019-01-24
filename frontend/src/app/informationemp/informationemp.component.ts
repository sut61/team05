import { Component, OnInit } from '@angular/core';
import {HttpClient} from '@angular/common/http';
// tslint:disable-next-line:import-spacing
import { Controller } from'../controller/controller';


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

constructor(private controller: Controller, private httpClient: HttpClient) { }

 ngOnInit() {

 this.controller.getPosition().subscribe(data => {
           this.position = data;
           console.log(this.position);
         });

 this.controller.getGender().subscribe(data => {
           this.gender = data;
           console.log(this.gender);
         });
 this.controller.getBankemp().subscribe(data => {
           this.bank = data;
           console.log(this.bank);
         });

 }
 save() {
  this.httpClient.post('http://localhost:8080/informationemp/' + this.views.firstname + '/' + this.views.lastname
                       + '/' + this.views.genderid + '/' + this.views.phone + '/' + this.views.address + '/'
                       + this.views.positionid + '/' + this.views.bankempid + '/' + this.views.banknumber + '/'
                       + this.views.email + '/' + this.views.password, this.views)
  .subscribe(
    data => {
        console.log('PUT Request is successful', data);
    },
    error => {
        console.log('Error to PUT Request', error);
    }
  );
}

}




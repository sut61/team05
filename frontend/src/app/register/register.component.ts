import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Controller } from'../controller/controller';
import { Router } from '@angular/router';

@Component({
selector: 'app-register',
templateUrl: './register.component.html',
styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {
province: Array<any>;
provincesenNameSelect='';

gender: Array<any>;
genderNameSelect='';

firstnamesenInput: Array<any>;
lastnamesenInput: Array<any>;
addresssenInput: Array<any>;
postcodesenInput: Array<any>;
phonesenInput: Array<any>;
emailInput: Array<any>;
passwordInput: Array<any>;

views: any = {

firstnamesenInput: '',
lastnamesenInput: '',
genderNameSelect:'',
addresssenInput: '',
provincesenNameSelect:'',
postcodesenInput:'',
phonesenInput:'',
emailInput:'',
passwordInput:''

};

constructor(private controller:Controller,private httpClient: HttpClient,private router: Router) { }

  ngOnInit() {
  this.controller.getprovince().subscribe(data => {
            this.province = data;
            console.log(this.province);
          });

  this.controller.getgender().subscribe(data => {
            this.gender = data;
            console.log(this.gender);
          });

  }
  save() {

      if(this.views.firstnamesenInput==null){
        alert('No found');
      }else if(this.views.lastnamesenInput==null){
        alert('No found');
      }else if(this.views.genderNameSelect==null){
        alert('No found');
      }else if(this.views.addresssenInput==null){
        alert('No found');
      }else if(this.views.provincesenNameSelect==null){
        alert('No found');
      }else if(this.views.postcodesenInput==null){
        alert('No found');
      }else if(this.views.phonesenInput==null){
        alert('No found');
      }else if(this.views.emailInput==null){
        alert('No found');
      }else if(this.views.passwordInput==null){
        alert('No found');
      }else{
      this.save_func();
    }
}
    save_func(){
    this.httpClient.post('http://localhost:8080/sender/'+ this.views.firstnamesenInput +'/' + this.views.lastnamesenInput
                        + '/' + this.views.genderNameSelect+ '/' + this.views.addresssenInput
                        + '/' + this.views.provincesenNameSelect
                        + '/' + this.views.postcodesenInput
                        + '/' + this.views.phonesenInput + '/' + this.views.emailInput
                        + '/' + this.views.passwordInput,this.views)
        .subscribe(
             data => {
                 console.log('PUT Request is successful', data);
                 alert('success');
                 this.router.navigate(['/login']);
             },
             error => {
                  console.log('Error', error);
                  alert('กรุณากรอกข้อมูลให้ครบถ้วน');
            }
    );
    }
}




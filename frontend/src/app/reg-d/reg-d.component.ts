import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Controller } from'../controller/controller';
import { Router } from '@angular/router';

@Component({
selector: 'app-reg-d',
templateUrl: './reg-d.component.html',
styleUrls: ['./reg-d.component.css']
})
export class RegDComponent implements OnInit {
province: Array<any>;
provinceNameSelect='';

firstnamerecInput: Array<any>;
lastnamerecInput: Array<any>;
addressrecInput: Array<any>;
postcoderecInput: Array<any>;
phonerecInput: Array<any>;

views: any = {

firstnamerecInput: '',
lastnamerecInput: '',
addressrecInput: '',
provinceNameSelect:'',
postcoderecInput:'',
phonerecInput:'',

};

constructor(private controller: Controller, private httpClient: HttpClient, private router: Router) { }

  ngOnInit() {

    this.controller.getprovince().subscribe(data => {
      this.province = data;
      console.log(this.province);
    });

  }

  save() {
      if(this.views.firstnamerecInput==null){
        alert('No found');
      }else if(this.views.lastnamerecInput==null){
        alert('No found');
      }else if(this.views.addressrecInput==null){
        alert('No found');
      }else if(this.views.provinceNameSelect==null){
        alert('No found');
      }else if(this.views.postcoderecInput==null){
        alert('No found');
      }else if(this.views.phonerecInput==null){
        alert('No found');
      }else{
      this.save_func();
    }
  }
    save_func(){
    this.httpClient.post('http://localhost:8080/receiver/' + this.views.firstnamerecInput + '/' + this.views.lastnamerecInput
                        + '/' + this.views.addressrecInput + '/' + this.views.provinceNameSelect + '/' +
                        this.views.postcoderecInput + '/' + this.views.phonerecInput, this.views)
        .subscribe(
             data => {
                 console.log('PUT Request is successful', data);
                 alert('บันทึกสำเร็จ');
                 this.router.navigate(['/login']);

             },
             error => {
                  console.log('Error', error);
                  alert('กรุณากรอกข้อมูลให้ครบถ้วน');
            }
    );
    }
  }


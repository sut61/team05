import { Component, OnInit } from '@angular/core';

import { HttpClient } from '@angular/common/http';

import{Controller}from'../controller/controller';
import { viewStart } from '@angular/core/src/render3/instructions';


@Component({
  selector: 'app-carinformation',
  templateUrl: './carinformation.component.html',
  styleUrls: ['./carinformation.component.css']
})



export class CarinformationComponent implements OnInit {
  
  gender: Array<any>;
  car: Array<any>;
  province: Array<any>;
  carInformation: Array<any>;

  name:Array<any>;

  address:Array<any>;

  telephone:Array<any>;

  age:Array<any>;

 
  
  views: any = {
    name:'',
    address:'',
    telephone:'',
    age:'',
    gender:'',
    carbrand:' ',
    province:'',
    licenseplate:''
    
};


  constructor(private controller:Controller,private httpClient: HttpClient) { }


  ngOnInit() {
    this.controller.getGender().subscribe(data => {
      this.gender = data;
      console.log(this.gender);
});

this.controller.getCarbrand().subscribe(data => {
      this.car= data;
      console.log(this.car);
});

this.controller.getProvince().subscribe(data => {
      this.province = data;
      console.log(this.province);  
});
this.controller.getCarInformation().subscribe(data => {
      this.carInformation = data;
      console.log(this.carInformation);
});

   
  }

  save() {
   
    if(this.views.name==''){
      alert('No found name');
    }else if(this.views.address==''){
      alert('No found address');
    }else if(this.views.telephone==''){
        alert('No found telephone');
    }else if(this.views.age==''){
        alert('No found age');
    }else if(this.views.gender==''){
        alert('No found gender');
    }else if(this.views.carbrand==''){
        alert('No found carbrand');
    }else if(this.views.provice==''){
      alert('No found provice');
    }else if(this.views.licenseplate!=''){
      alert('No found');
    }else{
      this.save_func();
    }
  }
      save_func(){
        
     this.httpClient.post('http://localhost:8080/CarInformation/'+ this.views.name + '/' + this.views.address + '/' + this.views.telephone + '/' + this.views.age + '/' + this.views.gender + '/' + this.views.carbrand + '/'  + this.views.provice,this.views)
        .subscribe(
          data => {
            console.log('PUT Request is successful', data);
          },
          error => {
            console.log('Error', error);
          }

        );


  }
  

}

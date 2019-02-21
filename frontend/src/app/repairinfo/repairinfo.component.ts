import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import {FormControl, Validators} from '@angular/forms';
import { HttpClient} from '@angular/common/http';
import { RepairinfoService, Repairinfo } from '../shared/repairinfo.service';

export interface Tool {
  name: string;
  name1: string;
  name2: string;
}

@Component({
  selector: 'app-repairinfo',
  templateUrl: './repairinfo.component.html',
  styleUrls: ['./repairinfo.component.css']
})
export class RepairinfoComponent implements OnInit {

  repairinfo: Repairinfo = new Repairinfo(); 
  cars: Array<any>;
  damages: Array<any>;
  drivers: Array<any>;
  repairinfos: Array<any>;

 /* toolControl = new FormControl('', [Validators.required]);
  selectFormControl = new FormControl('', Validators.required);
  tool: Tool[] = [
    {name: 'A', name1: 'นายA', name2: ' หม้อน้ำ'},
    {name: 'B', name1: 'นายB', name2: ' ยางรถยนตร์'},
  ]; */

  constructor( 
  private service: RepairinfoService , private httpClient: HttpClient) { }

  ngOnInit() {
    this.service.getName().subscribe(data => {
      this.drivers = data;
      console.log(this.drivers);
    });

    this.service.getDamage().subscribe(data => {
      this.damages= data;
      console.log(this.damages);
    });

    this.service.getCar().subscribe(data => {
      this.cars = data;
      console.log(this.cars);
    });

    this.service.getRepairinfo().subscribe(data => {
      this.repairinfos = data;
      console.log(this.repairinfos);
    });
  }

  save(){
    if(this.repairinfo.driver == '' || this.repairinfo.driver == null){
      alert('กรุณาระบุชื่อ')
    }else if(this.repairinfo.car == '' || this.repairinfo.car == null){
      alert('กรุณาระบุทะเบียนรถ')
    }else if(this.repairinfo.damage == '' || this.repairinfo.damage == null){
      alert('กรุณาระบุความเสียหาย')
    }else if(this.repairinfo.phone == '' || this.repairinfo.phone == null){
      alert('กรุณาระบุเบอร์โทรศัพท์')
    } else {
    console.log(this.repairinfo.driver.carInformationId);
    console.log(this.repairinfo.car.carId);
    console.log(this.repairinfo.damage.damageId);
    console.log(this.repairinfo.phone);
    this.httpClient.post('//localhost:8080/Repairinfo/' 
    + this.repairinfo.driver.carInformationId + '/' 
    + this.repairinfo.car.carId + '/' 
    + this.repairinfo.damage.damageId + '/'
    + this.repairinfo.phone,this.repairinfo)
    .subscribe(
      data => {
          alert("บันทึกสำเร็จ")
          console.log('PUT Request is successful', data);
      },
      error => {
          console.log('Fail', error);
          alert("Fail");
      }
    );
  }
}

}

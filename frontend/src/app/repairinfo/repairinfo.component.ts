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
  repairinfo1s: Array<any>;

 /* toolControl = new FormControl('', [Validators.required]);
  selectFormControl = new FormControl('', Validators.required);
  tool: Tool[] = [
    {name: 'A', name1: 'นายA', name2: ' หม้อน้ำ'},
    {name: 'B', name1: 'นายB', name2: ' ยางรถยนตร์'},
  ]; */

  constructor( 
  private service: RepairinfoService , private httpClient: HttpClient) { }

  ngOnInit() {
    this.service.getDriver().subscribe(data => {
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
      this.repairinfo1s = data;
      console.log(this.repairinfo1s);
    });
  }

  save(){
    console.log(this.repairinfo.driver.driverId);
    console.log(this.repairinfo.car.carId);
    console.log(this.repairinfo.damage.damageId);
    console.log(this.repairinfo.phone);
    this.httpClient.post('//localhost:8080/Repairinfo/' + this.repairinfo.driver.driverId + '/' + this.repairinfo.car.carId + '/' + this.repairinfo.damage.damageId + '/'
    + this.repairinfo.phone,this.repairinfo)
    .subscribe(
      data => {
          alert("บันทึกสำเร็จ")
          console.log('PUT Request is successful', data);
      },
      error => {
          console.log('Error to PUT Request', error);
          alert("You shall not pass");
      }
    );
  }

}

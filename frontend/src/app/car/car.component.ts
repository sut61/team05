import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { CarService } from '../shared/car.service';
import { Router } from "@angular/router";

@Component({
  selector: 'app-car',
  templateUrl: './car.component.html',
  styleUrls: ['./car.component.css']
})
export class CarComponent implements OnInit {

  nameCarBrand : Array<any>
  licenseplate : Array<any>
  carcode : Array<any>
  typecar : Array<any>
  nameprovince : Array<any>
  namecompany : Array<any>
  

  select: any = {
    nameCarBrand : '',
    licenseplate : '',
    carcode : '',
    typecar : '',
    nameprovince : '',
    namecompany : ''
  }

  constructor(private router:Router, private carService: CarService,private http: HttpClient) { }

  ngOnInit() {
    this.carService.getCarBrand().subscribe(data => {
      this.nameCarBrand = data;
      console.log(this.nameCarBrand);
    });

    this.carService.getCar().subscribe(data => {
      this.licenseplate = data;
      console.log(this.licenseplate);
    });
    this.carService.getProvince().subscribe(data => {
      this.nameprovince = data;
      console.log(this.nameprovince);
    });
    this.carService.getCarInsurance().subscribe(data => {
      this.namecompany = data;
      console.log(this.namecompany);
    });
  }

  save() {
    if (this.select.nameCarBrand == null || this.select.nameCarBrand == '') {
      alert('กรุณาเลือกยี่ห้อรถ');
    }
    else if (this.select.licenseplate == null || this.select.licenseplate == '') {
      alert('กรุณาระบุเลขทะเบียนรถ');
    }
    else if (this.select.carcode == null || this.select.carcode == '') {
      alert('กรุณาระบุรหัสรถ');
    }
    else if (this.select.typecar == null || this.select.typecar == '') {
      alert('กรุณาระบุประเภทรถ');
    }
    else if (this.select.nameprovince == null || this.select.nameprovince == '') {
      alert('กรุณาเลือกจังหวัด');
    }
    else if (this.select.namecompany == null || this.select.namecompany == '') {
      alert('กรุณาเลือกบริษัทประกันภัย');
    } else {
      console.log(this.select.nameCarBrand);
      console.log(this.select.licenseplate);
      console.log(this.select.carcode);
      console.log(this.select.typecar);
      console.log(this.select.nameprovince);
      console.log(this.select.namecompany);
    this.http.post('http://localhost:8080/cars/' + this.select.nameCarBrand + '/' + this.select.licenseplate 
    + '/' + this.select.carcode + '/' + this.select.typecar + '/' + this.select.nameprovince + '/' + this.select.namecompany ,this.select)
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

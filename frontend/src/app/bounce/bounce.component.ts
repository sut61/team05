import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';
import { BounceService } from '../shared/bounce/bounce.service';
import {SelectionModel} from '@angular/cdk/collections';
import {MatTableDataSource} from '@angular/material';

@Component({
selector: 'app-bounce',
templateUrl: './bounce.component.html',
styleUrls: ['./bounce.component.css']
})

export class BounceComponent implements OnInit {

    senders: Array<any>;
    provinces: Array<any>;
    receivers: Array<any>;
    provinces1: Array<any>;
    typeproducts: Array<any>;

  views: any = {
    senderSelect: '',
    provincesenSelect: '',
    receiverSelect: '',
    provinceSelect: '',
    reasonInput: '',
    typeproductNameSelect:'',
};

  constructor(private BounceService: BounceService, private httpClient: HttpClient, private router: Router) { }

  ngOnInit() {

    this.BounceService.getTypeproduct().subscribe(data => {
      this.typeproducts = data;
      console.log(this.typeproducts);
      });

    this.BounceService.getSender().subscribe(data => {
      this.senders = data;
      console.log(this.senders);
    });

    this.BounceService.getReceiver().subscribe(data => {
      this.receivers = data;
      console.log(this.receivers);
    });

    this.BounceService.getProvince().subscribe(data => {
      this.provinces = data;
      console.log(this.provinces);
    });

    this.BounceService.getProvince().subscribe(data => {
      this.provinces1 = data;
      console.log(this.provinces1);
    });

  }

  save_func(){
    this.httpClient.post('http://localhost:8080/bounce/' + this.views.senderSelect + '/' + this.views.provincesenSelect + '/' +  this.views.receiverSelect + '/' + this.views.provinceSelect + '/' + this.views.reasonInput + '/' + this.views.typeproductNameSelect,this.views)
        .subscribe(
             data => {
                 console.log('PUT Request is successful', data);
                 alert('success');
             },
             error => {
                  console.log('Error', error);
                  alert('กรุณากรอกข้อมูลให้ครบถ้วน');
            }
    );
    }

}

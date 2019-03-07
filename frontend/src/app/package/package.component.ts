import { Component, OnInit } from '@angular/core';
import { PackageService } from '../shared/package/package.service';
import { Router } from '@angular/router';
import { MatDialogRef } from '@angular/material';
import { HttpClient} from '@angular/common/http';
import { Employee } from '../employee';

@Component({
  selector: 'app-package',
  templateUrl: './package.component.html',
  styleUrls: ['./package.component.css']
})
export class PackageComponent implements OnInit {

senders: Array<any>;
receivers: Array<any>;
provinces: Array<any>;

employee = new Employee();
packNum = '';
supply = '';
price = '';
senderSelect = '';
receiverSelect = '';
provinceSelect = '';

noti: boolean;
message: String;

  constructor(private httpClient: HttpClient, private router: Router, private PackageService: PackageService) {
    PackageService.currentEmployee.subscribe(data =>{
        this.employee = data
      })
   }

  ngOnInit() {

    this.noti = true;

    this.PackageService.getSender().subscribe(data => {
      this.senders = data;
      console.log(this.senders);
    });

    this.PackageService.getReceiver().subscribe(data => {
      this.receivers = data;
      console.log(this.receivers);
    });

    this.PackageService.getProvince().subscribe(data => {
      this.provinces = data;
      console.log(this.provinces);
    });

  }
  cancel() {
    this.router.navigate(['/app-menu']);
  }

  save() {
    if (this.senderSelect === '' || this.supply === '' || this.receiverSelect === '' || this.provinceSelect === '' ||
        this.packNum === '' || this.price === '') {
      this.noti = false;
      this.message = 'กรอกข้อมูลให้ครบถ้วน'

    } else {
      this.httpClient.post('http://localhost:8080/package/' + this.senderSelect + '/' + this.supply + '/' + this.price +
                            '/' +this.receiverSelect +'/' + this.packNum + '/' + this.provinceSelect + '/' +
                            this.employee.informationempid, {})
      .subscribe(
          data => {
              this.noti = false;
              this.message = 'บันทึกสำเร็จ';
              console.log('PUT Request is successful', data);
              this.reset_func();

          },
          error => {
                    this.noti = false;
                    this.message = 'บันทึกล้มเหลว'
                    console.log('Error to PUT Request', error);
                    this.reset_func();
                }
      );
    }
  }

  reset_func() {
    this.PackageService.getSender().subscribe(data => {
          this.senders = data;
          console.log(this.senders);
        });

        this.PackageService.getReceiver().subscribe(data => {
          this.receivers = data;
          console.log(this.receivers);
        });

        this.PackageService.getProvince().subscribe(data => {
          this.provinces = data;
          console.log(this.provinces);
        });

        this.packNum = '';
        this.price = '';
        this.senderSelect = '';
        this.supply = '';
        this.receiverSelect = '';
        this.provinceSelect = '';

  }

}

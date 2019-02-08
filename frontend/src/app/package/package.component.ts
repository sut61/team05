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
supply = '';
senderSelect = '';
receiverSelect = '';
provinceSelect = '';

  constructor(private httpClient: HttpClient, private router: Router, private PackageService: PackageService) {
    PackageService.currentEmployee.subscribe(data =>{
        this.employee = data
      })
   }

  ngOnInit() {
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
    if (this.senderSelect === '' || this.supply === '' || this.receiverSelect === '' || this.provinceSelect === '') {
      alert('กรุณากรอกข้อมูลให้ครบถ้วน');

    } else {
      this.httpClient.post('http://localhost:8080/package/' + this.senderSelect + '/' + this.supply +
                            '/' +this.receiverSelect +'/' + this.provinceSelect + '/' + this.employee.informationempid, {})
      .subscribe(
          data => {
              alert("บันทึกสำเร็จ");
              console.log('PUT Request is successful', data);

              this.reset_func();
              //this.router.navigate(['/app-menu']);
          },
          error => {
                    alert("fail");
                    console.log('Error to PUT Request', error);
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

        this.senderSelect = '';
        this.supply = '';
        this.receiverSelect = '';
        this.provinceSelect = '';
  }

}

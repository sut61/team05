import { Component, OnInit } from '@angular/core';
import { PackageService } from '../shared/package/package.service';
import { Router } from '@angular/router';
import { MatDialogRef } from '@angular/material';
import { HttpClient} from '@angular/common/http';
import { Employee } from '../employee';

@Component({
  selector: 'app-bill',
  templateUrl: './bill.component.html',
  styleUrls: ['./bill.component.css']
})
export class BillComponent implements OnInit {

carries: Array<any>;
statuses: Array<any>;

employee = new Employee();
carryNo = '';
recName = '';
paid = '';
phone = '';
status = '';

noti: boolean;
message: String;

  constructor(private httpClient: HttpClient, private router: Router, private PackageService: PackageService) {
      PackageService.currentEmployee.subscribe(data =>{
          this.employee = data
        })
     }

  ngOnInit() {

    this.noti = true;

    this.PackageService.getStatus().subscribe(data => {
          this.statuses = data;
          console.log(this.statuses);
        });

    this.PackageService.getCarry().subscribe(data => {
         this.carries = data;
         console.log(this.carries);
        });
  }

  cancel() {
      this.router.navigate(['/app-menu']);
    }

   save() {
       if (this.carryNo === '' || this.recName === '' || this.phone === '' || this.status === '' || this.paid === '') {
         this.noti = false;
         this.message = 'กรุณากรอกข้อมูลให้ครบถ้วน';
       } else {
         this.httpClient.post('http://localhost:8080/bill/' + this.employee.informationempid + '/' + this.carryNo +
                               '/' +this.recName +'/' + this.phone + '/' + this.status + '/' +this.paid, {})
         .subscribe(
             data => {
                 this.noti = false;
                 this.message = 'บันทึกสำเร็จ';
                 console.log('PUT Request is successful', data);
                 this.reset_func();
             },
             error => {
                       this.noti = false;
                       this.message = 'บ ันทึกล้มเหลว';
                       console.log('Error to PUT Request', error);
                       this.reset_func();
                   }
         );
       }
     }

     reset_func() {
         this.PackageService.getStatus().subscribe(data => {
               this.statuses = data;
               console.log(this.statuses);
             });

             this.PackageService.getCarry().subscribe(data => {
               this.carries = data;
               console.log(this.carries);
             });

             this.carryNo = '';
             this.recName = '';
             this.phone = '';
             this.status = '';
             this.paid = '';
       }
}

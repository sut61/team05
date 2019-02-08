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
phone = '';
status = '';

  constructor(private httpClient: HttpClient, private router: Router, private PackageService: PackageService) {
      PackageService.currentEmployee.subscribe(data =>{
          this.employee = data
        })
     }

  ngOnInit() {
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
       if (this.carryNo === '' || this.recName === '' || this.phone === '' || this.status === '') {
         alert('กรุณากรอกข้อมูลให้ครบถ้วน');
       } else {
         this.httpClient.post('http://localhost:8080/bill/' + this.employee.informationempid + '/' + this.carryNo +
                               '/' +this.recName +'/' + this.phone + '/' + this.status, {})
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
       }
}

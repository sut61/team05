import { Component, OnInit } from '@angular/core';
import { PackageService } from '../shared/package/package.service';
import { Router } from '@angular/router';
import { Employee } from '../employee';

@Component({
  selector: 'app-loginemployee',
  templateUrl: './loginemployee.component.html',
  styleUrls: ['./loginemployee.component.css']
})
export class LoginemployeeComponent implements OnInit {
user: string
password: string
employee : Employee
constructor(private PackageService: PackageService, private router: Router) {

  }

  ngOnInit() {
  }
  login() {
    this.PackageService.login(this.user, this.password).subscribe(
      data => {
        if (data != null) {
          this.employee = data

          this.PackageService.setEmployee(this.employee)
          this.router.navigate(['/app-menu']);
        }else{
          alert("Username หรือ Password ไม่ถูกต้อง")
        }
      })

  }

}

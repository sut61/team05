import { Component, OnInit } from '@angular/core';
import { Controller }from'../controller/controller';
import { Router } from '@angular/router';
import { MatDialog, MatDialogRef, MAT_DIALOG_DATA} from '@angular/material';
import { IncorrectComponent } from '../incorrect/incorrect.component';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})

export class LoginComponent implements OnInit {
email : string ;
password : string ;
sender : Array<any>;
count : number ;
a:any;

  constructor(
  private controller:Controller,
  private router: Router,
  public dialog: MatDialog,
  ) { }
  openDialog(): void {
    const dialogRef = this.dialog.open(IncorrectComponent, {
      width: '250px',
    });

    dialogRef.afterClosed().subscribe(result => {
      console.log('The dialog was closed');

    });
  }

  ngOnInit() {
  this.controller.getsender().subscribe(data => {
  this.sender = data ;
  console.log(data);
  });
  }

  login(){
  this.count=0;
  for(this.a in this.sender){
    if(this.email == this.sender[this.a].email && this.password == this.sender[this.a].password){
      this.count++;
      this.func_login();
    }
    }
    if(this.count === 0){
      alert("Fail");
      this.count = 0;
    }
  }

  func_login(){
    alert("Success");
    this.router.navigate(['reg-d']);
  }
}


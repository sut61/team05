
import { Component, OnInit } from '@angular/core';
import { HttpClient} from '@angular/common/http';
import {  Router } from '@angular/router';
import { Controller } from'../controller/controller';

@Component({
  selector: 'app-slip',
  templateUrl: './slip.component.html',
  styleUrls: ['./slip.component.css']
})
export class SlipComponent implements OnInit {

   salary:Array<any>
    constructor(private httpClient: HttpClient,private router: Router,private controller: Controller) { }

    ngOnInit() {

      this.controller.getSalary().subscribe(data => {
        this.salary = data;
        console.log(this.salary);
      });
    }

}


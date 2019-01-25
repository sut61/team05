import { Component, OnInit } from '@angular/core';
import { PackageService } from '../shared/package/package.service';
import { Observable } from 'rxjs';
import { Employee } from '../employee';

@Component({
  selector: 'app-menu',
  templateUrl: './menu.component.html',
  styleUrls: ['./menu.component.css']
})
export class MenuComponent implements OnInit {

  constructor() { }

  ngOnInit() {
  }

}

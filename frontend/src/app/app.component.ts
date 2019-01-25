import { NgModule } from '@angular/core';
import { Component } from '@angular/core';
import { Routes , RouterModule } from '@angular/router';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { NoopAnimationsModule } from '@angular/platform-browser/animations';

import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { IceComponent } from './ice/ice.component';



const routes: Routes = [
    { path: '', component:LoginComponent },
    { path: 'login', component:LoginComponent },
    { path: 'register',component: RegisterComponent },
    { path: 'ice' ,component:IceComponent },



];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],

})

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = '';
}

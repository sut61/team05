import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppComponent } from './app.component';
import { HttpClientModule } from '@angular/common/http';
import { MatButtonModule, MatCardModule, MatInputModule, MatListModule, MatToolbarModule, MatDatepickerModule, MatNativeDateModule, MatRadioModule } from '@angular/material';
import { FormsModule } from '@angular/forms';
import { RouterModule, Routes } from '@angular/router';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { NoopAnimationsModule } from '@angular/platform-browser/animations';
import { MatCheckboxModule } from '@angular/material';
import { MatSelectModule } from '@angular/material/select';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatDialogModule } from '@angular/material/dialog';
import { MatSlideToggleModule } from '@angular/material/slide-toggle';
import { MatIconModule } from '@angular/material/icon';
import { MatTableModule } from '@angular/material/table';
import { MatMenuModule } from '@angular/material/menu';

import { Controller } from './controller/controller';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { IncorrectComponent } from './incorrect/incorrect.component';
import { RegDComponent } from './reg-d/reg-d.component';
import { IceComponent } from './ice/ice.component';
import { RepairinfoComponent } from './repairinfo/repairinfo.component';
import { InformationempComponent } from './informationemp/informationemp.component';
import { CarinformationComponent } from './carinformation/carinformation.component';


const appRoutes: Routes = [
    { path: 'login', component:LoginComponent },
    { path: 'register',component: RegisterComponent },
    { path: 'incorrect',component: IncorrectComponent },
    { path: 'reg-d' ,component:RegDComponent },
    { path: 'ice' ,component:IceComponent },
    { path: 'repairinfo', component: RepairinfoComponent },
    { path: 'informationemp', component: InformationempComponent },


];

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    RegisterComponent,
    IncorrectComponent,
    RegDComponent,
    IceComponent,
    RepairinfoComponent,
    InformationempComponent,
    CarinformationComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    BrowserAnimationsModule,
    MatButtonModule,
    MatCardModule,
    MatInputModule,
    MatListModule,
    MatToolbarModule,
    FormsModule,
    RouterModule.forRoot(appRoutes),
    BrowserAnimationsModule,
    NoopAnimationsModule,
    MatCheckboxModule,
    MatDatepickerModule,
    MatNativeDateModule,
    MatSelectModule,
    MatRadioModule,
    MatFormFieldModule,
    MatMenuModule,
    MatTableModule,
    MatDialogModule,
    MatSlideToggleModule,
    MatIconModule,

  ],
  providers: [Controller],
  bootstrap: [AppComponent]
})
export class AppModule { }



import { BrowserModule } from '@angular/platform-browser';
import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
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
import {MatExpansionModule} from '@angular/material/expansion';
import { MatButtonToggleModule } from '@angular/material/button-toggle';

import { Controller } from './controller/controller';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { IncorrectComponent } from './incorrect/incorrect.component';
import { RegDComponent } from './reg-d/reg-d.component';
import { IceComponent } from './ice/ice.component';
import { InformationempComponent } from './informationemp/informationemp.component';
import { CarinformationComponent } from './carinformation/carinformation.component';
import { CarryComponent } from './carry/carry.component';
import { LoginemployeeComponent } from './loginemployee/loginemployee.component';
import { MenuComponent } from './menu/menu.component';
import { RepairinfoComponent } from './repairinfo/repairinfo.component';
import { PackageComponent } from './package/package.component';
import { PackageService } from './shared/package/package.service';
import { CarComponent } from './car/car.component';
import { CarService } from './shared/car.service';
import { BillComponent } from './bill/bill.component';
import { BounceComponent } from './bounce/bounce.component';
import { BounceService } from './shared/bounce/bounce.service';
import { SalaryComponent } from './salary/salary.component';
import { SlipComponent } from './slip/slip.component';
import { CommentComponent } from './comment/comment.component';
import { CarcontrolComponent } from './carcontrol/carcontrol.component';
import { CarcontrolService } from './shared/Carcontrol/carcontrol.service';


const appRoutes: Routes = [
    { path: '', redirectTo: '/ice', pathMatch: 'full' },
    { path: 'ice' ,component:IceComponent },
    { path: 'login', component:LoginComponent },
    { path: 'register',component: RegisterComponent },
    { path: 'incorrect',component: IncorrectComponent },
    { path: 'reg-d' ,component:RegDComponent },
    { path: 'informationemp', component: InformationempComponent },
    { path: 'carinformation', component: CarinformationComponent},
    { path: 'carry', component: CarryComponent},
    { path: 'app-loginemployee',component: LoginemployeeComponent},
    { path: 'app-menu',component: MenuComponent},
    { path: 'app-package',component: PackageComponent},
    { path: 'repairinfo', component: RepairinfoComponent },
    { path: 'car', component: CarComponent },
    { path: 'bill', component: BillComponent },
    { path: 'salary',component: SalaryComponent },
    { path: 'slip',component: SlipComponent },
    { path: 'bounce' ,component:BounceComponent },
    { path: 'comment', component: CommentComponent },
    { path: 'carcontrol',component: CarcontrolComponent}

];

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    RegisterComponent,
    IncorrectComponent,
    RegDComponent,
    IceComponent,
    InformationempComponent,
    CarinformationComponent,
    CarryComponent,
    LoginemployeeComponent,
    MenuComponent,
    PackageComponent,
    RepairinfoComponent,
    CarComponent,
    BillComponent,
    SalaryComponent,
    SlipComponent,
    BounceComponent,
    CommentComponent,
    CarcontrolComponent

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
    MatExpansionModule,
    MatButtonToggleModule

  ],
  schemas: [ CUSTOM_ELEMENTS_SCHEMA],
  providers: [Controller, PackageService, CarService, BounceService,CarcontrolService],
  bootstrap: [AppComponent]
})
export class AppModule { }



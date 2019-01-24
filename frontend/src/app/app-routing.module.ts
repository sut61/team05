import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RepairinfoComponent } from './repairinfo/repairinfo.component';
import { RouterModule, Routes } from '@angular/router';

const appRoutes: Routes = [
  { path: 'repairinfo', component: RepairinfoComponent },
  { path: '',redirectTo: '/repairinfo',pathMatch: 'full'},
 
];

@NgModule({
  imports: [
    RouterModule.forRoot(appRoutes),
  ],
  exports: [RouterModule]
})
export class AppRoutingModule { }

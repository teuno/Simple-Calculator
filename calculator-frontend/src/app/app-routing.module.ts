import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { EditCalculationComponent } from './components/edit-calculation/edit-calculation.component';
import { ListCalculationsComponent } from './components/list-calculations/list-calculations.component';

const routes: Routes = [
  {
    path: 'list-calculations',
    component: ListCalculationsComponent
  },
  {
    path: 'create-calculation',
    component: EditCalculationComponent
  },
  {
    path: '',
    redirectTo: 'list-calculations',
    pathMatch: 'full'
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {}

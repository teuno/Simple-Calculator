import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { EditCalculationComponent } from './components/edit-calculation/edit-calculation.component';

const routes: Routes = [
  {
    path: 'create-calculation',
    component: EditCalculationComponent
  },
  {
    // todo make a still to calculations component the main component.
    path: '',
    redirectTo: 'create-calculation',
    pathMatch: 'full'
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {}

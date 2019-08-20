import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { MatButtonModule,
  MatToolbarModule,
  MatCardModule,
  MatInputModule,
  MatProgressSpinnerModule } from '@angular/material';

const modules = [
  MatButtonModule,
  MatToolbarModule,
  MatCardModule,
  MatInputModule,
  MatProgressSpinnerModule,
];

@NgModule({
  declarations: [],
  imports: [
    CommonModule,
    modules,
  ],
  exports : [
    CommonModule,
    modules,
  ],
})
export class CustomMaterialModule { }

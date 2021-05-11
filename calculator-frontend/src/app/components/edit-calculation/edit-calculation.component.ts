import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { CalculatorService } from '../../services/calculator.service';
import { Calculation } from '../../dto/Calculation';

@Component({
  selector: 'app-edit-calculation',
  templateUrl: './edit-calculation.component.html',
  styleUrls: ['./edit-calculation.component.css']
})
export class EditCalculationComponent implements OnInit {
  form: FormGroup;

  constructor(private calculatorService: CalculatorService, private fb: FormBuilder) {
    this.form = this.fb.group({
      firstNumber: ['', Validators.required],
      secondNumber: ['', Validators.required], // clientside devide by 0 check to be added to have better user friendliness.
      operator: ['', Validators.required] // possible latter change to dropdown.
    });
  }

  ngOnInit(): void {}

  submit(): void {
    const calculation = new Calculation(
      this.form.controls.firstNumber.value,
      this.form.controls.secondNumber.value,
      this.form.controls.operator.value
    );
    this.calculatorService.saveCalculation(calculation);
  }
}

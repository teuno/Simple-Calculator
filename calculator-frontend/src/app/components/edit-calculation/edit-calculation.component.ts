import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { CalculatorService } from '../../services/calculator.service';
import { Calculation } from '../../model/Calculation';

@Component({
  selector: 'app-edit-calculation',
  templateUrl: './edit-calculation.component.html',
  styleUrls: ['./edit-calculation.component.css']
})
export class EditCalculationComponent implements OnInit {
  form: FormGroup;
  result = '';

  constructor(private calculatorService: CalculatorService, private fb: FormBuilder) {
    this.form = this.fb.group({
      firstNumber: ['', Validators.required],
      secondNumber: ['', Validators.required],
      operator: ['', Validators.required] // possible latter change to dropdown.
    });
  }

  ngOnInit(): void {}

  submit(): void {
    const calculation = new Calculation(
      Number(this.form.controls.firstNumber.value),
      Number(this.form.controls.secondNumber.value),
      this.form.controls.operator.value
    );
    const calculated = calculation.calculate();
    this.result = calculated[1];
    if (calculated[0]) {
      this.calculatorService.saveCalculation(calculation);
    }
  }
}

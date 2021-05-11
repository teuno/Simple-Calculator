import { Component, OnInit } from '@angular/core';
import { CalculatorService } from '../../services/calculator.service';
import { RowCalculation } from '../../dto/RowCalculation';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-list-calculations',
  templateUrl: './list-calculations.component.html',
  styleUrls: ['./list-calculations.component.css']
})
export class ListCalculationsComponent implements OnInit {
  displayedColumns: string[] = ['firstNumber', 'operator', 'secondNumber', 'outcome'];
  dataSource: Observable<RowCalculation[]> = new Observable<RowCalculation[]>();

  constructor(private calculatorService: CalculatorService) {}

  ngOnInit(): void {
    this.dataSource = this.calculatorService.getCalculations();
  }
}

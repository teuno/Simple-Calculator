import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EditCalculationComponent } from './edit-calculation.component';
import { ReactiveFormsModule } from '@angular/forms';
import { By } from '@angular/platform-browser';
import { CalculatorService } from '../../services/calculator.service';

describe('EditCalculationComponent', () => {
  let component: EditCalculationComponent;
  let fixture: ComponentFixture<EditCalculationComponent>;
  let mockCalculatorService: CalculatorService;

  beforeEach(async () => {
    mockCalculatorService = jasmine.createSpyObj('CalculatorService', ['saveCalculation']);

    await TestBed.configureTestingModule({
      // not working because keeps wanting a httpclient, but why is that needed if I mock my service...
      declarations: [EditCalculationComponent],
      imports: [ReactiveFormsModule],
      providers: [CalculatorService]
    })
      .overrideProvider(CalculatorService, { useValue: mockCalculatorService })
      .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(EditCalculationComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });

  it('form firstNumber is required.', () => {
    const firstNumber = component.form.controls.firstNumber;
    expect(firstNumber.valid).toBeFalsy();
    expect(firstNumber.pristine).toBeTruthy();
    expect(firstNumber.hasError('required')).toBeTruthy();
    firstNumber.setValue(2);
    expect(firstNumber.value).toEqual(2);
  });

  it('form operator is required.', () => {
    const operator = component.form.controls.operator;
    expect(operator.valid).toBeFalsy();
    expect(operator.pristine).toBeTruthy();
    expect(operator.hasError('required')).toBeTruthy();
    operator.setValue(2);
    expect(operator.value).toEqual(2);
  });

  it('form secondNumber is required.', () => {
    const secondNumber = component.form.controls.secondNumber;
    expect(secondNumber.valid).toBeFalsy();
    expect(secondNumber.pristine).toBeTruthy();
    expect(secondNumber.hasError('required')).toBeTruthy();
    secondNumber.setValue(2);
    expect(secondNumber.value).toEqual(2);
  });

  it('When the submit button is pressed the form is submitted', () => {
    spyOn(component, 'submit');
    component.form.controls.firstNumber.setValue(2);
    component.form.controls.operator.setValue('+');
    component.form.controls.secondNumber.setValue(2);

    fixture.debugElement.query(By.css('form')).triggerEventHandler('submit', null);
    fixture.detectChanges();
    expect(component.submit).toHaveBeenCalledTimes(1);
    // component.submit();
  });
});

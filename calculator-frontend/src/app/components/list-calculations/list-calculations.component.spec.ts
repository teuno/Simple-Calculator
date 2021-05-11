import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListCalculationsComponent } from './list-calculations.component';
import { CalculatorService } from '../../services/calculator.service';

describe('ListCalculationsComponent', () => {
  let component: ListCalculationsComponent;
  let fixture: ComponentFixture<ListCalculationsComponent>;
  let mockCalculatorService: CalculatorService;

  beforeEach(async () => {
    mockCalculatorService = jasmine.createSpyObj<CalculatorService>(['getCalculations']);

    await TestBed.configureTestingModule({
      declarations: [ListCalculationsComponent],
      providers: [
        {
          provide: CalculatorService,
          useValue: mockCalculatorService
        }
      ]
    }).compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ListCalculationsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });

  it('should call getCalculations', () => {
    expect(mockCalculatorService.getCalculations).toHaveBeenCalledTimes(1);
  });
});

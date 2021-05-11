import { TestBed } from '@angular/core/testing';

import { CalculatorService } from './calculator.service';
import { HttpClientTestingModule, HttpTestingController } from '@angular/common/http/testing';
import { RowCalculation } from '../dto/RowCalculation';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { Calculation } from '../dto/Calculation';

describe('CalculatorService', () => {
  let httpClient: HttpClient;
  let httpTestCtrl: HttpTestingController;
  let service: CalculatorService;

  beforeEach(() => {
    TestBed.configureTestingModule({
      imports: [HttpClientTestingModule],
      providers: [CalculatorService]
    });
    httpClient = TestBed.inject(HttpClient);
    httpTestCtrl = TestBed.inject(HttpTestingController);
    service = TestBed.inject(CalculatorService);
  });

  afterEach(() => {
    httpTestCtrl.verify();
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });

  it(`saveCalculation should get a statuscode of 201 `, () => {
    const testUrl = 'http://localhost:8080/api/calculations';
    const testCalculation: Calculation = new Calculation(1, 1, '+');

    service.saveCalculation(testCalculation);

    const req = httpTestCtrl.expectOne(testUrl);
    expect(req.cancelled).toBeFalsy();
    expect(req.request.responseType).toEqual('json');
    expect(req.request.method).toEqual('POST');

    const expectedResponse = new HttpResponse({ status: 201, statusText: 'Created' });
    req.event(expectedResponse);
  });

  it(`getCalculations should return a list of RowCalculations`, () => {
    const testUrl = 'http://localhost:8080/api/calculations';
    const testCalculations: RowCalculation[] = [
      {
        id: 1,
        firstNumber: 1,
        secondNumber: 1,
        operator: '+',
        outcome: 2
      },
      {
        id: 2,
        firstNumber: 5,
        secondNumber: 1,
        operator: '-',
        outcome: 4
      }
    ];

    service.getCalculations().subscribe(data => expect(data).toEqual(testCalculations));
    const req = httpTestCtrl.expectOne(testUrl);
    expect(req.cancelled).toBeFalsy();
    expect(req.request.responseType).toEqual('json');
    expect(req.request.method).toEqual('GET');
  });
});

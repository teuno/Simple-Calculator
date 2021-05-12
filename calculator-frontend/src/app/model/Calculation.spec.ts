import { Calculation } from './Calculation';

describe('Calculation', () => {
  it('firstNumber should be a number', () => {
    const calc = new Calculation(NaN, 2, '+');
    const result = calc.calculate();
    expect(result[0]).toBeFalsy();
    expect(result[1]).toEqual('please use 2 number for the calculation.');
  });

  it('secondNumber should be a number', () => {
    const calc = new Calculation(2, NaN, '+');
    const result = calc.calculate();
    expect(result[0]).toBeFalsy();
    expect(result[1]).toEqual('please use 2 number for the calculation.');
  });

  it('operator should be +,-,*,/', () => {
    const calc = new Calculation(2, 3, 'l');
    const result = calc.calculate();
    expect(result[0]).toBeFalsy();
    expect(result[1]).toEqual('please use 1 of the following operators: ,*,+,-');
  });

  it('not allowed to devide by 0', () => {
    const calc = new Calculation(2, 0, '/');
    const result = calc.calculate();
    expect(result[0]).toBeFalsy();
    expect(result[1]).toEqual('Not allowed to devide by 0');
  });

  it('valid + works', () => {
    const calc = new Calculation(2, 8, '+');
    const result = calc.calculate();
    expect(result[0]).toBeTruthy();
    expect(result[1]).toEqual('10');
  });

  it('valid - works', () => {
    const calc = new Calculation(2, 8, '-');
    const result = calc.calculate();
    expect(result[0]).toBeTruthy();
    expect(result[1]).toEqual('-6');
  });

  it('valid * works', () => {
    const calc = new Calculation(2, 8, '*');
    const result = calc.calculate();
    expect(result[0]).toBeTruthy();
    expect(result[1]).toEqual('16');
  });

  it('valid / works', () => {
    const calc = new Calculation(2, 8, '/');
    const result = calc.calculate();
    expect(result[0]).toBeTruthy();
    expect(result[1]).toEqual('0.25');
  });
});

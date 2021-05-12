export class Calculation {
  constructor(private firstNumber: number, private secondNumber: number, private operator: string) {}

  public calculate(): [boolean, string] {
    let valid = false;
    let message = this.validateFields();
    if (message === '') {
      message = '' + this._calculate();
      valid = true;
    }
    return [valid, message];
  }

  private validateFields(): string {
    let result = '';
    if (isNaN(this.firstNumber) || isNaN(this.secondNumber)) {
      result = 'please use 2 number for the calculation.';
    } else if (!['/', '*', '+', '-'].includes(this.operator)) {
      result = 'please use 1 of the following operators: ,*,+,-';
    } else if (this.operator === '/') {
      if (this.secondNumber === 0) {
        result = `Not allowed to devide by 0`;
      }
    }
    return result;
  }

  private _calculate(): number {
    if (this.operator === '/') {
      return this.firstNumber / this.secondNumber;
    }
    if (this.operator === '*') {
      return this.firstNumber * this.secondNumber;
    }
    if (this.operator === '+') {
      return this.firstNumber + this.secondNumber;
    }
    if (this.operator === '-') {
      return this.firstNumber - this.secondNumber;
    }
    return 0;
  }
}

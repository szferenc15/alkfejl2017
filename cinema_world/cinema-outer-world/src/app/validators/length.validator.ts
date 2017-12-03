import { AbstractControl, ValidatorFn } from '@angular/forms';

export class LengthValidator {

   static checkRange(min: number, max: number): ValidatorFn {
    return (c: AbstractControl): { [key: string]: boolean } | null => {
        if (c.value && (isNaN(c.value) || c.value >= min || c.value <= max)) {
          console.log('here1')
            return { 'range': true };
        }
        console.log('here2')
        return null;
    };
  }
}

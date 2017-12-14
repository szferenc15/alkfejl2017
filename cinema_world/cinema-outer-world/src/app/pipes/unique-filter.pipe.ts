import { Pipe, PipeTransform } from '@angular/core';
import * as _ from 'lodash';

@Pipe({
  name: 'uniqueFilter',
  pure: false
})
export class UniqueFilter implements PipeTransform {
  transform(value: any, name: any): any {
    if (value!== undefined && value!== null){
        return _.uniqBy(value, name);
    }
    return value;
  }
}

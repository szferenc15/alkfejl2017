import { Pipe, PipeTransform } from '@angular/core';

@Pipe({ name: 'logicalTransform' })
export class LogicalTransform implements PipeTransform {
  transform(logicalValue: boolean) {
    return logicalValue ? 'igen' : 'nem';
  }
}

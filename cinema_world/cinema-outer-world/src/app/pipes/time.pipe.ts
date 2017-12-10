import { Pipe, PipeTransform } from '@angular/core';
import { Time } from '@angular/common';

@Pipe({ name: 'time' })
export class TimePipe implements PipeTransform {
  transform(time: Time) {
    let splittedTime = time.toString().split(':');
    return splittedTime[0] + ":" + splittedTime[1];
  }
}

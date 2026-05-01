import { Pipe, PipeTransform } from '@angular/core';

// TODO Day 2: Pure pipe that returns "today" / "3 days ago" / "2 weeks ago" / "1 month ago".
@Pipe({ name: 'relativeDate', standalone: true })
export class RelativeDatePipe implements PipeTransform {
  transform(value: string | Date | null | undefined): string {
    return '';
  }
}

import { Directive } from '@angular/core';

// TODO Day 2: Custom attribute directive [appStaleApplication]="lastUpdated".
// - Adds a CSS class / inline style when lastUpdated is older than 14 days.
// - Use input() signal + effect() to react to changes.
@Directive({
  selector: '[appStaleApplication]',
  standalone: true,
})
export class StaleApplicationDirective {}

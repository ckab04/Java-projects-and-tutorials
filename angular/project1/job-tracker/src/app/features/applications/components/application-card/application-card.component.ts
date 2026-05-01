import { ChangeDetectionStrategy, Component } from '@angular/core';

// TODO Day 3: Dumb (presentational) component.
// - Use input() signals: application, highlighted.
// - Use output() for: edit, delete events.
// - Apply [appStaleApplication]="application().lastUpdated" directive.
@Component({
  selector: 'app-application-card',
  standalone: true,
  changeDetection: ChangeDetectionStrategy.OnPush,
  template: `<article class="rounded border p-4">TODO: application card</article>`,
})
export class ApplicationCardComponent {}

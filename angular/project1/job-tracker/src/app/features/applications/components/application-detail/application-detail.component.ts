import { ChangeDetectionStrategy, Component } from '@angular/core';

// TODO Day 8: Read :id route param (try withComponentInputBinding via input()).
// - Use a resolver to pre-fetch the application before the route activates.
@Component({
  selector: 'app-application-detail',
  standalone: true,
  changeDetection: ChangeDetectionStrategy.OnPush,
  template: `<section class="p-6">TODO: application detail</section>`,
})
export class ApplicationDetailComponent {}

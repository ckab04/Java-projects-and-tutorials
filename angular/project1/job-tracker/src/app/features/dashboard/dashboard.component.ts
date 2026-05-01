import { ChangeDetectionStrategy, Component } from '@angular/core';

// TODO Day 8 & 9: Dashboard.
// - Read counts from ApplicationStore computed signals.
// - Wrap the chart section in @defer (on viewport) for Day 8 deferrable views.
@Component({
  selector: 'app-dashboard',
  standalone: true,
  changeDetection: ChangeDetectionStrategy.OnPush,
  template: `<section class="p-6">TODO: dashboard</section>`,
})
export class DashboardComponent {}

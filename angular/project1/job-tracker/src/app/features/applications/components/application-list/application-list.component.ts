import { ChangeDetectionStrategy, Component } from '@angular/core';

// TODO Day 3, 6, 9: Smart component.
// - Inject ApplicationStore, drive view from its computed signals.
// - Search input wired with debounceTime + distinctUntilChanged (Day 6).
// - Use @for / @if / @empty (Day 1) and trackBy (Day 9).
@Component({
  selector: 'app-application-list',
  standalone: true,
  changeDetection: ChangeDetectionStrategy.OnPush,
  template: `<p class="p-6 text-slate-500">TODO: application list</p>`,
})
export class ApplicationListComponent {}

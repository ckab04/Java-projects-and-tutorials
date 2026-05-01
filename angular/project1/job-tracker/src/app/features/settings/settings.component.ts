import { ChangeDetectionStrategy, Component } from '@angular/core';

// TODO Day 10: Settings (theme, default filters). Persist via signal + effect to localStorage.
@Component({
  selector: 'app-settings',
  standalone: true,
  changeDetection: ChangeDetectionStrategy.OnPush,
  template: `<section class="p-6">TODO: settings</section>`,
})
export class SettingsComponent {}

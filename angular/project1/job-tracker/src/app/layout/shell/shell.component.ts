import { ChangeDetectionStrategy, Component } from '@angular/core';
import { RouterLink, RouterLinkActive, RouterOutlet } from '@angular/router';

// TODO Day 8: Top-level shell with sidebar nav (routerLink + routerLinkActive) and <router-outlet>.
@Component({
  selector: 'app-shell',
  standalone: true,
  changeDetection: ChangeDetectionStrategy.OnPush,
  imports: [RouterOutlet, RouterLink, RouterLinkActive],
  template: `
    <div class="grid min-h-dvh grid-cols-[14rem_1fr]">
      <aside class="border-r bg-white p-4">
        <h1 class="mb-4 text-lg font-semibold">Job Tracker</h1>
        <nav class="flex flex-col gap-2 text-sm">
          <a routerLink="/dashboard" routerLinkActive="font-semibold text-blue-600">Dashboard</a>
          <a routerLink="/applications" routerLinkActive="font-semibold text-blue-600">Applications</a>
          <a routerLink="/settings" routerLinkActive="font-semibold text-blue-600">Settings</a>
        </nav>
      </aside>
      <main><router-outlet /></main>
    </div>
  `,
})
export class ShellComponent {}

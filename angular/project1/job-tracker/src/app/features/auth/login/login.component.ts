import { ChangeDetectionStrategy, Component } from '@angular/core';

// TODO Day 7: Reactive form (email + password). On submit -> AuthService.login() -> router.navigate(['/']).
@Component({
  selector: 'app-login',
  standalone: true,
  changeDetection: ChangeDetectionStrategy.OnPush,
  template: `<section class="grid min-h-dvh place-items-center p-6">TODO: login</section>`,
})
export class LoginComponent {}

import { CanActivateFn } from '@angular/router';

// TODO Day 8: Implement functional guard.
// - inject(AuthService) and inject(Router)
// - return true if authenticated, otherwise router.parseUrl('/login')
export const authGuard: CanActivateFn = () => {
  return true;
};

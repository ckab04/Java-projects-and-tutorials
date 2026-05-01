import { HttpInterceptorFn } from '@angular/common/http';

// TODO Day 5: Attach Authorization: Bearer <token> header from AuthService.
export const authInterceptor: HttpInterceptorFn = (req, next) => {
  return next(req);
};

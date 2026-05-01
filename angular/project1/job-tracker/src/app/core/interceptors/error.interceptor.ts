import { HttpInterceptorFn } from '@angular/common/http';

// TODO Day 5: Catch HttpErrorResponse, surface to a toast service, rethrow.
export const errorInterceptor: HttpInterceptorFn = (req, next) => {
  return next(req);
};

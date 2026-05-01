import { HttpInterceptorFn } from '@angular/common/http';

// TODO Day 5: Log method, url, and elapsed time using performance.now() + tap().
export const loggingInterceptor: HttpInterceptorFn = (req, next) => {
  return next(req);
};

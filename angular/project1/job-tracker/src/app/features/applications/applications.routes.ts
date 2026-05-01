import { Routes } from '@angular/router';

// TODO Day 8: Wire feature routes.
// - '' -> ApplicationListComponent
// - 'new' -> ApplicationFormComponent
// - ':id' -> ApplicationDetailComponent (with resolver)
// - ':id/edit' -> ApplicationFormComponent
export const APPLICATIONS_ROUTES: Routes = [
  {
    path: '',
    loadComponent: () =>
      import('./components/application-list/application-list.component').then(
        (m) => m.ApplicationListComponent,
      ),
  },
];

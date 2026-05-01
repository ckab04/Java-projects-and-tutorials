import { Routes } from '@angular/router';
import { DashboardComponent } from './components/dashboard/dashboard';
import { BoardComponent } from './components/board/board';
import { TaskListComponent } from './components/task-list/task-list.component';
import { AnalyticsComponent } from './components/analytics/analytics';

export const routes: Routes = [
  { path: '', redirectTo: 'dashboard', pathMatch: 'full' },
  { path: 'dashboard', component: DashboardComponent },
  { path: 'boards', component: BoardComponent },
  { path: 'tasks', component: TaskListComponent },
  { path: 'analytics', component: AnalyticsComponent },
];

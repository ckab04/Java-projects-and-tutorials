import { ChangeDetectionStrategy, Component } from '@angular/core';

// TODO Day 7: Reactive Forms (typed).
// - FormGroup<{ company: FormControl<string>, role: ..., status: ..., interviewRounds: FormArray<...> }>.
// - Custom sync validator (e.g. trimmed company min length).
// - Async validator: duplicate-company check via ApplicationService.
@Component({
  selector: 'app-application-form',
  standalone: true,
  changeDetection: ChangeDetectionStrategy.OnPush,
  template: `<form class="space-y-3 p-4">TODO: application form</form>`,
})
export class ApplicationFormComponent {}

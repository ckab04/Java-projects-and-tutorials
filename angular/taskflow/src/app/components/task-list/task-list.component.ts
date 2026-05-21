import {
  ChangeDetectionStrategy,
  Component,
  computed,
  inject,
  signal,
} from "@angular/core";
import { Task } from "../../models/task.interface";
import { Filter } from "../../models/filter.interface";

import { TaskCardComponent } from "../task-card/task-card.component";
import { TaskStateService } from "../../services/task-state.service";

@Component({
  selector: "app-task-list",
  imports: [TaskCardComponent],
  templateUrl: "./task-list.component.html",
  styleUrl: "./task-list.component.css",
  // changeDetection: ChangeDetectionStrategy.OnPush,
})
export class TaskListComponent {
  private taskState = inject(TaskStateService);

  searchTerm = signal("");
  sortAsc = signal(true);

  //priority = signal("");
  //status = signal("");

  filteredTasks = computed(() => {
    const search = this.searchTerm().toLowerCase();
    const direction = this.sortAsc() ? 1 : -1;

    return [...this.taskState.tasks()]
      .filter((task) => {
        const matchesSearch =
          !search || task.title.toLowerCase().includes(search);
        const matchesFilters = this.activeFilters().every(
          (f) => task[f.field] === f.value,
        );
        return matchesSearch && matchesFilters;
      })
      .sort((a, b) => (a.dueDate.getTime() - b.dueDate.getTime()) * direction);
  });

  // onPriorityChange(event: Event) {
  //   this.priority.set((event.target as HTMLSelectElement).value);
  // }

  // onStatusChange(event: Event) {
  //   this.status.set((event.target as HTMLSelectElement).value);
  // }

  activeFilters = signal<Filter<Task>[]>([]);

  setFilter(field: keyof Task, event: Event) {
    let value = (event.target as HTMLSelectElement).value;
    if (!value) {
      this.activeFilters.update((filters) =>
        filters.filter((f) => f.field !== field),
      );
    } else {
      this.activeFilters.update((filters) => [
        ...filters.filter((f) => f.field !== field),
        { field, value },
      ]);
    }
  }

  getFilter(field: keyof Task): string {
    return (
      (this.activeFilters().find((f) => f.field === field)?.value as string) ??
      ""
    );
  }

  sortDueDate() {
    this.sortAsc.update((asc) => !asc);
  }

  checkCount = 0;

  ngDoCheck() {
    this.checkCount++;
    console.log("Component checked: ", this.checkCount);
  }

  completeTask(task: Task) {
    //this.tasks.update((tasks) => tasks.filter((t) => t.id != task.id));
    this.taskState.remove(task.id);
  }
}

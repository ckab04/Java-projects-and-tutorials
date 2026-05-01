import { Component, computed, signal } from "@angular/core";
import { Task } from "../../models/task.interface";
import { Filter } from "../../models/filter.interface";

@Component({
  selector: "app-task-list",
  imports: [],
  templateUrl: "./task-list.component.html",
  styleUrl: "./task-list.component.css",
})
export class TaskListComponent {
  tasks: Task[] = [
    {
      id: 1,
      title: "Design landing page",
      description: "Hero section, features, pricing, and footer",
      priority: "high",
      status: "in-progress",
      assignee: "Josh",
      board: "Website redesign",
      dueDate: new Date("2026-04-30"),
      subtasks: [
        { label: "Sketch wireframes", done: true },
        { label: "Add pricing section", done: false },
      ],
    },
    {
      id: 2,
      title: "Implement user authentication",
      description: "JWT-based auth flow with refresh tokens",
      priority: "high",
      status: "todo",
      assignee: "Ryan",
      board: "Mobile App",
      dueDate: new Date("2026-04-25"),
      subtasks: [
        {
          label: "Set up JWT libray",
          done: false,
        },
      ],
    },
    {
      id: 3,
      title: "Write API documentation",
      description: "REST endpoints, auth headers, and error codes",
      priority: "low",
      status: "review",
      assignee: "Maya",
      board: "API Integration",
      dueDate: new Date("2026-05-02"),
      subtasks: [
        { label: "Document auth endpoints", done: true },
        { label: "Document task endpoints", done: true },
        { label: "Add error code table", done: true },
      ],
    },
    {
      id: 4,
      title: "Set up CI/CD pipeline",
      description: "GitHub Actions with staging and production environments",
      priority: "medium",
      status: "done",
      assignee: "Alex",
      board: "API Integration",
      dueDate: new Date("2026-04-28"),
      subtasks: [
        { label: "Write build workflow", done: true },
        { label: "Configure staging deploy", done: true },
      ],
    },
  ];

  searchTerm = signal("");
  //priority = signal("");
  //status = signal("");

  filteredTasks = computed(() => {
    const search = this.searchTerm().toLowerCase();

    return this.tasks.filter((task) => {
      const matchesSearch =
        !search || task.title.toLowerCase().includes(search);
      const matchesFilters = this.activeFilters().every(
        (f) => task[f.field] === f.value,
      );
      return matchesSearch && matchesFilters;
    });
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
}

import { Injectable, signal, computed } from "@angular/core";
import { Task } from "../models/task.interface";

@Injectable({
  providedIn: "root",
})
export class TaskStateService {
  private _tasks = signal<Task[]>([
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
  ]);

  readonly tasks = this._tasks.asReadonly();

  // mutations
  //
  add(task: Task) {
    this._tasks.update((list) => [...list, task]);
  }

  remove(id: number) {
    this._tasks.update((list) => list.filter((t) => t.id !== id));
  }

  update(id: number, changes: Partial<Task>) {
    this._tasks.update((list) =>
      list.map((t) => (t.id === id ? { ...t, ...changes } : t)),
    );
  }
}

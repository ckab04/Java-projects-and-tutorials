import { Component, input, output } from "@angular/core";
import { Task } from "../../models/task.interface";
import { HighlightOverdueDirective } from "../../directives/highlitoverdue.directive";
import { HighLightPipe } from "../../pipes/highlight.pipe";

@Component({
  selector: "tr[app-task-card]",
  imports: [HighlightOverdueDirective, HighLightPipe],
  templateUrl: "./task-card.component.html",
  styleUrl: "./task-card.component.css",
})
export class TaskCardComponent {
  task = input<Task>({} as Task);
  searchTerm = input<string>("");
  taskCompletion = output<Task>();

  emitTaskCompletionEvent(taskCompleted: Task) {
    //console.log("Task completed: ", taskCompleted);
    this.taskCompletion.emit(taskCompleted);
  }
}

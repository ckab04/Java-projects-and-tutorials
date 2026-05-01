export type Priority = "low" | "medium" | "high";
export type Status = "todo" | "in-progress" | "review" | "done";

export interface Task {
  id: number;
  title: string;
  description: string;
  priority: Priority;
  status: Status;
  assignee: string;
  board: string;
  dueDate: Date;
  subtasks: { label: string; done: boolean }[];
}

// TODO Day 1 & 4: Define the Application domain model.
// Suggested fields:
//   id: string
//   company: string
//   role: string
//   status: ApplicationStatus
//   appliedAt: string (ISO date)
//   lastUpdated: string
//   notes?: string
//   contacts?: Contact[]
//   interviewRounds?: InterviewRound[]
//
// Practice: utility types (Pick, Omit, Partial), branded id types, type guards.

export type ApplicationStatus =
  | 'applied'
  | 'screening'
  | 'interview'
  | 'offer'
  | 'rejected'
  | 'withdrawn';

export interface Application {
  id: string;
  company: string;
  role: string;
  status: ApplicationStatus;
  appliedAt: string;
  lastUpdated: string;
}

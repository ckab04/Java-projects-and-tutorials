export interface Filter<T> {
  field: keyof T;
  value: unknown;
}

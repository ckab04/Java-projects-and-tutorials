import { Injectable } from '@angular/core';

// TODO Day 4 & 5: CRUD service for Application.
// - inject(HttpClient) and API_BASE_URL token.
// - Typed responses: Observable<Application[]>, Observable<Application>.
// - Methods: list(), getById(id), create(dto), update(id, dto), remove(id).
// - Practice generics: e.g. private get<T>(path: string): Observable<T>.
@Injectable({ providedIn: 'root' })
export class ApplicationService {}

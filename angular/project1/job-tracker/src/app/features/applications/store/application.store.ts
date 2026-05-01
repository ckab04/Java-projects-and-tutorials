import { Injectable } from '@angular/core';

// TODO Day 10: Signal-based store.
// - Private writable signals: _applications, _filter, _loading, _error.
// - Public computed: filteredApplications, countsByStatus.
// - Methods: load(), addLocal(app), updateLocal(app), removeLocal(id), setFilter(...).
// - Stretch: refactor a slice to NgRx SignalStore and compare ergonomics.
@Injectable({ providedIn: 'root' })
export class ApplicationStore {}

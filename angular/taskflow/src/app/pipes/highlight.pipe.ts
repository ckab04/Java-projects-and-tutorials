import { PipeTransform, Pipe } from "@angular/core";

@Pipe({
  name: "highlight",
})
export class HighLightPipe implements PipeTransform {
  transform(value: string, term: string): string {
    if (!term.trim()) return value;
    const escaped = term.replace(/[.*+?^${}()|[\]\\]/g, "\\$&");
    const regex = new RegExp(`(${escaped})`, "gi");

    return value.replace(regex, "<mark>$1</mark>");
  }
}

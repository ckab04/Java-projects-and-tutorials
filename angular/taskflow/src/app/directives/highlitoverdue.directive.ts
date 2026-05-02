import { Directive, ElementRef, Renderer2, OnInit, Input } from "@angular/core";

@Directive({
  selector: "[appHighlightOverdue]",
})
export class HighlightOverdueDirective implements OnInit {
  @Input() appHighlightOverdue!: Date;

  constructor(
    private elementRef: ElementRef,
    private renderer: Renderer2,
  ) {}

  ngOnInit(): void {
    const isOverdue =
      this.appHighlightOverdue.getTime() < new Date("2026-04-30").getTime();
    if (isOverdue) {
      this.renderer.setStyle(
        this.elementRef.nativeElement,
        "background-color",
        "#fee2e2",
      );
    }
  }
}

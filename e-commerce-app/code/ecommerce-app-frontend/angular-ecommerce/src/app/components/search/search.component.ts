import { Component, OnInit } from "@angular/core";
import { Router } from "@angular/router";

@Component({
  selector: "app-search",
  standalone: true,
  imports: [],
  templateUrl: "./search.component.html",
  styleUrl: "./search.component.css",
})
export class SearchComponent implements OnInit {
  constructor(private router: Router) {}

  ngOnInit(): void {}

  doSearch(keyword: string) {
    console.log("Value searched = ", keyword);
    this.router.navigateByUrl(`search/${keyword}`);
  }
}

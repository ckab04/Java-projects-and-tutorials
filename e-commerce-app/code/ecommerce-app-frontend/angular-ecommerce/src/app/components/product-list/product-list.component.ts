import { Component, OnInit } from "@angular/core";
import { ProductService } from "../../services/product.service";
import { Product } from "../../common/product";
import { CommonModule } from "@angular/common";
import { ActivatedRoute, Router, NavigationEnd } from "@angular/router";

import { map, filter } from "rxjs/operators";
import { takeUntilDestroyed } from "@angular/core/rxjs-interop";
@Component({
  selector: "app-product-list",
  standalone: true,
  imports: [CommonModule],
  templateUrl: "./product-list.component.html",
  styleUrl: "./product-list.component.css",
})
export class ProductListComponent implements OnInit {
  products: Product[] = [];
  currentCategoryId: number = 1;

  constructor(
    private productService: ProductService,
    private route: ActivatedRoute,
    private router: Router,
  ) {
    //this.router.events.subscribe((event) => console.log(event));
    // Force component reload on route changes
    this.router.routeReuseStrategy.shouldReuseRoute = () => false;

    // Alternative solution: Subscribe to router events
    this.router.events
      .pipe(filter((event) => event instanceof NavigationEnd))
      .subscribe(() => {
        this.checkRouteParams();
      });
  }

  private checkRouteParams() {
    // METHOD 1: Using snapshot (immediate value)
    const snapshotId = this.route.snapshot.paramMap.get("id");
    console.log("Snapshot ID:", snapshotId);

    // METHOD 2: Using observable (for subsequent changes)
    this.route.paramMap.subscribe((params) => {
      const id = params.get("id");
      console.log("Observable ID:", id);

      if (id) {
        this.currentCategoryId = +id;
        console.log("Valid ID found:", this.currentCategoryId);
        this.listProducts();
      } else {
        console.warn("No ID parameter found in URL");
        this.currentCategoryId = 1; // Default value
        this.listProducts();
      }
    });
  }

  ngOnInit(): void {
    this.checkRouteParams();
    // console.log("Route snapshot:", this.route.snapshot);
    // console.log("URL segments:", this.route.snapshot.url);
    // console.log(
    //   "ParamMap keys:",
    //   Array.from(this.route.snapshot.paramMap["keys"]),
    // );

    // this.route.paramMap.subscribe((params) => {
    //   // Get ID from ROUTE parameters (/category/:id)
    //   const id = params.get("id");
    //   console.log("ID: ", id);

    //   // Update current category ID
    //   this.currentCategoryId = id ? +id : 1;
    //   console.log("Current category ID:", this.currentCategoryId);
    // });
  }

  listProducts() {
    // check if "id" parameter is available
    const hasCategoryId: boolean = this.route.snapshot.queryParamMap.has("id");

    // Get the ID from query parameters (?id=)
    //const categoryId = this.route.snapshot.queryParamMap.get("id");

    // If ID exists in query params, use it; otherwise use default (1)
    //this.currentCategoryId = categoryId ? +categoryId : 1;
    console.log("id value = ", this.currentCategoryId);
    this.productService
      .getProductList(this.currentCategoryId)
      .subscribe((data) => {
        this.products = data;
        console.log("Data ", this.products);
      });
  }
}

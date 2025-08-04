import { Component, OnInit } from "@angular/core";
import { ProductService } from "../../services/product.service";
import { Product } from "../../common/product";
import { CommonModule } from "@angular/common";
import { ActivatedRoute, Router } from "@angular/router";

import { map } from "rxjs/operators";
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
    this.route.params
      .pipe(
        takeUntilDestroyed(),
        map((params) => {
          // Explicitly type the params object
          const typedParams = params as { id?: string };
          return typedParams.id ? +typedParams.id : 0;
        }),
      )
      .subscribe((categoryId) => {
        this.currentCategoryId = categoryId;
        this.listProducts();
      });
  }

  ngOnInit(): void {
    //this.route.paramMap.subscribe(() => {
    // this.listProducts();
    //});
    //
    // Subscribe FIRST, then call listProducts() WHEN params change
    // this.route.paramMap.pipe(takeUntilDestroyed()).subscribe({
    //   next: (params) => {
    //     this.currentCategoryId = params["id"] ? +params["id"] : 0;
    //     this.listProducts(); // Call AFTER params are set
    //   },
    //   error: (err) => console.error("Route error:", err),
    // });
    //this.listProducts();
  }

  listProducts() {
    // check if "id" parameter is available
    const hasCategoryId: boolean = this.route.snapshot.paramMap.has("id");

    console.log("Full URL:", window.location.href);
    console.log("Route Snapshot:", this.route.snapshot);
    console.log("ParamMap contents:", this.route.snapshot.paramMap);

    this.route.paramMap.subscribe({
      next: (params) => {
        console.log("All params:", params);
        const id = params.get("id");
        console.log("Raw id value:", id, "Type:", typeof id);
        if (id) {
          console.log("INSIDE IF");
          this.currentCategoryId = +id;
          console.log("Category ID: ", this.currentCategoryId);
        } else {
          console.log("INSIDE ELSE - no id parameter found");
          this.currentCategoryId = 0;
        }
      },
      error: (err) => console.error("Route param error: ", err),
    });

    // if (hasCategoryId) {
    //   // get the id and convert it to a number.
    //   this.currentCategoryId = +this.route.snapshot.paramMap.get("id")!;
    //   console.log("Is this even working ??");
    // } else {
    //   this.currentCategoryId = 1;
    // }
    console.log("id value = ", this.currentCategoryId);
    this.productService
      .getProductList(this.currentCategoryId)
      .subscribe((data) => {
        this.products = data;
        //console.log(this.products);
      });
  }
}

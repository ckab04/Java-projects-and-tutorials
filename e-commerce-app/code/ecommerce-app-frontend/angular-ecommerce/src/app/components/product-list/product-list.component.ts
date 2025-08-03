import { Component, OnInit } from "@angular/core";
import { ProductService } from "../../services/product.service";
import { Product } from "../../common/product";
import { CommonModule } from "@angular/common";
import { ActivatedRoute, Router } from "@angular/router";

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
    this.router.events.subscribe((event) => console.log(event));
  }

  ngOnInit(): void {
    this.route.paramMap.subscribe(() => {
      this.listProducts();
    });
    //this.listProducts();
  }

  listProducts() {
    // check if "id" parameter is available
    const hasCategoryId: boolean = this.route.snapshot.paramMap.has("id");
    this.route.paramMap.subscribe((params) => {
      const id = params.get("id");
      if (id) {
        this.currentCategoryId = +id;
        console.log("Category ID: ", this.currentCategoryId);
      } else {
        this.currentCategoryId = 2;
      }
    });

    // if (hasCategoryId) {
    //   // get the id and convert it to a number.
    //   this.currentCategoryId = +this.route.snapshot.paramMap.get("id")!;
    //   console.log("Is this even working ??");
    // } else {
    //   this.currentCategoryId = 1;
    // }

    this.productService
      .getProductList(this.currentCategoryId)
      .subscribe((data) => {
        this.products = data;
        //console.log(this.products);
      });
  }
}

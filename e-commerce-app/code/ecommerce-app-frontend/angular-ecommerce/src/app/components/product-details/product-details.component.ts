import { Component, OnInit } from "@angular/core";
import { ProductService } from "../../services/product.service";
import { Product } from "../../common/product";
import { ActivatedRoute, Router } from "@angular/router";

@Component({
  selector: "app-product-details",
  standalone: true,
  imports: [],
  templateUrl: "./product-details.component.html",
  styleUrl: "./product-details.component.css",
})
export class ProductDetailsComponent implements OnInit {
  product!: Product;

  constructor(
    private productService: ProductService,
    private route: ActivatedRoute,
    private router: Router,
  ) {}

  ngOnInit(): void {}

  getProductDetails() {
    const productName: string =
      this.route.snapshot.paramMap.get("product-name")!;
    this.productService.getProductDetails(productName).subscribe((data) => {
      this.product = data;
    });

    console.log("Product details = ", this.product);
  }
}

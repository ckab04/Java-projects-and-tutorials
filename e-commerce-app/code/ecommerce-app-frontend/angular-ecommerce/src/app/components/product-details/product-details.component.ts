import { Component, OnInit } from "@angular/core";
import { ProductService } from "../../services/product.service";
import { Product } from "../../common/product";
import { ActivatedRoute, Router } from "@angular/router";
import { CommonModule } from "@angular/common";

@Component({
  selector: "app-product-details",
  standalone: true,
  imports: [CommonModule],
  templateUrl: "./product-details.component.html",
  styleUrl: "./product-details.component.css",
})
export class ProductDetailsComponent implements OnInit {
  product!: Product;

  constructor(
    private productService: ProductService,
    private route: ActivatedRoute,
  ) {}

  ngOnInit(): void {
    //this.getProductDetails();
    this.route.paramMap.subscribe(() => this.handleProductDetails());
  }

  getProductDetails() {
    const productName: string =
      this.route.snapshot.paramMap.get("product-name")!;

    this.productService.getProductDetails(productName).subscribe((data) => {
      this.product = data;
      console.log("DATA = ", data);
    });

    console.log("Product details = ", this.product);
  }
  handleProductDetails() {
    const productId: number = +this.route.snapshot.paramMap.get("id")!;
    this.productService.getProduct(productId).subscribe((data) => {
      this.product = data;
    });
  }
}

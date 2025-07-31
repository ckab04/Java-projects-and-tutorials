import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";

import { Product } from "../common/product";
import { map, Observable } from "rxjs";

@Injectable({
  providedIn: "root",
})
export class ProductService {
  private baseUrl = "http://localhost:8081/api/products";

  constructor(private httpClient: HttpClient) {}

  getProductList(theCategoryId: number): Observable<Product[]> {
    // TODO: need to build url based on category

    return this.httpClient
      .get<GetResponse>(this.baseUrl)
      .pipe(map((response) => response._embedded.products));
  }
}

interface GetResponse {
  _embedded: {
    products: Product[];
  };
}

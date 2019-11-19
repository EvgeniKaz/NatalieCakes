import { Component, OnInit } from '@angular/core';
import { ProductsService } from 'src/app/servieces/products.service';

import { Products } from 'src/app/models/Products';

@Component({
  selector: 'app-products',
  templateUrl: './products.component.html',
  styleUrls: ['./products.component.scss']
})
export class ProductsComponent implements OnInit {
  products:Products[];

  constructor(private productsServiece:ProductsService) { }

  ngOnInit() {
    this.productsServiece.GetProducts().subscribe((products:Products[]) => {
        this.products = products;
      }
    )
  }

}

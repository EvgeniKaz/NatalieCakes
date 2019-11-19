import { Component, OnInit } from '@angular/core';

import { Categories } from 'src/app/models/Categories';
import { ProductsService } from 'src/app/servieces/products.service';

@Component({
  selector: 'app-cake-categories',
  templateUrl: './cake-categories.component.html',
  styleUrls: ['./cake-categories.component.scss']
})
export class CakeCategoriesComponent implements OnInit {
  cards:Categories[];

  constructor(private productsServiece:ProductsService) { }

  ngOnInit() {
    this.cards = [
      {
        img: '../../../assets/img/categories/3.jpg',
        title: 'Theme Cakes',
        category: 'THEME_CAKES'
      },
      {
        img: '../../../assets/img/categories/8.jpg',
        title: 'Party Sets',
        category: 'PARTY_SETS'
      },
      {
        img: '../../../assets/img/categories/9.jpg',
        title: 'Salts',
        category: 'SALTED'
      }
    ]
  }


}

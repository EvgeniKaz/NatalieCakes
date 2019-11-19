import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';

import { Products } from '../models/Products';
import { Router } from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class ProductsService {

  constructor(private http:HttpClient, private router:Router) { }

  GetProducts():Observable<Products[]> {
    return this.http.get<Products[]>('http://localhost:8080/product');
  }
}


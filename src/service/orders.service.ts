import { Injectable } from '@angular/core';
import { AbstractService } from './abstractservice';
import { OrdersDTO } from 'src/dto/ordersdto';
import { HttpClient } from '@angular/common/http';
//import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class OrdersService extends AbstractService<OrdersDTO> {

  constructor(http: HttpClient) {
    super(http);
    this.type = 'orders';
  }
}

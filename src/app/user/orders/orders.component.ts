import { Component, OnInit } from '@angular/core';
import { OrdersService } from 'src/service/orders.service';
import { OrdersDTO } from 'src/dto/ordersdto';

@Component({
  selector: 'app-orders',
  templateUrl: './orders.component.html',
  styleUrls: ['./orders.component.css']
})
export class OrdersComponent implements OnInit {

  isselected: boolean=false;
  selected: OrdersDTO;
  orders: OrdersDTO[];
  orderstoinsert: OrdersDTO = new OrdersDTO();
  constructor(private service: OrdersService) { }

  ngOnInit() {
    this.clear();
    this.getOrders();
  }

  getOrders() {
    this.service.getAll().subscribe(orders => this.orders = orders);
  }

  /*delete(orders: OrdersDTO) {
    this.service.delete(orders.id).subscribe(() => this.getOrders());
  }*/

  update(order: OrdersDTO) {
    this.service.update(order).subscribe(() => this.getOrders());
  }

  insert(order: OrdersDTO) {
    this.service.insert(order).subscribe(() => this.getOrders());
  }

  clear(){
    this.orderstoinsert = new OrdersDTO();
  }
  
  close() {
    this.service = null;
  }
  
  select(reviews: OrdersDTO) {
    this.selected = reviews;
    this.isselected=true;
    return this.selected;
  }
  closeread() {
    this.isselected=false;
  }
}
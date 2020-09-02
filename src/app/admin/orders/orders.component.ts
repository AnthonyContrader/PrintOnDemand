import { Component, OnInit } from '@angular/core';
import { OrdersService } from 'src/service/orders.service';
import { ItemService } from 'src/service/item.service';
import { ClientService } from 'src/service/client.service';
import { OrdersDTO } from 'src/dto/ordersdto';
import { ClientDTO } from 'src/dto/clientdto';
import { ItemDTO } from 'src/dto/itemdto';
import { BehaviorSubject, Subject, Subscriber } from 'rxjs';
@Component({
  selector: 'app-orders',
  templateUrl: './orders.component.html',
  styleUrls: ['./orders.component.css']
})
export class OrdersComponent implements OnInit {

  isselected: boolean=false;
  isselectedi: boolean=false;
  isselectedc: boolean=false;
  selected: OrdersDTO;
  selectedc: ClientDTO;
  selectedi: ItemDTO;
  orders: OrdersDTO[]=[];
  clients: ClientDTO[];
  items: ItemDTO[];
  listits: ItemDTO[]=[];
  orderstoinsert: OrdersDTO = new OrdersDTO();
  constructor(private service: OrdersService, private servicei: ItemService, private servicec: ClientService) { }

  ngOnInit() {
    this.clear();
    this.getOrders();
    //this.filteritems();
    
  }

  getOrders() {
    this.service.getAll().subscribe(orders => this.orders = orders);
    this.servicei.getAll().subscribe(items => this.items = items);
    this.servicec.getAll().subscribe(clients => this.clients = clients);
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
    this.isselectedi=false;
    this.isselectedc=false;
  }
  readi(reviews: number){
    this.servicei.read(reviews).subscribe(sel=>this.selectedi=sel);
    this.isselectedi=true;
    return this.selectedi;
  }
  readc(reviews: number){
    this.servicec.read(reviews).subscribe(sel=>this.selectedc=sel);
    this.isselectedc=true;
    return this.selectedi;
  }
 /*filteritems(){
    
    
   for(let i=0;i<this.orders.length; i++){
     
    this.servicei.read(this.orders[i].iditem).subscribe(item => this.selectedi=item);
    this.listits[i]=this.selectedi;

   }
   for(let it of this.listits) console.log(it);
  }*/
}



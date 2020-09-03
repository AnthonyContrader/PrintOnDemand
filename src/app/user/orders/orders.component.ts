import { Component, OnInit } from '@angular/core';
import { OrdersService } from 'src/service/orders.service';
import { ItemService } from 'src/service/item.service';
import { ClientService } from 'src/service/client.service';
import { OrdersDTO } from 'src/dto/ordersdto';
import { ClientDTO } from 'src/dto/clientdto';
import { ItemDTO } from 'src/dto/itemdto';
import { BehaviorSubject, Subject, Subscriber } from 'rxjs';
import { UserDTO } from 'src/dto/userdto';
import { defineDirective } from '@angular/core/src/render3';
import { defaultComparator } from '@angular/common/src/pipes/keyvalue_pipe';
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
  orders: OrdersDTO[];
  clients: ClientDTO[]=[];
  defd: ClientDTO[];
  items: ItemDTO[]=[];
  listits: ItemDTO[];
  length:number;
  sdata:string;
  orderstoinsert: OrdersDTO = new OrdersDTO();
  user: UserDTO=new UserDTO;
  constructor(private service: OrdersService, private servicei: ItemService, private servicec: ClientService) { }

  ngOnInit() {
    this.clear();
    this.getOrders();
    for(let client of this.clients){ console.log(client.id)}
    this.user = JSON.parse(localStorage.getItem('currentUser'));
    //this.filteritems();
        
  }

  getOrders() {
    this.servicec.getAll().subscribe((clients: ClientDTO[]) => {
      for(let cl of clients) {
        if(this.user.id===cl.userID)
        this.length=this.clients.push(cl);
      }
    });

    this.servicei.getAll().subscribe((items: ItemDTO[]) => {
      for(let it of items) {
        if((it.immagine==="" || it.immagine===null ) && (it.link==="" || it.immagine===null)) this.length=this.items.push(it);
      }
    });

    //this.servicec.getAll().subscribe(clients => this.clients = clients);
    /*for(const{index,client} of this.clients.map((client,index)=>({index,client})))
    {
      if(!(===client.userID)) console.log((this.clients.splice(index,1)));
    }*/
  
    this.service.getAll().subscribe(orders => this.orders = orders);
    //this.servicei.getAll().subscribe(items => this.items = items);
  }

  /*delete(orders: OrdersDTO) {
    this.service.delete(orders.id).subscribe(() => this.getOrders());
  }*/

  update(order: OrdersDTO) {
    this.service.update(order).subscribe(() => this.getOrders());
  }

  insert(order: OrdersDTO) {
    order.data=this.sdata;
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
  dataora(){
    let d= new Date();
    this.sdata=d.getFullYear()+"/"+("0"+(d.getMonth()+1)).slice(-2)+"/"+("0"+d.getDate()).slice(-2)+" "+d.getHours()+":"+d.getMinutes()+":"+("0"+d.getSeconds()).slice(-2);
    return this.sdata;
  }
 /*filteritems(){
    
    
   for(let i=0;i<this.orders.length; i++){
     
    this.servicei.read(this.orders[i].iditem).subscribe(item => this.selectedi=item);
    this.listits[i]=this.selectedi;

   }
   for(let it of this.listits) console.log(it);
  }*/
}
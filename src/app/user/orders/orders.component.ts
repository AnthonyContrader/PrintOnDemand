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
import { async } from '@angular/core/testing';
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
  clients: ClientDTO[]=[];
  it: ItemDTO;
  defd: ClientDTO[];
  items: ItemDTO[]=[];
  listits: ItemDTO[];
  duplicateit: ItemDTO;
  length:number;
  sdata:string;
  orderstoinsert: OrdersDTO = new OrdersDTO();
  user: UserDTO=new UserDTO;
  constructor(private service: OrdersService, private servicei: ItemService, private servicec: ClientService) { }

  ngOnInit() {
    this.clear();
    this.getOrders();
    //for(let client of this.clients){ console.log(client.id)}
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
    this.allOrders();

    //this.servicec.getAll().subscribe(clients => this.clients = clients);

  

    
    
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
    this.it.id=0;
    let temp: ItemDTO[]=[];
    this.servicei.insert(this.it).subscribe(()=>{},undefined,()=>{this.servicei.getAll().subscribe((t: ItemDTO[])=>{
      for(let ordtmp of t) this.length=temp.push(ordtmp);
      order.iditem=(temp.pop()).id}
      ,undefined,()=>{this.service.insert(order).subscribe(()=>{},undefined,()=>{this.orders.push(order);})})});
    
    //console.log(this.duplicateit.nome+this.duplicateit.descrizione+this.duplicateit.tipo+this.duplicateit.colore+this.duplicateit.taglia);
    //this.servicei.insert(this.it);
    //let tempobs: ItemDTO[]=[];
 
      
    /*this.servicei.getAll().subscribe((t: ItemDTO[])=>{
      for(let ordtmp of t) this.length=temp.push(ordtmp);
      order.iditem=(temp.pop()).id;
      console.log(order.iditem);
      this.service.insert(order).subscribe(() => {this.allClient();});
      });*/
      
      
  }

  clear(){
    console.log(this.length);
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
    return this.selectedc;
  }
  dataora(){
    let d= new Date();
    this.sdata=d.getFullYear()+"/"+("0"+(d.getMonth()+1)).slice(-2)+"/"+("0"+d.getDate()).slice(-2)+" "+d.getHours()+":"+d.getMinutes()+":"+("0"+d.getSeconds()).slice(-2);
    return this.sdata;
  }
  save(item: ItemDTO){
    this.it=item;
  }
  /*checkorder(review: number){
    if(this.clients.find(this.readc(review)))
     {
      return true;
    }
    else return false;
  }
*/
  allOrders()  {
    this.service.getAll().subscribe(orders => {
      
      //this.orders = orders
    for(let client of this.clients)
    {
      for(let order of orders)
      {
        if(client.id===order.idclient) {this.orders.push(order);
          this.orders.sort((a,b)=>a.data.localeCompare(b.data));
        }
      }
    }
  });
  }
}
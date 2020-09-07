import { Component, OnInit } from '@angular/core';
import { OrdersService } from 'src/service/orders.service';
import { ItemService } from 'src/service/item.service';
import { ClientService } from 'src/service/client.service';
import { OrdersDTO } from 'src/dto/ordersdto';
import { ClientDTO } from 'src/dto/clientdto';
import { ItemDTO } from 'src/dto/itemdto';
import { UserDTO } from 'src/dto/userdto';
import{ HttpClient, HttpEventType} from '@angular/common/http';

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
  items: ItemDTO[]=[];
  listits: ItemDTO[];
  orderstoinsert: OrdersDTO = new OrdersDTO();
  it: ItemDTO;
  defd: ClientDTO[];
  duplicateit: ItemDTO;
  length:number;
  sdata:string;
  sfdata:string;
  user: UserDTO=new UserDTO;
  selectedfile: File=null;
  itemsorders:ItemDTO[]=[];
  qrlink:string;
 
 

  constructor(private service: OrdersService, private servicei: ItemService, private servicec: ClientService , private http:HttpClient) { }


  ngOnInit() {
    this.clear();
    this.user = JSON.parse(localStorage.getItem('currentUser'));
    //this.filteritems();
    this.getOrders();
    
  }

  onFileSelected(event)
  {
    this.selectedfile=<File>event.target.files[0];
  }

  upload(idselect:number)
  {
    let tmpitem:ItemDTO;
    this.dataoraupload();

    const fd=new FormData;
    fd.append('img',this.selectedfile,this.selectedfile.name);
    this.http.post('http://localhost:8080/order/upload',fd, {reportProgress:true, observe:'events'}).subscribe(event =>{
      if(event.type===HttpEventType.UploadProgress) {
        console.log('UploadProgress' + Math.round(event.loaded / event.total * 100 ) +'%');
      }else if(event.type===HttpEventType.Response) 
      {
        this.servicei.getAll().subscribe((t: ItemDTO[])=>{
          for(let ordtmp of t) 
          {
            if(ordtmp.id===idselect) tmpitem=ordtmp;
          }
        },undefined,()=>{

          tmpitem.immagine= ("\\immaginisalvate") + this.sfdata +"\\"+ this.selectedfile.name;
          this.servicei.update(tmpitem).subscribe();
          console.log(event+ " " + tmpitem.id);
           });

        
      
      }
    });
    
  }

  dataoraupload()
  {
    let d= new Date();
    this.sfdata="\\" + d.getFullYear()+"-"+("0"+(d.getMonth()+1)).slice(-2)+"-"+("0"+d.getDate()).slice(-2)+"-"+("0"+d.getHours()).slice(-2)+"-"+("0"+d.getMinutes()).slice(-2)+"-"+("0"+d.getSeconds()).slice(-2);
  }

  dataora(){
    let d= new Date();
    this.sdata=d.getFullYear()+"/"+("0"+(d.getMonth()+1)).slice(-2)+"/"+("0"+d.getDate()).slice(-2)+" "+d.getHours()+":"+d.getMinutes()+":"+("0"+d.getSeconds()).slice(-2);
    return this.sdata;
  }

  getOrders() {
    this.servicec.getAll().subscribe((clients: ClientDTO[]) => {
      for(let cl of clients) {
       
        this.length=this.clients.push(cl);
      }
      console.log("Clienti caricati");
    },undefined,()=>{
      this.service.getAll().subscribe(orders => {
      
        for(let client of this.clients)
        {
          for(let order of orders)
          {
            if(client.id===order.idclient) {this.orders.push(order);
              this.orders.sort((a,b)=>a.data.localeCompare(b.data));
            }
          }
        }
        console.log("Orders caricati");
      });

    });
    this.servicei.getAll().subscribe((items: ItemDTO[]) => {
      for(let it of items) 
      {
        if((it.immagine==="" || it.immagine===null ) && (it.link==="" || it.immagine===null))
        {
        this.length=this.items.push(it);
        }else{this.itemsorders.push(it);

        }
      }
    });

  }




/*
    this.servicei.getAll().subscribe((items: ItemDTO[]) => {
      for(let it of items) {
        if((it.immagine==="" || it.immagine===null ) && (it.link==="" || it.immagine===null)) this.length=this.items.push(it);
      }
    });
    this.allOrders();

  }*/

  /*delete(orders: OrdersDTO) {
    this.service.delete(orders.id).subscribe(() => this.getOrders());
  }*/

  update(order: OrdersDTO) {
    this.service.update(order).subscribe(() => {});
    let itemtoupdate:ItemDTO;
    itemtoupdate=this.checkitems(order.iditem);
    //itemtoupdate.link=this.checkitems(order.iditem).link;
    this.servicei.update(itemtoupdate).subscribe();
  }

  updatei(item: ItemDTO) {
    item.link=this.qrlink;
    this.servicei.update(item).subscribe(() => {});
  }

  insert(order: OrdersDTO) {

    order.data=this.sdata;
    this.it.id=0;
    let temp: ItemDTO[]=[];
    this.it.immagine="ND";
    this.it.link="ND";
    this.servicei.insert(this.it).subscribe(()=>{},undefined,()=>{this.servicei.getAll().subscribe((t: ItemDTO[])=>{
      for(let ordtmp of t) this.length=temp.push(ordtmp);
      order.iditem=(temp.pop()).id}
      ,undefined,()=>{this.service.insert(order).subscribe(()=>{},undefined,()=>{this.orders.push(order);})})});     
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
  closereada() {
    this.isselectedc=false;
  }
  closereadb() {
    this.isselectedi=false;
  }
  closereadc() {
    this.isselected=false;
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

  save(item: ItemDTO){
    this.it=item;
  }

  /*allOrders()  {
    this.service.getAll().subscribe(orders => {
      
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
  }*/

  checkitems(iditem:number){
    for(let item of this.itemsorders)
    {
      if(item.id==iditem)
      {
        return item;
      }
    }
  }
}



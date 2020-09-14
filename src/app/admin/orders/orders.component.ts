import { Component, OnInit } from '@angular/core';
import { ItemService } from 'src/service/articoli.service';
import { ClientService } from 'src/service/client.service';
import { OrdersDTO } from 'src/dto/ordersdto';
import { ClientDTO } from 'src/dto/clientdto';
import { ItemDTO } from 'src/dto/articolidto';
import { UserDTO } from 'src/dto/userdto';
import{ HttpClient, HttpEventType} from '@angular/common/http';

@Component({
  selector: 'app-orders',
  templateUrl: './orders.component.html',
  styleUrls: ['./orders.component.css']
})
export class OrdersComponent implements OnInit {
  base64Data: any;
  imageBlobUrl: string | null = null;
  isselected: boolean=false;
  isselectedi: boolean=false;
  isselectedc: boolean=false;
  selected: ItemDTO;
  selectedc: ClientDTO;
  selectedi: ItemDTO;
  orders: ItemDTO[]=[];
  clients: ClientDTO[]=[];
  items: ItemDTO[]=[];
  listits: ItemDTO[];
  orderstoinsert: ItemDTO = new ItemDTO();
  itselected: ItemDTO;
  defd: ClientDTO[];
  duplicateit: ItemDTO;
  length:number;
  sdata:string;
  sfdata:string;
  user: UserDTO=new UserDTO;
  selectedfile: File=null;
  itemsorders:ItemDTO[]=[];
  qrlink:string;
  image: any;
 

  constructor(private service: ItemService, private servicec: ClientService , private http:HttpClient) { }


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

  upload(orderselect)
  {
    let tmpitem:ItemDTO;
    this.dataoraupload();

    const fd=new FormData;
    fd.append('img',this.selectedfile,this.selectedfile.name);
    this.service.upload(fd)/*this.http.('http://localhost:8080/api/order/upload',fd, {reportProgress:true, observe:'events'})*/.subscribe(path =>{
      orderselect.immagine= ("\immaginisalvate") + this.sfdata +"\\"+ this.selectedfile.name;
      console.log(orderselect);

      this.service.update(orderselect).subscribe();
      console.log(event+ " " + orderselect.id);/*
      if(event.type===HttpEventType.UploadProgress) {
        console.log('UploadProgress' + Math.round(event.loaded / event.total * 100 ) +'%');
      }else if(event.type===HttpEventType.Response) 
      {


        this.service.getAll().subscribe((t: ItemDTO[])=>{
        },undefined,()=>{

           });

        
      
      }*/
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
            if(client.id===order.idcliente) {this.orders.push(order);
              this.orders.sort((a,b)=>a.data.localeCompare(b.data));
            }
          }
        }
        console.log("Orders caricati");
      });

    });
    this.service.getAll().subscribe((items: ItemDTO[]) => {
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

  update(order: ItemDTO) {
    this.service.update(order).subscribe(() => {});
    let itemtoupdate:ItemDTO;
    itemtoupdate=this.checkitems(order.id);
    //itemtoupdate.link=this.checkitems(order.iditem).link;
    this.service.update(itemtoupdate).subscribe();
  }

  updatei(item: ItemDTO) {
    item.link=this.qrlink;
    this.service.update(item).subscribe(() => {});
  }
  insert() {
      let idtemp=this.orderstoinsert.id;
      this.orderstoinsert.id=null;
      this.service.read(idtemp).subscribe((itselected:ItemDTO)=>{this.itselected=itselected;},undefined, ()=>{
      this.orderstoinsert.nome=this.itselected.nome;
      this.orderstoinsert.descrizione=this.itselected.descrizione;
      this.orderstoinsert.tipo=this.itselected.tipo;
      this.orderstoinsert.colore=this.itselected.colore;
      this.orderstoinsert.taglia=this.itselected.taglia;
      this.orderstoinsert.immagine="ND";
      this.orderstoinsert.link="ND";
      this.orderstoinsert.data=this.sdata;
      this.service.insert(this.orderstoinsert).subscribe(()=>{},undefined,()=>{
        this.orderstoinsert.id=idtemp;
        this.orders.push(this.orderstoinsert);
      
      });
    });     
  }

  clear(){
    this.orderstoinsert = new ItemDTO();
  }
  
  close() {
    this.service = null;
  }
  
  select(reviews: ItemDTO) {
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
  readi(reviews: number, img){
    this.service.read(reviews).subscribe(sel=>this.selectedi=sel);
    this.isselectedi=true;
    this.getImgHtml(img);
    return this.selectedi;
  }
  readc(reviews: number){
    this.servicec.read(reviews).subscribe(sel=>this.selectedc=sel);
    this.isselectedc=true;
    return this.selectedi;
  }

getImgHtml(img){
  this.service.getImage(img).subscribe((blob:any)=>{
  let objectURL = URL.createObjectURL(blob);       
  return objectURL;
    });
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



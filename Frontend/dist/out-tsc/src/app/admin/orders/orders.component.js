import { __decorate, __metadata } from "tslib";
import { Component } from '@angular/core';
import { ItemService } from 'src/service/articoli.service';
import { ClientService } from 'src/service/client.service';
import { ItemDTO } from 'src/dto/articolidto';
import { UserDTO } from 'src/dto/userdto';
import { HttpClient } from '@angular/common/http';
import { DomSanitizer } from '@angular/platform-browser';
var OrdersComponent = /** @class */ (function () {
    function OrdersComponent(service, servicec, http, sanitizer) {
        this.service = service;
        this.servicec = servicec;
        this.http = http;
        this.sanitizer = sanitizer;
        this.imageBlobUrl = null;
        this.isselected = false;
        this.isselectedi = false;
        this.isselectedc = false;
        this.orders = [];
        this.clients = [];
        this.items = [];
        this.orderstoinsert = new ItemDTO();
        this.user = new UserDTO;
        this.selectedfile = null;
        this.itemsorders = [];
    }
    OrdersComponent.prototype.ngOnInit = function () {
        this.clear();
        this.user = JSON.parse(localStorage.getItem('currentUser'));
        //this.filteritems();
        this.getOrders();
    };
    OrdersComponent.prototype.onFileSelected = function (event) {
        this.selectedfile = event.target.files[0];
    };
    OrdersComponent.prototype.upload = function (orderselect) {
        var _this = this;
        var tmpitem;
        this.dataoraupload();
        var fd = new FormData;
        fd.append('img', this.selectedfile, this.selectedfile.name);
        console.log(fd.get("img"));
        console.log(this.selectedfile);
        this.service.upload(fd).subscribe(function (path) {
            orderselect.immagine = ("\immaginisalvate") + _this.sfdata + "\\" + _this.selectedfile.name;
            //console.log(orderselect);
            _this.service.update(orderselect).subscribe();
            // console.log(event+ " " + orderselect.id);
            /*
            if(event.type===HttpEventType.UploadProgress) {
              console.log('UploadProgress' + Math.round(event.loaded / event.total * 100 ) +'%');
            }else if(event.type===HttpEventType.Response)
            {
      
      
              this.service.getAll().subscribe((t: ItemDTO[])=>{
              },undefined,()=>{
      
                 });
      
              
            
            }*/
        });
    };
    OrdersComponent.prototype.dataoraupload = function () {
        var d = new Date();
        this.sfdata = "\\" + d.getFullYear() + "-" + ("0" + (d.getMonth() + 1)).slice(-2) + "-" + ("0" + d.getDate()).slice(-2) + "-" + ("0" + d.getHours()).slice(-2) + "-" + ("0" + d.getMinutes()).slice(-2) + "-" + ("0" + d.getSeconds()).slice(-2);
    };
    OrdersComponent.prototype.dataora = function () {
        var d = new Date();
        this.sdata = d.getFullYear() + "/" + ("0" + (d.getMonth() + 1)).slice(-2) + "/" + ("0" + d.getDate()).slice(-2) + " " + d.getHours() + ":" + d.getMinutes() + ":" + ("0" + d.getSeconds()).slice(-2);
        return this.sdata;
    };
    OrdersComponent.prototype.getOrders = function () {
        /*console.log("prima");
        this.servicec.getAllByUtentiId(this.user.id).subscribe((test)=>console.log(test));
        console.log("dopo");*/
        var _this = this;
        this.servicec.getAll().subscribe(function (clients) {
            for (var _i = 0, clients_1 = clients; _i < clients_1.length; _i++) {
                var cl = clients_1[_i];
                _this.length = _this.clients.push(cl);
            }
            console.log("Clienti caricati");
        }, undefined, function () {
            _this.service.getAll().subscribe(function (orders) {
                for (var _i = 0, _a = _this.clients; _i < _a.length; _i++) {
                    var client = _a[_i];
                    for (var _b = 0, orders_1 = orders; _b < orders_1.length; _b++) {
                        var order = orders_1[_b];
                        if (client.id === order.idcliente) {
                            _this.orders.push(order);
                            _this.orders.sort(function (a, b) { return a.data.localeCompare(b.data); });
                        }
                    }
                }
                console.log("Orders caricati");
            });
        });
        this.service.getAll().subscribe(function (items) {
            for (var _i = 0, items_1 = items; _i < items_1.length; _i++) {
                var it_1 = items_1[_i];
                if ((it_1.immagine === "" || it_1.immagine === null) && (it_1.link === "" || it_1.immagine === null)) {
                    _this.length = _this.items.push(it_1);
                }
                else {
                    _this.itemsorders.push(it_1);
                }
            }
        });
    };
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
    OrdersComponent.prototype.update = function (order) {
        this.service.update(order).subscribe(function () { });
        var itemtoupdate;
        itemtoupdate = this.checkitems(order.id);
        //itemtoupdate.link=this.checkitems(order.iditem).link;
        this.service.update(itemtoupdate).subscribe();
    };
    OrdersComponent.prototype.updatei = function (item) {
        item.link = this.qrlink;
        this.service.update(item).subscribe(function () { });
    };
    OrdersComponent.prototype.insert = function () {
        var _this = this;
        var idtemp = this.orderstoinsert.id;
        this.orderstoinsert.id = undefined;
        this.service.read(idtemp).subscribe(function (itselected) { _this.itselected = itselected; }, undefined, function () {
            _this.orderstoinsert.nome = _this.itselected.nome;
            _this.orderstoinsert.descrizione = _this.itselected.descrizione;
            _this.orderstoinsert.tipo = _this.itselected.tipo;
            _this.orderstoinsert.colore = _this.itselected.colore;
            _this.orderstoinsert.taglia = _this.itselected.taglia;
            _this.orderstoinsert.immagine = "ND";
            _this.orderstoinsert.link = "ND";
            _this.orderstoinsert.data = _this.sdata;
            _this.orderstoinsert.idcliente = Number(_this.orderstoinsert.idcliente);
            _this.service.insert(_this.orderstoinsert).subscribe(function () { }, undefined, function () {
                _this.orderstoinsert.id = Number(idtemp);
                _this.orders.push(_this.orderstoinsert);
            });
        });
    };
    OrdersComponent.prototype.clear = function () {
        this.orderstoinsert = new ItemDTO();
    };
    OrdersComponent.prototype.close = function () {
        this.service = null;
    };
    OrdersComponent.prototype.select = function (reviews) {
        this.selected = reviews;
        this.isselected = true;
        return this.selected;
    };
    OrdersComponent.prototype.closereada = function () {
        this.isselectedc = false;
    };
    OrdersComponent.prototype.closereadb = function () {
        this.isselectedi = false;
    };
    OrdersComponent.prototype.closereadc = function () {
        this.isselected = false;
    };
    OrdersComponent.prototype.readi = function (reviews, img) {
        var _this = this;
        this.service.read(reviews).subscribe(function (sel) { return _this.selectedi = sel; });
        this.isselectedi = true;
        //this.getImgHtml(img);
        return this.selectedi;
    };
    OrdersComponent.prototype.readc = function (reviews) {
        var _this = this;
        this.servicec.read(reviews).subscribe(function (sel) { return _this.selectedc = sel; });
        this.isselectedc = true;
        return this.selectedi;
    };
    OrdersComponent.prototype.getImgHtml = function (img) {
        var _this = this;
        this.service.getImage(img).subscribe(function (blob) {
            _this.objURL = URL.createObjectURL(blob);
            console.log(_this.objURL);
        });
    };
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
    OrdersComponent.prototype.checkitems = function (iditem) {
        for (var _i = 0, _a = this.itemsorders; _i < _a.length; _i++) {
            var item = _a[_i];
            if (item.id == iditem) {
                return item;
            }
        }
    };
    OrdersComponent = __decorate([
        Component({
            selector: 'app-orders',
            templateUrl: './orders.component.html',
            styleUrls: ['./orders.component.css']
        }),
        __metadata("design:paramtypes", [ItemService, ClientService, HttpClient, DomSanitizer])
    ], OrdersComponent);
    return OrdersComponent;
}());
export { OrdersComponent };
//# sourceMappingURL=orders.component.js.map
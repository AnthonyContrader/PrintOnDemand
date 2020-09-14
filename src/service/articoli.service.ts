import { Injectable } from '@angular/core';
import { AbstractService } from './abstractservice';
import { ItemDTO } from 'src/dto/articolidto';
import { HttpClient } from '@angular/common/http';
//import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ItemService extends AbstractService<ItemDTO> {

  constructor(http: HttpClient) {
    super(http);
    this.type = 'articolis';
    this.port= '8080';
    this.nome='microarticoli';
  }
  upload(fd: FormData) {
    return this.http.post('http://localhost:8080/microarticoli/api/order/upload',fd, {reportProgress:true, observe:'events',      headers: {
      Authorization : this.auth()
    }
    });
  }


}
import { Injectable } from '@angular/core';
import { AbstractService } from './abstractservice';
import { ItemDTO } from 'src/dto/itemdto';
import { HttpClient } from '@angular/common/http';
//import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ItemService extends AbstractService<ItemDTO> {

  constructor(http: HttpClient) {
    super(http);
    this.type = 'item';
  }

  
}

import { Injectable } from '@angular/core';
import { AbstractService } from './abstractservice';
import { ClientDTO } from 'src/dto/clientdto';
import { HttpClient } from '@angular/common/http';
//import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ClientService extends AbstractService<ClientDTO> {

  constructor(http: HttpClient) {
    super(http);
    this.type = 'client';
  }
}

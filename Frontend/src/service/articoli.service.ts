import { Injectable } from '@angular/core';
import { AbstractService } from './abstractservice';
import { ItemDTO } from 'src/dto/articolidto';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
//import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ItemService extends AbstractService<ItemDTO> {

  constructor(http: HttpClient) {
    super(http);
    this.type = 'articoli';
    this.port= '5001';
    this.nome='';
  }
  upload(fd: FormData) {
    return this.http.post('https://localhost:5001/api/articoli/upload',fd);
  }
  getImage(imageUrl: string): Observable<Blob> {
    return this.http.get('https://localhost:' + this.port + '/api/' + this.type + "/"+ imageUrl, { responseType: 'blob' });
  }

}
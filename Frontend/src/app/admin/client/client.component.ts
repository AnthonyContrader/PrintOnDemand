import { Component, OnInit } from '@angular/core';
//import { AbstractCrudComponent } from 'src/app/utils/abstractcomponent';
import { ClientService } from 'src/service/client.service';
import { ClientDTO } from 'src/dto/clientdto';
@Component({
  selector: 'app-client',
  templateUrl: './client.component.html',
  styleUrls: ['./client.component.css']
})
export class ClientComponent implements OnInit {

  isselected: boolean=false;
  selected: ClientDTO;
  clients: ClientDTO[];
  clienttoinsert: ClientDTO = new ClientDTO();
  constructor(private service: ClientService) { }

  ngOnInit() {
    this.clear();
    this.getClients();
  }

  getClients() {
    this.service.getAll().subscribe(clients => this.clients = clients);
  }

  delete(client: ClientDTO) {
    this.service.delete(client.id).subscribe(() => this.getClients());
  }

  update(client: ClientDTO) {
    this.service.update(client).subscribe(() => this.getClients());
  }

  insert(client: ClientDTO) {
    
    client.iduser =  Number(client.iduser);
    this.service.insert(client).subscribe(() => this.getClients());
  }

  clear(){
    this.clienttoinsert = new ClientDTO();
  }
  
  close() {
    this.service = null;
  }
  
  select(reviews: ClientDTO) {
    this.selected = reviews;
    this.isselected=true;
    return this.selected;
  }
  closeread() {
    this.isselected=false;
  }
}






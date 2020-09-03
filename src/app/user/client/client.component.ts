import { Component, OnInit } from '@angular/core';
//import { AbstractCrudComponent } from 'src/app/utils/abstractcomponent';
import { ClientService } from 'src/service/client.service';
import { ClientDTO } from 'src/dto/clientdto';
import { UserDTO } from 'src/dto/userdto';

@Component({
  selector: 'app-client',
  templateUrl: './client.component.html',
  styleUrls: ['./client.component.css']
})
export class ClientComponent implements OnInit {
  
  ouruser: boolean=false;
  isselected: boolean=false;
  selected: ClientDTO;
  clients: ClientDTO[];
  clienttoinsert: ClientDTO = new ClientDTO();
  user: UserDTO = new UserDTO;
  constructor(private service: ClientService) { }

  ngOnInit() {
    this.clear();
    this.getClients();
    this.user = JSON.parse(localStorage.getItem('currentUser'));
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
  checkuser(review: ClientDTO){
    if(this.user.id===review.userID)
     {
      return true;
    }
    else return false;
  }
}




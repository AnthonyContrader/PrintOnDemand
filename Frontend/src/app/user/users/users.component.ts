import { Component, OnInit } from '@angular/core';
import { UserService } from 'src/service/user.service';
import { UserDTO } from 'src/dto/userdto';
import { Router } from '@angular/router';


@Component({
  selector: 'app-users',
  templateUrl: './users.component.html',
  styleUrls: ['./users.component.css']
})
export class UsersComponent implements OnInit {
  users: UserDTO;
  usertoinsert: UserDTO = new UserDTO();
  user: UserDTO;

  constructor(private service: UserService, private router: Router) { }

  ngOnInit() {
    this.users=new UserDTO();
    this.getUsers();
    this.user = JSON.parse(localStorage.getItem('currentUser'));
  }

  getUsers() {
    this.service.getAll().subscribe(users => {
      for(let us of users)
      {
        if (us.id==this.user.id) this.users=us;
      }
      });
  }

  /*delete(user: UserDTO) {
    this.service.delete(user.id).subscribe(() => this.getUsers());
  }*/

  update(user: UserDTO) {
    this.service.update(user).subscribe(() => this.getUsers());
  }

  /*insert(user: UserDTO) {
    this.service.insert(user).subscribe(() => this.getUsers());
  }*/

  clear(){
    this.usertoinsert = new UserDTO();
  }

  disable(user: UserDTO){
    if(window.confirm("Vuoi davvero eliminare questo account?")){
      user.usertype = "DISABLED";
      this.service.update(user).subscribe(() => this.getUsers());
      localStorage.clear();
      this.router.navigateByUrl('');
    }
  }
}

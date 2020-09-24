import { Component, OnInit } from '@angular/core';
import { LoginDTO } from 'src/dto/logindto';
import { UserDTO } from 'src/dto/userdto';
import { NgForm } from '@angular/forms';
import { UserService } from 'src/service/user.service';
import { Router } from '@angular/router';
//import { userInfo } from 'os';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  loginDTO: LoginDTO;
  userDTO:UserDTO;
  isinsert:boolean;
  //userlogged:UserDTO;

  constructor(private service: UserService, private router: Router) { }

  ngOnInit() {
    this.isinsert=false;
    
  }

  login(f: NgForm): void {
      this.userDTO=new UserDTO();
      this.loginDTO = new LoginDTO(f.value.username, f.value.password);
      this.service.login(this.loginDTO).subscribe((user: UserDTO)=>{
        localStorage.setItem("currentUser",JSON.stringify(user));
        switch (user.usertype) {
          case "ADMIN": {
            this.router.navigate(['/admin-dashboard']);
            break;
          }
          case "USER": {
            this.router.navigate(['/user-dashboard']);
            break;
          }
          case "DISABLED": {
            alert("Account disabilitato");
            break;
          }
          default:
          alert("Username o password errati");
            //this.router.navigate(['/login']);
        }
      });
    }



  signup(f: NgForm): void 
  {
    this.userDTO=new UserDTO();
    this.userDTO.username=f.value.username;
    this.userDTO.password=f.value.password;
    this.userDTO.usertype="USER";

    this.service.insert(this.userDTO).subscribe(()=>this.isinsert=true);
 
    
  }
}

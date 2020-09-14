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
    this.loginDTO = new LoginDTO("admin","admin");
    this.userDTO=new UserDTO();
    this.service.login(this.loginDTO).subscribe((token : any) => {
      this.userDTO.authorities=token.id_token;
      //localStorage.setItem("AUTOKEN", JSON.stringify({ "authorities": token.id_token }));
      localStorage.setItem("currentUser",JSON.stringify(this.userDTO) /*JSON.stringify({ "authorities": token.id_token })*/);
      this.service.userLogged(this.loginDTO.username).subscribe((user:UserDTO)=>{
        /*for(let user of users){
          console.log(user);
          if((f.value.username===user.username)&&(f.value.password===user.password)) this.userlogged=user;
        }*/ 
        //user.authorities=token.id_token;
        
      if (user != null) {
        //user.authorities[0]="ROLE_ADMIN";
        this.service.getAll().subscribe((users:UserDTO[])=>{for(user of users){
          if((f.value.username===user.username)&&(f.value.password==user.password)) {
          this.userDTO.id=user.id;
          this.userDTO.username=user.username;
          this.userDTO.password=user.password;
          this.userDTO.usertype=user.usertype;
        }
        }},undefined,()=>{

          console.log(this.userDTO);
        localStorage.setItem("currentUser",JSON.stringify(this.userDTO) /*JSON.stringify({ "authorities": token.id_token })*/);
        switch (this.userDTO.usertype) {
          case "ADMIN": {
            //console.log("sono entrato nel if di authorities"+ this.userlogged.authorities);
            this.router.navigate(['/admin-dashboard']);
            break;
          }
          case "USER": {
            this.router.navigate(['/user-dashboard']);
            break;
          }
          default:
          alert("Username o password errati");
            this.router.navigate(['/login']);
        }
      });
      }
    });
  });
  }



  signup(f: NgForm): void 
  {
    this.userDTO=new UserDTO();
    this.loginDTO = new LoginDTO("admin","admin");
    this.userDTO.username=f.value.username;
    this.userDTO.password=f.value.password;
    this.userDTO.usertype="USER";
    this.service.login(this.loginDTO).subscribe((token : any) => {
    this.userDTO.authorities=token.id_token;
    localStorage.setItem("currentUser",JSON.stringify(this.userDTO) /*JSON.stringify({ "authorities": token.id_token })*/);

    this.service.insert(this.userDTO).subscribe(()=>this.isinsert=true);
    });
    
  }
}

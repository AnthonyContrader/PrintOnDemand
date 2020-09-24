import { Injectable } from '@angular/core';
import { AbstractService } from './abstractservice';
import { UserDTO } from 'src/dto/userdto';
import { HttpClient } from '@angular/common/http';
import { LoginDTO } from 'src/dto/logindto';
import { Observable } from 'rxjs';
import { AbstractUService } from './abstractuservice';

/**
 * I service sono decorati da @Injectable. 
 * Qui trovate, oltre ai metodi ereditati dall'Abstract,
 *  il metodo per il login (in mirror con il backend).
 * 
 * @author Vittorio Valent
 * 
 * @see AbstractService
 */
@Injectable({
  providedIn: 'root'
})
export class UserService extends AbstractService<UserDTO>{

  constructor(http: HttpClient) {
    super(http);
    this.type = 'utenti';
    this.port= '5001';
    this.nome='';

  }

  test(){
    let utenti;
    return this.http.get<any>('https://localhost:5001/api/utenti', utenti);
  } 

  auth() {
    const user = JSON.parse(localStorage.getItem('currentUser')) as UserDTO;
     if (user) {
      return 'Bearer ' + user.authorities;
    } else {
      return '';
    }
  }
  login(login: LoginDTO): Observable<UserDTO> {
    
    return this.http.post<any>('https://localhost:5001/api/login', login)
  }

  userLogged(username: string) {
    console.log('qua: ', this.auth());
    console.log(this.auth());
    return this.http.get('http://localhost:8080/api/users/'+username, {
      headers: {
        Authorization: this.auth()
      }
    });
  }


  insert(dto: UserDTO): Observable<UserDTO> {
    return this.http.post<UserDTO>('https://localhost:' + this.port + '/api/utenti' , dto );
  }
  /*uten
  tiCall(username: String, password: String): Observable<DTO[]>{
    return this.http.get<DTO[]>('http://localhost:8080/microservizio/api/utentis', {
      headers: {
        Authorization: this.auth()
      }
    });

}*/

}
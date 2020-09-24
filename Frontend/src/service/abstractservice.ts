import { Service } from './service';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { UserDTO } from 'src/dto/userdto';


export abstract class AbstractService<DTO> implements Service<DTO> {

    type: string;
    port: string = '5001';
    nome: string;
    constructor(protected http: HttpClient) {
    }

    auth() {
        const user = JSON.parse(localStorage.getItem('currentUser')) as UserDTO;
        if (user) {
          console.log('Bearer ' + user.authorities);
          return 'Bearer ' + user.authorities;
        } else {
          return '';
        }
    
      }
    

      getAllBy(id: number): Observable<DTO[]> {
        return this.http.get<DTO[]>('https://localhost:' + this.port + '/api/' + this.type + id, {
          headers: {
            Authorization : this.auth()
          }
        });
      }

     
      getAll(): Observable<DTO[]> {
        return this.http.get<DTO[]>('https://localhost:' + this.port + '/api/' + this.type );
      }
    
      //la read non è prevista...la facciamo in un secondo momento forse
      read(id: number): Observable<DTO> {
        return this.http.get<DTO>('https://localhost:' + this.port + '/' + this.nome  + 'api/'  + this.type + '/' + id , {
          headers: {
            Authorization : this.auth()
          }
        });
      }
    
    
      delete(id: number): Observable<DTO> {
        return this.http.delete<DTO>('https://localhost:' + this.port + '/' + 'api' + '/' + this.type + '/' + id , {
          headers: {
            Authorization : this.auth()
          }
        });
      }
    /*
      deleteU(login: string): Observable<DTO> {
        return this.http.delete<DTO>('https://localhost:' + this.port + '/' + this.nome  + 'api' + '/' + this.type + '/' + login , {
          headers: {
            Authorization : this.auth()
          }
        });
      }
      */
    
      insert(dto: DTO): Observable<DTO> {
        return this.http.post<DTO>('https://localhost:' + this.port + '/api/'+this.type+'/add', dto );
      }
    
      update(dto: DTO): Observable<DTO> {
        return this.http.put<DTO>('https://localhost:' + this.port + '/' + 'api' + '/' + this.type +'/edit', dto /*, {
          headers: {
            Authorization : this.auth()
          }
        }*/);
    
      }

}
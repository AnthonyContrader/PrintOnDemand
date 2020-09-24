import { Service} from './service';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { UserDTO} from '../dto/userdto';

export abstract class AbstractUService<DTO>  implements Service <DTO> {

  type: string;
  port: string;

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
    return this.http.get<DTO[]>('http://localhost:' + this.port + '/' + this.type + id, {
      headers: {
        Authorization : this.auth()
      }
    });
  }
  getAll(): Observable<DTO[]> {
    return this.http.get<DTO[]>('http://localhost:' + this.port + '/' + 'api' + '/' + this.type , {
      headers: {
        Authorization : this.auth()
      }
    });
  }

  read(id: number): Observable<DTO> {
    return this.http.get<DTO>('http://localhost:' + this.port + '/' + 'api' + '/'  + this.type + id , {
      headers: {
        Authorization : this.auth()
      }
    });
  }

  delete(id: number): Observable<DTO> {
    return this.http.delete<DTO>('http://localhost:' + this.port + '/' + 'api' + '/' + this.type + '/' + id , {
      headers: {
        Authorization : this.auth()
      }
    });
  }

  deleteU(login: string): Observable<DTO> {
    return this.http.delete<DTO>('http://localhost:' + this.port + '/' + 'api' + '/' + this.type + '/' + login , {
      headers: {
        Authorization : this.auth()
      }
    });
  }

  insert(dto: DTO): Observable<DTO> {
    return this.http.post<DTO>('http://localhost:' + this.port + '/' + 'api' + '/' + this.type, dto , {
      headers: {
        Authorization : this.auth()
      }
    });
  }

  update(dto: DTO): Observable<DTO> {
    return this.http.put<DTO>('http://localhost:' + this.port + '/' + 'api' + '/' + this.type, dto , {
      headers: {
        Authorization : this.auth()
      }
    });

  }



}
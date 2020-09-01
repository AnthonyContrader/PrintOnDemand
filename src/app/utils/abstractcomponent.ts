  
import { AbstractService } from 'src/service/abstractservice';


/**
 * Questa classe deinisce tutti i metodi di CRUD da usare nelle varie componenti (se lo richiedono).
 * Si osservi come, invece degli oggetti specifici, si fa riferimento a dto e dtolist.
 * 
 * @author Vittorio Valent
 * 
 * @param DTO
 * 
 */
export abstract class AbstractCrudComponent<DTO>{

  dtolist: DTO[];
  dto: DTO;
  selected: DTO;

  constructor(protected service: AbstractService<DTO>) { }

  getAll() {
    this.service.getAll().subscribe(dtolist => this.dtolist = dtolist);
  }

  delete(id: number) {
    this.service.delete(id).subscribe(() => this.getAll());
  }

  update(user: DTO) {
    this.service.update(user).subscribe(() => this.getAll());
  }

  insert(dto: DTO) {
    this.service.insert(dto).subscribe(() => this.getAll());
  }

  select(dto: DTO) {
    this.selected = dto;
  }

}
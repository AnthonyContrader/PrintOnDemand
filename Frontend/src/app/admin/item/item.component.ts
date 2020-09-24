import { Component, OnInit } from '@angular/core';
import { ItemService } from 'src/service/articoli.service';
import { ItemDTO } from 'src/dto/articolidto';

@Component({
  selector: 'app-item',
  templateUrl: './item.component.html',
  styleUrls: ['./item.component.css']
})
export class ItemComponent implements OnInit {

  isselected: boolean=false;
  selected: ItemDTO;
  items: ItemDTO[];
  itemtoinsert: ItemDTO = new ItemDTO();
  searchVal='';
  filteredItems: ItemDTO[] = [];
  result: ItemDTO[];
  constructor(private service: ItemService) { }

  ngOnInit() {
    this.clear();
    this.getItems();
  }

  getItems() {
    this.service.getAll().subscribe(items => {this.items = items; this.result=items});
  }

  delete(item: ItemDTO) {
    this.service.delete(item.id).subscribe(() => this.getItems());
  }

  update(item: ItemDTO) {
    this.service.update(item).subscribe(() => this.getItems());
  }

  insert(item: ItemDTO) {
    this.service.insert(item).subscribe(() => this.getItems());
  }

  clear(){
    this.itemtoinsert = new ItemDTO();
  }
  
  close() {
    this.service = null;
  }
  
  select(reviews: ItemDTO) {
    this.selected = reviews;
    this.isselected=true;
    return this.selected;
  }
  closeread() {
    this.isselected=false;
  }
  cutstring(str: string){
    if((str!==null)&&(str.length>35)) return str.substring(34);
    else return str;
  }
  checkSearchVal() {    
    this.filteredItems=[];
   if (this.searchVal && this.searchVal !== '') {
      for (let selecteditems of this.items) {
        if (selecteditems.tipo.toLowerCase().startsWith(this.searchVal.toLowerCase())) {
          this.filteredItems.push(selecteditems);
        }
        this.result=this.filteredItems.slice();
      }   
    }else{this.result=this.items;
  }
}
}


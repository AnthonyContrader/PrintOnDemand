import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-user-menu',
  templateUrl: './user-menu.component.html',
  styleUrls: ['./user-menu.component.css']
})
export class UserMenuComponent implements OnInit {

  isUserCollapsed = false;
  isClientCollapsed = false;
  isAccountCollapsed = false;
  isItemCollapsed = false;
  isOrdersCollapsed = false;

  constructor(private router: Router) {
  }

  ngOnInit() {
  }

  logout() {
    localStorage.clear();
    this.router.navigateByUrl('');
  }

  userscollapse() {
    if (this.isUserCollapsed === false) {
      this.isUserCollapsed = true;
    } else { this.isUserCollapsed = false; }
  }

  clientcollapse() {
    if (this.isClientCollapsed === false) {
      this.isClientCollapsed = true;
    } else { this.isClientCollapsed = false; }
  }
  itemcollapse() {
    if (this.isItemCollapsed === false) {
      this.isItemCollapsed = true;
    } else { this.isItemCollapsed = false; }
  }
  orderscollapse() {
    if (this.isOrdersCollapsed === false) {
      this.isOrdersCollapsed  = true;
    } else { this.isOrdersCollapsed = false; }
  }
}

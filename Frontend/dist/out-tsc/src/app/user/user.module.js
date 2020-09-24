import { __decorate } from "tslib";
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { UserRoutingModule } from './user-routing.module';
import { UserDashboardComponent } from './user-dashboard/user-dashboard.component';
import { UsersComponent } from './users/users.component';
import { ClientComponent } from './client/client.component';
import { ItemComponent } from './item/item.component';
import { OrdersComponent } from './orders/orders.component';
var UserModule = /** @class */ (function () {
    function UserModule() {
    }
    UserModule = __decorate([
        NgModule({
            declarations: [UserDashboardComponent, UsersComponent, ClientComponent, ItemComponent, OrdersComponent],
            imports: [
                CommonModule,
                UserRoutingModule,
                FormsModule
            ]
        })
    ], UserModule);
    return UserModule;
}());
export { UserModule };
//# sourceMappingURL=user.module.js.map